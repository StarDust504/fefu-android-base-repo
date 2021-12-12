package com.example.app.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.app.R

class Password : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val changePassword: TextView = view.findViewById(R.id.profile_change_password_btn)
        changePassword.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .apply {
                    replace(
                        R.id.profile_flow_fragment,
                        ChangePassword.newInstance()
                    )
                    addToBackStack(null)
                    commit()
                }
        }
    }

    companion object {
        fun newInstance() = Password()
    }
}