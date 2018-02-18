package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ingredientsIv = findViewById(R.id.image_iv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = JsonUtils.parseSandwichJson(json);
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI(sandwich);
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Sandwich sandwich) {
        populateTextView(R.id.header_origin_tv, R.id.origin_tv, sandwich.getPlaceOfOrigin());

        populateTextView(R.id.header_description_tv, R.id.description_tv, sandwich.getDescription());

        String alsoknownText = concatList(sandwich.getAlsoKnownAs());
        populateTextView(R.id.header_also_known_tv, R.id.also_known_tv, alsoknownText);

        String ingredientsText = concatList(sandwich.getIngredients());
        populateTextView(R.id.header_ingredients_tv, R.id.ingredients_tv, ingredientsText);
    }

    private void populateTextView(int headerTextViewID, int contentTextViewID, String content){
        TextView headertTextView = findViewById(headerTextViewID);
        TextView contentTextView = findViewById(contentTextViewID);
        contentTextView.setText(content);
        //Thanks to forum: https://discussions.udacity.com/t/hide-views-sandwich-club/599464
        if(TextUtils.isEmpty(content)){
            headertTextView.setVisibility(View.GONE);
            contentTextView.setVisibility(View.GONE);
        }
    }

    private static String concatList(List<String> list) {
        return TextUtils.join(", ", list);
    }
}
