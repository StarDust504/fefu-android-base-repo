package com.example.app.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app.R
import com.example.app.databinding.FragmentProfileFragmentBinding


class Profile_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.beginTransaction()
            .apply {
                add(
                    R.id.profile_flow_fragment,
                    Password.newInstance(),
                    "profileSettings"
                )
                commit()
            }
    }

    companion object {
        @JvmStatic
        fun newInstance() = Profile_fragment()
    }
}