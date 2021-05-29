package Modules;

import UIActions.UiAction;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;



public class AllureTestExecutionListener implements ITestListener  {

            UiAction element = new UiAction();



        @Override
        public void onTestStart(ITestResult result) {
            // TODO Auto-generated method stub



        }
        @Override
        public void onTestSuccess(ITestResult result) {
            // TODO Auto-generated method stub

        }
        @Override
        public void onTestFailure(ITestResult result) {
            // TODO Auto-generated method stub
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) UiAction.getDriver()).getScreenshotAs(OutputType.BYTES)));

            // IMPORTANT: Save the old System.out!
//            PrintStream old = System.out;
//            System.setOut(ps);
////            System.out.flush();
//            System.setOut(old);
//            System.out.println("Here: " + baos.toString());
//
//            // Tell Java to use your special stream
//                Allure.addAttachment("Failed page source", "text/plain", "Here: " +baos.toString(), "txt");


        }
        @Override
        public void onTestSkipped(ITestResult result) {
            // TODO Auto-generated method stub

        }
        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
            // TODO Auto-generated method stub

        }
        @Override
        public void onStart(ITestContext context) {
            // TODO Auto-generated method stub

        }
        @Override
        public void onFinish(ITestContext context) {
            // TODO Auto-generated method stub
////
//            LogEntries logEntries = UiAction.getDriver().manage().logs().get(LogType.BROWSER);
//
//            StringBuilder logs = new StringBuilder();
//
//
//            for (org.openqa.selenium.logging.LogEntry entry : logEntries) {
//                logs.append(new Date(entry.getTimestamp()) + " "
//                        + entry.getLevel() + " " + entry.getMessage());
//                logs.append(System.lineSeparator());
//
//            }
//            System.out.println(logs);
//            Allure.addAttachment("Console log: ", String.valueOf(logs));
        }

    }


