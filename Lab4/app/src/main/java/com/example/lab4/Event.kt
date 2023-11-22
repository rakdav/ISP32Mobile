package com.example.lab4

import android.net.Uri
import java.util.Date

data class Event(var name:String,var data:Date,var desc:String,
    var isResolved:Boolean,var path:Uri)