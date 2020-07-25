package com.hanseltritama.interfacecommunicationdemo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_a.*
import kotlinx.android.synthetic.main.fragment_a.view.*
import java.lang.RuntimeException

class FragmentA : Fragment() {

    private var listener: FragmentAListener? = null

    // Interface to communicate between fragment & activity
    interface FragmentAListener {
        fun onInputASent(input: String)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_a, container, false)

        view.fragment_a_button.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                listener?.onInputASent(fragment_a_edit_text.text.toString())
            }
        })

        return view
    }

    fun updateEditTextFragmentA(newText: String) {
        fragment_a_edit_text.setText(newText)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // if context is activity, implement FragmentAListener
        if (context is FragmentAListener) {
            // Subscriber
            listener = context
        } else {
            throw RuntimeException(context.toString()
            + " must implement FragmentAListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}