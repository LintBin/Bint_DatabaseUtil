package com.bint.util;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
/**
 * @author  linhongbin
 * @version:  V1.0
 */
public class DbConfigXMLUtil {
	private File file;
	private Document doc;
	public static String dbType;
	public static String dbName;
	public static String dbUsername;
	public static String dbPassword;
	public static String dbHost;
	public static String port;

	public DbConfigXMLUtil() {
		try {
			file = new File("src/dbconfig.xml");
			doc = Jsoup.parse(file, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbType = doc.select("db-type").text();
		dbName = doc.select("db-dbname").text();
		dbPassword = doc.select("db-password").text();
		dbUsername = doc.select("db-username").text();
		dbHost = doc.select("db-host").text();
		port = doc.select("db-port").text();
	}
}
