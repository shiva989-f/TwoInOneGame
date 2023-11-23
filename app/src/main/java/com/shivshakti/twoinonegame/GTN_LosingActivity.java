package com.shivshakti.twoinonegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.shivshakti.twoinonegame.databinding.ActivityGtnLosingBinding;

public class GTN_LosingActivity extends AppCompatActivity {

    ActivityGtnLosingBinding binding;
    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityGtnLosingBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        Intent iNumberWas = getIntent();
        randomNumber = iNumberWas.getIntExtra("numberWas", 0);

        binding.randomNumTV.setText("The number was " + randomNumber);

    }
}