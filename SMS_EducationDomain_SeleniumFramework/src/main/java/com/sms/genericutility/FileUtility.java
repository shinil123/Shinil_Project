package com.sms.genericutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String getFilePathFromPropertiesFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./config/filepath.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
	
	public String getDataFromProperties(String filePath, String key) throws Throwable {
		FileInputStream fis = new FileInputStream(filePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
}
}