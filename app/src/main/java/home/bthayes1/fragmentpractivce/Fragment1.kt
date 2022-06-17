package home.bthayes1.fragmentpractivce

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class Fragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var listener: OnItemSelectedListener

    interface OnItemSelectedListener {
        fun onItemSelected(link : String)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_1, container, false)

        val button : Button = view.findViewById(R.id.button1)
        button.setOnClickListener {
            onSomeClick(button)
        }
        // Inflate the layout for this fragment
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is OnItemSelectedListener) {
            context
        } else {
            throw ClassCastException("$context must implement MyListFragment.OnItemSelectedListener")
        }
    }


    fun onSomeClick(view: View){
        listener.onItemSelected("Your Mom")
    }

}