package com.example.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

        val answer1 = binding.answerOne.text.toString().toUpperCase()
        val answer2 = binding.answerTwo.text.toString().toUpperCase()
        val answer3 = binding.answerThree.text.toString().toUpperCase()
        val answer4 = binding.answerFour.text.toString().toUpperCase()

        if (answer1 == getString(R.string.value_true)) {
            correctAnswers++
        }
        if (answer2 == getString(R.string.value_false)) {
            correctAnswers++
        }
        if (answer3 == getString(R.string.value_false)) {
            correctAnswers++
        }
        if (answer4 == getString(R.string.value_false)) {
            correctAnswers++
        }

        when (correctAnswers) {
            maxCorrectAnswers -> allAnswersCorrect()
            else -> Toast.makeText(this, getString(R.string.correct_answers, correctAnswers), Toast.LENGTH_SHORT).show()
        }
    }

    private fun allAnswersCorrect() {
        Toast.makeText(this, getString(R.string.all_correct), Toast.LENGTH_SHORT).show()
    }
}