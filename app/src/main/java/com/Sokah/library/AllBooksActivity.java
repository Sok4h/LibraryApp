package com.Sokah.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.UUID;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private BookRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        recycler=findViewById(R.id.booksRecyclerView);
        adapter=new BookRecyclerViewAdapter(this);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        ArrayList <Book> arrayBooks= new ArrayList();

        arrayBooks.add(new Book (UUID.randomUUID().toString(),"Harry Potter y la cámara secreta","J. K. Rowling","https://cdn.joinnus.com/file_fil/estruendo/9786124498077.png"
                ,"Harry Potter y la cámara secreta, es el segundo libro de la serie literaria Harry Potter, escrito por la autora británica J. K. Rowling en 1998",
                "a trama sigue el segundo año de Harry Potter en el Colegio Hogwarts de Magia y Hechicería, durante el cual una serie de mensajes en las paredes de los pasillos de la escuela advierten que la Cámara de los Secretos ha sido abierta y que el «heredero de Slytherin» matará a todos los alumnos que no provengan de familias con sangre mágica. Dichas amenazas se cumplen con ataques que dejan a los alumnos de la escuela «petrificados». Durante todo el año, Harry y sus amigos Ron Weasley y Hermione Granger investigan sobre los ataques, un hecho similar que había ocurrido años antes, lo cual lleva al protagonista a conocer más la historia de su mayor enemigo, lord Voldemort, quien había asesinado a sus padres cuando era un bebé.",286));

        adapter.setBooksArray(arrayBooks);
    }
}