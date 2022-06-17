package home.bthayes1.fragmentpractivce

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


/**
 * A simple [Fragment] subclass.
 * Use the [Fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment2 : Fragment() {

    private lateinit var listener: OnItemSelectedListener
    private lateinit var button2: Button
    private lateinit var button3: Button

    interface OnItemSelectedListener {
        //For every event you want to send to MainActivity, create a function here
        fun onButton2Selected(link : String)
        fun onButton3Selected(link: String)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_2, container, false)

        //Initialize views and create listeners to fire off clickListeners
        button2 = view.findViewById(R.id.button2)
        button3 = view.findViewById(R.id.button3)
        button2.setOnClickListener {
            onSomeClick(button2)
        }
        button3.setOnClickListener { onSomeClick(button3) }
        // Inflate the layout for this fragment
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e(TAG, "$context")
        listener = if (context is OnItemSelectedListener) {
            context
        } else {
            throw ClassCastException("$context must implement MyListFragment.OnItemSelectedListener")
        }
    }


    fun onSomeClick(view: View){
        // Determine which event to report to MainActivity, depending on which view that was interacted with
        when (view){
            button2 -> listener.onButton2Selected("your granny")
            button3 -> listener.onButton3Selected("your daddy")
        }
    }
    companion object{
        private const val TAG = "Fragment2"
    }
}