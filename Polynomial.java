public class Polynomial{
	
	double [] coef;
	
	public Polynomial(){
		
		double [] a = {0};
		
		this.coef = a;
	}
	
	
	public Polynomial(double [] arr){
		
		coef = arr;
		
	}
	
	
	public Polynomial add(Polynomial p){

		
		if(p.coef.length <= this.coef.length) {
				
			for(int i = 0; i < p.coef.length; i++) {
			
				this.coef[i] += p.coef[i];
			}

			return this;
			
		}
		
		
		for(int i = 0; i < this.coef.length; i++) {
			
			p.coef[i] += this.coef[i];			
			
		}
		
		this.coef = p.coef;
		
		return this;

	}

	
	public double evaluate(double n) {
		
		double r = 0;
		
		for(int i = 0; i < this.coef.length; i++) {
			
			r += this.coef[i]*Math.pow(n,i);
			
			
		}
		
		
		return r;
		
	}
	
	
	public boolean hasRoot(double n) {
		
		return this.evaluate(n) == 0.0;		
		
	}
	
	
	
	
}