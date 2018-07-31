package edu.uab.cis;

import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BankAccountTest 
{
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		BankAccount acct = new BankAccount(176342,3000,"Test");
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("out.txt"));
		out.writeObject(acct);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("out.txt"));
		acct = (BankAccount) in.readObject();
		in.close();
		System.out.println(acct);
		
	}
}
