package practisePrograms

class Calculator(name:String){
  def add(a:Int,b:Int): Int = a+b

  override def toString: String = s"This is $name"

}
object Calculator extends App {
  val c1 = new Calculator("casio")
  println(c1.add(2,3))
  println(c1)
}
