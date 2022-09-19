package com.example.demo;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoApplication {

	public static void main(String[] args) throws Exception {
	 ServerSocket ss = new ServerSocket(8082);
	Socket  s;
	while((s= ss.accept())!=null) {
		var x1=s;
		Runnable a=()->{
			try (InputStream in =new BufferedInputStream(  x1.getInputStream())){
				byte[] buf=new byte[1024];
				int l=0;
				while((l=in.read(buf))!=-1) {
					System.out.println(new String(buf,0,l));
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		new Thread(a).start();
	}
		
	}

}
