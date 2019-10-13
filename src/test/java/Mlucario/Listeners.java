package Mlucario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import resources.ExtentManager;
import resources.ExtentTestManager;
import resources.base;

public class Listeners extends base implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		LOGGER.info("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		LOGGER.info((result.getMethod().getMethodName() + " failed!"));

		String targetLocation = null;

		String testClassName = (result.getInstanceName()).trim();
		Timestamp timestampX = new Timestamp(System.currentTimeMillis());
		Long timeStamp = timestampX.getTime(); // get timestamp
		String testMethodName = result.getName().toString().trim();
		String screenShotName = testMethodName + timeStamp + "_screenshot.png";
		String fileSeperator = System.getProperty("file.separator");
		String reportsPath = System.getProperty("user.dir") + fileSeperator + "test-output" + fileSeperator
				+ "screenshots";
		LOGGER.info("Screen shots reports path - " + reportsPath);
		try {

			File file = new File(reportsPath + fileSeperator + testClassName); // Set screenshots folder

			if (!file.exists()) {
				if (file.mkdirs()) {
					LOGGER.info("Directory: " + file.getAbsolutePath() + " is created!");
				} else {
					LOGGER.info("Failed to create directory: " + file.getAbsolutePath());
				}

			}

			targetLocation = reportsPath + fileSeperator + testClassName + fileSeperator + screenShotName;

			getScreenShot(targetLocation);
			LOGGER.info("Take screen shot of failure test........");
			LOGGER.info("Screen shot file location - " + targetLocation);
		} catch (FileNotFoundException e) {
			LOGGER.info("File not found exception occurred while taking screenshot " + e.getMessage());
		} catch (Exception e) {
			LOGGER.info("An exception occurred while taking screenshot " + e.getCause());
		}

		// attach screenshots to report
		try {
			ExtentTestManager.getTest().fail("Screenshot",
					MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
		} catch (IOException e) {
			LOGGER.info("An exception occured while taking screenshot " + e.getCause());
		}
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());

	}

	@Override
	public void onStart(ITestContext context) {

		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();

	}

}
