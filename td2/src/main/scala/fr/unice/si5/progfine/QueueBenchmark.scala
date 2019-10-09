package fr.unice.si5.progfine

object QueueBenchmark {

  def mutableBenchmark(nbLoop : Int): Unit ={
    var mutableQueue = new scala.collection.mutable.Queue[String]()

    val startTimeEnqueue = System.currentTimeMillis()
    for (i <- 0 until nbLoop) {
      mutableQueue.enqueue(i.toString())
    }

    val stopTimeEnqueue = System.currentTimeMillis()
    println("Enqueue mutable Queue runtime" + (stopTimeEnqueue - startTimeEnqueue) + " ms")
  }

  def immutableBenchmark(nbLoop : Int): Unit ={
    var immutableQueue = scala.collection.immutable.Queue[String]()

    val startTimeEnqueue = System.currentTimeMillis()
    for (i <- 0 until nbLoop) {
      immutableQueue.enqueue(i.toString())
    }

    val stopTimeEnqueue = System.currentTimeMillis()
    println("Enqueue immutable Queue runtime" + (stopTimeEnqueue - startTimeEnqueue) + " ms")
  }
  
}
