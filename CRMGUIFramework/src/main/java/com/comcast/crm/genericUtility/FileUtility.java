package com.comcast.crm.genericUtility;

import java.io.FileInputStream;

import java.util.Properties;

public class FileUtility {
public String getdatafrompropertiesfile(String key) throws Throwable {
	FileInputStream file = new FileInputStream("./ConfigureAppdata/commondata.properties");
	Properties obj = new Properties();
	obj.load(file);
	String data = obj.getProperty(key);
	return data;
}
}
