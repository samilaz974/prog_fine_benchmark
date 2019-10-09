package fr.unice.si5.progfine

import java.io.File

import com.github.tototoshi.csv.CSVWriter

/**
 * @author ${user.name}
 */
object App {

  def main(args: Array[String]) {
    HashMapBenchmark.benchmarkImmutable(100000000)
    HashMapBenchmark.benchmarkMutable(100000000)
  }
}