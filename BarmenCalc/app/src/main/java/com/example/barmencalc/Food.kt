package com.example.barmencalc

data class Food (val food:String,val count:Int,val price:Double)
{
    override fun toString(): String {
        return "$food $count $price"
    }
}