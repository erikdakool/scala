object assignments extends App{
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
    ""
  }
  println(sarr.mkString)
}


