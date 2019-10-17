package fr.unice.si5.progfine

import java.io.File

import com.github.tototoshi.csv.CSVWriter

object TreeSetBenchmark {
  def MutableBenchmark(powerLimit: Int): Unit = {
    val f_mutable_add= new File("mutable-treeset-add.csv")
    val writer_add = CSVWriter.open(f_mutable_add)

    val f_mutable_contains = new File("mutable-treeset-contains.csv")
    val writer_contains= CSVWriter.open(f_mutable_contains)

    val f_mutable_remove = new File("mutable-treeset-remove.csv")
    val writer_remove = CSVWriter.open(f_mutable_remove)
    
    writer_add.writeRow(List("size", "start_time", "stop_time", "total_time"))
    writer_contains.writeRow(List("size", "start_time", "stop_time", "total_time"))
    writer_remove.writeRow(List("size", "start_time", "stop_time", "total_time"))

    for (power <- 1 to powerLimit) {
      println("treeset Mutable Benchmark actual power : " + power)
      runMutableScenario(power, writer_add, writer_contains, writer_remove)
    }
  }

  def ImmutableBenchmark(powerLimit: Int): Unit = {
    val f_immutable_add= new File("immutable-treeset-add.csv")
    val writer_add = CSVWriter.open(f_immutable_add)

    val f_immutable_contains = new File("immutable-treeset-contains.csv")
    val writer_contains= CSVWriter.open(f_immutable_contains)

    val f_immutable_remove = new File("immutable-treeset-remove.csv")
    val writer_remove = CSVWriter.open(f_immutable_remove)

    writer_add.writeRow(List("size", "start_time", "stop_time", "total_time"))
    writer_contains.writeRow(List("size", "start_time", "stop_time", "total_time"))
    writer_remove.writeRow(List("size", "start_time", "stop_time", "total_time"))

    for (power <- 1 to powerLimit) {
      println("treeset Immutable Benchmark actual power : " + power)
      runImmutableScenario(power, writer_add, writer_contains, writer_remove)
    }
  }

  private def runMutableScenario(power: Int, writer_add: CSVWriter, writer_contains: CSVWriter, writer_remove: CSVWriter): Unit = {
    var mutableTreeSet = new scala.collection.mutable.TreeSet[Int]()

    val startTimeEntreeset = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      mutableTreeSet = mutableTreeSet.+(i)
    }

    val stopTimeEntreeset = System.currentTimeMillis()
    writer_add.writeRow(List(power, startTimeEntreeset, stopTimeEntreeset, stopTimeEntreeset - startTimeEntreeset))

    println("Mutable TreeSet length " + mutableTreeSet.size)
    assert(mutableTreeSet.size == scala.math.pow(2, power).toInt)

    val startTimeContains = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      mutableTreeSet.contains(i)
    }

    val stopTimeContains = System.currentTimeMillis()
    writer_contains.writeRow(List(power, startTimeContains, stopTimeContains, stopTimeContains - startTimeContains))

    assert(mutableTreeSet.size == scala.math.pow(2, power).toInt)

    val startTimeRemove = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      mutableTreeSet.remove(i)
    }

    val stopTimeRemove = System.currentTimeMillis()
    writer_remove.writeRow(List(power, startTimeRemove, stopTimeRemove, stopTimeRemove - startTimeRemove))

    assert(mutableTreeSet.size == 0)
  }

  private def runImmutableScenario(power: Int, writer_add: CSVWriter, writer_contains: CSVWriter, writer_remove: CSVWriter): Unit = {
    var immutableTreeSet = new scala.collection.immutable.TreeSet[Int]()

    val startTimeEntreeset = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      immutableTreeSet = immutableTreeSet.+(i)
    }

    val stopTimeEntreeset = System.currentTimeMillis()
    writer_add.writeRow(List(power, startTimeEntreeset, stopTimeEntreeset, stopTimeEntreeset - startTimeEntreeset))

    assert(immutableTreeSet.size == scala.math.pow(2, power).toInt)

    val startTimeContains = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      immutableTreeSet.contains(i)
    }

    val stopTimeContains = System.currentTimeMillis()
    writer_contains.writeRow(List(power, startTimeContains, stopTimeContains, stopTimeContains - startTimeContains))

    assert(immutableTreeSet.size == scala.math.pow(2, power).toInt)

    val startTimeRemove = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      immutableTreeSet = immutableTreeSet.-(i)
    }

    val stopTimeRemove = System.currentTimeMillis()
    writer_remove.writeRow(List(power, startTimeRemove, stopTimeRemove, stopTimeRemove - startTimeRemove))

    assert(immutableTreeSet.size == 0)
  }
}
