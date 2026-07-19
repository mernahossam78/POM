package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class AllureUtils {
    //Clean allure results folder
    public static void cleanAllureResults() {
        FileUtils.deleteQuietly(new File("test-output/allure-results"));
    }
}
