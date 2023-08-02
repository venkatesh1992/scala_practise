import scala.annotation.tailrec

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


















