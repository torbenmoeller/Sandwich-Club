package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject jsonRoot = new JSONObject(json);
            JSONObject name = jsonRoot.getJSONObject("name");

            String mainName = name.getString("mainName");

            List<String> alsoKnownAs = convertJSONArrayToStringList(
                    name.getJSONArray("alsoKnownAs")
            );

            String placeOfOrigin = jsonRoot.getString("placeOfOrigin");

            String description = jsonRoot.getString("description");

            String image = jsonRoot.getString("image");

            List<String> ingredients = convertJSONArrayToStringList(
                    jsonRoot.getJSONArray("ingredients")
            );

            Sandwich sandwich = new Sandwich(mainName, alsoKnownAs,  placeOfOrigin,  description,  image, ingredients);
            return sandwich;
        }
        catch(JSONException e){
            return null;
        }
    }

    private static List<String> convertJSONArrayToStringList(JSONArray jsonArray) throws JSONException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.getString(i));
        }
        return list;
    }
}
