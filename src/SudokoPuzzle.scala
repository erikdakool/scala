import com.sun.org.apache.xpath.internal.operations.And

object SudokoPuzzle extends App {
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

    def removeValue(wrongSolution:Int):Square  ={
      val newlist = possibleValues.filter(_ != wrongSolution);
      if(newlist.length==1){
        return new Square(this.box,this.x,this.y,newlist,solved=true);
      }
      return new Square(this.box,this.x,this.y,newlist);
    }

    def getCorrectValue():Int = {
      if(this.isSolved){
        return this.possibleValues(0)
      }else{
        return 0;
      }
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
    return allSquares.filter(_.x == i);
  }

  def getAllFromY(i:Int):List[Square] = {
    return allSquares.filter(_.y == i)
  }

  def getAllFromBox(i:Int):List[Square] = {
    return allSquares.filter(_.box == i);
  }

  def getSquare(x:Int,y:Int):Square = {
    return allSquares.filter(_.x == x).filter(_.y == y)(0)
  }

  def setValue(x:Int,y:Int,solution:Int) = {
    var s = getSquare(x,y);
    allSquares = allSquares.filter(_!=s);
    s = s.setValue(solution);
    allSquares = allSquares :+ s;
  }

  def removeValue(x:Int,y:Int,wrongSolution:Int) = {
    var s = getSquare(x,y);
    allSquares = allSquares.filter(_!=s);
    s = s.removeValue(wrongSolution);
    allSquares = allSquares :+ s;
  }

  //Seeding game values
  setValue(1,1,3);
  setValue(1,2,4);
  setValue(1,3,1);
  setValue(2,2,2)
  setValue(3,3,2)
  setValue(4,2,1)
  setValue(4,3,4)
  setValue(4,4,3)


  def printIt() ={
    for(y<-List(1,2,3,4)){
      for(x<- List(1,2,3,4)){
        var s = getSquare(x,y);
        print(s.possibleValues)
      }
      println("")
    }
  }

  def printSolution() = {
    var output:String = ""
    for(y<-List(4,3,2,1)){
      for(x<- List(1,2,3,4)){
        var s = getSquare(x,y);
        if(s.possibleValues.length == 1) output += s.possibleValues(0) + "|"
        else {output += 0 + "|"}
      }
      output+="\n"
    }
    print(output)
  }

  def isValid(x:Int,y:Int,solution:Int):Boolean = {
    for(s<-getAllFromX(x):::getAllFromY(y):::getAllFromBox(getBoxFromXY(x,y))){
      val oneSquare = s.asInstanceOf[Square];
      if(x!= oneSquare.x || y!=oneSquare.y){
        if(oneSquare.isSolved == true && oneSquare.possibleValues(0) == solution){
          println("Has solution " + oneSquare.x,oneSquare.y,oneSquare.possibleValues)
          return false;
        }
      }
    }
    return true;
  }

  def removeIfNotValid(x:Int,y:Int,solution:Int) ={
    if(!isValid(x,y,solution)){
      println("Removing" , x,y,solution);
      removeValue(x,y,solution);
    }
  }

  printIt()
  printSolution()

  //Pattern matching
  def patternMatching(s1:Int,s2:Int,s3:Int,s4:Int):Int ={
    val l = List(s1,s2,s3).sortWith(_<_);
    return l match {
      case List(1,2,3) =>4;
      case List(1,2,4) =>3;
      case List(1,3,4) =>2;
      case List(2,3,4) =>1;
      case List(_,_,_) =>s4;
    }
  }

  def updateAllX(): Unit ={
    for(x<-List(1,2,3,4)){
      for(y<-List(1,2,3,4)){
        val l = List(1,2,3,4).filter(_!=y);
        var res = patternMatching(
          getSquare(x,l(0)).getCorrectValue(),
          getSquare(x,l(1)).getCorrectValue(),
          getSquare(x,l(2)).getCorrectValue(),
          getSquare(x,y).getCorrectValue()
        );
        if(res>0){
          setValue(x,y,res);
        }
      }
    }
  }
  println(updateAllX())
  printSolution();


  //actual brute force
  for(x<-List(1,2,3,4)){
    for(y<-List(1,2,3,4)){
      for(s<-List(1,2,3,4)){
        removeIfNotValid(x,y,s);
      }
    }
  }

  printIt();
  printSolution();

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
}
