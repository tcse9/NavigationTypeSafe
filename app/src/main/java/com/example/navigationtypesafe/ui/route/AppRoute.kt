package com.example.navigationtypesafe.ui.route

import kotlinx.serialization.Serializable

@Serializable
data class Home(val screenName: String)

@Serializable
data class Movies(val screenName: String)

@Serializable
data class Details(val mediaId: Int)