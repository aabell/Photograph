package project8;
import java.util.*;
public class Main {

	public static void main(String[] args) {
// put your testing code here
	//System.out.println(Main.m(400));
	System.out.println(Main.logStar(4));
	//System.out.println(Main.lSystem("F","F","F+F-F",1));
	
	}

	/**
	 * PART 1 - the M method
	 * @param n
	 * @return
	 */
	public static int m(int n) {
	if (n>100){
	return n-10;
		
	}
	else {
		return m(m(n+11));
	
	}
		
	}
	
	/**
	 * PART 2 - Log* method
	 * @param x
	 * @return
	 */
	public static int logStar(double x) {
      if(x<=1)
	   return 0;
      
	return 1+logStar(Math.log(x) / Math.log(2));
	}
		
	


/**
	 * PART 3 - makeChange method
	 * @param n
	 * @return
	 */
	public static String makeChange(int n) {
	
		return makeChange_aux("",n);
		
		
	}
	
	private static String makeChange_aux(String change, int n){
		if(n>=25)
			return makeChange_aux(change+"Q",n-25);
		else if(n>=10 && n<25)
			return makeChange_aux(change+"D",n-10);
		else if(n>=5 && n<10)
			return makeChange_aux(change+"N",n-5);
		else if(n>=1 && n<5)
			return makeChange_aux(change+"P",n-1);
		else
			return change;
	}
	/**
	 * CHALLENGE PROBLEM - l-SYSTEM
	 * @param start
	 * @param pattern
	 * @param replacement
	 * @param depth
	 * @return
	 */
	public static String lSystem(String start, String pattern, String replacement, int depth) {
if (depth==0){
	return start;
}
else {
	 return lSystem(start.replace(pattern, replacement),pattern,replacement,depth-1);
}
	}

}
