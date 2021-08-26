package utils;
import com.google.gson.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadJsonFile {

    public static JSONObject readJsonFile(String path) throws FileNotFoundException {
        File file;
        FileReader fileReader = new FileReader(path);
        Object object = JsonParser.parseReader(fileReader);

        JSONObject data = (JSONObject)(object);

        return data;
    }
}
