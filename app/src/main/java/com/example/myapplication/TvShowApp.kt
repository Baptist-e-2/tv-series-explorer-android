package com.example.myapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp // <--- CETTE LIGNE EST CRUCIALE

@HiltAndroidApp
class TvShowApp : Application()