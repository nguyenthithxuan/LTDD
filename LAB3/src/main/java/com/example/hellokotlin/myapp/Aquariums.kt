package com.example.hellokotlin.myapp

class Aquariums(var length: Int = 100, var width: Int = 20, var height: Int = 40) {


    fun printSize() {
        println(
            "Width: $width cm " +
                    "Length: $length cm " +
                    "Height: $height cm ")
    }
}