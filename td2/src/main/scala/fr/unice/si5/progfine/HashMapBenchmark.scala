package fr.unice.si5.progfine

import java.io.File

import com.github.tototoshi.csv.CSVWriter

object HashMapBenchmark {

  def MutableBenchmark(powerLimit: Int): Unit = {
    val f_mutable_put = new File("mutable-hashmap-put.csv")
    val writer_put = CSVWriter.open(f_mutable_put)

    val f_mutable_get = new File("mutable-hashmap-get.csv")
    val writer_get = CSVWriter.open(f_mutable_get)

    val f_mutable_remove = new File("mutable-hashmap-remove.csv")
    val writer_remove = CSVWriter.open(f_mutable_remove)

    writer_put.writeRow(List("size", "start_time", "stop_time", "total_time"))
    writer_get.writeRow(List("size", "start_time", "stop_time", "total_time"))
    writer_remove.writeRow(List("size", "start_time", "stop_time", "total_time"))

    for (power <- 1 to powerLimit) {
      println("HashMap Mutable Benchmark actual power : " + power)
      runMutableScenario(power, writer_put, writer_get, writer_remove)
    }
  }

  def ImmutableBenchmark(powerLimit: Int): Unit = {
    val f_mutable_put = new File("immutable-hashmap-put.csv")
    val writer_put = CSVWriter.open(f_mutable_put)

    val f_mutable_get = new File("immutable-hashmap-get.csv")
    val writer_get = CSVWriter.open(f_mutable_get)

    val f_mutable_remove = new File("immutable-hashmap-remove.csv")
    val writer_remove = CSVWriter.open(f_mutable_remove)

    writer_put.writeRow(List("size", "start_time", "stop_time", "total_time"))
    writer_get.writeRow(List("size", "start_time", "stop_time", "total_time"))
    writer_remove.writeRow(List("size", "start_time", "stop_time", "total_time"))

    for (power <- 1 to powerLimit) {
      println("HashMap immutable Benchmark actual power : " + power)
      runImmutableScenario(power, writer_put, writer_get, writer_remove)
    }
  }

  private def runMutableScenario(power: Int, writer_put: CSVWriter, writer_get: CSVWriter, writer_remove: CSVWriter): Unit = {
    var mutableHashMap: scala.collection.mutable.HashMap[String, String] = scala.collection.mutable.HashMap("0" -> "0")

    val startTimePut = System.currentTimeMillis()
    for (i <- 1 until scala.math.pow(2, power).toInt) {
      mutableHashMap.put(i.toString(), i.toString)
    }
    val stopTimePut = System.currentTimeMillis()
    writer_put.writeRow(List(power, startTimePut, stopTimePut, stopTimePut - startTimePut))
    
    assert(mutableHashMap.size == scala.math.pow(2, power).toInt)

    val startTimeGet = System.currentTimeMillis()
    for (i <- 1 until scala.math.pow(2, power).toInt) {
      mutableHashMap.get(i.toString())
    }
    val stopTimeGet = System.currentTimeMillis()
    writer_get.writeRow(List(power, startTimeGet, stopTimeGet, stopTimeGet - startTimeGet))

    assert(mutableHashMap.size == scala.math.pow(2, power).toInt)

    val startTimeRemove = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      mutableHashMap.remove(i.toString())
    }
    val stopTimeRemove = System.currentTimeMillis()
    writer_remove.writeRow(List(power, startTimeRemove, stopTimeRemove, stopTimeRemove - startTimeRemove))

    assert(mutableHashMap.size == 0)
  }

  private def runImmutableScenario(power: Int, writer_put: CSVWriter, writer_get: CSVWriter, writer_remove: CSVWriter): Unit = {
    var immutableHashMap: scala.collection.immutable.HashMap[String, String] = scala.collection.immutable.HashMap("0" -> "0")

    val startTimePut = System.currentTimeMillis()
    for (i <- 1 until scala.math.pow(2, power).toInt) {
      immutableHashMap = immutableHashMap + (i.toString -> i.toString)
    }
    val stopTimePut = System.currentTimeMillis()
    writer_put.writeRow(List(power, startTimePut, stopTimePut, stopTimePut - startTimePut))

    assert(immutableHashMap.size == scala.math.pow(2, power).toInt)

    val startTimeGet = System.currentTimeMillis()
    for (i <- 1 until scala.math.pow(2, power).toInt) {
      immutableHashMap.get(i.toString())
    }
    val stopTimeGet = System.currentTimeMillis()
    writer_get.writeRow(List(power, startTimeGet, stopTimeGet, stopTimeGet - startTimeGet))

    assert(immutableHashMap.size == scala.math.pow(2, power).toInt)

    val startTimeRemove = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      immutableHashMap = immutableHashMap - (i.toString(), i.toString)
    }
    val stopTimeRemove = System.currentTimeMillis()
    writer_remove.writeRow(List(power, startTimeRemove, stopTimeRemove, stopTimeRemove - startTimeRemove))
  
    assert(immutableHashMap.size == 0)
  }

}

