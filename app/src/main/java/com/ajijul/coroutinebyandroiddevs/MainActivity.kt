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


        //Jobs, Waiting, Cancelation
        val job = GlobalScope.launch {

            repeat(5) { // Cancellation will work properly because we have pause in each iteration,
                          // CoRoutine will get enough time to cancel the job.
                Log.e(TAG, "CoRounting under progress...")
                delay(3000)
            }

        }

        runBlocking {
            job.join() // join(): Its block the current thread until the particular job
            // coroutine got finish
            Log.e(TAG, "Job finished, current start running again...")
        }
        Log.e(TAG, "Hello from thread ${Thread.currentThread().name}")


    }


    fun fib(n: Int): Long {
        return if (n == 0) 0
        else if (n == 1) 1
        else fib(n - 1) + fib(n - 2)
    }
}
