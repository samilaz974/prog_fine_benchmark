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

    HeapBenchmark.MutableBenchmark(powerLimit)
    //HeapBenchmark.ImmutableBenchmark(powerLimit) jusqu'a 19, resultats enregistrés

    TreeSetBenchmark.ImmutableBenchmark(powerLimit)
    //TreeSetBenchmark.MutableBenchmark(powerLimit) jusqu'a 17, resultats enregistrés
  }
}