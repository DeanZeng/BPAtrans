package bpaCards;
import java.io.*;
import java.util.Scanner;

public class SelfFunc {

	public static void main(String[] args) throws IOException 
	{
		TestFunc.strToD_t();
	}
	protected static int min(int a,int b){
		return a<b?a:b;
	}
	protected static double  strToD(String str, int m, int n)
	{
		//convert from string to double
		//for BPAtoCard conversion 
		//Fm.n
		for(int i=0;i<m-str.length();i++)
		{
			str=str+' ';
		}
		char[] c=(str+' ').toCharArray();
		
		double f=0;
		if (str.indexOf('.') ==-1)
		{
			//��������
			for(int i=m-1;i>=0;i--)
			{
				//����������

				if((c[i]>='0')&&(c[i]<='9')){
					if(m-i-1>=n)
					{
						c[i+1]='.';
					}
					else
					{
						for(int j=m;j>m-n;j--)
						{
							c[j]=c[j-1];
						}
						c[m-n]='.';
					}
					break;
				}
			}
		}
			//��������
			for(int i=0;i<str.length();i++)//��������.������0;
			{
				if(((c[i]<'0')||(c[i]>'9'))&&(c[i]!='.')&&(c[i]!='-')){
					c[i]='0';
				}
			}
			String s=new String(c);
			try{
			f=Double.parseDouble(s);
			}
			catch(Exception e){
				e.printStackTrace();
				
			}
	
		if ((Math.abs(f) < 0.0000001) || (Math.abs(f)>1000000))
		{
			f = 0;
		}
		return f;
	}
	protected static double strToD(String str)
	{
		//convert from string to double
		//for BPAtoCard conversion 
		//Fm.n n=0
		int m=str.length();
		return strToD(str,m,0);
	}
	protected static String substring(String str, int beginIn, int endIn){
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)>255){
				if(i<beginIn){
					beginIn--;
				}
				if(i<endIn){
					endIn--;
				}
			}
		}
		
		return str.substring(beginIn,endIn);

	}
	protected static int strlen(String str){
		//计算字符串长度
		//针对含有汉字的字符串，
		//汉字占2个字符长度
		int l=str.length();
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)>255){
				l++;
			}
		}
		return l;
	}
	
	public static boolean isBcard(String str){
		//判断是否为B卡
		if(str.isEmpty())
			return false;
		if (str.charAt(0) == 'B') {
			if ((str.charAt(1) == ' ') || (str.charAt(1) == 'T') || (str.charAt(1) == 'C') || (str.charAt(1) == 'V') || (str.charAt(1) == 'E') || (str.charAt(1) == 'Q')
					|| (str.charAt(1) == 'G') || (str.charAt(1) == 'F') || (str.charAt(1) == 'S') || (str.charAt(1) == 'J') || (str.charAt(1) == 'K')
					|| (str.charAt(1) == 'L') || (str.charAt(1) == 'X')) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
}

class TestFunc{
	protected static void strToD_t()
	{
		String s;
		int m,n;
		boolean endflag=true;
		// ���� System.in ���� BufferedReader 
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter characters, 'q' to quit.");
		// ��������
		do {
			s =  scan.next();
			m=scan.nextInt();
			n=scan.nextInt();
			System.out.println(SelfFunc.strToD(s,m,n));
			do{
				System.out.println("continue: Y/N");
				String c=scan.next();
				if(c.equals("N")){
					scan.close();
					endflag=false;
					break;
				}
				else if(c.equals("Y"))
					break;
			}while(true);
		}while(endflag);
	}
}