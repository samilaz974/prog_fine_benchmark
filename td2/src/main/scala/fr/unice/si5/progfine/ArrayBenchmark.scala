package fr.unice.si5.progfine

import java.io.File

import com.github.tototoshi.csv.CSVWriter
import fr.unice.si5.progfine.datastructures.immutable.ImmutableArray

object ArrayBenchmark {
  def MutableBenchmark(powerLimit: Int): Unit = {
    val f_mutable_set = new File("mutable-array-set.csv")
    val writer_set = CSVWriter.open(f_mutable_set)

    val f_mutable_get = new File("mutable-array-get.csv")
    val writer_get = CSVWriter.open(f_mutable_get)

    writer_set.writeRow(List("size", "start_time", "stop_time", "total_time"))
    writer_get.writeRow(List("size", "start_time", "stop_time", "total_time"))

    for (power <- 1 to powerLimit) {
      println("array Mutable Benchmark actual power : " + power)
      runMutableScenario(power, writer_set, writer_get)
    }
  }

  def ImmutableBenchmark(powerLimit: Int): Unit = {
    val f_immutable_set = new File("immutable-array-set.csv")
    val writer_set = CSVWriter.open(f_immutable_set)

    val f_immutable_get = new File("immutable-array-get.csv")
    val writer_get = CSVWriter.open(f_immutable_get)

    writer_set.writeRow(List("size", "start_time", "stop_time", "total_time"))
    writer_get.writeRow(List("size", "start_time", "stop_time", "total_time"))

    for (power <- 1 to powerLimit) {
      println("array Immutable Benchmark actual power : " + power)
      runImmutableScenario(power, writer_set, writer_get)
    }
  }

  private def runMutableScenario(power: Int, writer_set: CSVWriter, writer_get: CSVWriter): Unit = {

    var mutablearray = new Array[String](scala.math.pow(2, power).toInt)

    val startTimeset = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      mutablearray.+(i.toString)
    }

    val stopTimeset = System.currentTimeMillis()

    assert(mutablearray.length == scala.math.pow(2, power).toInt)
    writer_set.writeRow(List(power, startTimeset, stopTimeset, stopTimeset - startTimeset))

    val startTimeget = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      mutablearray(i)
    }

    val stopTimeget = System.currentTimeMillis()

    assert(mutablearray.length == scala.math.pow(2, power).toInt)
    writer_get.writeRow(List(power, startTimeget, stopTimeget, stopTimeget - startTimeget))
  }

  private def runImmutableScenario(power: Int, writer_set: CSVWriter, writer_get: CSVWriter): Unit = {
    var immutablearray = new Array[String](scala.math.pow(2, power).toInt)

    val startTimeset = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      immutablearray = ImmutableArray.add(immutablearray, i.toString)
    }

    val stopTimeset = System.currentTimeMillis()

    assert(immutablearray.length == scala.math.pow(2, power).toInt)
    writer_set.writeRow(List(power, startTimeset, stopTimeset, stopTimeset - startTimeset))

    val startTimeget = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      immutablearray(i)
    }

    val stopTimeget = System.currentTimeMillis()

    assert(immutablearray.length == scala.math.pow(2, power).toInt)
    writer_get.writeRow(List(power, startTimeget, stopTimeget, stopTimeget - startTimeget))
  }
}
