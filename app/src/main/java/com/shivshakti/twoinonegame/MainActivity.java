package com.shivshakti.twoinonegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.shivshakti.twoinonegame.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.rockPaperLl.setOnClickListener(v ->{
            startActivity(new Intent(MainActivity.this, RockPaperScissorActivity.class));
        });

        binding.guessTheNoLl.setOnClickListener(v ->{
            startActivity(new Intent(MainActivity.this, GuessTheNumberActivity.class));
        });

    }
}