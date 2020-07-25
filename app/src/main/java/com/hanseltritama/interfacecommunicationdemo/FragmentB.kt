package com.hanseltritama.interfacecommunicationdemo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_b.*
import kotlinx.android.synthetic.main.fragment_b.view.*
import java.lang.RuntimeException

class FragmentB : Fragment() {

    private var listener: FragmentBListener? = null

    // Interface to communicate between fragment & activity
    interface FragmentBListener {
        fun onInputBSent(input: String)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_b, container, false)

        view.fragment_b_button.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                // Needed for Activity to communicate with the interface
                listener?.onInputBSent(fragment_b_edit_text.text.toString())
            }
        })

        return view
    }

    fun updateEditTextFragmentB(newText: String) {
        fragment_b_edit_text.setText(newText)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // if context is activity, implement FragmentBListener
        if (context is FragmentBListener) {
            // Subscriber
            listener = context
        } else {
            throw RuntimeException(context.toString()
            + " must implement FragmentBListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}