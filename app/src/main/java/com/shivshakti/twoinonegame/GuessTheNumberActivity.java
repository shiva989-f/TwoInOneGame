package com.shivshakti.twoinonegame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.window.OnBackInvokedDispatcher;

import com.shivshakti.twoinonegame.databinding.ActivityGuessTheNumberBinding;

import java.util.Random;

public class GuessTheNumberActivity extends AppCompatActivity {

    ActivityGuessTheNumberBinding binding;

    Random random;
    int randomNum, guessedNum, guessesLeft = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityGuessTheNumberBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        random = new Random();

        randomNum = random.nextInt(100);
        randomNum += 1;

        binding.guessBtn.setOnClickListener(v ->{

            guessedNum =  Integer.parseInt(binding.guessET.getText().toString());

            guessesLeft -= 1;
            MediaPlayer chanceMP = MediaPlayer.create(GuessTheNumberActivity.this, R.raw.chances_losing);
            chanceMP.start();

            binding.guessesLeftTV.setText("You have " + guessesLeft + " left");

            binding.guessET.setText("");

            Log.d("random", String.valueOf(randomNum));

            MediaPlayer highLowMp = MediaPlayer.create(GuessTheNumberActivity.this, R.raw.high_low);

            if (guessesLeft == 0) {
                // Losing sound
                MediaPlayer losingMP = MediaPlayer.create(GuessTheNumberActivity.this, R.raw.guess_the_no_losing);
                losingMP.start();
                Intent iLosing = new Intent(GuessTheNumberActivity.this, GTN_LosingActivity.class);
                iLosing.putExtra("numberWas", randomNum);
                startActivity(iLosing);
            }
            else if (guessedNum == randomNum){
                // Wining Sound
                MediaPlayer winingMP = MediaPlayer.create(GuessTheNumberActivity.this, R.raw.guess_the_no_wining);
                winingMP.start();
                binding.lowHighTv.setVisibility(View.VISIBLE);
                startActivity(new Intent(GuessTheNumberActivity.this, GTN_WiningActivity.class));
            }
            else if (guessedNum > randomNum){
                highLowMp.start();
                binding.lowHighTv.setVisibility(View.VISIBLE);
                binding.lowHighTv.setText("Too High! Try Again");
            }
            else {
                highLowMp.start();
                binding.lowHighTv.setVisibility(View.VISIBLE);
                binding.lowHighTv.setText("Too low! Try Again");
            }


        });

    }

}