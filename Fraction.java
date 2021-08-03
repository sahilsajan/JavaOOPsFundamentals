package classesandobjects;

public class Fraction {
	private int numerator;
	private int denominator;

//Constructor to initialize values of the numerator and denominator
	public Fraction(int numerator, int demoninator){
		if(denominator == 0){
		//throw error or set default value
		   denominator = 1;
		}
		this.numerator = numerator;
		this.denominator = denominator;
		simplify();
	}


//using setters and getters to work with private values
	public void setNumerator(int num){
		this.numerator = num;
		simplify();
	}
	
	public int getNumerator(){
		return numerator;
	}
	
	public void setDenominator(int num){
		if(num == 0){
		//throw error or return
		   return;
		}
		this.denominator = num;
		simplify();
	}
	
	public int getDenominator(){
		return denominator;
	}

//simplifies the fraction to simplest form
	private void simplify(){
		int gcd = 1;
		int smaller = Math.min(numerator, denominator);
		for(int i = 2; i <= smaller; i++){
		   if(numerator % i == 0 && denominator % i == 0){
			gcd = i;
		   }
		}
		numerator = numerator / gcd;
		denominator = denominator / gcd;
	}

//adding 1 to the fraction
	public void increment(){
		numerator = numerator + denominator;
		simplify();
	}

//printing the fraction values
	public void print(){
		System.out.println(numerator +"/"+ denominator);
	}

//adding two fractions and update current fraction as answer
	public void add(Fraction f2){
	//first fraction is the fraction on which function is called
	//second fraction is passed as the argument
	this.numerator = this.numerator * f2.denominator + this.denominator * f2.numerator;
	this.denominator = this.denominator * f2.denominator;
	simplify();
	}

//adding two fraction and returning new fraction as answer
//its static because it should not depend on an object as we are passing in 2 fractions required
	public static Fraction addNew(Fraction f1, Fraction f2){
		int newNum = f1.numerator * f2.denominator + f1.denominator * f2.numerator;
		int newDeno = f1.denominator * f2.denominator;
		Fraction f3 = new Fraction(newNum, newDeno);
		return f3;
	}

}
