package com.example.albertfernie.uf2_practica_sonido;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.IOException;

public class Main3Activity extends AppCompatActivity {

    private Button returnButton, goButton;
    private EditText etURL;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        traerReferencias();
        try {
            prepararMediaPlayer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onClickReproducir (View view) throws Exception {
        mediaPlayer = null;
        mediaPlayer = new MediaPlayer();
        String direccion = String.valueOf(etURL.getText());
        reproduceMiURL(direccion, mediaPlayer);
    }

    private void reproduceMiURL (String pathUrl, MediaPlayer mp)throws Exception {
        mp.setDataSource(pathUrl);
        mp.prepare();
        mp.start();
    }


    public void onClickReturn (View view){
        Intent intent= new Intent(Main3Activity.this, MainActivity.class);
        startActivity(intent);
    }

    private void traerReferencias(){
        returnButton = (Button) findViewById(R.id.buttonReturn);
        goButton = (Button) findViewById(R.id.buttonGo);
        etURL = (EditText) findViewById(R.id.etLink);
    }

    private void prepararMediaPlayer() throws IOException {
        killMediaPlayer();
        //mediaPlayer = MediaPlayer.create(this, R.raw.ficherosonido);
        //mediaPlayer = MediaPlayer.create(this, R.raw.bayonetta_ost);
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
