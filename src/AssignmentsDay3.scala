object AssignmentsDay3 extends App {
  //Assignment 1
  var translations = Map[String,String]("Hei"->"Hi", "Ja"->"Yes","No"->"Nei");
  def translate(in:String):String = {
    return translations(in);
  }
  println(translate("Hei"))

  //Assignment 2
  val l = List(1,1,1,2,3,4,5,4,3,2);
  def listtolist(l:List[Int]):List[Int] = {
    l.toSet.toList
  }
  println(listtolist(l))

  //Assignment 3
  object Logger2{
    var count = 1;
    def printLog():Unit = {
      println("This is the log from: " + count)
      count +=1;
    }
  }
  for(i<-List(1,2,3,4,5)){
    Logger2.printLog();
  }

  //Assignment 4
  object Calculator{
    var number = 0.0;
    def Add(x:Double): Unit ={
      number += x;
      println(number)
    }
    def Sub(x:Double):Unit={
      number-=x;
      println(number)
    }
    def Mult(x:Double)={
      number *=x;
      println(number)
    }
    def Div(x:Double) = {
      number /=x;
      println(number)
    }
  }

  Calculator.Add(1.1)
  Calculator.Mult(2)
  Calculator.Sub(3)
  Calculator.Div(2)

  //Assignment 5
  val string = "?5?7891?3"
  val ca = string.toCharArray().toList;
  for(x<-ca){
    //println(x)
  }

  //Assignment 6
  class PuzzleValues(val values:List[Int]){
    override def toString() = {
      values.mkString(",") + "\r"
    }
  }

  var puzzle = List[PuzzleValues]();

  for(x<-ca){
    if(x=='?') {
      var l3 = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
      puzzle = puzzle :+ new PuzzleValues(l3)
    } else {
      var l3 = List(x.toInt)
      puzzle = puzzle:+ new PuzzleValues(l3)
    }
  }
  puzzle.foreach(println)

  //Assignment 7
  implicit def boolToInt(x: Boolean):Int ={
    if(x) return 1
    else return 0
  }
  println(true * 4)
  println(false * 4)
}
