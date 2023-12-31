import scala.annotation.tailrec
import scala.math.cos
import scala.util.Try

object WordCount {
  def main(): Unit = {
    val l1 = List("Hi", "Hello", "How", "are", "you", "doing", "good","How","are","are")
    val c1 = l1.groupBy(identity).map{case(x,y) => (x, y.length)}
    c1.foreach(println)
  }
}
WordCount.main()

val x = Array(1,2,3,4,5)
val x1 = new Array[Int](3)
x1(0)=1
x1(1)=2
x1(2)=3
x1

val x2 = Array.range(1,10)
val x3 = Array.fill(3)("hi")
val l1 = List.range(1,10)

@tailrec
def gcd(a:Int, b:Int):Int= if(b==0) a else gcd(b,a%b)
gcd(66,42)

val cities = List("Mumbai","Bangalore","Delhi","Chennai","Hyderabad")
cities.foreach(println)
for(city <- cities) println(city)
for(city <- cities if city != "Delhi") println(city)
for(city <- cities if city != "Delhi";if ! city.startsWith("M")) println(city)
for(city <- cities) yield(city)
for(city <- cities if city != "Delhi") yield(city)
for(city <- cities if city != "Delhi";if ! city.startsWith("M")) yield(city)
//i can apply transformation in mid
for(city <- cities if city != "Delhi";if ! city.startsWith("M");cities=city.toUpperCase()) yield(cities)
for(city <- cities){
  city match{
    case "Delhi"=>println("Delhi is capital of India")
    case "Mumbai" => println("Business capital of india")
    case _ => println("one of the city")
  }
}

for(city<- cities)
  city match {
    case "Delhi"=>println("capital of India")
    case otherCity => println(s"$otherCity")
  }


cities match {
  case List("Mumbai", _ *) => println("starting with mumbai")
  case _ => println("not starting with delhi")
}

def listToString(cities: List[String]): String = {
  cities match {
    case head :: tail => head + " " + listToString(tail)
    case Nil =>""
  }
}
listToString(cities)

val tupA = ("hello","everyone")
val tupB = ("learn","scala")

for(tup <- List(tupA,tupB))
  tup match {
    case (a,b) if(a=="hello") =>println(a,b)
    case _ =>print("nothing")
  }

case class Person(name:String,age:Int)
val p1=Person("Venkat",28)
val p2 = Person("Ravi",24)
val p3 = Person("raju",16)

for(p<-List(p1,p2,p3))
  p match {
    case Person(name, age) if(age>= 18) => println(s"age greater than 18,$name qualified")
    case Person(name,age) => println(s"$name not qualified")
  }

val divide = try{
  5/0
} catch{
  case ex:ArithmeticException => println("can't divide by 0")
  case _ => println("some other exception")
}

def divide1(num:Int,den:Int)={
  Try{
    if(den == 0) throw new ArithmeticException("denominator can't be 0")
    else num/den
  }
}
divide1(5,2).get
divide1(3,0)

class Calculator(name:String){
  def add(num1:Int,num2:Int)=num1 + num2
  override def toString: String = s"This is $name calculator"
}

object Calculator{
  def main(): Unit = {
    val c1 = new Calculator("casio")
    println(c1.add(2,3))
    println(c1)
  }
}
Calculator.main()

class Calc2(name:String,calType:String){
  def this(name:String){
    this("primary called","from single arg con")
    println("single arg construct")
  }
  def this() {
    this("casio")
    println("calling from no arg to single arg")
  }
  println("executing from main constructor body")
}
object Calc2{
  def main(): Unit = {
    val c2 = new Calc2() //it is calling constructor with no args
  }
}
Calc2.main()

class Calc3(name:String){
  private def add(num1:Int,num2:Int)=num1 + num2
  override def toString: String = s"This is $name calculator"
}

object Calc3{
  def main(): Unit = {
    val c1 = new Calc3("casio")
    println(c1.add(2,3))
    println(c1)
  }
}
Calc3.main()
//if i change object name,i can't accessible add method
//object Calc4{
//  def main(): Unit = {
//    val c1 = new Calc3("casio")
//    println(c1.add(2,3))
//    println(c1)
//  }
//}
//Calc4.main()

(x:Int)=> x+10
(10)
val f = (y:Int) => y + 10
f(10)

import scala.math.{Pi=>mypi}
val Pi=3.1
println(s"$Pi defined $mypi")

//import scala.math.{Pi=> _,_}
//val Pi=3.2
println(Pi)

trait Calc4{
  def show(): Unit = {
    println("implemented method in trait")
  }
  def getName:String
  def getCost:Double
  def calcType:String
  val a =10
}

class Calc5(name:String,cost:Double,typ:String) extends Calc4{
  override def getName: String = name

  override def getCost: Double = cost

  override def calcType: String = typ

  override def show(): Unit = {
    super.show()
    println("printing from class as well")
  }
}
val c5 = new Calc5("c5",2.5,"scientific")
c5.getName
c5.getCost
c5.calcType
c5.a
c5.show()




























