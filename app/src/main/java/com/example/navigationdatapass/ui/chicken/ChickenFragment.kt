package com.example.navigationdatapass.ui.chicken

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigationdatapass.MealViewModel
import com.example.navigationdatapass.R
import com.example.navigationdatapass.adapter.MealAdapter
import kotlinx.android.synthetic.main.fragment_chicken.*

class ChickenFragment : Fragment() {

    private lateinit var chickenViewModel: MealViewModel
    private lateinit var chickenAdapter: MealAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_chicken, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chickenAdapter = MealAdapter()
        recyclerChicken.apply {
            adapter = chickenAdapter
            layoutManager = LinearLayoutManager(context)
        }
        obserViewModel()
    }

    override fun onResume() {
        super.onResume()
        chickenViewModel.loadMeal("Chicken")
    }

    fun obserViewModel() {
        chickenViewModel = ViewModelProvider(this).get(MealViewModel::class.java)

        chickenViewModel.getMeal().observe(viewLifecycleOwner,
            Observer {
                chickenAdapter.upDateList(it)
            })
    }


}