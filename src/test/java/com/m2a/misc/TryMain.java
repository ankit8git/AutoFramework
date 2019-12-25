package com.m2a.misc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TryMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
       Properties config=new Properties();
       FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
       config.load(fis);
       System.out.println(config.getProperty("browser"));
       
	}

}
