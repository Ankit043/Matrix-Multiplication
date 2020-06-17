package MatMul_spark

import org.apache.spark.mllib.linalg.{DenseMatrix}

object MatMul_spark {
  val random = new java.security.SecureRandom

  def get2dRandomArray(dim1: Int) = Array.fill(dim1) {
    random.nextDouble()*100 }

  def main(args: Array[String]): Unit = {
    var total = 0.0
    val matrix1 = get2dRandomArray(1000000)
    val matrix2 = get2dRandomArray(1000000)

    val dense_matrix1: DenseMatrix = new DenseMatrix(1000, 1000, matrix1)
    val dense_matrix2: DenseMatrix = new DenseMatrix(1000, 1000, matrix2)

    for(i<-0 to 1000) {
      val t1 = System.currentTimeMillis()
      val matrix3 = dense_matrix1.multiply(dense_matrix2)
      val duration = (System.currentTimeMillis() - t1)
      //Dividing the time difference by 1000 to convert milli seconds to seconds
      total += (duration.toFloat/1000)
    }
    val average = total/1000
    println("Average", average)
  }

}
