package com.example.navdetails.model

data class NavigationResponses(
    val result: Result,
    val session_id: String
)

data class Result(
    val title: String,
    val user_photo: String,
    val menus: List<Menu>,
    val notification_count: Int,
    val friend_req_count: Int,
    val message_count: Int,
    val loggedin_user_id: Int
)

data class Menu(
    val type: Int,
    val module: String?,
    val label: String,
    val icon: String?,
    val url: String?,
    val `class`: String
)





















//package com.example.navdetails.data.model
//
//
//data class NavigationResponses(
//    val result: Result,
//    val session_id: String
//)
//
//data class Result(
//    val title: String,
//    val user_photo: String,
//    val menus: List<Menu>,
//    val notification_count: Int,
//    val friend_req_count: Int,
//    val message_count: Int,
//    val loggedin_user_id: Int
//)
//
//data class Menu(
//    val type: Int,
//    val module: String?, // made nullable because some items lack "module"
//    val label: String,
//    val icon: String?,
//    val url: String?,
//    val `class`: String
//)
