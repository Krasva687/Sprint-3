package ru.sber.oop

import java.util.Objects.isNull
import ru.sber.oop.Goblin as Goblin

open class Room(val name: String, val size: Int) {

    constructor(name: String): this(name,100)
    open protected val dangerLevel = 5
    var monster: Monster = Goblin("FireBalls", 40, "FireSlims", "Scare of salt potion and do not have safe place")

    fun description() = "Room: $name"

    fun Monster.getSolutation(): String{
        return "My name is ${monster.name}, now u know who will kill u"
    }

    open fun load() = "You are in ${name}!\n ${monster.getSolutation()}"
    }


//TODO: create class TownSquare here...
class TownSquare(name: String, size: Int = 1000) : Room(name,size) {

    override val dangerLevel: Int
        get() = super.dangerLevel - 3

    final override fun load(): String {
        return "You have a lot to see here"
    }
}
