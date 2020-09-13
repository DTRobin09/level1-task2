package com.example.madlevel1task2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.madlevel1task2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitButton.setOnClickListener {
            checkAnswer()
        }
    }

    private fun checkAnswer() {
        var correctAnswers: Int = 0
        val maxCorrectAnswers: Int = 4

        val filledInAnswers = arrayOf<String>(
            binding.answerOne.text.toString().toUpperCase(),
            binding.answerTwo.text.toString().toUpperCase(),
            binding.answerThree.text.toString().toUpperCase(),
            binding.answerFour.text.toString().toUpperCase()
        )

        // checks if the filled in answers are right
        for (x in filledInAnswers.indices) {
            if (x == 0 && filledInAnswers[x] == getString(R.string.value_true)) {
                correctAnswers++
            } else if (filledInAnswers[x] == getString(R.string.value_false)) {
                correctAnswers++
            }
        }

        when (correctAnswers) {
            maxCorrectAnswers -> allAnswersCorrect()
            else -> Toast.makeText(
                this,
                getString(R.string.correct_answers, correctAnswers),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun allAnswersCorrect() {
        Toast.makeText(this, getString(R.string.all_correct), Toast.LENGTH_SHORT).show()
    }
}