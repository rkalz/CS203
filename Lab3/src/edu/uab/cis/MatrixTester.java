package edu.uab.cis;

public class MatrixTester {

	public static void main(String[] args) 
	{
		
		double[][] mat = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		double[][] tes = {
				{1,1,1},
				{1,1,1},
				{1,1,1}
		};
		
		Matrix test = new Matrix(tes);
		Matrix matr = new Matrix(mat);
		
		test.plus(matr).display();
		System.out.println();
		test.multiply(matr).display();
		/*
		
		Matrix.display();
		
		System.out.println(matr.getRows());
		System.out.println(matr.getCols());
		System.out.println();
		
		matr.set(5, 1, 2);
		matr.display();
		System.out.println(matr.get(1, 2));*/
		

	}

}
