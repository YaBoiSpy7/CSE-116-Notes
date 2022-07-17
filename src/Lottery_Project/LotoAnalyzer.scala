package Lottery_Project


import scala.collection.MapView
import scala.collection.immutable.ListMap
import scala.io.Source

object LotoAnalyzer {

  def winningNumbers(filename: String): Map[Int,Int] = {
    val bufferedSource = Source.fromFile(filename)
    var drawingCounter = 0
    var winningNumberList:List[Int] = List()
    for (line <- bufferedSource.getLines.drop(1)) {
      val cols: Array[String] = line.split(",").map(_.trim)
      drawingCounter = drawingCounter + 1
      val numberList:Array[String] = cols(1).split(" ") //These are the winning numbers
      for (number <- numberList){
        if (numberList.indexOf(number) != 5) {
          winningNumberList = winningNumberList :+ number.toInt
        }
      }
    }
    val winningNumberMap = winningNumberList.groupBy(x => x) map { case (k,v) => k-> v.length }
    val sorted = ListMap(winningNumberMap.toSeq.sortWith(_._2 > _._2):_*)
    return sorted
  }


  def powerballNumbers(filename: String): Map[Int,Int] = {
    val bufferedSource = Source.fromFile(filename)
    var drawingCounter = 0
    var powerballNumberList:List[Int] = List()
    for (line <- bufferedSource.getLines.drop(1)) {
      val cols: Array[String] = line.split(",").map(_.trim)
      drawingCounter = drawingCounter + 1
      val numberList:Array[String] = cols(1).split(" ") //These are the winning numbers
      for (number <- numberList){
        if (numberList.indexOf(number) == 5) {
          powerballNumberList = powerballNumberList :+ number.toInt
        }
      }
    }
    val powerballNumberMap = powerballNumberList.groupBy(x => x) map { case (k,v) => k-> v.length }
    val sorted = ListMap(powerballNumberMap.toSeq.sortWith(_._2 > _._2):_*)
    return sorted
  }



  def recursiveCounter(filename: String): Map[Int,Int] = {
    val bufferedSource = Source.fromFile(filename)
    var drawingCounter = 0
    var winningNumberList:List[Int] = List()
    for (line <- bufferedSource.getLines.drop(1)) {
      val cols: Array[String] = line.split(",").map(_.trim)
      drawingCounter = drawingCounter + 1
      val numberList:Array[String] = cols(1).split(" ") //These are the winning numbers
      for (number <- numberList){
        if (numberList.indexOf(number) != 5) {
          winningNumberList = winningNumberList :+ number.toInt
        }
      }
    }
    println("Total Drawings Analyzed: " + drawingCounter)
    val winningNumberMap = winningNumberList.groupBy(x => x) map { case (k,v) => k-> v.length }
    val sorted = ListMap(winningNumberMap.toSeq.sortWith(_._2 > _._2):_*)
    return sorted
  }




  def main(args: Array[String]): Unit = {
    val powerballStats = powerballNumbers("data/Lottery_Powerball_Winning_Numbers__Beginning_2010.csv")
    val testStats = recursiveCounter("data/Lottery_Powerball_Winning_Numbers__Beginning_2010.csv")
    println("Winning Number Occurances")
    for ((key, value) <- testStats){
      println(key + " -> " + value)
    }

    println("Powerball Number Occurances")
    for ((key, value) <- powerballStats){
      println(key + " -> " + value)
    }

  }

}
