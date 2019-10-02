This repo documents the benchmarking results of different sorting algorithms in scala

## Benchmarking using scala
### Running the benchmarks
Run the `App.scala` in the `src/main/scala/fr/unice/si5/progfine/` package to run all the benchmarks.<br>
Sorting algorithms are in the `src/main/scala/fr/unice/si5/progfine/sort` package.<br>

Running this will generate .csv files for each algorithm `algo.csv` algo being the name of the algorithm.<br>
These .csv files have 3 columns: "power", "start_time", "stop_time".<br>

### Tests
Tests are in the `src/test/scala/samples/junit.scala`. <br>
We test that sorting algorithms output is indeed sorted.<br>

### Adding a new algorithm
To benchmark another sorting algorithm, you simply need to add a scala object `Algo.scala` in the `src/main/scala/fr/unice/si5/progfine/sort` package.<br>
Have a function calling your sorting algorithm, `algoSort` that takes an `Array[Int]` as an input and returns an `Array[Int]` being the sorted array.<br>

In the App.scala `main` function, you need to add a variable referencing the function and call the benchmark function above like this:

```scala
val f7 = Algo.algoSort _

benchmarkTest("AlgoSort", f7)
```

## Visualisation in Python - jupyter
Here we are using python 3.7.3

In the `visualisation/data` package, we put our .csv files.

In the `visualisation/` package, we have 2 notebooks:

[analysis_no_warmup.ipynb](https://github.com/samilazrak/prog_fine_benchmark/blob/master/visualisation/analysis_no_warmup.ipynb) using the `no_warmup` data.<br>
[analysis_warmed_up.ipynb.ipynb](https://github.com/samilazrak/prog_fine_benchmark/blob/master/visualisation/analysis_no_warmup.ipynb) using the `warmed_up` data.


## Authors

* **Youness El Idrissi** -  [el-youness](https://github.com/el-youness) - youness.el-idrissi@etu.unice.fr
* **Sami Lazrak** -  [samilazrak](https://github.com/samilazrak) - sami.lazrak@etu.unice.fr

