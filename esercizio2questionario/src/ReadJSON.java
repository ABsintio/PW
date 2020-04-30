import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.*;

/**
 * ReadJSON
 */
public class ReadJSON {

    public static JSONObject parseJSON(String filename) {

        JSONParser parser = new JSONParser();
        JSONObject object = new JSONObject();

        try (FileReader reader = new FileReader(filename)){
            
            Object obj = parser.parse(reader);
            object = (JSONObject) obj;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return object;
    }
}