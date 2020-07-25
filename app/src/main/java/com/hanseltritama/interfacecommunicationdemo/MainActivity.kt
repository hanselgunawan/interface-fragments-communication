package com.hanseltritama.interfacecommunicationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), FragmentA.FragmentAListener, FragmentB.FragmentBListener {

    private lateinit var fragmentA: FragmentA
    private lateinit var fragmentB: FragmentB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentA = FragmentA()
        fragmentB = FragmentB()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container_a, fragmentA)
            .replace(R.id.container_b, fragmentB)
            .commit()

    }

    override fun onInputASent(input: String) {
        fragmentB.updateEditTextFragmentB(input)
    }

    override fun onInputBSent(input: String) {
        fragmentA.updateEditTextFragmentA(input)
    }
}
