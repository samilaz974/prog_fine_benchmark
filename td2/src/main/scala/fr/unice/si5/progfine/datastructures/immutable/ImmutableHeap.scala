package fr.unice.si5.progfine.datastructures.immutable

class ImmutableHeap {
  private var Heap : Array[Int] = null
  private var size = 0
  private var maxsize = 0

  private val FRONT = 1

  def this(maxsize: Int) {
    this()
    this.maxsize = maxsize
    this.size = 0
    Heap = new Array[Int](this.maxsize + 1)
    Heap(0) = Integer.MIN_VALUE
  }

  // Function to return the position of
  // the parent for the node currently
  // at pos
  private def parent(pos: Int) = pos / 2

  // Function to return the position of the
  // left child for the node currently at pos
  private def leftChild(pos: Int): Int = {
    if(2*pos > size){
      return 0
    }else{
      return 2*pos
    }
  }

  // the right child for the node currently
  private def rightChild(pos: Int): Int = {
    if(2*pos+1 > size){
      return 0
    }else{
      return 2*pos+1
    }
  }

  // Function that returns true if the passed
  // node is a leaf node
  private def isLeaf(pos: Int): Boolean = {
    if (pos >= (size / 2) && pos <= size) return true
    false
  }

  // Function to swap two nodes of the heap
  private def swap(fpos: Int, spos: Int): Unit = {
    var newHeap = this.Heap.clone()

    var tmp = 0
    tmp = newHeap(fpos)
    newHeap(fpos) = newHeap(spos)
    newHeap(spos) = tmp

    this.Heap = newHeap
  }

  // Function to heapify the node at pos
  private def minHeapify(pos: Int): Unit = { // If the node is a non-leaf node and greater
    // than any of its child
    if (!isLeaf(pos)) if (Heap(pos) > Heap(leftChild(pos)) || Heap(pos) > Heap(rightChild(pos))) { // Swap with the left child and heapify
      // the left child
      if (Heap(leftChild(pos)) < Heap(rightChild(pos))) {
        swap(pos, leftChild(pos))
        minHeapify(leftChild(pos))
      }
      else { // Swap with the right child and heapify
        // the right child
        swap(pos, rightChild(pos))
        minHeapify(rightChild(pos))
      }
    }
  }

  // Function to insert a node into the heap
  def insert(element: Int): Unit = {
    if (size >= maxsize) return
    Heap({
      size += 1; size
    }) = element
    var current = size
    while ( {
      Heap(current) < Heap(parent(current))
    }) {
      swap(current, parent(current))
      current = parent(current)
    }
  }

  // Function to print the contents of the heap
  def print(): Unit = {
    var i = 1
    while ( {
      i <= size / 2
    }) {
      System.out.print(" PARENT : " + Heap(i) + " LEFT CHILD : " + Heap(2 * i) + " RIGHT CHILD :" + Heap(2 * i + 1))
      System.out.println()

      {
        i += 1; i - 1
      }
    }
  }

  // Function to build the min heap using
  // the minHeapify
  def minHeap(): Unit = {
    var pos = size / 2
    while ( {
      pos >= 1
    }) {
      minHeapify(pos)

      {
        pos -= 1; pos + 1
      }
    }
  }

  // Function to remove and return the minimum
  // element from the heap
  def remove: Int = {
    val popped = Heap(FRONT)
    Heap(FRONT) = Heap({
      size -= 1; size + 1
    })
    minHeapify(FRONT)
    popped
  }

  def length() : Int = {
    return this.size
  }
}
