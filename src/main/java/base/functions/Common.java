package main.java.base.functions;

import main.java.base.config.LogUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;


public class Common {

    private Common() {
    }

    @Deprecated
    public static String throwablesToString(Throwable e) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : e.getStackTrace()) {
            sb.append(element.toString());
            sb.append("\n");
        }
        return sb.toString();
    }


    public static void writeFile(String path, String content) {
        LogUtil.logger.debug("----Create file operation starts----");
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        Boolean fileExist;
        try {
            File file = new File(path);
            // if file doesn't exist, then create it
            if (!file.exists()) {
                fileExist = false;
                LogUtil.logger.info("Since file is not exist, create file operation begins");
                try {
                    file.createNewFile();
                } catch (FileAlreadyExistsException x) {
                    org.testng.Assert.fail(x.getMessage());
                } catch (IOException x) {
                    org.testng.Assert.fail(x.getMessage());
                }
                LogUtil.logger.debug("Create file operation is success");
            } else {
                fileExist = true;
                LogUtil.logger.debug("File is already exist. No need to create file again");
            }

            if (file.canWrite()) {
                // true = append file
                fileWriter = new FileWriter(file.getAbsoluteFile(), true);
                bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(content);

                if (fileExist) {
                    LogUtil.logger.debug("File is already exist. New content is appended into -->" + path);
                } else {
                    LogUtil.logger.debug("New file is created and content is written into -->" + path);
                }

            }
        } catch (IOException e) {
            LogUtil.logger.error(e);
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException ex) {
                org.testng.Assert.fail(ex.getMessage());
            }
        }
        LogUtil.logger.debug("----Create file operation ends----");
    }


    public static void takeSnapShot(WebDriver driver, String destFileWithPath) {
        try {
            // Convert web driver object to TakeScreenshot
            TakesScreenshot scrShot = ((TakesScreenshot) driver);

            // Call getScreenshotAs method to create image file
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

            // Move image file to new destination
            File destFile = new File(destFileWithPath);

            // Copy file at destination
            FileUtils.copyFile(srcFile, destFile);
        } catch (Exception e1) {
            org.testng.Assert.fail(e1.getMessage());
        }

    }
}
