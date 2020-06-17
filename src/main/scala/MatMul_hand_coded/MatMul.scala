package MatMul_hand_coded

object MatMul {
  val random = new java.security.SecureRandom
  type Row = Array[Double]
  type Matrix = Array[Row]

  def get2dRandomArray(dimension_1: Int, dimension_2: Int) = Array.fill(dimension_1, dimension_2) {
    random.nextDouble()*100 }

  def main(args: Array[String]): Unit = {
    val resultant_matrix : Matrix = Array.ofDim[Double](1000, 1000)
    var total = 0.0
    val matrix1 = get2dRandomArray(1000, 1000)
    //      matrix1 foreach (row => println(row.mkString(",")))
    val matrix2 = get2dRandomArray(1000, 1000)
    //      matrix2 foreach (row => println(row.mkString(",")))
    for (i<-0 to 1000) {
      val t1 = System.currentTimeMillis()
      for(j<-0 to 999){
        for(k<-0 to 999){
          var sum = 0.0
          for(l<-0 to 999){
            sum += matrix1(j)(l) * matrix2(l)(k)
          }
          resultant_matrix(j)(k) = sum
        }
      }
      val duration = (System.currentTimeMillis() - t1)
      //Dividing the time difference by 1000 to convert milli seconds to seconds
      total += (duration.toFloat / 1000.0)
    }
    val average = total/1000
    print("Average", average)
  }
}
