import DayTwoOne.Square

object DayThreeOne extends App{
  //Sets
  var jetSet = Set("Boeing","Airbus","Boeing")
  for(i <- jetSet){
    println(i)
  }

  val l = List(1,1,1,1,2,2,2,2,2,3,3,4,4,4,5,5,5,5)
  val s = l.toSet[Int];
  for (i <- s){
    println(i + ": " + l.count(_==i))
  }

  val l1 = List("exam","test","important","exam","homework","test")
  val s1 = l1.toSet[String]
  for(i<-s1){
    println(i +  " : " + l1.count(_==i))
  }

  //Maps
  val romans = Map[Int,String](1->"1",2->"11",3->"111");
  println(romans(2));

  for((arabic,roman) <- romans){
    println(arabic + " : " + roman)
  }

  val countries = Map[String,String]("Norway" -> "Oslo", "Germany" ->"Berlin")

  for((country,capital) <- countries){
    println(country + " : " +capital);
  }

  //Singleton
  class Conf{
    val username = "Morten";
    val password = "Secret";
  }

  val c = new Conf();
  println(c);

  object Configuration{
    val username = "Morten"
    val password = "Secret"
  }

  println(Configuration.username)

  object Logger{
     def printLog(s:String): Unit ={
       println(java.util.Calendar.getInstance().getTime.toString + " : "+ s)
     }
  }

  Logger.printLog("Hello world")

  //Implicit correction
  implicit def doubleToInt(d:Double):Int ={
    d.toInt
  }

  val e:Int = doubleToInt(3.5)
  val j:Int = 3.5

  implicit def stringToInt(s:String):Int = {
    s.length
  }
  val i1:Int = "Hei" // i = 3
  val j1 = "Hei"/2 // = 3/2
  println(i1)
  println(j1)

  implicit def squareInt(i:Int):Square = {
    new Square(1,1,1,List(i));
  }
  val x:Square = 4;
  println(x.possibleValues.toString)

  def sum(a:Int,b:Int,c:Int):Int = {
    println(sum(1,2,3));
  }

  def b:Int => Int=sum(3,_:Int,6);
  println(b(4));

  def multiply(a:Double,b:Double,c:Double):Double = {
    a+b+c
  } 

  def multiplyTwo: (Double,Double)=> multiply(_:Double,_:Double,1);
  multiply(3,2,1);
  multiplyTwo(3,2);

  
}





