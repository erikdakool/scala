
object DayFiveOne extends App {

  //Inheritance
  abstract class SuperClass(){
    def someMethod():Unit ={
      println("hi");
    }
  }

  class SubClass extends SuperClass{
    override def someMethod():Unit = {
      println("hello");
    }
  }

  trait Philosophical{
    def philosophize():Unit = {
      println("I consume memory therefore i am");
    }
  }

  trait Animal{
    def hearthBeat(): Unit ={
      println("My heart is beating");
    }
  }

  class Frog extends Philosophical with Animal {
    override def toString = "Green";
  }

  val f = new Frog //with Animal;
  f.philosophize();
  f.hearthBeat();

/*  class Lightsaber{
    def properties():List[String] = List();
    override def toString() = "It is a " + properties.mkString(" ", " ") + "Lightsaber";
  }

  trait Red extends Lightsaber{
  
  }

  trait Crossguard extends Lightsaber{
    override def properties(): List[String] = super.properties() ::: List["crossguard"];   
  }

  val mySaber = new Lightsaber with Red with Crossguard;
  println(mySaber);*/

  trait Wheels{
    def run():Unit ={
      println("I run");
    }
  }

  trait SteeringWheels{
    def steer():Unit = {
      println("I steer");
    }
  }

  abstract class Vehicle;

  class Car extends Vehicle with Wheels with SteeringWheels {
    def drive():Unit={
      run();
      steer();
    }
  }

  (new Car()).drive();

  //Extractors
  object Email {
    //Injection method
    def apply(user:String, domain:String) = user + "@" + domain;

    //Extraction method
    def unapply(str: String): Option[(String,String)] = {
      val parts = str split("@")
      if(parts.length == 2) Option(parts(0),parts(1))
      else None
    }
  }

  def workAtUia(s:String):Boolean =
  s match{
    case Email(_,"uia.no") => true;
    case _=> false;
  }

  println(workAtUia("something@uia.no"));
  println(workAtUia("something@other.com"));

  class Demo{
    lazy val x  ={println("Initializing x"); "done";}
  }

  val d = new Demo()
  println("before");
  println(d.x);

  //Make class with lists from 0 to 1000
  //List should be lazy
  class ListC {
    lazy val l = {println("List created"); (1 to 1000).toList;}
  }
  val l = new ListC();
  println(l.l(0));


}
