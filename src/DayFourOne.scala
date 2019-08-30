object DayFourOne extends App {
  //Functional objects
  class Rational(val n:Int,val d:Int){
    require(d != 0);
    override  def toString: String = n + "/" + d;
    //println("created: " + n + "/" + d);

    def +(that:Rational):Rational = {
      new Rational(n * that.d + that.n*d, d*that.d)
    }

    def *(that:Rational):Rational = {
      new Rational(n*that.n,d*that.d);
    }

    def *(that:Int):Rational = {
      new Rational(n*that,d*that);
    }
  }

  implicit def intTORational(n:Int):Rational = {
    return new Rational(n,1);
  }

  val r = new Rational(1,5);
  println(r.toString)
  val r2 = new Rational(3,2);
  val r3 = r.+(r2);
  val r4 = r + r2;
  val r5 = r * r2;
  val r6 = r * 3
  val r7 = 3 * r;

  println(r4.toString);
  println(r5.toString);
  println(r6.toString)

  //Program control
  val x = 12;
  val y = 14;
  val largest = if(x>y) x else y
  println(largest)

  val newList =
  for(i<-List(1,2,3,4,5,6,-1,-3,-5) if(i<5) if(i>0))
    yield i;

  println(newList)

  //Assignment --New list but only with words starting with h
  val l = List("hi","hello","good day");
  val l1 =
    for (i<-l if(i.toCharArray.array(0) == 'h'))
      yield i;
  println(l1)

  //Scopes
  for(i <- 1 to 5)
    for(i<-2 to 6){}
      //println("This will happen many times" + i)

  //Wite every possible 4 digit code
  for(i <- 0 to 9)
    for(i2<-0 to 9)
      for(i3<-0 to 9)
        for(i4<-0 to 9){}
          //println(i+""+i2+""+i3+""+i4)

  //Pattern matching
  def getText(x:Int):String ={
    return x match {
      case 1 => "One";
      case 2=> "Two";
      case 3=>"Three";
      case _ => "Something else";
    }
  }
  println(getText(3))
  println(getText(9))

  //bit -> bot , bot->bit ,  anything->bitbot
  def bitBot(x:String):String ={
    return x match {
      case "bit" => "bot";
      case "bot" => "bit";
      case _ => "bitbot";
    }
  }
  println(bitBot("bit"));
  println(bitBot("boit"));

  //Case classes
  sealed abstract class Expr;
  case class Var(name:String) extends Expr;
  case class Number(name:Double) extends Expr;
  case class Op(Operation:String,left:Expr,right:Expr) extends Expr;

  def simplify(expr: Expr):Expr = {
    expr match{
    case Op("+",e,Number(0)) => e;
    case Op("-",e,Number(0)) => e;
    case Op("*",e,Number(1)) => e;
    case Op(op,l,r)=>Op(op,simplify(l),simplify(r));
    case _ => expr;
    }
  }

  val v = Var("x");
  val op = Op("*",Var("x"),Number(1))

  println(op);
  println(simplify(op))
  println(simplify(Op("*",Var("x"),Op("*",Var("x"),Number(1)))))
}
