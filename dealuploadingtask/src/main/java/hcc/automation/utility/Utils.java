package hcc.automation.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Random;

import static java.time.temporal.TemporalAdjusters.firstInMonth;

public class Utils {
    public static String getElementFromPropertiesFile(String key, String filename) {
        Properties property = new Properties();
        try {
            FileInputStream readMe = new FileInputStream("src/main/java/hcc/automation/resources/" + filename + ".properties");
            property.load(readMe);
        } catch (IOException exception) {
            System.out.println("Something gone wrong in Utils. getElementFromPropertiesFile " + exception.getMessage());
        }
        return property.getProperty(key);
    }


}

