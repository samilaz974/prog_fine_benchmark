package fr.unice.si5.progfine

object HashMapBenchmark {

  def benchmarkMutable(nbLoop: Int): Unit = {
    var mutableHashMap: scala.collection.mutable.HashMap[String, String] = scala.collection.mutable.HashMap("1" -> "2", "3" -> "4")

    val startTimePut = System.currentTimeMillis()
    for (i <- 4 until nbLoop) {
      mutableHashMap.put(i.toString(), i.toString)
    }

    val stopTimePut = System.currentTimeMillis()
    println("Put mutable HashMap runtime" + (stopTimePut - startTimePut) + " ms")

    val startTimeGet = System.currentTimeMillis()
    for (i <- 4 until nbLoop) {
      mutableHashMap.get(i.toString())
    }

    val stopTimeGet = System.currentTimeMillis()
    println("Get mutable HashMap runtime" + (stopTimeGet - startTimeGet) + " ms")


    val startTimeRemove= System.currentTimeMillis()
    for (i <- 4 until nbLoop) {
      mutableHashMap.remove(i.toString())
    }

    val stopTimeRemove = System.currentTimeMillis()
    println("Remove mutable HashMap runtime" + (stopTimeRemove - startTimeRemove) + " ms")


  }

  def benchmarkImmutable(nbLoop: Int): Unit = {
    var immutableHashMap: scala.collection.immutable.HashMap[String, String] = scala.collection.immutable.HashMap("1" -> "2", "3" -> "4")

    val startTimePut = System.currentTimeMillis()
    for (i <- 4 until nbLoop) {
      immutableHashMap = immutableHashMap + (i.toString -> i.toString)
    }
    val stopTimePut = System.currentTimeMillis()
    println("Put immutable HashMap runtime" + (stopTimePut - startTimePut) + " ms")


    val startTimeGet = System.currentTimeMillis()
    for (i <- 4 until nbLoop) {
      immutableHashMap.get(i.toString())
    }

    val stopTimeGet = System.currentTimeMillis()
    println("Get immutable HashMap runtime" + (stopTimeGet - startTimeGet) + " ms")


    val startTimeRemove= System.currentTimeMillis()
    for (i <- 4 until nbLoop) {
      immutableHashMap = immutableHashMap - (i.toString(), i.toString)
    }

    val stopTimeRemove = System.currentTimeMillis()
    println("Remove immutable HashMap runtime" + (stopTimeRemove - startTimeRemove) + " ms")
  }

}

