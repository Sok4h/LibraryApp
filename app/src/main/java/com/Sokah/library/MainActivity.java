package com.Sokah.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSeeAllBooks, btnCurrentlyReading, btnAlreadyRead, btnWishlist, btnFavorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitViews();

    }

    private void InitViews() {

        btnSeeAllBooks = findViewById(R.id.btnAllBooks);
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead);
        btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnFavorites = findViewById(R.id.btnFavorites);
        btnWishlist = findViewById(R.id.btnWantToRead);

        btnSeeAllBooks.setOnClickListener(this);
        btnWishlist.setOnClickListener(this);
        btnFavorites.setOnClickListener(this);
        btnAlreadyRead.setOnClickListener(this);
        btnCurrentlyReading.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnAllBooks:

            Intent intent = new Intent(this,AllBooksActivity.class);
            startActivity(intent);

                break;
            case R.id.btnAlreadyRead:

                break;

            case R.id.btnCurrentlyReading:

                break;

            case R.id.btnFavorites:

                break;

            case R.id.btnWantToRead:
                break;

        }
    }
}