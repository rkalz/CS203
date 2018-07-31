package edu.uab.cis;

import java.util.Scanner;

public class Matrix {
	
	private double[][] matrix; 
	
	public Matrix()
	{
		matrix = read();
	}
	
	public Matrix(double[][] mat)
	{
		matrix = mat;
	}

	//reads in a matrix from the command line
	public double[][] read()
	{
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter the number of rows: ");
		int row = inp.nextInt();
		System.out.println("Enter the number of columns: ");
		int col = inp.nextInt();
		
		double[][] out = new double[row][col];
		
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				System.out.println("Enter the value for row " + i + " coulumn " + j + ": ");
				out[i][j] = inp.nextDouble();
			}
		}
		
		return out;
		
	}
	
	//prints the matrix to the command line
	public void display()
	{
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[i].length; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.println();
		}
	}
	
	//returns the number of rows
	public int getRows()
	{
		return matrix.length;
		
	}
	
	//returns the number of columns
	public int getCols()
	{
		return matrix[0].length;
		
	}
	
	//sets the double value at a particular column/row position
	public void set(double num, int row, int col)
	{
		matrix[row][col] = num;
	}
	
	//returns the value stored at a particular column/row position
	public double get(int row, int col)
	{
		return matrix[row][col];
		
	}
	
	// returns a new Matrix object that is the result of adding this Matrix object with another Matrix object. 
	//Two matrices have to have the same dimensions to be added together. 
	//Otherwise the two matrices cannot be added.
	public Matrix plus(Matrix that)
	{
		if (getRows() != that.getRows() || getCols() != that.getCols())
		{
			return null;
		}
		double[][] sol = new double[getRows()][getCols()];
		
		for (int i = 0; i < this.getRows(); i++)
		{
			for (int j = 0; j < this.getCols(); j++)
			{
				sol[i][j] = this.get(i,j) + that.get(i,j);
			}
		}
		return new Matrix(sol);
	}
	
	// returns a new Matrix object  (the product) that is the result of multiplying this Matrix object 
	//with another Matrix object. 
	//This Matrix has to have the same number of columns as the other Matrix object has number of rows. 
	//Otherwise the two matrices cannot be multiplied.
	public Matrix multiply(Matrix that)
	{
		if (getCols() != that.getRows())
		{
			return null;
		}
		double[][] sol = new double[getRows()][that.getCols()];
		
		for (int i = 0; i < this.getRows(); i++)
		{
			for (int j = 0; j < that.getCols(); j++)
			{
				for (int k = 0; k < this.getRows(); k++)
				{
					sol[i][j] = sol[i][j] + this.get(i,k)*that.get(i, j);
				}
			}
		}
		
		return new Matrix(sol);
	}
}
