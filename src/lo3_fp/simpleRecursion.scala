package lo3_fp

object simpleRecursion {
  def computeGeometricSum(n:Int): Int={
    if (n < 1){
      0
    }
    else {
      // n + computeGeometricSum(n-1)
      var result = computeGeometricSum(n-1)
      result += n
      return result
    }
  }

  def add(a:Int, b:Int): Int={
    if (b == 0){
      a
    }
    else if (b < 0){
      add(a-1, b+1)
    }
    else {
      add(a+1, b-1)
    }
  }

  def fib(n:Int): Int={
    if (n == 1){
      return 0
    }
    else if (n == 2){
      1
    }
    else {
      fib(n-1) + fib(n-2)
    }
  }

  def subtract(a:Int, b:Int): Int={ //Tail recursion - only function is the recursive function call
    if (b == 0){
      a
    }
    else if (b < 0){
      subtract(a+1, b+1)
    }
    else {
      subtract(a-1, b-1)
    }
  }

  def acronymTrail(strings: Array[String], tracker:Int): String={
    if (tracker == strings.length){
      ""
    }
    else{
      var out:String = acronymTrail(strings, tracker + 1)
      out = strings(tracker).slice(0, 1) + out
      out
    }
  }

  def acronym(strings: Array[String]): String={
    acronymTrail(strings, 0)
  }

  def acronymTail(strings: Array[String], acc:String, tracker:Int): String={
    if (tracker == strings.length){ //Stops when you get to the end
      return acc
    }
    else{
      acronymTail(strings, acc + strings(tracker).slice(0, 1), tracker + 1)
    }
  }

  def acronymTailHelper(strings:Array[String]): String={
    acronymTail(strings, "", 0)
  }

  def main(args: Array[String]): Unit={
    var out = computeGeometricSum(4)
    println(out)
    var words:Array[String] = Array("Fricked", "Up", "Beyond", "All", "Recognition")
    var ac = acronym(words)
    println(ac)
  }

}
