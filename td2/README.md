This repo documents the benchmarking results of different sorting algorithms in scala

## Benchmarking using scala
### Running the benchmarks
Run the `App.scala` in the `src/main/scala/fr/unice/si5/progfine/` package to run all the benchmarks.<br>
datastrcutures package contains the datastrctures that we have reimplemented<br>

Running the App object will generate .csv files for each method of each data structure in the pattern`immutable-datastructure-method.csv`.<br>
These .csv files have 4 columns: "power", "start_time", "stop_time", "total_time".<br>

### Tests
After running each data structure method in the code, we check with an assert that the length of the data structure is compliant with the action done : we test
 that the data structure has the right length after filling it or after emptying it.

### Adding a new algorithm
To benchmark a new data structure, you need to create two scenarios (an immutable version and a mutable one) with your data structure :
- Firstly, you fill it x times and then you benchmark the filling operation
- Optionally, you can benchmark the access to the dat structure you just have filled
- And then, you can empty it (and benchmark this action)

Then, two methods ImmutableBenchmark and MutableBenchmark runs these scenarios n times, 
each time filling the data structure one more time and removing one more element from it.
To benchmark another sorting algorithm, you simply need to add a scala object `{{DataStructure}}Benchmark.scala` in the `src/main/scala/fr/unice/si5/progfine/` package.<br>

In the App.scala `main` function, you need to add a variable referencing the functions ImmutableBenchmark() and MutableBenchmark() and call them ike this:

```scala
val powerLimit = 24

HashMapBenchmark.ImmutableBenchmark(powerLimit)
HashMapBenchmark.MutableBenchmark(powerLimit) 

```

### Scenario
Here is the scenario run to benchmark a mutable stack 

```scala
  private def runMutableScenario(power: Int, writer_push: CSVWriter, writer_pop: CSVWriter): Unit = {

    var mutableStack = new scala.collection.mutable.Stack[String]()

    val startTimePush = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      mutableStack.push(i.toString)
    }

    val stopTimePush = System.currentTimeMillis()

    assert(mutableStack.length == Math.round(Math.round(Math.pow(2, power))))
    writer_push.writeRow(List(power, startTimePush, stopTimePush, stopTimePush - startTimePush))

    val startTimePop = System.currentTimeMillis()
    for (i <- 0 until scala.math.pow(2, power).toInt) {
      mutableStack.pop()
    }

    val stopTimePop = System.currentTimeMillis()

    assert(mutableStack.length == 0)
    writer_pop.writeRow(List(power, startTimePop, stopTimePop, stopTimePop - startTimePop))
  }

```

This scenario is composed of two parts :
- Firstly, we push 2^power element in the stack, we benchmark it and then write the result in a .csv file
- Secondly, we pop element by element the stack filled previously, we benchmark it and then write the result in a .csv file

This scenario is also written for the immutable stack, and these scenarios are run everytime with a different "power" parameter.

## Visualisation in Python - jupyter
Here we are using python 3.7.3

In the `visualisation/data` package, we have the .csv files storing the benchmark results.

In the `visualisation/` package, we have the [analysis.ipynb](https://github.com/samilazrak/prog_fine_benchmark/blob/master/td2/visualisation/analysis.ipynb) notebook that contains all graphs.

## Authors

* **Youness El Idrissi** -  [el-youness](https://github.com/el-youness) - youness.el-idrissi@etu.unice.fr
* **Sami Lazrak** -  [samilazrak](https://github.com/samilazrak) - sami.lazrak@etu.unice.fr

