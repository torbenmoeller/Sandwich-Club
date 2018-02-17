package com.udacity.sandwichclub.utils;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.model.Sandwich;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;

@RunWith(AndroidJUnit4.class)
public class TestjsonUtils {

    @Test
    public void testAllSandwiches() {
        String[] sandwiches = getTargetContext().getResources().getStringArray(R.array.sandwich_details);
        for (String json : sandwiches) {
            Sandwich sandwich = JsonUtils.parseSandwichJson(json);
            Assert.assertNotNull(sandwich);
            Assert.assertNotNull(sandwich.getPlaceOfOrigin());
            Assert.assertNotNull(sandwich.getMainName());
            Assert.assertNotNull(sandwich.getIngredients());
            Assert.assertNotNull(sandwich.getAlsoKnownAs());
            Assert.assertNotNull(sandwich.getDescription());
            Assert.assertNotNull(sandwich.getImage());
        }
    }
}