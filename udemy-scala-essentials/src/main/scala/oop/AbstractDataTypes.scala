package oop

object AbstractDataTypes extends App {
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType = "canine"
    override def eat = println("crunch, crunch")
  }

  val dog: Animal = new Dog
  dog.eat

  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(
      s"I'm a croc and I'm eating ${animal.creatureType}"
    )
  }

  val croc = new Crocodile
  croc.eat(dog)

}
