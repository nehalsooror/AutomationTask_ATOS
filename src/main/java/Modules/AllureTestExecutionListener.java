package Modules;

import UIActions.UiAction;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class AllureTestExecutionListener implements ITestListener {

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
            element.saveScreenshot(result.getName(), UiAction.getDriver());
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
//            Allure.addAttachment("Console log: ", String.valueOf(UiAction.getDriver().manage().logs().get(LogType.BROWSER)));
//                System.out.println("Nehawwwww"+UiAction.getDriver().manage().logs().get(LogType.BROWSER));
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


