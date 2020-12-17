package com.Sokah.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.UUID;

public class BookActivity extends AppCompatActivity {

    private ImageView bookImage;
    private TextView bookName, author, pageNumber, shortDescription, longDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_book);

        InitViews();
        //TODO GET DATA FROM THE ARRAYLIST
        Book book = new Book(UUID.randomUUID().toString(), "Harry Potter y la cámara secreta", "J. K. Rowling", "https://cdn.joinnus.com/file_fil/estruendo/9786124498077.png"
                , "Harry Potter y la cámara secreta, es el segundo libro de la serie literaria Harry Potter, escrito por la autora británica J. K. Rowling en 1998",
                "a trama sigue el segundo año de Harry Potter en el Colegio Hogwarts de Magia y Hechicería, durante el cual una serie de mensajes en las paredes de los pasillos de la escuela advierten que la Cámara de los Secretos ha sido abierta y que el «heredero de Slytherin» matará a todos los alumnos que no provengan de familias con sangre mágica. Dichas amenazas se cumplen con ataques que dejan a los alumnos de la escuela «petrificados». Durante todo el año, Harry y sus amigos Ron Weasley y Hermione Granger investigan sobre los ataques, un hecho similar que había ocurrido años antes, lo cual lleva al protagonista a conocer más la historia de su mayor enemigo, lord Voldemort, quien había asesinado a sus padres cuando era un bebé.", 286);

        LoadInfo(book);

    }

    private void LoadInfo(Book book) {

        bookName.setText(book.getName());
        author.setText(book.getAuthor());
        pageNumber.setText(String.valueOf(book.getPageNumber()));
        shortDescription.setText(book.getShortDescription());
        longDescription.setText(book.getLongDescription());
        Glide.with(this).asBitmap().load(book.getImageUrl()).into(bookImage);

    }

    private void InitViews() {
        bookImage = findViewById(R.id.bookImage);
        bookName = findViewById(R.id.textBookName);
        author = findViewById(R.id.textAuthor);
        pageNumber = findViewById(R.id.textPageNumber);
        shortDescription = findViewById(R.id.textShortDescription);
        longDescription = findViewById(R.id.textLongDescription);
    }
}