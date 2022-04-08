package lo3_fp

object ILoveRecursion {
  //Get the total of an array of Ints
  //Get the average of an array of Ints
  //Search an array of ints for a value, returning a Boolean
  def average[T](data: List[T], f: T => Double): Double = {
    val out:List[Double] = (for(number <- data) yield {
      f(number)
    })
    val sumOfRatings:Double = out.sum
    val averageRating:Double = (sumOfRatings/out.length)
    return averageRating
  }

}
