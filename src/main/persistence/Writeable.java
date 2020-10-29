package persistence;

import org.json.JSONObject;

//Represents a interface to write to the Json object
//code adapted and re-modeled based on the JsonSerializationDemo

public interface Writeable {
    //effect: returns this as JSON object
    JSONObject toJson();
}
