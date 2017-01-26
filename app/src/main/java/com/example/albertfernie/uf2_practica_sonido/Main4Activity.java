package com.example.albertfernie.uf2_practica_sonido;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {

    private Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        traerReferencias();
    }

    public void onClickReturn (View view){
        Intent intent= new Intent(Main4Activity.this, MainActivity.class);
        startActivity(intent);
    }

    private void traerReferencias(){
        returnButton = (Button) findViewById(R.id.buttonReturn);
    }
}
