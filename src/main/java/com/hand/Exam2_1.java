package com.hand;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Exam2_1 {

	public static void main(String[] args) {
		new ReadByGet().start();


	}


	static class ReadByGet extends Thread{
		@Override
		public void run() {
			try {

				URL url = new URL("http://www.manning.com/gsmith/SampleChapter1.pdf");

				URLConnection conn = url.openConnection();
				InputStream is=conn.getInputStream();
				InputStreamReader isr = new InputStreamReader(is,"utf-8");
				BufferedReader br = new BufferedReader(isr);
				
				FileOutputStream fos = new FileOutputStream("SampleChapter1.pdf");
				OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
				PrintWriter pw = new PrintWriter(osw,true);

				String line;
				while ((line=br.readLine())!=null) {
					pw.println(line);

				}
				pw.close();
				osw.close();
				fos.close();
				br.close();
				isr.close();
				is.close();
				
				
				System.out.println("读写完成");



			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}

