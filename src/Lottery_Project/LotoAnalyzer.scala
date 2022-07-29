package Lottery_Project


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
    println("Total Drawings Analyzed: " + drawingCounter)
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



  //DON'T TOUCH, STUPID
  def megaMillionsAnalyzer(filename: String): Map[Int,Int] = {
    val bufferedSource = Source.fromFile(filename)
    var drawingCounter = 0
    var winningNumberList:List[Int] = List()
    for (line <- bufferedSource.getLines.drop(1)) {
      val cols: Array[String] = line.split(",").map(_.trim)
      drawingCounter = drawingCounter + 1
      val numberList:Array[String] = cols(1).split(" ") //These are the winning numbers
      for (number <- numberList){
        winningNumberList = winningNumberList :+ number.toInt
      }
    }
    println("Total Drawings Analyzed: " + drawingCounter)
    val winningNumberMap = winningNumberList.groupBy(x => x) map { case (k,v) => k-> v.length }
    val sortedNumbers = ListMap(winningNumberMap.toSeq.sortWith(_._2 > _._2):_*)
    return sortedNumbers
  }

  //DON'T TOUCH, STUPID
  def megaballAnalyzer(filename: String): Map[Int,Int] = {
    val bufferedSource = Source.fromFile(filename)
    var drawingCounter = 0
    var megaballNumberList:List[Int] = List()
    for (line <- bufferedSource.getLines.drop(1)) {
      val cols: Array[String] = line.split(",").map(_.trim)
      drawingCounter = drawingCounter + 1
      megaballNumberList = megaballNumberList :+ cols(2).toInt
    }
    val megaballNumberMap = megaballNumberList.groupBy(x => x) map { case (k,v) => k-> v.length }
    val sorted = ListMap(megaballNumberMap.toSeq.sortWith(_._2 > _._2):_*)
    return sorted
  }

/*
  def recentNumberChecker(filename:String, topNumbers:Map[Int,Int], dateMap:Map[Int,List[String]], tracker:Int): Map[Int,List[String]]={
    val bufferedSource = Source.fromFile(filename)
    val keys:List[Int] = topNumbers.keys.toList
    if (tracker == 26){
      return dateMap
    }
    else{
      var dateCounter:Int = 0
      var temp:Map[Int,List[String]] = Map()
      for (line <- bufferedSource.getLines.drop(1)) {
        val cols: Array[String] = line.split(",").map(_.trim)
        if (cols(1).contains(keys(tracker))){
          if (temp.contains(keys(tracker))){
            temp(keys(tracker)) :+ cols(0)
          }
          else{
            temp(keys(tracker)) -> cols(0)
          }
        }
        dateCounter = dateCounter + 1
      }
      recentNumberChecker(filename, topNumbers, temp, tracker+1)
    }
  }

*/



  def main(args: Array[String]): Unit = {
    /*
    val powerballStats = powerballNumbers("data/Lottery_Powerball_Winning_Numbers__Beginning_2010.csv")
    val testStats = winningNumbers("data/Lottery_Powerball_Winning_Numbers__Beginning_2010.csv")
    println("Winning Number Occurances")
    for ((key, value) <- testStats){
      println(key + " -> " + value)
    }

    println("Powerball Number Occurances")
    for ((key, value) <- powerballStats){
      println(key + " -> " + value)
    }
    */
    val file = ("data/Lottery_Mega_Millions_Winning_Numbers__Beginning_2002.csv")
    val megaMillionsStats = megaMillionsAnalyzer(file)
    val megaballStats = megaballAnalyzer(file)

    println("Winning Number Occurances")
    for ((key, value) <- megaMillionsStats){
      println(key + " -> " + value)
    }


    println("Megaball Number Occurances")
    for ((key, value) <- megaballStats){
      println(key + " -> " + value)
    }

  }

}