package fr.unice.si5.progfine.td1

object OperatorBenchmark {

  private val nbLoop:Int = 1000000000

  def additionBenchmark(): Unit ={
    var beginning:Long = 0
    var end:Long = 0

    beginning = System.currentTimeMillis()
    for(i <- 0 to nbLoop){
      i+3888
    }
    end = System.currentTimeMillis()

    println("Total addition computing time")
    println(end-beginning)

    println("Average time per addition (ms)")
    println((end-beginning).toFloat/nbLoop)
  }

  def multiplicationBenchmark(): Unit ={
    var beginning:Long = 0
    var end:Long = 0

    beginning = System.currentTimeMillis()
    for(i <- 0 to nbLoop){
      i*3888
    }
    end = System.currentTimeMillis()

    println("Total multiplication computing time")
    println(end-beginning)

    println("Average time per multiplication (ms)")
    println((end-beginning).toFloat/nbLoop)
  }

  def compareOperatorBenchmark(): Unit ={
    var beginning:Long = 0
    var end:Long = 0

    beginning = System.currentTimeMillis()
    for(i <- 0 to nbLoop){
      i<3888
    }
    end = System.currentTimeMillis()

    println("Total computing time with less than operator")
    println(end-beginning)

    println("Average time per operation (ms)")
    println((end-beginning).toFloat/nbLoop)
  }
}
