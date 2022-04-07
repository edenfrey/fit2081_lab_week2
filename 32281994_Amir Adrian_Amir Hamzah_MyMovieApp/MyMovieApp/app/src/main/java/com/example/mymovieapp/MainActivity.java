package com.example.mymovieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showFailToast(View view){
        Toast message = Toast.makeText(this,"Please input all fields!",Toast.LENGTH_SHORT);
        message.show();
    }
    public void showFailToast2(View view){
        Toast message = Toast.makeText(this,"Please input relevant fields!",Toast.LENGTH_SHORT);
        message.show();
    }
    public void showSuccessAddToast(View view, String text){
        Toast message = Toast.makeText(this,"Movie (" +text+ ") successfully added!",Toast.LENGTH_LONG);
        message.show();
    }
    public void showSuccessDoubledToast(View view){
        Toast message = Toast.makeText(this,"Successfully doubled cost!",Toast.LENGTH_LONG);
        message.show();
    }
    public void showSuccessClearedToast(View view){
        Toast message = Toast.makeText(this,"Successfully cleared fields!",Toast.LENGTH_LONG);
        message.show();
    }

    public void addMovie(View view){
        EditText title, country, genre, keywords, cost, year;
        String title_string, country_string, genre_string, keywords_string;
        int year_int;
        double cost_double;
        try {
            title = findViewById(R.id.titleInput);
            country = findViewById(R.id.countryInput);
            genre = findViewById(R.id.genreInput);
            keywords = findViewById(R.id.keywordsInput);
            cost = findViewById(R.id.costInput);
            year = findViewById(R.id.yearInput);
            title_string = title.getText().toString();
            country_string = country.getText().toString();
            genre_string = genre.getText().toString();
            keywords_string= keywords.getText().toString();
            cost_double = Double.parseDouble(cost.getText().toString());
            year_int = Integer.parseInt(year.getText().toString());
            MovieClass movie = new MovieClass(title_string, country_string, genre_string, keywords_string,year_int, cost_double);
            showSuccessAddToast(view,title_string+", " + year_int);
        }
        catch (Exception e){
            showFailToast(view);
        }

    }

    public void doubleCost(View view){
        EditText cost;
        double cost_double;
        try {
            cost = findViewById(R.id.costInput);
            cost_double = Double.parseDouble(cost.getText().toString()) * 2;
            cost.setText(cost_double + "");
            showSuccessDoubledToast(view);

        }
        catch (Exception e){
            showFailToast2(view);
        }
    }


    public void clearFields(View view) {
        EditText title, country, genre, keywords, cost, year;
        String empty = "";
        try {
            title = findViewById(R.id.titleInput);
            country = findViewById(R.id.countryInput);
            genre = findViewById(R.id.genreInput);
            keywords = findViewById(R.id.keywordsInput);
            cost = findViewById(R.id.costInput);
            year = findViewById(R.id.yearInput);
            title.setText(empty);
            country.setText(empty);
            genre.setText(empty);
            keywords.setText(empty);
            cost.setText(empty);
            year.setText(empty);
            showSuccessClearedToast(view);
        } catch (Exception e) {
            showFailToast(view);
        }

    }
}