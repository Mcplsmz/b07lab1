public class Driver { 
	public static void main(String [] args) { 
		Polynomial p = new Polynomial(); 
		//System.out.println(p.evaluate(3)); 
		double [] c2 = {6,1,1,5};
		int [] d2 = {0,1,2,3};
		 
		double [] c1 = {1,1,1,1,1};
		int [] d1 = {1,2,3,4,5};
		Polynomial p1 = new Polynomial(c1,d1);
		Polynomial p2 = new Polynomial(c2,d2); 
		Polynomial s = p1.multiply(p2);
		
		for(int i = 0; i<s.pow.length; i++) {
			
			
			System.out.println(s.coef[i]);
			System.out.println(s.pow[i]);
			System.out.println(" _________________ ");
			
			
		}
		
		System.out.println(p1.evaluate(1));
		System.out.println(p2.evaluate(1));
		System.out.println(s.evaluate(1));
		
		System.out.println("s(0.1) = " + s.evaluate(0.1)); 
		if(s.hasRoot(1)) 
			System.out.println("1 is a root of s");
		else
			System.out.println("1 is not a root of s");
	}
}