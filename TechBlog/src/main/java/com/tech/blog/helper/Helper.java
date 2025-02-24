package com.tech.blog.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Helper {
	
	public static boolean deleteFile(String path) {
		boolean flag = false;
		
		try {
			
			File file = new File(path);
			file.delete();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public static boolean saveFile(InputStream is, String path) {
		boolean flag = false;
		
		try {
			
			byte byteArr[] = new byte[is.available()];
			is.read(byteArr);
			
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(byteArr);
			
			fos.flush();
			fos.close();
			
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
}
