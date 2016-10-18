package test;
import bpaCards.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class testmain {

	public static void main(String[] args) throws IOException {
		FileReader q=new FileReader("wzl2016.dat");
		BufferedReader b = new BufferedReader(q);
		String str;
		List<Bcard> bcardArray=new ArrayList<Bcard>();
		int bi=0;
		List<Lcard> lcardArray=new ArrayList<Lcard>();
		int li=0;
		List<Tcard> tcardArray=new ArrayList<Tcard>();
		int ti=0;
		while((str=b.readLine())!=null){
			if(Bcard.isBcard(str)){
				Bcard bc=new Bcard();
				bc.CharToCard(str);
				bcardArray.add(bc);
				bi++;
			}
			if(Lcard.isLcard(str))
			{
				Lcard lc=new Lcard();
				lc.CharToCard(str);
				lcardArray.add(lc);
				li++;
			}
			if(Tcard.isLcard(str))
			{
				Tcard tc=new Tcard();
				tc.CharToCard(str);
				tcardArray.add(tc);
				ti++;
			}
		}
		
		b.close();
		System.out.println("OK!");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/bpadb";
			String user="bpadmin";
			String password="123456";
			Connection conn=DriverManager.getConnection(url,user,password);
			for(int i=0;i<bi;i++){
				String sql="insert into bpadb.bcardt values('"+bcardArray.get(i).type+"','"+bcardArray.get(i).subtype+"','"+bcardArray.get(i).chgcde+"','"+
						bcardArray.get(i).owner+"','"+bcardArray.get(i).name+"','"+bcardArray.get(i).kV+"','"+bcardArray.get(i).zone+"','"+
						bcardArray.get(i).PMW+"','"+bcardArray.get(i).QMVAR+"','"+bcardArray.get(i).ShMW+"','"+bcardArray.get(i).ShMVAR+"','"+
						bcardArray.get(i).Pmax+"','"+bcardArray.get(i).PgenMW+"','"+bcardArray.get(i).QmaxMAVR+"','"+bcardArray.get(i).QminMVAR+"','"+
						bcardArray.get(i).VholdVmaxPU+"','"+bcardArray.get(i).VholdVminPU+"')";
				System.out.println(sql);
				try{
				Statement stmt=conn.createStatement();
				stmt.executeUpdate(sql);
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			for(int i=0;i<li;i++){
				String sql="insert into bpadb.lcardtb values('"+lcardArray.get(i).type+"','"+lcardArray.get(i).chgcde+"','"+
						lcardArray.get(i).owner+"','"+lcardArray.get(i).name1+"','"+lcardArray.get(i).kV1+"','"+lcardArray.get(i).meter+"','"+
						lcardArray.get(i).name2+"','"+lcardArray.get(i).kV2+"','"+lcardArray.get(i).CktID+"','"+lcardArray.get(i).IRatA+"','"+
						lcardArray.get(i).R+"','"+lcardArray.get(i).X+"','"+lcardArray.get(i).G+"','"+lcardArray.get(i).B+"','"+
						lcardArray.get(i).miles+"','"+lcardArray.get(i).DescData+"','"+"20001101"+"','"+"2001130"+"')";
				System.out.println(sql);
				try{
				Statement stmt=conn.createStatement();
				stmt.executeUpdate(sql);
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			for(int i=0;i<ti;i++){
				String sql="insert into bpadb.tcardtb values('"+tcardArray.get(i).type+"','"+tcardArray.get(i).chg+"','"+
						tcardArray.get(i).owner+"','"+tcardArray.get(i).name1+"','"+tcardArray.get(i).kv1+"','"+tcardArray.get(i).meter+"','"+
						tcardArray.get(i).name2+"','"+tcardArray.get(i).kv2+"','"+tcardArray.get(i).cktID+"','"+tcardArray.get(i).SMVA+"','"+
						tcardArray.get(i).R+"','"+tcardArray.get(i).X+"','"+tcardArray.get(i).G+"','"+tcardArray.get(i).B+"','"+
						tcardArray.get(i).tpkv1+"','"+tcardArray.get(i).tpkv2+"','"+"20001101"+"','"+"20001130"+"')";
				System.out.println(sql);
				try{
				Statement stmt=conn.createStatement();
				stmt.executeUpdate(sql);
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("finish");
	}

}
