package support.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class FileOperations {

    private static final String DIR_PATH_PROPERTIES =

            System.getProperty("user.dir") + File.separator + "IntegrationTest" + File.separator + "src" +
                    File.separator + "test" + File.separator + "resources" + File.separator + "properties" + File.separator;

    public static Properties getProperties(String fileName){

        InputStream inputStream = null;
        Properties prop = new Properties();

        try {

            File file = new File(DIR_PATH_PROPERTIES+ fileName + ".properties");
            inputStream = new FileInputStream(file);
            prop.load(inputStream);
            return prop;

        } catch (Exception e) {

            System.out.println("Passando Exception " + e.getMessage());
        }
        return prop;
    }


}
