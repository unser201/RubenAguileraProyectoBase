package com.example.proyectobase;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Info_act extends AppCompatActivity {
    private VideoView videoInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);
        videoInfo= (VideoView)findViewById(R.id.vw_VideoInfo);
        String ruta = "android.resource://"+ getPackageName()+"/"+R.raw.video_peluc;
        Uri uri = Uri.parse(ruta);
        videoInfo.setVideoURI(uri);
        MediaController media = new MediaController(this);
        videoInfo.setMediaController(media);
    }
}