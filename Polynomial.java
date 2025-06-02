import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;




public class Polynomial{
	
	double [] coef;
	int [] pow;
	
	public Polynomial(){
		
		double [] a = {0.0};
		int [] b = {0};
		
		this.coef = a;
		this.pow = b;
	}
	
	
	public Polynomial(double [] a, int [] b){
		
		coef = a;
		pow = b;
				
	}
	
	
	
	public Polynomial(File a) throws Exception {
		
		Scanner input = new Scanner(a);
		String t = input.nextLine();
		input.close();
		
		if (t.charAt(0) != '+' && t.charAt(0) != '-') {
            t = "+" + t;
        }
		
		String[] p = t.split("(?=[+-])");
		
		int l = p.length;
		
		coef = new double[l];
        pow = new int[l];
        
        
        for(int i = 0; i<l; i++) {
        	
        	
        	if(p[i].contains("x")) {
        		
        			String[] pp = p[i].split("x");
        			if(pp[0].equals("+")) {
        				coef[i] = 1.0;        				
        			}else if(pp[0].equals("-")) {
        				coef[i] = -1.0;        				
        			}else {
        				coef[i] = Double.parseDouble(pp[0]);
        			}
        			
        			pow[i] = Integer.parseInt(pp[1]);
        		
        		
        		
        	}else {
        		coef[i] = Double.parseDouble(p[i]);
        		pow[i] = 0;
       		
        	}
        	
        	
        }
		
	}
	
	
	public void saveToFile(String a) throws IOException {
		
		String p = "";
		for(int i = 0; i < this.pow.length; i++) {
			if(i == 0) {
				p = p + Double.toString(this.coef[i]) + "x" + Integer.toString(this.pow[i]);			
			}else if(this.coef[i] > 0.0){
				p = p + "+" + Double.toString(this.coef[i]) + "x" + Integer.toString(this.pow[i]);
			}else if(this.coef[i] < 0.0) {
				p = p + Double.toString(this.coef[i]) + "x" + Integer.toString(this.pow[i]);
				
			}
			
		}
		
		FileWriter fileWriter = null;
		fileWriter = new FileWriter(a);
		fileWriter.write(p);
		fileWriter.close();
		
		
	}
	
	
	
	public Polynomial add(Polynomial p){

		
		int l = p.pow.length;
				
		
		for(int i = 0; i < this.pow.length; i++) {
			
			for(int j = 0; j < p.pow.length; j++) {
				if(p.pow[j] == this.pow[i]) {					
					
					this.coef[i] += p.coef[j];
					
					l--;					
				}
				
			}
			
			
		}
		
		l += this.pow.length;
		
		
		//Unordered temp arr
		
		double [] a = new double [l];
		int [] b = new int [l];
		
		
		int ii = 0;
		
		while(ii < this.pow.length) {

			b[ii] = this.pow[ii];
			a[ii] = this.coef[ii];
				
			ii++;
			
		}
		
		for(int j = 0; j < p.pow.length; j++) {
			
			int s = 0;
			
			for(int t = 0; t < this.pow.length; t++) {
				
				if(this.pow[t] == p.pow[j]) {
					s = 1;
				}			
			}
			
			if(s == 0) {
				
				a[ii] = p.coef[j];
				b[ii] = p.pow[j];
				ii++;		
				
				
			}
				
			
		}
		
		
		
		for(int i = 0; i < l; i++) {
			
			for(int j = i+1; j < l; j++) {
				
				if(b[i+1] < b[i]) {
					
					int abc = b[i];
					b[i] = b[i+1];
					b[i+1] = abc;
					
					double de = a[i];
					a[i] = a[i+1];
					a[i+1] = de;
					
				}

				
			}	
			
		}
		
		
		
		Polynomial pp = new Polynomial(a,b);
				
		return pp;
		
		
	}

	
	public double evaluate(double n) {
		
		double r = 0;
		
		for(int i = 0; i < this.pow.length; i++) {
			
			r += this.coef[i]*Math.pow(n,this.pow[i]);
			
			
		}
		
		
		return r;
		
	}
	
	
	public boolean hasRoot(double n) {
		
		return this.evaluate(n) == 0.0;		
		
	}
	
	
	public Polynomial multiply(Polynomial p) {
		
		int l = this.pow.length * p.pow.length;
		
		double [] a = new double [l];
		int [] b = new int [l];
		
		int ii = 0;
		
		
		for(int i = 0; i < this.pow.length; i++) {
			
			for(int j = 0; j < p.pow.length; j++) {
				
				a[ii] = this.coef[i] * p.coef[j];
				b[ii] = this.pow[i] + p.pow[j];
				ii++;
				
			}
			
			
			
		}
		
		double [] c = new double [l];
		int [] d = new int [l];
		
		ii = 0;
		
		for(int i = 0; i < l; i++) {
			
			
			int s = 0;
			
			for(int j = 0; j < ii; j++) {
				
				if(d[j] == b[i]) {
					c[j] += a[i];
					s = 1;
				}
				
			}
			
			
			if(s == 0) {
				
				c[ii] = a[i];
				d[ii] = b[i];
				ii++;				
				
			}

			
		}
		
		double [] e = new double [ii];
		int [] f = new int [ii];
		
		for(int i = 0; i < ii; i++) {
			
			e[i] = c[i];
			f[i] = d[i];			
			
		}
		
		
		for(int i = 0; i < ii; i++) {
			
			for(int j = i+1; j < ii; j++) {
				
				if(f[i+1] < f[i]) {
					
					int abc = f[i];
					f[i] = f[i+1];
					f[i+1] = abc;
					
					double de = e[i];
					e[i] = e[i+1];
					e[i+1] = de;
					
				}

				
			}	
			
		}
		
		
		
		Polynomial pp = new Polynomial(e,f);
				
		return pp;
		
		
		
		
		
		
	}
	
	
	
	
}