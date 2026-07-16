package utils;

import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonReader {

    /*Dynamic - Static

    1. static (best)
        1.1 Database snapshot (restore)


    2. Dynamic
        2.1 Database queries (setup) //insert into users values ('toBeModified', 'toBeModified@gmail,com', '123456')
        2.2 API endpoint (setup) //POST/users {"email": "toBeModified@gmail,com", "password": "123456"}
        2.3 UI (setup) //CRUD
     */

    //excel - csv - json - properties

    private final String test_data_path = "src/test/java/testData/";

    String jsonReader;
    String jsonFileName;

    public JsonReader(String jsonFileName) {
        this.jsonFileName = jsonFileName;
        try {
            JSONObject data = (JSONObject) new JSONParser().parse(new FileReader(test_data_path + jsonFileName + ".json"));
            jsonReader = data.toJSONString();
        } catch (Exception e) {
            System.out.println("Error reading json file: " + jsonFileName);

        }
    }

    //valid.username
    public String getJsonData(String jsonPath) {
        try {
            return JsonPath.read(jsonReader, jsonPath);
        } catch (Exception e) {
            System.out.println("Error reading json data from file: " + jsonFileName + " with path: " + jsonPath);
            return "";
        }
    }

}
