package com.ajijul.coroutinebyandroiddevs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    // CoRoutine is like task that run within a thread,
    //  multiple coroutine can be run on same thread.
    //  Like construction field, whole construction is a thread and
    //  labours are like a CoRoutine.

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Global scope live your CoRoutine until application die or after completion
        //task CoRoutine automatically remove from memory

        GlobalScope.launch {

            delay(3000) // delay() only make pause of current CoRoutine, not whole thread.
            // Whereas sleep() method in Thread class make pause of whole thread. On
            // Construction example, if one labour make delay() request then whole construction not
            // going to cancel but if whole construction got cancel then whole work will stop.
           println(doNetworkOperation())
           println(doNetworkOperation2())
            Log.e(TAG,"Hello from CoRoutine within the thread ${Thread.currentThread().name}")


        }



    }

    private suspend fun doNetworkOperation(): String {

        delay(3000)
        return "l"
    }

    private suspend fun doNetworkOperation2(): String {

        delay(3000)
        return "m"
    }

    fun fib(n: Int): Long {
        return if (n == 0) 0
        else if (n == 1) 1
        else fib(n - 1) + fib(n - 2)
    }
}
