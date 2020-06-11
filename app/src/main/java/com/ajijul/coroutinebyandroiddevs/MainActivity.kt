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


//        //CoRoutine  context
        GlobalScope.launch(Dispatchers.IO) {
            // .Main : for ui/noBlocking operation
            // .Default : CPU intensive work
            // .UnContained :
            //.IO : for network operation
            // custom(ex: newSingleThreadContext())
            val answer = doNetworkOperation()
            withContext(Dispatchers.Main){
                tvDummy.text = answer
            }
        }



    }

    private suspend fun doNetworkOperation(): String {

        delay(3000)
        return "l"
    }

}
