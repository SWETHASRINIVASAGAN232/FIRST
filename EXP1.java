import java.io.*;
import java.util.*;
class EXP1{
	private static String alphabect="abcdefghijklmnopqrstuvwxyz";
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter pt:");
		String pt=sc.next();
		System.out.println("enter key:");
		int key=sc.nextInt();
		String encrypted=encrypt(pt,key);
		System.out.println("ct:"+encrypted);
		System.out.println("enter ct:");
		String ct=sc.next();
		System.out.println("enter key:");
		int key1=sc.nextInt();
		String decrypted=decrypt(ct,key1);
		System.out.println("pt:"+decrypted);
		System.out.println("enter brute force:");
		String bt=sc.next();
		bruteforce(bt);
		System.out.println("freq analysis going on:");
		freq(bt);
		
		}
	public static String encrypt(String pt,int key){
		String plt=pt.toLowerCase();
		String ct="";
		for(int i=0;i<plt.length();i++){
			int charpos=alphabect.indexOf(pt.charAt(i));
			int val=(charpos+key)%26;
			char char1=alphabect.charAt(val);
			ct+=char1;
		}
		return ct;
		
	}
	public static String decrypt(String ct,int key){
		String cpt=ct.toLowerCase();
		String plain="";
		for(int i=0;i<cpt.length();i++){
			int charpos=alphabect.indexOf(cpt.charAt(i));
			int keyval=(charpos-key)%26;
			if(keyval<0){
				keyval=keyval+alphabect.length();
				
			}
			char vall=alphabect.charAt(keyval);
			plain+=vall;
			}
			return plain;
	}
	public static void bruteforce(String ct){
		String bf=ct.toLowerCase();
		String value="";
		for(int i=1;i<=26;i++){
			for(int j=0;j<bf.length();j++){
				int values=alphabect.indexOf(bf.charAt(j));
				int answer=(values-i)%26;
				if(answer<0){
					answer=answer+alphabect.length();
				}
				char str=alphabect.charAt(answer);
				value+=str;	
				
			}
			System.out.println(i+"-"+value);
			value="";			
		}
	}
	public static HashMap<Character,Integer> freq(String cipher){
		Scanner ll=new Scanner(System.in);
		String cc=cipher.toLowerCase();
		HashMap<Character,Integer> hm=getfreq(cc);
		char mostfreq=freqchar(hm);
		while(true)
		{		System.out.println("enter the char u want to map with:");
		char user=ll.next().charAt(0);
		int use=getkey(mostfreq,user);
		System.out.println(decrypt(cc,use));
		}
	}
		
		 static int getkey(char mostfreq,char user){
			int m=alphabect.indexOf(mostfreq);
			int u=alphabect.indexOf(user);
			int ket=(m-u)%26;
			if(ket<0){
				ket=ket+26;
			}
			return ket;
		}
		
		
		static char freqchar(HashMap<Character,Integer> hm){
			int max=Integer.MIN_VALUE;
			char macx='a';
			for(Map.Entry entry:hm.entrySet()){
				int v=Integer.parseInt(entry.getValue().toString());
				if(v>max){
					max=v;
					macx=entry.getKey().toString().charAt(0);
				}
			}
			return macx;
}	
		static HashMap<Character,Integer> getfreq(String cc){
			HashMap<Character,Integer> hm=new HashMap<>();
			char[] strarray=cc.toCharArray();
			for(char c:strarray){
				if(hm.containsKey(c)){
					hm.put(c,hm.get(c)+1);
					
				}
				else{
					hm.put(c,1);
				}
			
		}
		return hm;
	}
	
}