package bpaCards;

public class Bcard {

	protected static final int format1[] = new int[] { 0, 1, 2, 3, 6, 14, 18, 20, 25, 30, 34, 38, 42, 47, 52, 57, 61,
			65, 73, 77 };
	protected static final int format2[] = new int[] { 1, 1, 1, 3, 8, 4, 2, 5, 5, 4, 4, 4, 5, 5, 5, 4, 4, 8, 4, 3 };
	public int bus_i = -1; // ½Úµã±àºÅ
	public char type = 'B'; // 1 A1
	public char subtype = ' '; // 2 A1
	public char chgcde = ' '; // 3 A1
	public String owner = "   "; // 4-6 A3
	public String name = "        "; // 7-14 A8
	public double kV = 0; // 15-18 F4.0
	public String zone = "  "; // 19-20 A2
	public double PMW = 0; // 21-25 F5.0
	public double QMVAR = 0; // 26-30 F5.0
	public double ShMW = 0; // 31-34 F4.0
	public double ShMVAR = 0; // 35-38 F4.0
	public double Pmax = 0; // 39-42 F4.0
	public double PgenMW = 0; // 43-47 F5.0
	public double QmaxMAVR = 0; // 48-52 F5.0
	public double QminMVAR = 0; // 53-57 F5.0
	public double VholdVmaxPU = 0; // 58-61 F4.3
	public double VholdVminPU = 0; // 62-65 F4.3
	public String Rname = "        "; // 66-73 A8
	public double RkV = 0; // 74-77 F4.0
	public double Rvars = 0; // 78-80 F3.0


	public void CharToCard(String s) {

		{
			int len = SelfFunc.strlen(s);
			// int flag = 1;
			String temp;

			// char type; //1 A1
			if (len > format1[0]) {
				type = s.charAt(0);
			} else {
				return;
			}
			// char subtype; //2 A1
			if (len > format1[1]) {
				subtype = s.charAt(1);
			} else {
				return;
			}

			// char chgcde; //3 A1
			if (len > format1[2]) {
				chgcde = s.charAt(2);
			} else {
				return;
			}

			// char owner[3]; //4-6 A3
			if (len > format1[3]) {
				owner = SelfFunc.substring(s,format1[3], format1[3] + SelfFunc.min(format2[3], len - format1[3]));
			} else {
				return;
			}
			// char name[8]; //7-14 A8
			if (len > format1[4]) {
				name = SelfFunc.substring(s,format1[4], format1[4] + SelfFunc.min(format2[4], len - format1[4]));

			} else {
				return;
			}
			// char kV[4]; //15-18 F4.0
			if (len > format1[5]) {
				temp = SelfFunc.substring(s,format1[5], format1[5] + SelfFunc.min(format2[5], len - format1[5]));
				kV = SelfFunc.strToD(temp);
			} else {
				return;
			}
			// char zone[2]; //19-20 A2
			if (len > format1[6]) {
				zone = SelfFunc.substring(s,format1[6], format1[6] + SelfFunc.min(format2[6], len - format1[6]));
			} else {
				return;
			}
			// char PMW[5]; //21-25 F5.0
			if (len > format1[7]) {
				temp = SelfFunc.substring(s,format1[7], format1[7] + SelfFunc.min(format2[7], len - format1[7]));
				PMW = SelfFunc.strToD(temp);
			} else {
				return;
			}
			// char QMVAR[5]; //26-30 F5.0
			if (len > format1[8]) {
				temp = SelfFunc.substring(s,format1[8], format1[8] + SelfFunc.min(format2[8], len - format1[8]));
				QMVAR = SelfFunc.strToD(temp);
			} else {
				return;
			}
			// char ShMW[4]; //31-34 F4.0
			if (len > format1[9]) {
				temp = SelfFunc.substring(s,format1[9], format1[9] + SelfFunc.min(format2[9], len - format1[9]));
				ShMW = SelfFunc.strToD(temp);
			} else {
				return;
			}
			// char ShMVAR[4]; //35-38 F4.0
			if (len > format1[10]) {
				temp = SelfFunc.substring(s,format1[10], format1[10]+SelfFunc.min(format2[10], len - format1[10]));
				ShMVAR = SelfFunc.strToD(temp);
			} else {
				return;
			}
			// char Pmax[4]; //39-42 F4.0
			if (len > format1[11]) {
				temp = SelfFunc.substring(s,format1[11], format1[11]+SelfFunc.min(format2[11], len - format1[11]));
				Pmax = SelfFunc.strToD(temp);
			} else {
				return;
			}
			// char PgenMW[5]; //43-47 F5.0
			if (len > format1[12]) {
				temp = SelfFunc.substring(s,format1[12], format1[12]+SelfFunc.min(format2[12], len - format1[12]));
				PgenMW = SelfFunc.strToD(temp);
			} else {
				return;
			}
			// char QmaxMAVR[5]; //48-52 F5.0
			if (len > format1[13]) {
				temp = SelfFunc.substring(s,format1[13], format1[13]+SelfFunc.min(format2[13], len - format1[13]));
				QmaxMAVR = SelfFunc.strToD(temp);
			} else {
				return;
			}
			// char QminMVAR[5]; //53-57 F5.0
			if (len > format1[14]) {
				temp = SelfFunc.substring(s,format1[14], format1[14]+SelfFunc.min(format2[14], len - format1[14]));
				QminMVAR = SelfFunc.strToD(temp);
			} else {
				return;
			}
			// char VholdVmaxPU[4]; //58-61 F4.3
			if (len > format1[15]) {
				temp = SelfFunc.substring(s,format1[15], format1[15]+SelfFunc.min(format2[15], len - format1[15]));
				VholdVmaxPU = SelfFunc.strToD(temp, 4, 3);
			} else {
				return;
			}
			// char VholdVminPU[4]; //62-65 F4.3
			if (len > format1[16]) {
				temp = SelfFunc.substring(s,format1[16], format1[16]+SelfFunc.min(format2[16], len - format1[16]));
				VholdVminPU = SelfFunc.strToD(temp, 4, 3);
			} else {
				return;
			}
			// char Rname[8]; //66-73 A8
			if (len > format1[17]) {
				Rname = SelfFunc.substring(s,format1[17], format1[17]+SelfFunc.min(format2[17], len - format1[17]));
			} else {
				return;
			}
			// char RkV[4]; //74-77 F4.0
			if (len > format1[18]) {
				temp = SelfFunc.substring(s,format1[18], format1[18]+SelfFunc.min(format2[18], len - format1[18]));
				RkV = SelfFunc.strToD(temp);
			} else {
				return;
			}
			// char Rvars[3]; //78-80 F3.0
			if (len > format1[19]) {
				temp = SelfFunc.substring(s,format1[19], format1[19]+SelfFunc.min(format2[19], len - format1[19]));
				Rvars = SelfFunc.strToD(temp);
			} else {
				return;
			}
		}
	}
	// public void ToXLS(ofstream &out){
	//
	// }
	// public void StartXLS(ofstream &out){
	//
	// }
	// public void CSVToCard(string line){
	//
	// }
	// public void To_dat(ofstream &out){
	//
	// }
}

class BPACards {
	// protected static final int format1[];
	// protected static final int format2[];

}
