package Runner;

import java.awt.geom.GeneralPath;

import javax.swing.text.html.HTML;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.jvm.GenerateJvm;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/resources",glue = "stepdefinitions",monochrome = true,dryRun=false,
                 strict=true,snippets=SnippetType.CAMELCASE,plugin= {"html:target","junit:junit\\xmlreport.xml","json:JsonReport\\jsonre.json"})
public class TestRunner {
	
    @AfterClass
	public static void reportGenerationjvm() {
		GenerateJvm.report("C:\\Users\\Lenovo\\eclipse-workspace\\Cucumber\\JsonReport\\jsonre.json");
	}

}
