package test;
import bpaCards.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class testmain {

	public static void main(String[] args) throws IOException {
		List<Integer> bb=new ArrayList<Integer>();
		for(int i=0;i<10;i++)
		{
			bb.add(i);
		}
		FileReader q=new FileReader("wzl2016.dat");
		BufferedReader b = new BufferedReader(q);
		String str;
		List<Bcard> bcardArray=new ArrayList<Bcard>();
		int bi=0;
		
		while((str=b.readLine())!=null){
			if(SelfFunc.isBcard(str)){
//				if(str.indexOf('яс')!=-1)
//				{
//					System.out.println("kanyikan");
//				}
				Bcard bc=new Bcard();
				bc.CharToCard(str);
				bcardArray.add(bc);
				bi++;
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
