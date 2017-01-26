package com.example.albertfernie.uf2_practica_sonido;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btCancion, btLink, btTarjeta, btYoutube, btVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        traerReferencias();
    }

    public void onClickSong (View view){
        Intent intent= new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }

    public void onClickLink (View view){
        Intent intent= new Intent(MainActivity.this, Main3Activity.class);
        startActivity(intent);
    }

    public void onClickSD (View view){
        Intent intent= new Intent(MainActivity.this, Main4Activity.class);
        startActivity(intent);
    }

    public void onClickYoutube (View view){
        Intent intent= new Intent(MainActivity.this, Main5Activity.class);
        startActivity(intent);
    }

    public void onClickVideo (View view){
        Intent intent= new Intent(MainActivity.this, Main6Activity.class);
        startActivity(intent);
    }

    private void traerReferencias(){
        btCancion = (Button) findViewById(R.id.button1);
        btLink = (Button) findViewById(R.id.button2);
        btTarjeta = (Button) findViewById(R.id.button3);
        btYoutube = (Button) findViewById(R.id.button4);
        btVideo = (Button) findViewById(R.id.button5);
    }

}
