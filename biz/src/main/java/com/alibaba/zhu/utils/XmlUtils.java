package com.alibaba.zhu.utils;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;

//3
public class XmlUtils {
	private static String filepath;
	static{
		filepath=XmlUtils.class.getClassLoader().getResource("users.xml").getPath();
		filepath=filepath.replace("%20", " ");
	}
	public static Document getDocument() throws Exception{
		SAXReader reader = new SAXReader();
        Document document = reader.read(new File(filepath));
        return document;
	}
	public static void write2Xml(Document document) throws Exception{
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(new FileOutputStream(filepath), format );
        writer.write( document );
        writer.close();
	}

}
