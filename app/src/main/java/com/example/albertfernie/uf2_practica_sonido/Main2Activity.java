package com.example.albertfernie.uf2_practica_sonido;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    private ImageButton playButton, pauseButton, ffButton, rewButton;
    private Button returnButton;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        traerReferencias();
        try{
            prepararMediaPlayer();
        }catch(IOException e){}
    }

    public void onClickPlayButton(View view){
        mediaPlayer.start();
    }

    public void onClickPauseButton(View view){
        mediaPlayer.pause();
    }

    public void onClickffButton(View view){
        //metodo_ffButton();
        int time = mediaPlayer.getCurrentPosition();
        int pos = time + 10000;
        mediaPlayer.seekTo(pos);
        if (mediaPlayer.isPlaying()) {
            int currentPosition = mediaPlayer.getCurrentPosition();
            mediaPlayer.seekTo(currentPosition + 10000);
        }
    }

    public void onClickRewButton(View view){
        //metodo_rewButton();
        int time = mediaPlayer.getCurrentPosition();
        int pos = time - 10000;
        mediaPlayer.seekTo(pos);
    }

    public void onClickReturn (View view){
        Intent intent= new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }

    protected void onPause(){ //la cabecera del método onPause
        super.onPause();
        //se debe poner siempre
        killMediaPlayer();//llamar al método que parará el sonido
    }

    private void traerReferencias(){
        playButton = (ImageButton) findViewById(R.id.button_play);
        pauseButton = (ImageButton) findViewById(R.id.button_pause);
        ffButton = (ImageButton) findViewById(R.id.button_ff);
        rewButton = (ImageButton) findViewById(R.id.button_rew);
        returnButton = (Button) findViewById(R.id.buttonReturn);
    }

    private void prepararMediaPlayer() throws IOException{
        killMediaPlayer();
        //mediaPlayer = MediaPlayer.create(this, R.raw.ficherosonido);
        mediaPlayer = MediaPlayer.create(this, R.raw.bayonetta_ost);
    }

    private void killMediaPlayer(){
        if(mediaPlayer != null){
            try{
                mediaPlayer.release();
                mediaPlayer.stop(); //parar
                mediaPlayer = null; //borrar de la memoria
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
