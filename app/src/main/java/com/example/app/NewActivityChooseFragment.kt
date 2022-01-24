package com.example.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.app.views.adapters.NewActivityAdapter
import com.example.app.views.fragments.NewActivityData

class NewActivityChooseFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val dataList = listOf(
        NewActivityData("Велосипед"),
        NewActivityData("Бег"),
        NewActivityData("Шаг"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_activity_choose, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.new_activity_recycler_view)
        val adapter = NewActivityAdapter(dataList)
        recyclerView.adapter = adapter

        val btn: Button = view.findViewById(R.id.new_activity_btn_create)
        btn.setOnClickListener {
            parentFragmentManager
                .beginTransaction().apply {
                    replace(
                        R.id.new_activity_flow,
                        NewActivityCreateFragment.newInstance(),
                        "createActivity"
                    )
                    addToBackStack(null)
                    commit()
                }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewActivityChooseFragment()
    }
}