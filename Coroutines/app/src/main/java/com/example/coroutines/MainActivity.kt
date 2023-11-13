package com.example.coroutines

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.coroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    var count = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val asyncAwait = AsyncAwait()

        CoroutineScope(Dispatchers.Main).launch {
            Log.d("Tag", "Calculation started...")
            val res1 = async(Dispatchers.IO) { asyncAwait.getStockCount1() }
            val res2 = async(Dispatchers.IO) { asyncAwait.getStockCount2() }
            val result = res1.await() + res2.await()
            Toast.makeText(this@MainActivity, "$result", Toast.LENGTH_SHORT).show()
            Log.d("Tag", result.toString())
        }

        binding = DataBindingUtil.setContentView(
            this@MainActivity,
            R.layout.activity_main
        )

        binding.button.setOnClickListener {
//            binding.textView2.text = count.toString()
//            count++
//            CoroutineScope(Dispatchers.IO).launch{
//                downloadUserData(binding.textView)
//            }

            CoroutineScope(Dispatchers.IO).launch {
                uploadUserData(binding.textView2)
            }

//            CoroutineScope(Dispatchers.Main).launch {
//                binding.textView.text = UserDataManager().getTotalUserAccount().toString()
////                binding.textView.text = UserDataManager2().getTotalUserCount().toString()
//            }
        }

        binding.button2.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
//                downloadUserData(binding.textView)

            }
        }


        CoroutineScope(Dispatchers.IO).launch {
            Log.d("Tag", Thread.currentThread().name)
        }

        CoroutineScope(Dispatchers.IO).launch {
            Log.d("Tag", Thread.currentThread().name)
        }

        CoroutineScope(Dispatchers.Main).launch{
            Log.d("Tag", Thread.currentThread().name)
        }
    }

    private suspend fun downloadUserData(view: TextView) {
        for(i in 1..20000) {
//            Log.d("Tag", i.toString())
            // withContext is a suspending function helps to run `suspend tasks` without blocking the Main(UI) thread...
            withContext(Dispatchers.Main) {// with the help of withContext we can switch the thread of coroutine scope...
                view.text = i.toString()
            }
        }
    }

    private fun uploadUserData(view: TextView) {
        for(i in 1..80000) {
//            Log.d("Tag", i.toString())
            CoroutineScope(Dispatchers.Main).launch {
                view.text = i.toString()
            }
        }
    }
 }