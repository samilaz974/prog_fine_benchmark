package fr.unice.si5.progfine

/**
 * @author ${user.name}
 */
object App {

  def main(args: Array[String]) {
    val powerLimit = 24

    HashMapBenchmark.ImmutableBenchmark(powerLimit)
    HashMapBenchmark.MutableBenchmark(powerLimit)

    QueueBenchmark.ImmutableBenchmark(powerLimit)
    QueueBenchmark.MutableBenchmark(powerLimit)

    StackBenchmark.ImmutableBenchmark(powerLimit)
    StackBenchmark.MutableBenchmark(powerLimit)
  }
}