package fr.unice.si5.progfine

import java.io.File

import com.github.tototoshi.csv.CSVWriter

object QueueBenchmark {

  def MutableBenchmark(powerLimit: Int): Unit = {
    val f_mutable_enqueue = new File("mutable-queue-enqueue.csv")
    val writer_enqueue = CSVWriter.open(f_mutable_enqueue)

    val f_mutable_dequeue = new File("mutable-queue-dequeue.csv")
    val writer_dequeue = CSVWriter.open(f_mutable_dequeue)

    writer_enqueue.writeRow(List("size", "start_time", "stop_time", "total_time"))
    writer_dequeue.writeRow(List("size", "start_time", "stop_time", "total_time"))

    for (power <- 1 to powerLimit) {
      println("Queue Mutable Benchmark actual power : " + power)
      runMutableScenario(power, writer_enqueue, writer_dequeue)
    }
  }

  def ImmutableBenchmark(powerLimit: Int): Unit = {
    val f_immutable_enqueue = new File("immutable-queue-enqueue.csv")
    val writer_enqueue = CSVWriter.open(f_immutable_enqueue)

    val f_immutable_dequeue = new File("immutable-queue-dequeue.csv")
    val writer_dequeue = CSVWriter.open(f_immutable_dequeue)

    writer_enqueue.writeRow(List("size", "start_time", "stop_time", "total_time"))
    writer_dequeue.writeRow(List("size", "start_time", "stop_time", "total_time"))

    for (power <- 1 to powerLimit) {
      println("Queue Immutable Benchmark actual power : " + power)
      runImmutableScenario(power, writer_enqueue, writer_dequeue)
    }
  }

  private def runMutableScenario(power: Int, writer_enqueue: CSVWriter, writer_dequeue: CSVWriter): Unit = {
    var mutableQueue = new scala.collection.mutable.Queue[String]()

    val startTimeEnqueue = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      mutableQueue.enqueue(i.toString())
    }

    val stopTimeEnqueue = System.currentTimeMillis()
    writer_enqueue.writeRow(List(power, startTimeEnqueue, stopTimeEnqueue, stopTimeEnqueue - startTimeEnqueue))

    assert(mutableQueue.length == scala.math.pow(2, power).toInt)

    val startTimeDequeue = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      mutableQueue.dequeue()
    }

    val stopTimeDequeue = System.currentTimeMillis()
    writer_dequeue.writeRow(List(power, startTimeDequeue, stopTimeDequeue, stopTimeDequeue - startTimeDequeue))

    assert(mutableQueue.length == 0)
  }

  private def runImmutableScenario(power: Int, writer_enqueue: CSVWriter, writer_dequeue: CSVWriter): Unit = {
    var immutableQueue = scala.collection.immutable.Queue[String]()

    val startTimeEnqueue = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      immutableQueue = immutableQueue.enqueue(i.toString())
    }

    val stopTimeEnqueue = System.currentTimeMillis()
    writer_enqueue.writeRow(List(power, startTimeEnqueue, stopTimeEnqueue, stopTimeEnqueue - startTimeEnqueue))

    assert(immutableQueue.length == scala.math.pow(2, power).toInt)

    val startTimeDequeue = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      immutableQueue = immutableQueue.dequeue._2
    }

    val stopTimeDequeue = System.currentTimeMillis()
    writer_enqueue.writeRow(List(power, startTimeEnqueue, stopTimeEnqueue, stopTimeEnqueue - startTimeEnqueue))

    assert(immutableQueue.length == 0)
  }

}
