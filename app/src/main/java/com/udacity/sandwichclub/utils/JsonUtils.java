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
            Sandwich sandwich = new Sandwich();
            JSONObject jsonRoot = new JSONObject(json);

            JSONObject name = jsonRoot.getJSONObject("name");

            String mainName = name.getString("mainName");
            sandwich.setMainName(mainName);

            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownList = new ArrayList<>();
            for (int i = 0; i < alsoKnownAs.length(); i++) {
                alsoKnownList.add(alsoKnownAs.getString(i));
            }
            sandwich.setAlsoKnownAs(alsoKnownList);

            String placeOfOrigin = jsonRoot.getString("placeOfOrigin");
            sandwich.setPlaceOfOrigin(placeOfOrigin);

            String description = jsonRoot.getString("description");
            sandwich.setDescription(description);

            String image = jsonRoot.getString("image");
            sandwich.setImage(image);

            JSONArray ingredients = jsonRoot.getJSONArray("ingredients");
            List<String> ingredientsList = new ArrayList<>();
            for (int i = 0; i < ingredients.length(); i++) {
                ingredientsList.add(ingredients.getString(i));
            }
            sandwich.setIngredients(ingredientsList);

            return sandwich;
        }
        catch(JSONException e){
            return null;
        }
    }
}
