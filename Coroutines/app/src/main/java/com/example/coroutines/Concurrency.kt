package com.example.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// unstructured concurrency -> does not guarantee to complete all tasks of suspending function using coroutines, before it returns.
// async-await can be used to overcome above problem.

class UserDataManager {
    suspend fun getTotalUserAccount(): Int {
        // output:- 0 without using async-await,
        // 80 with async-await,
        // expected output-130

        var count = 10
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            count = 50
        }

        val deferred = CoroutineScope(Dispatchers.IO).async {
            delay(2000)
            return@async 70
        }
        return count + deferred.await()
    }
}


// structured concurrency -> all the suspending functions will be executed before function returns
class UserDataManager2 {
    private var count = 0
    private lateinit var deferred: Deferred<Int>
    suspend fun getTotalUserCount(): Int {
        // output:- 50 without using async-await,
        // 120 with async-await,
        // expected output fulfilled with/without async-await.

        coroutineScope {
            launch {
                delay(1000)
                count = 50
            }

            deferred = async(Dispatchers.IO) {
                delay(2000)
                return@async 70
            }
        }
        return count + deferred.await()
    }
}

// Note:- Best practices is -> use CoroutineScope(Dispatchers.Main) as parent scope and enclose all child suspend function with coroutineScope also called as structured concurrency.