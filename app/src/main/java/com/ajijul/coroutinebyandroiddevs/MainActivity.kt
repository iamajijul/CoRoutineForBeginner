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


        //RunBlocking
        runBlocking { //its block the current thread

            launch(Dispatchers.IO) {
                delay(1000L)// its not delaying whole thread, its only delaying
                // current coroutine
                println("Delaying first coRoutine")
            }

            launch(Dispatchers.IO) {
                delay(1000L)
                println("Delaying second coRoutine")
            }
            println("Before blocking start")
            delay(6000L)//its delaying whole current thread main, it will freeze the UI
            println("after blocking end")

        }
        //////////////



    }

}
