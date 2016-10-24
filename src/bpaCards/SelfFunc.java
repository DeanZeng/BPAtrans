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
	protected static String bpadate(char month, int year){
		return "null";
	}
	protected static double  strToD(String str, int m, int n)
	{
		//convert from string to double
		//for BPAtoCard conversion 
		//Fm.n
		//problem:1)" -18" 2)"    " (3)" . "(4)"  1137"F6,5
		while(m>str.length()){
			str=str+' ';
		}
		char[] c=(str+' ').toCharArray();
		
		double f=0;
		if (str.indexOf('.') ==-1)
		{
			//无小数点
			for(int i=m-1;i>=0;i--)
			{
				//插入小数点
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
		// 有小数点
		int begin=0,end=0,l=c.length;
		for(begin=0;begin<l;begin++){
			if(c[begin]!=' '){
				break;
			}
		}
		for(end=l-1;end>=0;end--){
			if(c[end]!=' '){
				break;
			}
		}
		if(begin==l){
			return 0;
		}
		if((begin==end)&&((c[begin]<'0')&&(c[begin]<'9'))){
			return 0;
		}
		boolean negative=false;
		if(str.charAt(begin)=='-'){
			negative=true;
			begin++;
		}
		for (int i = begin; i <=end; i++)
		{
			//其他字符（包括空格）用0替代
			if((c[i]>='0')&&(c[i]<='9')){
			}
			else if(c[i]=='.'){
			}
			else if(c[i]==' ')
			{
				c[i]='0';
			}
			else
			{
				System.out.println("String:'"+str+"' 格式不对，输出结果为0");
				return 0;
			}
		}
		String s = new String(c,begin,end-begin+1);
		try {
			f = Double.parseDouble(s);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("String:'"+str+"' 格式不对，输出结果为0");
			return 0;
		}
		f=negative?-f:f;
		if ((Math.abs(f) < 0.0000001) || (Math.abs(f)>1000000))
		{
			f = 0;
		}
		return f;
	}
	protected static double strToDtest(String str, int m, int n){
		//convert from string to double
		//for BPAtoCard conversion 
		//Fm.n
		//problem:1)" -18" 2)"   " 3) "456" F(3,2)
		int f = 0;
		int l = str.length();
		int begin = 0;
		int end = 0;
		boolean negative = false;
		for (int i = 0; i < l; i++) {
			if (str.charAt(i) != ' ') {
				begin = i;
				break;
			}
		}
		for (int i = l - 1; i >= 0; i--) {
			if (str.charAt(i) != ' ') {
				end = i;
				break;
			}
		}
		if (begin == end) {
			return 0;
		}
		if (str.charAt(begin) == '-') {
			negative = true;
			begin++;
		}
		for (int i = begin; i <= end; i++) {
			if ((str.charAt(i) >= '0') && (str.charAt(i) <= '9')) {
				f = f + str.charAt(i) * 10;
			} else if (str.charAt(i) == '.') {
				break;
			} else {
				System.out.println("String:'" + str + "' 格式不对，输出结果为0");
				return 0;
			}
		}
		if (negative) {
			f = -f;
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
	protected static int strToI(String str){
		//convert string to integer
		//for BPA card conversion
		//required formation: "  (-)XXXX。    "
		//X:0-9
		int f=0;
		int l=str.length();
		int begin=0;
		int end=0;
		boolean negative=false;
		for(int i=0;i<l;i++)
		{
			if(str.charAt(i)!=' '){
				begin=i;break;
			}
		}
		for(int i=l-1;i>=0;i--){
			if(str.charAt(i)!=' ')
			{
				end=i;
				break;
			}
		}
		if(begin==end){
			return 0;
		}
		if(str.charAt(begin)=='-'){
			negative=true;
			begin++;
		}
		for(int i=begin;i<=end;i++)
		{
			if((str.charAt(i)>='0')&&(str.charAt(i)<='9')){
				f=f+str.charAt(i)*10;
			}
			else if(str.charAt(i)=='.'){
				break;
			}
			else
			{
				System.out.println("String:'"+str+"' 格式不对，输出结果为0");
				return 0;
			}
		}
		if(negative)
		{
			f=-f;
		}
		return f;
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
	protected static char charAt(String str, int index){
		//返回第n个字符
		//针对含有汉字的字符串，汉字占两个字符长度
		for(int i=0;i<index;i++)
		{
			if(str.charAt(i)>255)
			{
				index--;
			}
		}
		char c=str.charAt(index);
		return c;
	}
}

class TestFunc{
	protected static void strToD_t()
	{
		String s;
		int m,n;
		boolean endflag=true;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter characters, 'q' to quit.");
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