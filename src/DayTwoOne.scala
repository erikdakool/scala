object DayTwoOne extends App{

  def addTwo(x:Int,y:Int):Int = {
    x+y
  }

/*  class ATM(x:Int){
    var balance:Int = x;
    def insert(nok:Int):Unit = {
      balance+=nok
    }
  }*/

  class ATM(x:Int){
    val balance:Int = x;
    def insert(nok:Int):ATM = {
      return new ATM(balance+nok)
    }
    def whitDraw(nok:Int):ATM = {
      return new ATM(balance-nok)
    }
  }

  val a1 = new ATM(0);
  println(a1.balance);
  val a2 =  a1.insert(100);
  println(a2.balance);
  val a3 = a2.whitDraw(30);
  println(a3.balance);

  class Square(boxNumber:Int,xNumber:Int,yNumber:Int,values:List[Int]=List(1,2,3,4),solved:Boolean=false){
    val possibleValues = values;
    val x = xNumber;
    val y = yNumber;
    val box = boxNumber;
    val isSolved = solved;

    override def toString() = {
      "x" + x + " y" + y + " box" + box + " " +possibleValues.mkString(",") + "\n"
    }

    def setValue(solution:Int):Square = {
      return new Square(this.box,this.x,this.y, List(solution),true)
    }
    def removeValue(wrongSolution:Int):Square = {
      val newList = possibleValues.filter(_!= wrongSolution)
      if(newList.length == 1) {
        return new Square(this.box,this.x,this.y,newList,true);
      }
      return new Square(this.box,this.x,this.y,newList,false);
    }
  }

/*  implicit def squreWrong(x:Int):Square = {
    return new Square(x,1,1)
  }
  var s3:Square = 4;*/

  def getBoxFromXY(x:Int,y:Int):Int = {
    if(x<=2 && y<=2){
      return 1;
    }
    else if(x>2 && y<=2){
      return 2;
    }else if(x<=2 && y>2){
      return 3;
    }
    return 4;
  }

  var allSquares = List[Square]();
  for (xValue <- List(1,2,3,4)){
    for (yValue <- List(1,2,3,4)){
      val s = new Square(getBoxFromXY(xValue,yValue),xValue,yValue);
      allSquares = allSquares :+s;
    }
  }

  //println(allSquares)
  def getAllFromX(i:Int):List[Square] = {
    return allSquares.filter((s:Square)=>s.x==i);
  }

  def getAllFromY(i:Int):List[Square] = {
    return allSquares.filter((s:Square)=>s.y == i)
  }

  def getAllFromBox(i:Int):List[Square] = {
    return allSquares.filter((s:Square)=>s.box == i);
  }

  def getValidLine(f:(Int=>List[Square]),l:List[Square],i:Int):Boolean = {
    val squares = f(i);
    var taken = Array[Int](4)
    for (i<-0 to squares.length){
      if(squares(i).possibleValues.length > 1) return false
      if(taken.contains(squares(i).possibleValues(0))) return false
      taken(i) = squares(i).possibleValues(0);
    }
    println(squares.toString)
    return true
  }
  println(getValidLine(getAllFromBox,allSquares,1))
 //getAllFromX(1).foreach(println)


  allSquares = allSquares :+
    new Square(1,1,1,List(1),true)
  val sq1 = getAllFromX(1);
  //println(sq1.exists((s:Square)=>s.possibleValues == List(1)))
  //println(sq1.forall((s:Square)=>s.possibleValues == List(1)))

  var s1 = new Square(1,1,1)
  s1 = s1.removeValue(1)
  //println(s1.possibleValues.toString());


  //Lists
  val winningList = List(1,2,3,4,5,88,99);
  val nums = List(1,2,3,4,9);
  //println(nums.forall((x:Int)=>winningList.contains(x)))

  //exists
  //println(nums.exists((x:Int)=>winningList.contains(x)))



  //Tuples

  val a = (99,"Red Ballons");
  val b:Tuple2[Int,String] = (99, "Red baloons");
  //println(a._1+ " " + a._2);


  def inTwo(x:Int,y:Int) = {
    (x+1,y+2);
  }
  val (c,d) = inTwo(1,1);
  //println(c,d)

  //assignment 3
  val e = List(1,2,3,4,-5,-6,-7)
  e.foreach((arg:Int) => if(arg>0)println(arg + " "))

  //assignment 4
  println(e.forall((x:Int)=>x>0))

  //assignment 6
  def returnMinMax(l:List[Any]) = {
    (l(0),l(l.length-1))
  }
  println(returnMinMax(e))
}
