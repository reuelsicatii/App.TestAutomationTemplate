package cucumber.Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.genium_framework.appium.support.server.AppiumServer;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import io.appium.java_client.android.AndroidDriver;
import test.Utilities.CustomLogger;

//MERGE WEBHelper and ReUsablesKeywords through Interface
public class WEBHelper {

	public static WebDriver driver = null;
	public static AndroidDriver ADdriver = null;
	public static WebDriverWait WD = null;
	public static String winHandleBefore;
	public static JavascriptExecutor JS = null;
	public static ReUsablesKeywords ReUsablesKeyword = new ReUsablesKeywords();
	public static CommonSteps CommonStep = new CommonSteps();
	public static Logger log = CustomLogger.log(WEBHelper.class);
	public static AppiumServer appiumServer = null;
	public static Process process;
	public static Properties properties;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static Actions action = null;
	public static Alert alert;
	public static Date date = new Date();
	public static String yearMonthDayFormat = new SimpleDateFormat("yyyy-MM-dd").format(date);
	public static String yearMonthDayTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	public static String dateNoSpace = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
	public static String monthYearFormat = new SimpleDateFormat("MMM yyyy").format(date);
	public static String dateNoMin = new SimpleDateFormat("yyMMddSSS").format(date);
	public static String loginRunStatus = "no";

	static String BrowserType;
	static int I_wait = 60;
	static int S_wait = 60;
	static int WD_wait = 60;
	static int PG_wait = 60;

	public static String GetPropertValue(String Path, String Key) {

		properties = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(Path);
			properties.loadFromXML(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return properties.getProperty(Key);

	}

	public static void CloseDriverObject() {
		try {
			log.info("Execute TASK KILL against pre-existing CHROMEDRIVER");
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
			Thread.sleep(5000);

		} catch (IOException | InterruptedException e) {
			log.info("Pre-existing CHROMEDRIVER not killed");
		}

		try {
			log.info("Execute TASK KILL against pre-existing FIREFOXDRIVER");
			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");
			Thread.sleep(5000);
		} catch (IOException | InterruptedException e) {
			log.info("Pre-existing FIREFOXDRIVER not killed");
		}

		try {
			log.info("Execute TASK KILL against pre-existing IEDRIVERSERVER");
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe /T");
			Thread.sleep(5000);
		} catch (IOException | InterruptedException e) {
			log.info("Pre-existing IEDRIVERSERVER not killed");
		}

	}

	public static void GetDriverObject() {

		System.out.println("Helper - Scenario Name: " + SetUp.ScenarioName);
		switch (SetUp.ScenarioName) {
		case "COMSMOKETEST_TS06":
			BrowserType = "FIREFOX";
			break;

		case "COMSMOKETEST_TS07":
			BrowserType = "FIREFOX";
			break;

		case "COMSMOKETEST_TS08":
			BrowserType = "FIREFOX";
			break;

		case "COMSMOKETEST_TS09":
			BrowserType = "FIREFOX";
			break;

		case "LocalSEO_TS01":
			BrowserType = "FIREFOX";
			break;

		case "LocalSEO_TS04":
			BrowserType = "FIREFOX";
			break;

		case "OrganicSEO_TS01":
			BrowserType = "FIREFOX";
			break;

		case "OrganicSEO_TS04":
			BrowserType = "FIREFOX";
			break;

		case "WebDesign_TS01":
			BrowserType = "FIREFOX";
			break;

		case "TAA-382":
			BrowserType = "FIREFOX";
			break;

		default:
			BrowserType = GetPropertValue("Data/TestProperties.xml", "BrowserType");
			break;

		}

		log.info("Execution will be begin on Browser name " + BrowserType);
		String Environment = GetPropertValue("Data/TestProperties.xml", "TestEnv");
		log.info("Execution will be begin on Environment: " + Environment);
		DesiredCapabilities capabilities = new DesiredCapabilities();

		if (driver == null) {
			if (BrowserType.equalsIgnoreCase("IE")) {
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver(capabilities);
				driver.manage().window().maximize();
			}

			else if (BrowserType.equalsIgnoreCase("CHROME")) {
				System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");
				options.setBinary(System.getProperty("user.dir") + "\\Browsers\\CH64_v53\\chrome.exe");
				driver = new ChromeDriver(options);
				log.info("Initiate CHROME v53");
			}
			
			else if (BrowserType.equalsIgnoreCase("CHROME") && SetUp.ScenarioName.matches("TAA-382")) {
				System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
				Proxy proxy = new Proxy();
				proxy.setHttpProxy("173.234.225.196:3128");
				proxy.setSslProxy("173.234.225.196:3128");
				capabilities.setCapability("proxy", proxy);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");
				options.setBinary(System.getProperty("user.dir") + "\\Browsers\\CH64_v53\\chrome.exe");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(capabilities);
				log.info("Initiate CHROME v53");
			}

			else if (BrowserType.equalsIgnoreCase("FIREFOX")) {
				System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
				FirefoxBinary FfBinary = new FirefoxBinary(
						new File(System.getProperty("user.dir") + "\\Browsers\\FF64_v46\\firefox.exe"));
				FirefoxProfile firefoxProfile = new FirefoxProfile();
				driver = new FirefoxDriver(FfBinary, firefoxProfile);
				driver.manage().window().maximize();
				log.info("Initiate FIREFOX v46");
			}

			else if (BrowserType.equalsIgnoreCase("HTMLUNIT")) {
				LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log",
						"org.apache.commons.logging.impl.NoOpLog");
				java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
				java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);
				driver = new HtmlUnitDriver();

			}

		}

