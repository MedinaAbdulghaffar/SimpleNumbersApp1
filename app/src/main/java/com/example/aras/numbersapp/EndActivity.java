package com.example.aras.numbersapp;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import static com.example.aras.numbersapp.R.raw.test;

public class EndActivity extends AppCompatActivity {
    Button playSoundb;
    Button learningPhaseb;
    CheckBox firstCheckBox;
    CheckBox secondCheckBox;
    CheckBox thirdCheckBox;
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    AudioManager.OnAudioFocusChangeListener afChangeListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        mediaPlayer = MediaPlayer.create(EndActivity.this, R.raw.notmatch);
        mediaPlayer.start();
        playSoundb=findViewById(R.id.play_sound_b);
        learningPhaseb=findViewById(R.id.learning_phase_b);
        firstCheckBox=findViewById(R.id.first_ch);
        secondCheckBox=findViewById(R.id.second_ch);
        thirdCheckBox=findViewById(R.id.third_ch);

        audioManager = (AudioManager) getApplicationContext().getSystemService(AUDIO_SERVICE);
        afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int focusChange) {
                if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                    mediaPlayer.stop();
                } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                    mediaPlayer.pause();
                } else if(focusChange == AudioManager.AUDIOFOCUS_GAIN)
                {
                    mediaPlayer.start();
                }
            }
        };

        playSoundb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(EndActivity.this, R.raw.notmatch);
                int result = audioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    if (!mediaPlayer.isPlaying()) {
                        // Start playback
                        mediaPlayer.start();
                    }
                }

            }
        });
        learningPhaseb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EndActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        firstCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer=MediaPlayer.create(EndActivity.this,R.raw.welldone);
                int result = audioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback
                    mediaPlayer.start();
                }
            }
        });

        secondCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer=MediaPlayer.create(EndActivity.this,R.raw.welldone);
                int result = audioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback
                    mediaPlayer.start();
                }            }
        });
        thirdCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer=MediaPlayer.create(EndActivity.this,R.raw.test);
                int result = audioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback
                    mediaPlayer.start();
                }            }
        });
    }
}
