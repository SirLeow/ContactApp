package com.example.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val rvList: RecyclerView by lazy {
        findViewById(R.id.rv_list)
    }
    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindView()
        updateList()
    }

    private fun bindView(){
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList(){
        adapter.updateList(
            arrayListOf(
                Contact(
                    nome = "Thiago Barros",
                    phone= randomPhone(),
                    photo = "img.png"),
                Contact(
                    nome = "Gabriel Coelho",
                    phone= randomPhone(),
                    photo = "img.png"),
                Contact(
                    nome = "Luiz Henrique",
                    phone= randomPhone(),
                    photo = "img.png"),
                Contact(
                    nome = "Debora Rodrigues",
                    phone= randomPhone(),
                    photo = "img.png")

            )
        )
    }

    private fun randomPhone(): String {
        val ddd = Random.nextInt(10,99)
        val part1 = Random.nextInt(1000,9999)
        val part2 = Random.nextInt(1000,9999)
        return "($ddd)9$part1-$part2"
    }
}