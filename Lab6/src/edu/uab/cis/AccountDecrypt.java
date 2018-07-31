package edu.uab.cis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AccountDecrypt extends FileInputStream 
{

	public AccountDecrypt(String arg) throws FileNotFoundException {
		super(arg);
	}
	
	@Override
	public int read() throws IOException
	{
		int byteValue = super.read();
		//byteValue--;
		return byteValue;
	}

}
