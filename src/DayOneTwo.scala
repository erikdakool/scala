object DayOneTwo extends App {

  val arr = Array("Luke","Leka","Han");

  var i = 0;
  while(i<arr.length){
    println(arr(i) + " " + 1);
    i+=1;
  }

  for(arg <- arr){
    println(arg + " " + 2);
  }

  for(i<-0 to arr.length){
  }

  arr.foreach(println);
  arr.foreach((arg:String) => println(arg + " " + 3))
  var greetString = new Array[String](3);
  greetString(0) = "Luke";
  greetString(1) = "Leia";

  var narr = Array(1,2,7,4,5);
  var e = Int.MinValue;
  for(arg <- narr){
    if(arg > e) e = arg;
  }

  println(e);
  println(narr.max)


}
