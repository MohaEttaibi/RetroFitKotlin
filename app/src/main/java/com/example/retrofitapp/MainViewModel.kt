package com.example.retrofitapp.api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapp.model.Post
import com.example.retrofitapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {
    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse3: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myResponse4: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myResponse5: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse6: MutableLiveData<Response<Post>> = MutableLiveData()
    fun getPost(auth: String){
        viewModelScope.launch {
            val response = repository.getPost(auth)
            myResponse.value = response
        }
    }

    fun getPost2(number: Int){
        viewModelScope.launch {
            val response = repository.getPost2(number)
            myResponse2.value = response
        }
    }

    fun getCustomPosts(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomPosts(userId, sort, order)
            myResponse3.value = response
        }
    }

    fun getCustomPosts2(userId: Int, options: Map<String,String>) {
        viewModelScope.launch {
            val response = repository.getCustomPosts2(userId, options)
            myResponse4.value = response
        }
    }

    fun pushPost(post: Post) {
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse5.value = response
        }
    }

    fun pushPost2(userId: Int, id: Int, title: String, body: String) {
        viewModelScope.launch {
            val response = repository.pushPost2(userId, id, title, body)
            myResponse6.value = response
        }
    }
}