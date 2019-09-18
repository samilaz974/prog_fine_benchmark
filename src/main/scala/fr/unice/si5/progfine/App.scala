package fr.unice.si5.progfine

import fr.unice.si5.progfine.td1.OperatorBenchmark

/**
 * @author ${user.name}
 */
object App {
  
  def foo(x : Array[String]) = x.foldLeft("")((a,b) => a + b)
  
  def main(args : Array[String]) {
    println( "Benchmarking" )
    OperatorBenchmark.additionBenchmark()
  }

}
