package bpaCards;

public class ACcard {
	private static final int format1[] = new int[]{ 0, 1, 2, 3, 13, 21, 26, 35 };
	private static final int format2[] = new int[]{ 1, 1, 1, 10, 8, 4, 8, 60 };
	public int zoneNo = 0;
	public char type = 'A';			//1 A1
		//2 A1
	public char chgcde = ' ';		//3 A1
	//String InterChg;		//4-13 A10
	public String areaName="          ";
	//String SlkName;		//14-21 A8
	public String slkName="        ";
	//double SlkbasekV;				//22-25 F4.0
	public double slkbasekV = 0;
	////26 A1
	//double ExpMW;		//27-34 F8.0
	public double expMW = 0;
	public String[]zone=new String[20];
	////35 A1
	//String zone[20];	//36-95 A2*10
	public ACcard(){
		for (int i = 0; i < 20; i++)
		{
			zone[i]="  ";
		}
	}
	public void CharToCard(String s){
		int len = SelfFunc.strlen(s);

		String temp;

		//char type;			//1 A1
		if (len >format1[0])
		{
			type = s.charAt(0);
		}
		else
		{
			return;
		}

		//char chgcde;		//3 A1
		if (len > format1[2])
		{
			chgcde = s.charAt(2);
		}
		else
		{
			return;
		}

		//String InterChg;		//4-13 A10
		if (len >format1[3])
		{
			areaName= SelfFunc.substring(s,format1[3], format1[3] + SelfFunc.min(format2[3], len - format1[3]));
		}
		else
		{
			return;
		}
		//String SlkName;		//14-21 A8
		if (len > format1[4])
		{
			slkName = SelfFunc.substring(s,format1[4], format1[4] + SelfFunc.min(format2[4], len - format1[4]));

		}
		else
		{
			return;
		}
		//double SlkbasekV;				//22-25 F4.0
		if (len > format1[5])
		{
			temp = SelfFunc.substring(s,format1[5], format1[5] + SelfFunc.min(format2[5], len - format1[5]));
			slkbasekV = SelfFunc.strToD(temp);;
		}
		else
		{
			return;
		}
		//double ExpMW;		//27-34 F8.0
		if (len > format1[6])
		{
			temp = SelfFunc.substring(s,format1[6], format1[6] + SelfFunc.min(format2[6], len - format1[6]));
			expMW = SelfFunc.strToD(temp);;
		}
		else
		{
			return;
		}
		//String zone[20];	//36-95 A2*10
		int dl= len - format1[7];
		int k = 0;
		while ((dl>0) && (k<20))
		{
			zone[k]=SelfFunc.substring(s,format1[7]+3*k, format1[7]+3*k+SelfFunc.min(2, dl));
			k++;
			dl = dl - 3;
		}
		zoneNo = k;
		//return;
	}
	public String sqlInsert(String dbname,String tablename){
		String sql="insert into "+dbname+"."+tablename+" values('"+type+"','"+chgcde+"','"+areaName+"','"+slkName+"','"+slkbasekV+"','"+expMW;
		for(int i=0;i<20;i++){
			sql=sql+"','"+zone[i];
		}
		sql=sql+"')";
		return sql;
	}
	public static boolean isAcard(String s){
		if(s.length()<2){
			return false;
		}
		if (s.charAt(0)== 'A') {
			if (s.charAt(1) == 'C' || s.charAt(1) == ' ') {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
