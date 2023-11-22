package com.example.testprojectisp32

public class Calculator(var x:Int,var y:Int)
{
    fun Add():Int{
        return x+y;
    }
    fun Sub():Int{
        return x-y;
    }
    fun Mult():Int{
        return x*y;
    }
    fun Div():Int
    {
        if(y==0) return throw Exception("На ноль делить нельзя")
        return x/y;
    }
}