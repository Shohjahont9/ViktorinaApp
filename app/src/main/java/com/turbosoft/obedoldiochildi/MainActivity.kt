package com.turbosoft.obedoldiochildi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_item.*

class MainActivity : AppCompatActivity() {

    var questionNumber = 1
    var correctAnswers = 0
    var answerBool = false

    val images = arrayOf(
            R.drawable.facebook,
            R.drawable.slack,
            R.drawable.medium,
            R.drawable.reddit,
            R.drawable.snapchat,
            R.drawable.pinterest,
            R.drawable.discord,
            R.drawable.instagram,
            R.drawable.quora,
            R.drawable.skype,
            R.drawable.telegram,
            R.drawable.tiktok,
            R.drawable.tinder,
            R.drawable.tumblr,
            R.drawable.twitter,
            R.drawable.vimeo,
            R.drawable.vk,
            R.drawable.whats_app
    )

    val titles = arrayOf(
            "Facebook",
            "Slack",
            "Medium",
            "Reddit",
            "Snapchat",
            "Pinterest",
            "Discord",
            "Instagram",
            "Quora",
            "Skype",
            "Telegram",
            "Tik-tok",
            "Tinder",
            "Tumblr",
            "Twitter",
            "Vimeo",
            "Vk",
            "Whats App"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flipperAdapter = FlipperAdapter(this, images, titles)

        adapterFlipper.apply {
            adapter = flipperAdapter
        }

        submit_bt.setOnClickListener {
            if (answerBool) {
                Toast.makeText(applicationContext, "Right", Toast.LENGTH_SHORT).show()
                correctAnswers++
                correct_ans_number.text = correctAnswers.toString()
            } else{
                Toast.makeText(applicationContext, "Wrong", Toast.LENGTH_SHORT).show()
            }
            addOneToQuestionNumber()
            adapterFlipper.showNext()
        }

    }

    private fun addOneToQuestionNumber() {
        questionNumber++
        question_number.text = questionNumber.toString()

    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rb_1 ->
                    if (checked) {
                        answerBool = rb_1.text == titles[questionNumber-1]
                    }
                R.id.rb_2 ->
                    if (checked) {
                        answerBool = rb_2.text == titles[questionNumber-1]
                    }
                R.id.rb_3 ->
                    if (checked) {
                        answerBool = rb_3.text == titles[questionNumber-1]
                    }
                R.id.rb_4 ->
                    if (checked) {
                        answerBool = rb_4.text == titles[questionNumber-1]
                    }
            }
        }
    }
}