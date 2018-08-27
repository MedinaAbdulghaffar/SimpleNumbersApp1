package com.example.aras.numbersapp;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Number> numbers = new ArrayList<>();
    MediaPlayer mediaPlayer;


    ImageView previousButton;
    ImageView nextButton;
    ImageView playButton;
    ImageView numbersImageView;
    int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        index=0;



        numbers.add(new Number(R.drawable.one,R.raw.one1));
        numbers.add(new Number(R.drawable.two,R.raw.tow));
        numbers.add(new Number(R.drawable.three,R.raw.three));
        numbers.add(new Number(R.drawable.foure,R.raw.four));
        numbers.add(new Number(R.drawable.five,R.raw.five));
        numbers.add(new Number(R.drawable.six,R.raw.six));
        numbers.add(new Number(R.drawable.seven,R.raw.seven));
        numbers.add(new Number(R.drawable.eight,R.raw.eight));
        numbers.add(new Number(R.drawable.nine,R.raw.nine1));

        numbersImageView=findViewById(R.id.number_iv);

        previousButton=findViewById(R.id.previous_btn);
        nextButton=findViewById(R.id.next_btn);
        playButton=findViewById(R.id.play_btn);

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index!=0) {
                    index--;
                    numbersImageView.setImageResource(numbers.get(index).getmNumber());
                }



            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this,numbers.get(index).getmSound());
                mediaPlayer.start();

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index!=8){
                    index++;
                    numbersImageView.setImageResource(numbers.get(index).getmNumber());
                }
                else {
                        Intent intent = new Intent(MainActivity.this,EndActivity.class);
                        startActivity(intent);
                    }
            }
        });




    }

}
