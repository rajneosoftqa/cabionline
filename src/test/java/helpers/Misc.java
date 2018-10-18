package helpers;

import org.apache.commons.io.FilenameUtils;
import static org.junit.Assert.*;
import step_definitions.BaseClass;

import java.io.File;

public class Misc extends BaseClass {

    String driverDirectory = System.getProperty("user.dir") + "/testData/Download";

    public void downloadFile(String filename, String extension) throws Throwable {
        Thread.sleep(10000);
        File[] files = new File(driverDirectory).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
                assertTrue(FilenameUtils.getExtension(file.getName()).equals(extension) && file.getName().contains(filename));

                file.delete();
            }
        }
    }
}
