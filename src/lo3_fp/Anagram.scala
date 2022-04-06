package lo3_fp

object Anagram {
  def anagrams(input:String): List[String] ={
    println("\n" + input)
    if (input.length == 1){
      List(input)
    }
    else{
      val output:List[List[String]]= (for (i <- 0 until input.length) yield{
        val newString:String = input.substring(0, i) + input.substring(i + 1, input.length)
        anagrams(newString).map(_ + input.charAt(i))
      }).toList
      println(output)
      println(output.flatten.distinct)
      println("Finish anagram("+input+")")
      output.flatten.distinct //Flatten - takes list of lists and makes it into a single list
    }
  }

  def main(args:Array[String]): Unit ={
    val ana=anagrams("abca")
    println(ana)
  }

}

