package com.example.demo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.online_songs.jcAudios;
import static com.example.demo.online_songs.jcPlayerView;

public class online_songAdapter extends RecyclerView.Adapter<online_songAdapter.MyViewHolder> {

    public void setSelectedPosi(int selectedPosi) {
        this.selectedPosi = selectedPosi;
    }

    public int getSelectedPosi() {
        return selectedPosi;
    }

    int selectedPosi;
   Context context;
   List<online_SongInfo> onlineSongInfos;

    public online_songAdapter(Context context, List<online_SongInfo> onlineSongInfos ) {
        this.context = context;
        this.onlineSongInfos = onlineSongInfos;
    }

    @NonNull
    @Override
    public online_songAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.online_music_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull online_songAdapter.MyViewHolder holder, final int position) {

        final online_SongInfo songInfo = onlineSongInfos.get(position);

        if (songInfo != null){
            if (selectedPosi == position){
                //holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));
                holder.online_play_pause.setVisibility(View.VISIBLE);
            }
            else {
               // holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
                holder.online_play_pause.setVisibility(View.INVISIBLE);
            }
        }

        holder.online_song_name.setText(songInfo.getSongTitle());
        holder.online_song_artist.setText(songInfo.getSongArtist());
        holder.online_song_dur.setText(convertDuration(Long.parseLong(songInfo.getSongDur())));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jcPlayerView.playAudio(jcAudios.get(position));
                jcPlayerView.setVisibility(View.VISIBLE);
                jcPlayerView.createNotification();
            }
        });

    }

    @Override
    public int getItemCount() {
        return onlineSongInfos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView online_song_name, online_song_dur, online_song_artist;
        ImageView online_song_img, online_play_pause;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            online_song_name = itemView.findViewById(R.id.online_song_title);
            online_song_img = itemView.findViewById(R.id.online_song_img);
            online_song_artist = itemView.findViewById(R.id.online_song_artist);
            online_song_dur = itemView.findViewById(R.id.online_dur_tv);
            online_play_pause = itemView.findViewById(R.id.online_playPause);

        }
    }

    public static String convertDuration(long duration){
        long min = (duration/1000)/60;
        long sec = (duration/1000)%60;
        String converted = String.format("%d:%02d",min,sec);
        return converted;
    }


}
