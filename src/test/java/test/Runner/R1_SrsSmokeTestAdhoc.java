package test.Runner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.Framework.WEBHelper;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import test.Utilities.Mail;

@RunWith(Cucumber.class)
@CucumberOptions(

		format = { "pretty", "html:target/cucumber", "json:target/JSON/R1_SrsSmokeTestAdhocReport.json" }, features = {
				"." }, glue = { "cucumber.Framework", "webApp.Compass", "webApp.Seoreseller", "webApp.PayPerContent",
						"webApp.Mailbox" }, plugin = {
								"com.cucumber.listener.ExtentCucumberFormatter:target/R1_SrsSmokeTestAdhocReport.html",
								"rerun:target/SrsAdhocRerun.txt" }, tags = { "@SRS-7870_TS02" }

)

public class R1_SrsSmokeTestAdhoc extends WEBHelper {

	@BeforeClass
	public static void BeforeClass() throws Exception {
		log.info("Execution is started from First Runner Test - BeforeClass Annotation");
		loginRunStatus = "yes";
		File file = new File(System.getProperty("user.dir") + "\\target\\JSON\\R1_SrsSmokeTestAdhocReport.json");
		try {
			file.delete();
			log.info("File successfully deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public static void AfterClass() throws IOException, Throwable {

		String htmlFilePath = System.getProperty("user.dir") + "\\target\\R1_SrsSmokeTestAdhocReport.html";
		String htmlFileContent = new String(Files.readAllBytes(Paths.get(htmlFilePath)));

		if (htmlFileContent.contains("'status fail'")) {

			Mail.SendFailedReport("R1_SrsSmokeTestAdhocReport.html", GetApplication() + GetTestEnv(),
					"[SMOKE TEST]: " + GetApplication() + GetTestEnv() + " (Adhoc:FAILED) - ");
			log.info("Execution is ended from Second Runner - Test AfterClass Annotation");
		}

	}
}
