package com.example.kotlinfishermenhandbook

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var adapter:MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener(this)

        var list = ArrayList<ListItem>()

        list.addAll(fillArray
            (resources.getStringArray(R.array.fish),
            resources.getStringArray(R.array.fish_content),
            getImageID(R.array.fish_image_array)))

        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list)
        rcView.adapter = adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.id_fish -> {
                Toast.makeText(this,"id fish",Toast.LENGTH_SHORT).show()
                adapter?.updateAdaptor(fillArray(resources.getStringArray(R.array.fish),
                    resources.getStringArray(R.array.fish_content),
                    getImageID(R.array.fish_image_array)))
            }
            R.id.id_na ->
            {
                Toast.makeText(this,"id na",Toast.LENGTH_SHORT).show()
                adapter?.updateAdaptor(fillArray(resources.getStringArray(R.array.na),
                    resources.getStringArray(R.array.na_content),
                    getImageID(R.array.na_image_array)))
            }
            R.id.id_sna -> Toast.makeText(this,"id sna",Toast.LENGTH_SHORT).show()
            R.id.id_history -> Toast.makeText(this,"id history",Toast.LENGTH_SHORT).show()
        }
      return true
    }
    fun fillArray(titleArray:Array<String>,contentArray:Array<String>,imageArray:IntArray): List<ListItem>
    {
       var listItemArray = ArrayList<ListItem>()
        for (n in 0..titleArray.size - 1) {
            var listitem = ListItem(imageArray[n],titleArray[n],contentArray[n])
            listItemArray.add(listitem)


        }
        return listItemArray
    }
    fun  getImageID(imageArrayId:Int):IntArray
    {
        var tArray:TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices){
            ids[i] = tArray.getResourceId(i,0)
        }
        tArray.recycle()
        return ids
    }
}