package fr.unice.si5.progfine

import java.io.File

import com.github.tototoshi.csv.CSVWriter
import fr.unice.si5.progfine.datastructures.immutable.ImmutableHeap
import fr.unice.si5.progfine.datastructures.mutable.MutableHeap

object HeapBenchmark {
  def MutableBenchmark(powerLimit: Int): Unit = {
    val f_mutable_insert = new File("mutable-heap-insert.csv")
    val writer_insert = CSVWriter.open(f_mutable_insert)

    val f_mutable_remove = new File("mutable-heap-remove.csv")
    val writer_remove = CSVWriter.open(f_mutable_remove)

    writer_insert.writeRow(List("size", "start_time", "stop_time", "total_time"))
    writer_remove.writeRow(List("size", "start_time", "stop_time", "total_time"))

    for (power <- 1 to powerLimit) {
      println("Queue Mutable Benchmark actual power : " + power)
      runMutableScenario(power, writer_insert, writer_remove)
    }
  }

  def ImmutableBenchmark(powerLimit: Int): Unit = {
    val f_immutable_insert = new File("immutable-heap-insert.csv")
    val writer_insert = CSVWriter.open(f_immutable_insert)

    val f_immutable_remove = new File("immutable-heap-remove.csv")
    val writer_remove = CSVWriter.open(f_immutable_remove)

    writer_insert.writeRow(List("size", "start_time", "stop_time", "total_time"))
    writer_remove.writeRow(List("size", "start_time", "stop_time", "total_time"))

    for (power <- 1 to powerLimit) {
      println("Queue Immutable Benchmark actual power : " + power)
      runImmutableScenario(power, writer_insert, writer_remove)
    }
  }

  private def runMutableScenario(power: Int, writer_insert: CSVWriter, writer_remove: CSVWriter): Unit = {
    var mutableheap = new MutableHeap(scala.math.pow(2, power).toInt+1)

    val startTimeinsert = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      mutableheap.insert(i)
    }

    val stopTimeinsert = System.currentTimeMillis()
    writer_insert.writeRow(List(power, startTimeinsert, stopTimeinsert, stopTimeinsert - startTimeinsert))

    assert(mutableheap.length == scala.math.pow(2, power).toInt)

    val startTimeremove = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      mutableheap.remove
    }

    val stopTimeremove = System.currentTimeMillis()
    writer_remove.writeRow(List(power, startTimeremove, stopTimeremove, stopTimeremove - startTimeremove))

    assert(mutableheap.length == 0)
  }

  private def runImmutableScenario(power: Int, writer_insert: CSVWriter, writer_remove: CSVWriter): Unit = {
    var immutableheap = new ImmutableHeap(scala.math.pow(2, power).toInt+1)

    val startTimeinsert = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      immutableheap.insert(i)
    }

    val stopTimeinsert = System.currentTimeMillis()
    writer_insert.writeRow(List(power, startTimeinsert, stopTimeinsert, stopTimeinsert - startTimeinsert))

    assert(immutableheap.length == scala.math.pow(2, power).toInt)

    val startTimeremove = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      immutableheap.remove
    }

    val stopTimeremove = System.currentTimeMillis()
    writer_remove.writeRow(List(power, startTimeremove, stopTimeremove, stopTimeremove - startTimeremove))

    assert(immutableheap.length == 0)

  }

}
