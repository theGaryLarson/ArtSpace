package com.example.artspace.data

import com.example.artspace.model.ArtSlide
import com.example.artspace.R
class DataSource() {
    fun loadSlides(): List<ArtSlide> {
        return listOf<ArtSlide>(
            ArtSlide(R.drawable.geisha, R.string.geishaDescription, R.string.showCaseArtist),
            ArtSlide(R.drawable.geisha2, R.string.geisha2Description, R.string.showCaseArtist),
            ArtSlide(R.drawable.jack, R.string.jack, R.string.showCaseArtist),
            ArtSlide(R.drawable.key, R.string.key, R.string.showCaseArtist),
            ArtSlide(R.drawable.kincaid, R.string.kincaid, R.string.showCaseArtist),
            ArtSlide(R.drawable.octopus, R.string.octopus, R.string.showCaseArtist),
            ArtSlide(R.drawable.morte, R.string.morte, R.string.showCaseArtist),
            ArtSlide(R.drawable.seattlebot, R.string.seattlebot, R.string.showCaseArtist),
            ArtSlide(R.drawable.seattlescape, R.string.seattlescape, R.string.showCaseArtist),
            ArtSlide(R.drawable.tiger, R.string.tiger, R.string.showCaseArtist),
            ArtSlide(R.drawable.treeleaf, R.string.treeleaf, R.string.showCaseArtist),
            ArtSlide(R.drawable.tribalfairy, R.string.tribalfairy, R.string.showCaseArtist),
            ArtSlide(R.drawable.whale, R.string.whale,R.string.showCaseArtist)
        )
    }
}
