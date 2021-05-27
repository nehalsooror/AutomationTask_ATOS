package FileReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import Modules.ErrorHandling;


public class PropertiesFileReader {
    /**
	 *
     * @param Keys
     * @return
     */
    public static String[] propertiesFileReader(String[] Keys, String path) {

        String data[] = new String[Keys.length];
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream(path);

            prop.load(input);
        } catch (IOException e) {
            //errorhandling method
            ErrorHandling.IOExceptionHandling(e);
            // TODO Auto-generated catch block
        }
        for (int j = 0; j < Keys.length; j++) {
            data[j] = prop.getProperty(Keys[j]);
        }
        return data;
    }
}
