package com.androidgang.myrecyclerviewapp.scenes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidgang.myrecyclerviewapp.adpter.MainAdapter
import com.androidgang.myrecyclerviewapp.databinding.ActivityMainBinding
import com.androidgang.myrecyclerviewapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var adapter: MainAdapter? = null

    private val cellsListViewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvTestList.layoutManager = LinearLayoutManager(applicationContext)
        updateUI()
    }

    private fun updateUI() {
        val cells = cellsListViewModel.cells
        adapter = MainAdapter(this, cells)
        binding.rvTestList.adapter = adapter
    }
}