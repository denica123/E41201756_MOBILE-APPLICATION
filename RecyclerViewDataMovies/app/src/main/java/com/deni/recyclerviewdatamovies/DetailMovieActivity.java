package com.deni.recyclerviewdatamovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailMovieActivity extends AppCompatActivity {


    TextView textViewTitle, textViewRating, textViewReleaseDate, textViewGenre, textViewDirector, textViewDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        //deklarasi Textview
        textViewTitle = findViewById(R.id.tvTitle);
        textViewRating = findViewById(R.id.tvRating);
        textViewReleaseDate = findViewById(R.id.tvReleaseDate);
        textViewGenre = findViewById(R.id.tvGenre);
        textViewDirector = findViewById(R.id.tvDirector);
        textViewDescription = findViewById(R.id.tvDescription);

        //memanggil data intent yang disimpan dalam object movie,name disesuaikan nama intent.putExtra yaitu "MOVIES"
        Movies movies = getIntent().getParcelableExtra("MOVIES");

        //set nilai textview
        textViewTitle.setText(movies.getTitle());
        textViewRating.setText(String.valueOf(movies.getRating()));
        textViewReleaseDate.setText(movies.getReleasedate());
        textViewGenre.setText(movies.getGenre());
        textViewDirector.setText(movies.getDirector());
        textViewDescription.setText(movies.getDescription());
    }
}