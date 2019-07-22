package com.training.mphasis.fileprograms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandlingExample {
	public static void main(String args[]) throws IOException{
		
		//writing the data
		
		FileOutputStream fos = new FileOutputStream("abc.txt",true);
		BufferedOutputStream bos = new BufferedOutputStream(fos); // when we have huge data
		String s1 = "Welcome to IO";
		bos.write(s1.getBytes());
		bos.close();
		fos.close();
		
		//reading the data
		
		FileInputStream fis = new FileInputStream("abc.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		//System.out.println((char)fis.read());  ----> for single character
		int i;
		while((i=bis.read())!=-1) {               //for the complete string
			System.out.print((char)i);
		}
		bis.close();
		fis.close();
	}
}
