package ru.sber.oop

import java.util.Objects.isNull

open class Room(val name: String) {

    var size: Int = 100
    constructor(name: String, size: Int) : this(name = name){
        this.size = size

    }

    open protected val dangerLevel = 5

    init{
        val size: Int = 100
    }

    fun description() = "Room: $name"

    open fun load() = "Nothing much to see here..."

}

//TODO: create class TownSquare here...
class TownSquare(name: String, size: Int = 1000) : Room(name,size) {
    override val dangerLevel: Int
        get() = super.dangerLevel - 3

    final override fun load(): String {
        return "You have a lot to see here"
    }
}
