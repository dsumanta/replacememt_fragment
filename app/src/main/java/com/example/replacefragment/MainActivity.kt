package com.example.replacefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val add = findViewById<Button>(R.id.add_fragment)
        add.setOnClickListener {
            val fragment = BlankFragment()
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.main_container, fragment, "BlankFragment") // The third parameter should be a string
            fragmentTransaction.commit()
        }
        val remove:Button=findViewById(R.id.remove_fragment)
        remove.setOnClickListener{
            val fragment=supportFragmentManager.findFragmentById(R.id.main_container)
            fragment ?.let {
                supportFragmentManager.beginTransaction().remove(fragment).commit()
            }
        }
        val replacefragment=findViewById<Button>(R.id.replace_fragment)
        replacefragment.setOnClickListener{
            val fragment=BlankFragment2()
            with(supportFragmentManager.beginTransaction()){
                replace(R.id.main_container,fragment)
                addToBackStack(null)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                commit()
            }
        }
    }
}
