package com.george.skadiweather.logic

import androidx.lifecycle.liveData
import com.george.skadiweather.logic.model.Place
import com.george.skadiweather.logic.network.SkadiWeatherNetwork
import kotlinx.coroutines.Dispatchers

object Repository {
    fun searchPlaces(query:String)= liveData(Dispatchers.IO) {
    val result=try {
        val placeResponse=SkadiWeatherNetwork.searchPlaces(query)
        if (placeResponse.status=="ok")
        {
            val places=placeResponse.places
            Result.success(places)
        }
        else{
            Result.failure(RuntimeException("response is ${placeResponse.status}"))
        }
    }catch (e:Exception){
        Result.failure<List<Place>>(e)
    }
    emit(result)
    }
}