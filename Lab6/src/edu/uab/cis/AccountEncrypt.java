package edu.uab.cis;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AccountEncrypt extends FileOutputStream {

	public AccountEncrypt(String arg) throws FileNotFoundException 
	{
		super(arg);
		
	}
	
	@Override
	public void write(byte[] arg) throws IOException
	{
		for (int i = 0; i < arg.length; i++)
		{
			arg[i]++;
		}
	}

}
