package com.androidgang.myrecyclerviewapp.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.androidgang.myrecyclerviewapp.R
import com.androidgang.myrecyclerviewapp.models.SomeCells

class MainAdapter(private val context: Context, private var cells: List<SomeCells>) : RecyclerView.Adapter<MainAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val cell = cells[position]
        holder.bind(cell)
    }

    override fun getItemCount(): Int = cells.size

    inner class MainHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private lateinit var cell: SomeCells

        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitleText)
        private val tvDesc: TextView = itemView.findViewById(R.id.tvDescText)

        fun bind(cell: SomeCells) {
            this.cell = cell
            tvTitle.text = this.cell.title
            tvDesc.text = this.cell.desc
        }

        init {
           itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            Toast.makeText(context, "${cell.title} pressed!", Toast.LENGTH_SHORT).show()
        }
    }
}