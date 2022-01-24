package com.example.app

import androidx.fragment.app.FragmentManager
interface ParentFragmentManager {
    fun getActivitiesFragmentManager() : FragmentManager
}