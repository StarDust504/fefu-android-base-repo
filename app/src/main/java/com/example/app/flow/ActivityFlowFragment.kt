package com.example.app.flow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.app.ParentFragmentManager
import com.example.app.R
import com.example.app.views.fragments.Activity_fragment
import com.example.app.views.fragments.NewActivityFragment

class ActivityFlowFragment : Fragment(R.layout.fragment_activity_flow), ParentFragmentManager {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.fragment_activity_flow, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction().apply {
                add(
                    R.id.activity_flow_container,
                    Activity_fragment.newInstance(),
                    "activities"
                )
                commit()
            }
            val btnToStartNewActivity: ImageView = view.findViewById(R.id.btn_start)
            btnToStartNewActivity.setOnClickListener {
                val intent = Intent(it.context, NewActivityFragment::class.java)
                startActivity(intent)
            }
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = ActivityFlowFragment()
    }
    override fun getActivitiesFragmentManager(): FragmentManager = childFragmentManager

}