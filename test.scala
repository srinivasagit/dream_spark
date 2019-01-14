object test {

  def main(args: Array[String]): Unit = {

    val xs = List( 'a', 'b' , 'c' , 'd' , 'e' )
    val k = (1 to xs.length flatMap (x => xs.combinations(x)))
    System.out.println(k)


  }

}
