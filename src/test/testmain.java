package test;
import bpaCards.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class testmain {

	public static void main(String[] args) throws IOException {
		FileReader q=new FileReader("sx2015.dat");
		BufferedReader b = new BufferedReader(q);
		String str;
		List<ACcard> accardArray=new ArrayList<ACcard>();
		int aci=0;
		List<Bcard> bcardArray=new ArrayList<Bcard>();
		int bi=0;
		List<Lcard> lcardArray=new ArrayList<Lcard>();
		int li=0;
		List<Tcard> tcardArray=new ArrayList<Tcard>();
		int ti=0;
		while((str=b.readLine())!=null){
			if(ACcard.isAcard(str))
			{
				ACcard acc=new ACcard();
				acc.CharToCard(str);
				accardArray.add(acc);
				aci++;
			}
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
			if(Tcard.isTcard(str))
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
			String url="jdbc:mysql://localhost:3306/bpadb?autoReconnect=true&useSSL=false";
			String user="bpadmin";
			String password="123456";
			Connection conn=DriverManager.getConnection(url,user,password);
			for(int i=0;i<aci;i++){
				String sql=accardArray.get(i).sqlInsert("bpadb","accardtb");
//				System.out.println(sql);
				try{
				Statement stmt=conn.createStatement();
				stmt.executeUpdate(sql);
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			for(int i=0;i<bi;i++){
				String sql=bcardArray.get(i).sqlInsert("bpadb", "bcardtb");
//				System.out.println(sql);
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
				String sql=lcardArray.get(i).sqlInsert("bpadb", "lcardtb");
//				System.out.println(sql);
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
				String sql=tcardArray.get(i).sqlInsert("bpadb", "tcardtb");
//				System.out.println(sql);
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
