package com.example.contactapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.DetailActivity.Companion.EXTRA_CONTACT
import kotlin.random.Random

class MainActivity : AppCompatActivity(), ClickItemContactListener {

    private val rvList: RecyclerView by lazy {
        findViewById(R.id.rv_list)
    }
    private val adapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)

        bindView()
        updateList()
        initDrawer()
    }

    private fun initDrawer(){
        val drawerLayout = findViewById<View>(R.id.drawerLayout) as DrawerLayout
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item1 ->{
                showToast("Exibindo item do menu 1")
                true
            }
            R.id.item2 ->{
                showToast("Exibindo item do menu 2")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun clickItemContact(contact: Contact) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(EXTRA_CONTACT, contact)
        startActivity(intent)
    }

    private fun randomPhone(): String {
        val ddd = Random.nextInt(10,99)
        val part1 = Random.nextInt(1000,9999)
        val part2 = Random.nextInt(1000,9999)
        return "($ddd)9$part1-$part2"
    }

    private fun showToast(msg:String){
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show()
    }
}