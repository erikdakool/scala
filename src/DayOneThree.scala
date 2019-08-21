object DayOneThree extends App{
  def applyToInt(f:(Int=>Int),i:Int):Int = {
    return f(i);
  }

  def inc(x:Int):Int = {
    return x+1;
  }

  println(applyToInt(inc,1))



  def div(x:Int):Double = x/2

  def applyToArray(f:(Int=>Double),l: Array[Int]):Unit ={
    for(i<-l){
      println(f(i))
    };
  }

  val narr = Array(1, 2, 7, 4, 5)
  applyToArray(div,narr);

  println(narr.mkString("\n"))
}
