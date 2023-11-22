package oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, age: Int = 18) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String =
      s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name what the heck?!"
    def isAlive: Boolean = true

    def apply(): String =
      s"Hi, my name is $name I am $age years old and I like $favoriteMovie"

    // Excercises
    def +(title: String): Person =
      new Person(s"${this.name} ($title)", this.favoriteMovie)
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, age + 1)

  }

  val mary = new Person("Mary", "Inception")
  val tom = new Person("Tom", "Fight Club")

  // Prefix notation, unary operators
  // "Unary operators are also methods!"
  println(-1)
  println(1.unary_-)

  // Postfix notation
  // println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent
  //
  /*
   * Excercises
   *
   * 1. Overload the + operator
   *  mary + "the rockstar" => new person "Mary (the rockstar)"
   *
   * 2. Add an age to the Person class
   *  add unary + oeprator => new person with age + 1
   *
   * 3. Add a "learns" method in the Person class => "Mary learns Scala"
   *  Add a learnScala method, calls learns with "Scala"
   *  Use it in postfix notation.
   *
   * 4. Overload the apply method
   *  mary.apply(2) => "Mary watched Inception 2 times"
   */
  // 1)
  println((mary + "the rockstar")())
  // 2)
  println((+mary)())

}
