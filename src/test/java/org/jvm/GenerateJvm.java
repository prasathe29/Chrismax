package org.jvm;

import java.io.File;
import java.util.ArrayList;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class GenerateJvm {

	public static void report(String jsonfilepath) {
		
		File f = new File("C:\\Users\\Lenovo\\eclipse-workspace\\Cucumber\\src\\test\\resources\\Jvm");
		Configuration c = new Configuration(f, "facebook");
		c.addClassifications("browser", "chrome");
		c.addClassifications("os", "11");
		java.util.List<String> l = new ArrayList<String>();
		l.add(jsonfilepath);
		ReportBuilder r = new ReportBuilder(l, c);
		r.generateReports();
		System.out.println(l);
	}
}
