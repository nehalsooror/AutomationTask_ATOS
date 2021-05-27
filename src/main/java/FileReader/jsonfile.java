package FileReader;



import java.io.FileReader;
import java.io.IOException;

import org.json.simple.*;
import org.json.simple.parser.*;

import Modules.ErrorHandling;

public class jsonfile {

    /**
     *
     * @param x
     * @param y
     * @return
     */
  public static String[][] json_reader(int x,int y) {

		String [][]data = new String[x][y];
		//String []data_internal_arr = new String[2];
		
      try {
          JSONParser parser = new JSONParser();
//         Object obj = parser.parse(new FileReader("jsonfile.json"));
          JSONArray jsonarr = (JSONArray) parser.parse(new FileReader("jsonfile.json"));
          
        for(int i = 0 , j = 3 ; i < x ; i++) {
        	  
          JSONObject jsonobject = (JSONObject)jsonarr.get(i);
          
         data[i][0] = (String) jsonobject.get("name");

          data[i][1] = (String) jsonobject.get("msg");

          //data[i][2] = (String) jsonobject.get("job");

          /*
          JSONArray internal_arr = (JSONArray)jsonobject.get("cars");

		 Iterator<String> iterator = internal_arr.iterator();
         while (iterator.hasNext()) {
        	  data[i][j]= iterator.next();
        	  j++;

          		}//end of while loop*/
          	}//end of for loop
      } catch(IOException e) {
    	  ErrorHandling.IOExceptionHandling(e);
    	  
      } catch (ParseException e) {
          e.printStackTrace();
      }

        return data;
  }
}