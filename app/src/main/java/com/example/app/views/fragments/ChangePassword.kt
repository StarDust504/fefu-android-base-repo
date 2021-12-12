package com.example.app.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.app.R

class ChangePassword : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_change_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar: Toolbar = view.findViewById(R.id.change_password_toolbar)
        val saveBtn: Button = view.findViewById(R.id.change_password_accept_btn)

        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
        saveBtn.setOnClickListener {  }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ChangePassword()
    }
}