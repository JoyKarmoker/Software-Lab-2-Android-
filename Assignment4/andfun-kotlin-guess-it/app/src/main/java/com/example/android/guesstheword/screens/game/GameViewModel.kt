package com.example.android.guesstheword.screens.game
import android.util.Log
import androidx.lifecycle.ViewModel
class GameViewModel: ViewModel() {
    init{
        Log.i("Game View Model", "Game view model created")
    }

    override fun onCleared(){
        super.onCleared()
        Log.i("Game View Model", "Game view model destroyed")
    }
}