package entities;

public class Triangulo {
	
	public double a;
	public double b;
	public double c;
	
	public double calculaArea() {
		double p = (a + b + c) / 2.0;
		double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		return area;
	}

}
/* not using any parameter because we just need
a, b and c to calculate the triangle area */
