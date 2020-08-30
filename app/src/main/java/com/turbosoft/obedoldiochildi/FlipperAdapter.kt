package com.turbosoft.obedoldiochildi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import java.util.ArrayList

class FlipperAdapter(val context: Context, val images: Array<Int>, val titles : Array<String>) : BaseAdapter(){

    var inflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return images.size
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = inflater.inflate(R.layout.custom_item, null)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val radioButton1 = view.findViewById<RadioButton>(R.id.rb_1)
        val radioButton2 = view.findViewById<RadioButton>(R.id.rb_2)
        val radioButton3 = view.findViewById<RadioButton>(R.id.rb_3)
        val radioButton4 = view.findViewById<RadioButton>(R.id.rb_4)
        val choices = mutableListOf<String>()
        var choice1 = titles[position]
        var choice2: String
        var choice3: String
        var choice4: String
        choices.add(choice1)
        do {
            choice2 = titles.random()
        } while (choice2 in choices )
        choices.add(choice2)

        do {
            choice3 = titles.random()
        } while (choice3 in choices )
        choices.add(choice3)

        do {
            choice4 = titles.random()
        } while (choice4 in choices)
        choices.add(choice4)

        radioButton1.text = choices.random()
        choices.remove(radioButton1.text.toString())
        radioButton2.text = choices.random()
        choices.remove(radioButton2.text.toString())
        radioButton3.text = choices.random()
        choices.remove(radioButton3.text.toString())
        radioButton4.text = choices.random()


        imageView.setImageResource(images[position])
        return view
    }

}