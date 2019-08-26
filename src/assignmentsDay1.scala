object assignmentsDay1 extends App{
  //assignment 1
  def func1(array: Array[Int]):Double ={
    return array.sum/array.length
  }
  val arr = Array(6,4,3,2,5,1,2)
  println(func1(arr));

  //assignment 2
  def func2(array: Array[Int]):Int = {
    array.sortWith(_<_)(array.length/2)
  }
  println(func2(arr))

  //assignment 3
  val sarr = Array("Han","Luke","Leia")
  def func3(array: Array[String]):String = {
    var ret = ""
    sarr.mkString.toCharArray.foreach((arg:Char) => if(arg.isUpper)ret += arg)
    ret;
  }
  println(func3(sarr))

  //assignment 4
  val narr = Array(1,2,3,4,5)

  def func4(array: Array[Int]):Int = {
    if(array.length == 1) return array(0)
      return array(0)+func4(array.slice(1,array.length))
  }
  println(func4(narr))

  //assignment 6
  val a = List(10,1,2,5)
  def evenNumber(x:Int):Boolean = {
    if(x % 2 == 0) true
    else false
  }
  var b = a.filter(evenNumber)
  println(b.mkString)

  //assignment 7
  var c = a.filter((x:Int)=>x%2==0)
  println(c.mkString)
}


