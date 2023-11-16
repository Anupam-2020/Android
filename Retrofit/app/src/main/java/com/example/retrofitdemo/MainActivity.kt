package com.example.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.awaitResponse

class MainActivity : AppCompatActivity() {

//    lateinit var responseData: Deferred<Response<Albums>>
    lateinit var retrofitService: AlbumService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.albumData)
        retrofitService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)

//        functionForGettingAlbumsUsingCoroutineScopeMethod(textView)
//        functionForGettingAlbumsUsingLiveDataBuilderMethod(textView)
//        functionForGettingAlbumsOfSingleUserId(textView)
//        functionForgetSingleAlbumM_1()
//        functionForgetSingleAlbumM_2(textView)
//        uploadAlbum(textView)
    }

    private fun functionForGettingAlbumsUsingCoroutineScopeMethod(textView: TextView) {
        val responseData = CoroutineScope(Dispatchers.IO).async {
            retrofitService.getAlbums()
        }

        CoroutineScope(Dispatchers.Main).launch {
            Log.d("Tag", responseData.await().body().toString())
            responseData.await().body()?.let { it ->
                it.forEach {
                    val albumList = " "+ "Album Title: ${it.title}"+"\n"+
                            " "+"Album Id: ${it.id}"+"\n"+
                            " "+"User Id: ${it.userId}"+"\n\n\n"

                    textView.append(albumList)
                }
            }
        }
    }

    private fun functionForGettingAlbumsUsingLiveDataBuilderMethod(textView: TextView) {
        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response = retrofitService.getAlbums()
            emit(response)
        }

        responseLiveData.observe(this, Observer { it ->
            Log.d("Tag", it.body().toString())
            it.body()?.let { it ->
                it.forEach {
                    val albumList = " "+ "Album Title: ${it.title}"+"\n"+
                            " "+"Album Id: ${it.id}"+"\n"+
                            " "+"User Id: ${it.userId}"+"\n\n\n"

                    textView.append(albumList)
                }
            }
        })
    }

    private fun functionForGettingAlbumsOfSingleUserId(textView: TextView) {
        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response = retrofitService.getSortedAlbums(3)
            emit(response)
        }
        responseLiveData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()
            if (albumsList != null) {
                while (albumsList.hasNext()) {
                    val albumsItem = albumsList.next()
//                    Log.d("Tag", albumsItem.title)
                    val result = " "+ "Album Title: ${albumsItem.title}"+"\n"+
                            " "+"Album Id: ${albumsItem.id}"+"\n"+
                            " "+"User Id: ${albumsItem.userId}"+"\n\n\n"
                    textView.append(result)
                }
            }
        })
    }

    private fun functionForgetSingleAlbumM_1() {
        val responseData: LiveData<Response<AlbumsItem>> = liveData {
            val response = retrofitService.getAlbum(3)
            emit(response)
        }

        responseData.observe(this) {
            val title = it.body()?.title
            Toast.makeText(this,title, Toast.LENGTH_SHORT).show()
        }
    }

    private fun functionForgetSingleAlbumM_2(textView: TextView) {
        val responseData = CoroutineScope(Dispatchers.IO).async {
            retrofitService.getAlbum(3)
        }

        CoroutineScope(Dispatchers.Main).launch {

            val result = responseData.await().body().toString()
            textView.text = result
        }
    }

    private fun uploadAlbum(textView: TextView) {
        val album = AlbumsItem(0, "This is my Album", 2)
        val postResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response = retrofitService.uploadAlbum(album)
            emit(response)
        }


        postResponse.observe(this, Observer {it ->
            val result = it.body()
            val textToDisplay = result?.let {
                " "+"Album title: ${it.title}"+"\n"+
                        " "+"Album id: ${it.id}"+"\n\n"
            }

            textView.text = textToDisplay

            Log.d("Tag", it.body()?.title.toString())
        })
    }
}