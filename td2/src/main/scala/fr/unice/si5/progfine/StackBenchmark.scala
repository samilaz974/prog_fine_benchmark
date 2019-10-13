package fr.unice.si5.progfine

import java.io.File

import com.github.tototoshi.csv.CSVWriter

object StackBenchmark {

  def MutableBenchmark(powerLimit: Int): Unit = {
    val f_mutable_push = new File("mutable-stack-push.csv")
    val writer_push = CSVWriter.open(f_mutable_push)

    val f_mutable_pop = new File("mutable-stack-pop.csv")
    val writer_pop = CSVWriter.open(f_mutable_pop)

    writer_push.writeRow(List("size", "start_time", "stop_time", "total_time"))
    writer_pop.writeRow(List("size", "start_time", "stop_time", "total_time"))

    for (power <- 1 to powerLimit) {
      println("Stack Mutable Benchmark actual power : " + power)
      runMutableScenario(power, writer_push, writer_pop)
    }
  }

  def ImmutableBenchmark(powerLimit: Int): Unit = {
    val f_immutable_push = new File("immutable-stack-push.csv")
    val writer_push = CSVWriter.open(f_immutable_push)

    val f_immutable_pop = new File("immutable-stack-pop.csv")
    val writer_pop = CSVWriter.open(f_immutable_pop)

    writer_push.writeRow(List("size", "start_time", "stop_time", "total_time"))
    writer_pop.writeRow(List("size", "start_time", "stop_time", "total_time"))

    for (power <- 1 to powerLimit) {
      println("Stack Immutable Benchmark actual power : " + power)
      runImmutableScenario(power, writer_push, writer_pop)
    }
  }

  private def runMutableScenario(power: Int, writer_push: CSVWriter, writer_pop: CSVWriter): Unit = {

    var mutableStack = new scala.collection.mutable.Stack[String]()

    val startTimePush = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      mutableStack.push(i.toString)
    }

    val stopTimePush = System.currentTimeMillis()

    assert(mutableStack.length == Math.round(Math.round(Math.pow(2, power))))
    writer_push.writeRow(List(power, startTimePush, stopTimePush, stopTimePush - startTimePush))

    val startTimePop = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      mutableStack.pop()
    }

    val stopTimePop = System.currentTimeMillis()

    assert(mutableStack.length == 0)
    writer_pop.writeRow(List(power, startTimePop, stopTimePop, stopTimePop - startTimePop))
  }

  private def runImmutableScenario(power: Int, writer_push: CSVWriter, writer_pop: CSVWriter): Unit = {
    var immutableStack = scala.collection.immutable.Stack[String]()

    val startTimePush = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      immutableStack = immutableStack.push(i.toString)
    }

    val stopTimePush = System.currentTimeMillis()

    assert(immutableStack.length == Math.round(Math.round(Math.pow(2, power))))
    writer_push.writeRow(List(power, startTimePush, stopTimePush, stopTimePush - startTimePush))

    val startTimePop = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      immutableStack = immutableStack.pop
    }

    val stopTimePop = System.currentTimeMillis()

    assert(immutableStack.length == 0)
    writer_pop.writeRow(List(power, startTimePop, stopTimePop, stopTimePop - startTimePop))
  }
}
