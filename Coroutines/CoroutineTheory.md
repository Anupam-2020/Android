## CoroutineScope and Context.........................................................

CoroutineScope -> An interface which provides the scope for coroutines
GlobalScope ->  is used to launch top-level coroutines which are operating on whole application lifetime...

Context in coroutine -> Dispatchers.IO/Main/Default/Unconfined

Dispatchers.Main -> Coroutine runs on Main(UI) thread.
Dispatchers.IO -> Coroutine will run on background thread using shared pool of on-demand created threads. ( used for local database, fetching data from server, working with files)
Dispatchers.Default -> used for CPU intensive tasks like sorting a very large list/ parsing JSON file with large set of data
Dispatchers.unconfined -> Coroutine will run on current thread, but if it is suspended and resumed, it will run on suspending function's thread.

Note -> We can join multiple coroutine contexts using + operator.............................


## Coroutine builders....................................................

launch -> launch is the coroutine builder.
CoroutineBuilders -> are extension functions of coroutine-scope which are are used for launching a new coroutine.

four types of coroutineBuilders -> 1. launch, 2. async, 3.runBlocking, 4. produce

launch -> launch builder launches a new coroutine without blocking current thread. 
          This builder returns an instance of job, which is used as a reference of coroutine
          launch is used for coroutine which doesn't return any value.

async -> async builder is used for coroutines which returns some value.
         Same as launch, async also launches a new coroutine without blocking current thread.
         This builder returns an instance of Deferred<T>. We need to invoke await() to get the values.
        (Similar to but not exactly Javascript async/await).

produce -> produce builder is for coroutines which returns stream of elements
            returns an instance of ReceiveChannel

runBlocking -> the coroutine created using this builder will block the thread during execution.
               returns a result of type T.


## Suspending Functions..........................................................

various suspending functions -> 1. withContext, 2. withTimeout, 3. withTimeoutOrNull, 4. delay, 5. await, 6. join, 7. coroutineScope
