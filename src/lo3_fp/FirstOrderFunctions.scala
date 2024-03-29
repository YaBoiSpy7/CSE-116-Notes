package lo3_fp

import archived.physics.PhysicsVector
import java.util.Comparator

object FirstOrderFunctions {
  def compare(a:Int, b:Int): Boolean={
    if(a<b) {
      true
    }
    else{
      false
    }
  }

  def selectionSort(inputData:Array[Int], comparator:(Int,Int)=>Boolean): Array[Int]={
    var out:Array[Int] = inputData.clone()
    var min:Int = 0
    var temp:Int = 0
    for (i <- out.indices){
      min=i
      for (j <- i+1 until out.length){
        if (comparator(out(j), out(min))){
          min=j
        }
      }
      temp = out(i)
      out(i) = out(min)
      out(min) = temp
    }
    out
  }

  def selectionSortGeneral[T](inputData:Array[T], comparator:(T,T)=>Boolean): Array[T]={
    val out:Array[T] = inputData.clone()
    var min:Int = 0
    var temp:T = out(0)

    for (i <- out.indices){
      min=i
      for (j <- i+1 until out.length){
        if (comparator(out(j), out(min))){
          min=j
        }
      }
      temp = out(i)
      out(i) = out(min)
      out(min) = temp
    }
    out
  }
/*
  def distance(v1:PhysiceVector, v2:PhysiceVector): Double={
    Math.sqrt(Math.pow(v1.x - v2.x,2) + Math.pow(v1.y - v2.y,2) + Math.pow(v1.z - v2.z,2))
  }

  def distanceComparator(referencePoint:PhysicsVector): (PhysicsVector,PhysicsVector)=>Boolean={
    distance(v1,referencePoint) < distance(v2,referencePoint)
  }
*/
  def main(args: Array[String]): Unit={
    //val myWork:PhysicsVector = new PhysicsVector(0,0,0)
    //val myWorkComparator = distanceComparator(myWork)
    //val orderdHouse = selectionSortGeneral(houseList, myWorkComparator)

    var numbers = List(10,-7,-8,5,13)
    var sorted = numbers.sortWith(compare)
    println(sorted)
    var numbers2:Array[Int] = Array(5,3,4)
    var out = selectionSort(numbers2, compare)
    println(out.mkString(" "))
    var numbers3:Array[Double] = Array(2.0,4.0,1.0,0)
    var out2 = selectionSortGeneral(numbers3, (a:Double,b:Double) => a<b)
    println(out2.mkString(" "))
    val compare2:(Double, Double) => Boolean=(a:Double,b:Double) => a<b
    var out3 = selectionSortGeneral(numbers3, compare2)
    println(out3.mkString(" "))
    var numbers4=List(10, -7, -8, 5, 13)
    numbers4.foreach(println)
    var words:List[String] = List("one", "two", "three", "four")
    var greater=(a:String) => a.length>3
    val filtered = words.filter(greater)
    filtered.foreach(println)
    val filtered2 = words.filter(_.length>3) // _ is the wildcard operator
    filtered2.foreach(println)
    var squared = numbers3.map(Math.pow(_,2.0))
    squared.foreach(println)


    //yield - applies the operation to the items you're selecting
    val numbers5:List[Double] = List(1.0, 2.0, 3.0, 4.0)
    val numbersSquared:List[Double] = (for(number <- numbers5) yield {
      Math.pow(number, 2.0)
    }).toList
    println(numbersSquared)

    //reduce - takes a collection and brings it down to something (like an accumulator)
    val accumeFunc = (acc:Double, b:Double) => acc+Math.pow(b,2.0)
    val sumSquares:Double = numbers5.reduce(_+Math.pow(_,2.0))
    println(sumSquares)

    //fold - like reduce, but has an initial value
    val sumSquaresPlus:Double = numbers5.fold(100.0)(_+Math.pow(_,2.0))
    println(sumSquaresPlus)

    //sum - sum of a collection
    println(numbers5.sum)

    //distinct - makes sure that each element only shows up once
    val values = List(1,2,3,3,3,4,5,5,5,6,7,7,7,7,8)
    println(values.distinct)

    //slice - takes only part of a list
    val track:Int = 7
    println(values.slice(0,track)) //Inclusive of starting point and not inclusive of ending point (position 1 to before 7)

    //reverse - reverses the order
  }

}
