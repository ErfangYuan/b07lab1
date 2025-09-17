
public class Polynomial {
	double [] coefficients;
	
	public Polynomial() {
		coefficients = new double[1];
	}
	
	public Polynomial(double [] new_coef) {
		coefficients = new double[new_coef.length];
		for (int i = 0; i < new_coef.length; i++) {
			this.coefficients[i] = new_coef[i];
		}
	}
	
	public Polynomial add(Polynomial another) {
		if (this.coefficients.length >= another.coefficients.length) {
			double[] result = new double[this.coefficients.length];
			for (int i = 0; i < this.coefficients.length; i++) {
				result[i] += this.coefficients[i];
				if (i >= another.coefficients.length){
					result[i] += 0;
				}
				else {
					result[i] += another.coefficients[i];
				}
			}
			return new Polynomial(result);
		}
		else {
			double[] result = new double[another.coefficients.length];
			for (int j = 0; j < another.coefficients.length; j++) {
				result[j] += another.coefficients[j];
				if (j >= this.coefficients.length) {
					result[j] += 0;
				}
				else {
					result[j] += this.coefficients[j];
				}
			}
			return new Polynomial(result);
		}
	}
	
	public double evaluate(double x) {
		double result = 0.0;
		for (int i = 0; i < this.coefficients.length; i++) {
			result += this.coefficients[i] * (Math.pow(x, i));
		}
		return result;
	}
	
	public boolean hasRoot(double x) {
		if (this.evaluate(x) == 0) {
			return true;
		}
		return false;
	}
}
