package com.example.hellokotlin

import com.example.hellokotlin.myapp.Aquariums
import com.example.hellokotlin.myapp.Decoration

fun main(){
    buildAquarium()
    makeDecorations()
}
fun buildAquarium() {
    val aquarium1 = Aquariums()
    aquarium1.printSize()
    // default height and length
    val aquarium2 = Aquariums(width = 25)
    aquarium2.printSize()
    // default width
    val aquarium3 = Aquariums(height = 35, length = 110)
    aquarium3.printSize()
    // everything custom
    val aquarium4 = Aquariums(width = 25, height = 35, length = 110)
    aquarium4.printSize()
}
fun makeDecorations() {
    val decoration1 = Decoration("granite")
    println(decoration1)

    val decoration2 = Decoration("slate")
    println(decoration2)

    val decoration3 = Decoration("slate")
    println(decoration3)
    println (decoration1.equals(decoration2))
    println (decoration3.equals(decoration2))
}
