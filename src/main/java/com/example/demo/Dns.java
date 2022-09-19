package com.example.demo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;

public class Dns {
public static void main(String[] args) throws Exception {
	//System.setProperty("sun.net.spi.nameservice.nameservers", "8.8.8.8");
	//System.setProperty("sun.net.spi.nameservice.provider.1", "dns,sun");
	System.setProperty("jdk.net.hosts.file", "C:\\Users\\e115891\\OneDrive - AIA Group Ltd\\.env\\hosts");
	InetAddress giriAddress = java.net.InetAddress.getByName("test.com");
 
	System.out.println( giriAddress.getHostAddress());
}
}
