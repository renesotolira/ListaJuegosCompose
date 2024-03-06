package com.example.listajuegos.viewmodels

import androidx.lifecycle.ViewModel
import com.example.listajuegos.R
import com.example.listajuegos.models.Game

class GamesViewModel : ViewModel() {

    fun loadGames(): ArrayList<Game>{
        val games = ArrayList<Game>()
        games.add( Game("Mario Bros Wonder", "Nintendo Switch", 1300, R.drawable.mario))
        games.add( Game("Resident Eivl", "Multiplataforma", 1600, R.drawable.resident))
        for(i in 1..10){
            games.add( Game("Resident Eivl $i", "PS$i", 1600 + (i * 100), R.drawable.resident))

        }
        return games
    }
}