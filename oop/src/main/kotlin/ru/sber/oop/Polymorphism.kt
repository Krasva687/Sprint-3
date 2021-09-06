package ru.sber.oop

import kotlin.random.Random

interface Fightable {

    val powerType: String
    var healthPoints: Int
    val damageRoll: Int
    get() = Random.nextInt()

    fun attack(opponent: Fightable): Int
}

//TODO: create class Player, Monster, Goblin here...
class Player(
    var name: String,
    var isBlessed: Boolean,
    override val powerType: String,
    override var healthPoints: Int
): Fightable{

    override fun attack(opponent: Fightable): Int {
        var damageForPlayer = damageRoll

        if(isBlessed) damageForPlayer *= 2
        else damageForPlayer

        opponent.healthPoints -= damageForPlayer
        return damageForPlayer
    }
}

abstract class Monster(open val name: String, open val description: String): Fightable{

    override fun attack(opponent: Fightable): Int {
        val damage = damageRoll
        opponent.healthPoints -= damage
        return damage
    }


}

class Goblin(
    override val powerType: String,
    override var healthPoints: Int,
    override val name: String,
    override val description: String
) :
    Monster(name, description) {

    override val damageRoll: Int
        get() = super.damageRoll / 2
}

