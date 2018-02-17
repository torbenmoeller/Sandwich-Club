package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.model.Sandwich;

import junit.framework.Assert;

import org.junit.Test;

public class JsonUtilsTest {

    @Test
    public void testAllSandwiches() {
        //How to get the resources? :(
//        String[] sandwiches = getTargetContext().getResources().getStringArray(R.array.sandwich_details);
//        for (String json : sandwiches) {
//            Sandwich sandwich = JsonUtils.parseSandwichJson(json);
//            Assert.assertNotNull(sandwich);
//            Assert.assertNotNull(sandwich.getPlaceOfOrigin());
//            Assert.assertNotNull(sandwich.getMainName());
//            Assert.assertNotNull(sandwich.getIngredients());
//            Assert.assertNotNull(sandwich.getAlsoKnownAs());
//            Assert.assertNotNull(sandwich.getDescription());
//            Assert.assertNotNull(sandwich.getImage());
//        }
    }
}