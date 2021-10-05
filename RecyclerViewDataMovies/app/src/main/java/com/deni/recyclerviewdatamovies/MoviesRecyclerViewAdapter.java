package com.deni.recyclerviewdatamovies;
//Class Adaptor recyclerview
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

//class tersendiri yg dibuat atau bisa disebut inner class
public class MoviesRecyclerViewAdapter extends RecyclerView.Adapter<MoviesRecyclerViewAdapter.MovieViewHolder> {
    ArrayList<Movies> arrayListMovies; //inisialisasi data array

    //generate contructor
    public MoviesRecyclerViewAdapter(ArrayList<Movies> arrayListMovies) {
        this.arrayListMovies = arrayListMovies;
    }

    @NonNull
    @Override
    public MoviesRecyclerViewAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MovieViewHolder(view);
    } //mengambil data dari layout item.xml

    @Override
    public void onBindViewHolder(@NonNull MoviesRecyclerViewAdapter.MovieViewHolder holder, int position) {
        final Movies movies = arrayListMovies.get(position);//memanggil object movies untuk mendapatkan data dari setiap index arraylist

        //pemanggilan nilai di dalam arraylist
        holder.textViewTitle.setText(movies.getTitle());
        holder.textViewRating.setText(String.valueOf(movies.getRating()));
        holder.textViewReleaseDate.setText(movies.getReleasedate());

        //action detail list item,fungsi ini seperti melempar nilai menggunakan intent agar bisa ditangkap oleh detail movie,nama code pada intent putExtra
        //yang akan dipanggil di detailmovie untuk ditampilkan
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailMovieActivity.class);
                intent.putExtra("MOVIES", movies);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayListMovies.size();
    } //untuk mendapatkan jumlah datanya

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewRating, textViewReleaseDate; //mendeklarasikan textview

        public MovieViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.tvTitle);
            textViewRating = itemView.findViewById(R.id.tvRating);
            textViewReleaseDate = itemView.findViewById(R.id.tvReleaseDate); //memanggil fungsi untuk mengambil nilai dari layout textview id
        }
    }
}
