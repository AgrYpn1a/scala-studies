package oop

class Person(val name: String, val age: Int) {
  println("Created Person object")

  // Multiple constructors
  def this(name: String) = this(name, 0)
}

class Counter(val count: Int = 0) {
  def inc = {
    println("incrementing")
    new Counter(count + 1) // Immutability
  }
  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }
  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(count)
}

object Main {
  def main(args: Array[String]): Unit = {
    val counter = new Counter
    counter.inc.print
    counter.inc.inc.inc.print
    counter.inc(5).print
  }
}
