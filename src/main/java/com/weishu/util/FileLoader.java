package com.weishu.util;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileLoader {
	
	private String fileString;

	/**
	 * 
	 * @param classPathFile 在ClassPath下的文件路径
	 */
	public FileLoader(String classPathFile) {
		fileString = readFile(classPathFile);
	}
	
	public String getFileString() {
		return fileString;
	}

	private String readFile(String fileName) {
		String result = "";
		Reader reader = null;
		InputStream in = FileLoader.class.getClassLoader().getResourceAsStream(fileName);
		try {
			reader = new InputStreamReader(in,"UTF-8");
			int tempChar;
			while((tempChar=reader.read())!=-1) {
				result += (char)tempChar;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
