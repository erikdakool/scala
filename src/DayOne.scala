import java.math.BigInteger

object DayOne extends App{
  println("Hello world");

  var a = 12;
  a = 13;
  println(a);

  val b = 29;
  val big = new BigInteger("23");

  val a1 = 3.5f; //float
  val b1 = 3.5; // double
  val c1 = 'h' // typechar
  val d1 = "hei" //string
  val e1 =
    """
      |many lines of string
    """.stripMargin;

  1 == 1 //true
  1 == 1.0 //true
  //Compares object value, not object address

  def max(x:Int, y:Int):Int = {
    if (x > y) return x;
    else return y;
  }


  def max2(x:Int,y:Int):Int = {
    if (x > y)x;
    else y;
  }
  println(max(2,3));

  def greet():Unit = println("hello word");
  def f = 2;
  println(f);

  val s = "Hello world!";
  println(s.indexOf('w));

  println(5+4);
  println((5).+(4));

  var y = 1;
  if(y<2)
    println("small")
  else
    println("big")


  var flo = 1.00;
  def sqrt(flo:Double):Any  = {
    if(flo < 0) return "Connot do square root of a negative number"
    math.sqrt(flo)
  }
  println(sqrt(16.0))
}
