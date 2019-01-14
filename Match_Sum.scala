import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Row
object Match_Sum {


    def generator2(x: List[String]): List[List[Any]] = x match {
          case Nil    => List(Nil)
          case h :: t => for (j <- generator2(t); i <- h) yield i :: j
    }

    def main(args: Array[String]) {

      val spark = SparkSession.builder
        .master("local")
        .appName("Match_sum")
        .getOrCreate()

      import spark.implicits._

      val dDF = spark.read.option("header", "true").csv("src/main/resources/d.txt")
      val rDF = spark.read.option("header", "true").csv("src/main/resources/r.txt")

      val result  = generator2(dDF.map(rec => rec.toString()).collect().toList)
      System.out.println(result)

      //rDF.show()

      spark.stop()

    }

}
