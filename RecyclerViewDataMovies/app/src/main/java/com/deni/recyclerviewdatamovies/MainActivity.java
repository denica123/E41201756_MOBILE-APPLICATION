package com.deni.recyclerviewdatamovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Movie;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Deklarasikan recyclerview widget pada activitymain
    RecyclerView recyclerView;
    //memanggil object dari recyclerview adaptor
    MoviesRecyclerViewAdapter adapter;
    //membuat sebuah arraylist
    ArrayList<Movies> objMovies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

    //mengisi data arraylist kemudian disimpan di object movies,urutan pengisian data menyesuaikan berdasarkan urutan data pada Movies.java
        objMovies.add(new Movies("Mortal Kombat Legends","Action,Andventure,Animation","Ethan Spaulding",6.7,
                "The Earthrealm heroes must journey to the Outworld and fight for the survival of their homeland, invaded by the forces of evil warlord Shao Kahn, in the tournament to end all tournaments: the final Mortal Kombat.","30 Agustus 2021"));
        objMovies.add(new Movies("Toy Story 4", "Adventure, Animation, Comedy", "Elyse D. Meier, Josh Cooley, Rachel Slansky", 7.8, "Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that’s Andy or Bonnie. But when Bonnie adds a reluctant new toy called “Forky” to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy.","19 Juni 2019"));
        objMovies.add(new Movies("Train to Busan", "Action, Thriller","Sang-ho Yeon",7.5,"Darurat militer dinyatakan ketika wabah virus misterius mendorong Korea ke keadaan darurat. Mereka yang berada di kereta ekspres ke Busan, kota yang berhasil menangkis serangan virus, harus berjuang demi kelangsungan hidup mereka sendiri","20 Juli 2016"));
        objMovies.add(new Movies("Luca","Adventure,Comedy, Family","Enrico Casarosa, Kelly Bonbright, Rayna Helgens",8.0,"Luca bertemu dengan sahabatnya saat sedang liburan musim panas di tepi pantai Riviera Italia.\n" +
                "Akan tetapi, liburan yang diharapkan akan menyenangkan justru menjadi mengerikan ketika ia mengetahui rahasia bahwa dirinya adalah monster laut dari dunia lain, tepatnya di bawah permukaan air kisah sangat menarik dan keren.","17 Juni 2021"));
        objMovies.add(new Movies("The Conjuring 3","Horror, Mystery, Thriller","Jeffrey Wetzel",6.5,"A harrowing tale of terror, murder, and unknown crimes that shocks even real-life paranormal investigators Ed and Lorraine Warren. One of the most sensational cases from their archives, starting with a fight for a boy's soul, then taking them beyond anything they've ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as defense.","04 Juni 2021"));
        objMovies.add(new Movies("Imperfect ","Comedy, Drama, Romance","Ernest Prakasa",8.0,"Sebagai karyawan perusahaan kosmetik berurusan dengan rasa tidak aman tentang citra tubuhnya, ia mempertimbangkan transformasi untuk kesempatan promosi.","19 Desember 2019"));

        //penerapan adaptor di set dalam bentuk linearlayoutmanajer di MainActivity
        adapter = new MoviesRecyclerViewAdapter(objMovies);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}