		driver.manage().timeouts().implicitlyWait(I_wait, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(S_wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PG_wait, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		WD = new WebDriverWait(driver, WD_wait);
		JS = (JavascriptExecutor) driver;
		action = new Actions(driver);

	}

	public static void CallAPI(String Endpoint) throws IOException, InterruptedException {

		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(Endpoint).build();

		Response response = client.newCall(request).execute();
		if (response.code() == 200) {
			System.out.println("URL link Resopnse Code 200");
		}

		else {
			System.out.println("URL link Resopnse Code not 200");
		}

	}

	public static String GetApplication() throws IOException, InterruptedException {
		String App = null;
		if (SetUp.getScenarioID().contains("seoreseller")) {
			App = "Seoreseller";
		} else if (SetUp.getScenarioID().contains("compass")) {
			App = "Compass";
		}

		return App;
	}

	public static String GetTestEnv() throws IOException, InterruptedException {
		String TestEnv = null;
		TestEnv = GetPropertValue("Data/TestProperties.xml", "TestEnv");

		return TestEnv;
	}

	public static void MouseHover(WebElement we) {
		Actions action = new Actions(driver);
		action.moveToElement(we).build().perform();
	}

	public static String GetCurrentDateWithTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

		return currentDate;
	}

	public static String GetCurrentDateWithoutTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(date);

		return currentDate;
	}

	public static String DateAddition(int numberOfDays) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, numberOfDays);
		String currentDate = dateFormat.format(c.getTime());

		return currentDate;
	}

	public static void WindowScrollAndClick(WebElement we) {
		driver.manage().window().maximize();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", we);
	}

	public static String GetCurrentDateMonthYear() {
		Date date = new Date();
		String currentDate = new SimpleDateFormat("MMM yyyy").format(date);

		return currentDate;
	}

	public static String ReadContentFromTextFile(String fileName) throws IOException {
		String filePath = System.getProperty("user.dir") + "\\Data\\" + fileName;

		String content = "";
		content = new String(Files.readAllBytes(Paths.get(filePath)));
		return content;
	}

	public void actionSendKeys(WebElement WE, String input) {
		Actions actions = new Actions(driver);
		actions.moveToElement(WE);
		actions.click();
		actions.sendKeys(input);
		actions.build().perform();
	}

	public static void SelectByVisibleText(WebElement we, String text) {
		Select select = new Select(we);
		select.selectByVisibleText(text);
	}

	public static void clearWriteTextfile(String file, String content) throws IOException {
		String filePath = System.getProperty("user.dir") + "\\Data\\" + file + "";

		FileWriter fwOb = new FileWriter(filePath, false);
		PrintWriter pwOb = new PrintWriter(fwOb, false);
		pwOb.print(content);
		pwOb.flush();
		pwOb.close();
		fwOb.close();
	}

	String content;

	public static String readTextfile(String file) throws IOException {
		String filePath = System.getProperty("user.dir") + "\\Data\\" + file + "";
		String content;
		content = new String(Files.readAllBytes(Paths.get(filePath)));

		return content;
	}

}
