package fr.unice.si5.progfine

import java.io.File

import com.github.tototoshi.csv.CSVWriter

/**
 * @author ${user.name}
 */
object App {

  def main(args: Array[String]) {
    val nbLoop = 10000000
    //HashMapBenchmark.benchmarkImmutable(nbLoop)
    //HashMapBenchmark.benchmarkMutable(nbLoop)

    QueueBenchmark.immutableBenchmark(nbLoop)
    QueueBenchmark.mutableBenchmark(nbLoop)
  }
}