package com.shivshakti.twoinonegame;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.shivshakti.twoinonegame.databinding.ActivityRockPaperScissorBinding;

import java.util.Random;

public class RockPaperScissorActivity extends AppCompatActivity {

    ActivityRockPaperScissorBinding binding;
    Random random;
    int cuteBot = 0;
    boolean gameState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityRockPaperScissorBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        gameState = false;

        /*
		Winning Situations
		1 > 3 = Rock Scissor
		2 > 1 = Paper Rock
		3 > 2 = Scissor Paper
		Losing Situations
		1 > 2
		2 > 3
		3 > 1 */

        random = new Random();

        binding.gameStateBtn.setOnClickListener(v ->{
            if (gameState){
                gameState = false;
                binding.playerBtnsLL.setVisibility(View.INVISIBLE);
                binding.gameStateBtn.setText("Start");
            }
            else {
                gameState = true;
                binding.playerBtnsLL.setVisibility(View.VISIBLE);
                binding.gameStateBtn.setText("Stop");
            }
        });

        binding.rockImg.setOnClickListener(v ->{
            checkGame(1);
        });

        binding.paperImg.setOnClickListener(v ->{
            checkGame(2);
        });

        binding.scissorImg.setOnClickListener(v ->{
            checkGame(3);
        });

    }

    private void checkGame(int playerChoice){

            cuteBot = random.nextInt(3);

            cuteBot += 1;

            if(cuteBot == playerChoice){
                binding.resultTV.setVisibility(View.VISIBLE);
                binding.resultTV.setText("Game Tie");
                MediaPlayer gameTieMP = MediaPlayer.create(this, R.raw.rps_losing);
                gameTieMP.start();
                setBotChoiceImage();
            }
            else if(cuteBot == 1 && playerChoice == 3 || cuteBot == 2 && playerChoice == 1 || cuteBot == 3 && playerChoice == 2){
                binding.resultTV.setVisibility(View.VISIBLE);
                binding.resultTV.setText("Cute Bot Wins");
                MediaPlayer gameLoseMP = MediaPlayer.create(this, R.raw.rps_losing);
                gameLoseMP.start();
                setBotChoiceImage();
            }
            else {
                binding.resultTV.setVisibility(View.VISIBLE);
                binding.resultTV.setText("You Wins");
                MediaPlayer gameWinMP = MediaPlayer.create(this, R.raw.rps_wining);
                gameWinMP.start();
                setBotChoiceImage();
            }

    }

    private void setBotChoiceImage(){

        switch (cuteBot){
            case 1:
                binding.botChoiceImg.setImageResource(R.drawable.rock);
                break;
            case 2:
                binding.botChoiceImg.setImageResource(R.drawable.paper);
                break;
            case 3:
                binding.botChoiceImg.setImageResource(R.drawable.scissor);
                break;
            default:
                binding.botChoiceImg.setImageResource(R.drawable.rock_paper_scissor);
                break;
        }

    }

}