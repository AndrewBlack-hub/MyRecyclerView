package com.androidgang.myrecyclerviewapp.viewmodel

import androidx.lifecycle.ViewModel
import com.androidgang.myrecyclerviewapp.models.SomeCells

class MainViewModel: ViewModel() {

    val cells = mutableListOf<SomeCells>()

    init {
        for (i in 0 until 100) {
            val cell = SomeCells()
            cell.title = "Cell #$i"
            cell.desc = "Some cell #$i"
            cells += cell
        }
    }
}