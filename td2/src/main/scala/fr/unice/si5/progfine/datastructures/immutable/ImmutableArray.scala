package fr.unice.si5.progfine.datastructures.immutable

// https://www.freecodecamp.org/news/write-safer-and-cleaner-code-by-leveraging-the-power-of-immutability-7862df04b7b6/
object ImmutableArray {

  def add(array: Array[String], value: String): Array[String] ={
    val copiedArray = array.slice(0, array.length)
    copiedArray.+:(value)
    return copiedArray
  }

}
