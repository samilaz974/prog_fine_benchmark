package fr.unice.si5.progfine.td1

object OperatorBenchmark {

  def additionBenchmark(): Unit ={
    var timestamp:Long = System.currentTimeMillis()
    var beginning:Long = 0
    var end:Long = 0

    var totalDuration:Long = 0
    var loopMax:Int = 1000000

    var addition:Int = 0;

    for(i <- 0 to loopMax){
      beginning = System.currentTimeMillis()
      addition = i+1
      end = System.currentTimeMillis()
      totalDuration = totalDuration + (end - beginning)
    }

    println("The whole for loop time")
    println(System.currentTimeMillis() - timestamp)

    println("Total additionning time")
    println(totalDuration)
  }
}
