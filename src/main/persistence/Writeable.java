package persistence;

import org.json.JSONObject;

public interface Writeable {
    //effect: returns this as JSON object
    JSONObject toJson();
}
