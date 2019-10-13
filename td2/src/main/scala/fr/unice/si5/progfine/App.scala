package fr.unice.si5.progfine

/**
 * @author ${user.name}
 */
object App {

  def main(args: Array[String]) {
    val powerLimit = 23

    HashMapBenchmark.ImmutableBenchmark(powerLimit)
    HashMapBenchmark.ImmutableBenchmark(powerLimit)

    QueueBenchmark.ImmutableBenchmark(powerLimit)
    QueueBenchmark.MutableBenchmark(powerLimit  )

    StackBenchmark.ImmutableBenchmark(powerLimit)
    StackBenchmark.MutableBenchmark(powerLimit)
  }
}