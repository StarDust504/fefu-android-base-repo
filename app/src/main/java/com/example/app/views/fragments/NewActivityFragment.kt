package com.example.app.views.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import com.example.app.NewActivityChooseFragment
import com.example.app.ParentFragmentManager
import com.example.app.R

class NewActivityFragment : AppCompatActivity(), ParentFragmentManager {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_new_activity)

        val cardView: CardView = findViewById(R.id.card_with_settings)
        cardView.setBackgroundResource(R.drawable.up_corner_25dp_shape)

        supportFragmentManager.beginTransaction().apply {
            add(
                R.id.new_activity_flow,
                NewActivityChooseFragment.newInstance(),
                "chooseActivity"
            )
            commit()
        }
    }

    override fun getActivitiesFragmentManager(): FragmentManager = supportFragmentManager
}