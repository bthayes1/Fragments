package home.bthayes1.fragmentpractivce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * This is a guide to setting up interfaces and fragments.
 */

class MainActivity :  AppCompatActivity(), Fragment1.OnItemSelectedListener, Fragment2.OnItemSelectedListener{
    private val fragment = Fragment1()
    private val fragment2 = Fragment2()

    private lateinit var tvLink : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvLink = findViewById(R.id.tvLink)
        Log.e(TAG, "App started")
        openFragment(fragment)
    }
    // Interface from Fragment1
    override fun onItemSelected(link: String) {
        updateUI(link)
        openFragment(fragment2)
    }
    // Interface from button2 in fragment2
    override fun onButton2Selected(link: String) {
        updateUI(link)
        openFragment(fragment)
    }
    // Interface from button2 in fragment2
    override fun onButton3Selected(link: String) {
        updateUI(link)
    }
    
    private fun openFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment, fragment)
        ft.commit()
    }

    private fun updateUI(link: String) {
        Log.e(TAG, "onItemSelected: $link")
        tvLink.text = link
    }

    companion object{
        private const val TAG = "MainActivity"
    }
}
