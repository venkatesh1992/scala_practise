
1+2
res0 * 3
println("Hello world")
val message = "Hello world"
message
println(message)
//message = "Good bye" --reassignment to val
println(message)
var msg = "hello Scala"
println(msg)
msg="i'm learning scala"
println(msg)

def max(x:Int,y:Int):Int={
  if(x>y) x else y
}
//scala compiler doesn't infer types of the function parameters,
//so we have to define types of parameters implicitly
max(10,12)
max(17,2)

def max2(x:Int,y:Int)= if(x>y) x else y

max2(4,5)

def greet():Unit=println("Hello scala")
greet()
//to pass command line arguments
//println("Hello scala"+args(0))

val big = new java.math.BigInteger("12345")
big
val greetStrings = new Array[String](3)
greetStrings(0) = "Venkatesh"
greetStrings(1) = "Ravi"
greetStrings(2) = "Raju"

println(greetStrings.mkString(" "))
greetStrings.foreach(println)

val numNames = Array("Venkat","ravi","raju")
numNames.foreach(println)

val oneTwoThree = List(1,2,3)
val oneTwo = List(1,2)
val threeFour = List(3,4)
val oneTwoThreeFour = oneTwo ::: threeFour
// list concatenation
println(oneTwoThreeFour)

val oneFour = oneTwo.appended(threeFour)
println(oneFour)

val oneToFour = 1 :: 2 :: 3 :: 4 :: Nil
println(oneToFour)

List()
Nil
List("cool","tool","rule")
val thrill =  List("fill","will","until")
List("a","b") ::: List("c","d")
thrill(2)
thrill.count(s=>s.length==5)
thrill.drop(2) //drops 2 elements
thrill
thrill.dropRight(2)
thrill.exists(s=>s=="will")
thrill.contains("will")
thrill.filter(s=>s.length==4)
thrill.forall(s=>s.endsWith("l"))
thrill.head
thrill.tail
thrill.init
thrill.last
//thrill.first //there is no first method on list
thrill.isEmpty
thrill.length
thrill.map(s=>s + "y")
thrill.mkString(" ")
thrill.reverse
()
val pair=(1,"venkat")
pair._1
pair._2
pair.toString()
pair._1
("u","r",1,3,"to","me")
(1,2,3,4,5,6,7,8,9,10,"eleven",12.5,13,14,"fifteen",16,17,18,19,20,21,22)
//tuples may not have more than 22 elements, but 26 given
//(1,2,3,4,5,6,7,8,9,10,"eleven",12.5,13,14,"fifteen",16,17,18,19,20,21,22,23,24,25,26)
//(1,2,3,4,5,6,7,8,9,10,"eleven",12.5,13,14,"fifteen",16,17,18,19,20,21,22,23,24,25,26)
var jetSet = Set("Boeing","Airbus")
jetSet += ("indigo")
jetSet
println(jetSet.contains("sky jet"))

val movieSet = scala.collection.mutable.Set("Tagore","Baby")
movieSet += "bro"

val treasureMap = scala.collection.mutable.Map[Int,String]()
treasureMap +=(1->"Hunter")
treasureMap += (2->"land")

val t1 = Map(1->"abc",2->"xyz")

def printArgs(args:Array[String]): Unit ={
  var i=0
  while(i < args.length){
    println(args(i))
    i+=1
  }
}

printArgs(Array("Venkat","Ravi","Raju"))

def printArgs1(args:Array[String]):Unit={
  args.foreach(println)
}

printArgs1(Array("Venkat","Ravi","Raju"))

def formatArgs(args:Array[String])=args.mkString("\n")
formatArgs(Array("Venkat","Ravi","Raju"))

val res1 = formatArgs(Array("Venkat","Ravi","Raju"))
assert(res1 == "Venkat\nRavi\nRaju")
/*
java.lang.AssertionError: assertion failed
  at scala.Predef$.assert(Predef.scala:264)
  ... 37 elided
 */
//assert(res1 == "Venkat\nRavi\nRaj")

class checkSumAccumulator{
  var sum=0
}

val aSum = new checkSumAccumulator
val bSum = new checkSumAccumulator

aSum.sum = 20

//aSum = new checkSumAccumulator

class checkSumAccumulator1{
  private var sum=0
}
val aSum1 = new checkSumAccumulator1
val bSum1 = new checkSumAccumulator1

//aSum1.sum = 20 //can't accessible private variable from outside

class checkSumAccumulator2{
  private var sum=0
  def add(b:Byte):Unit= sum += b
  def checkSum():Int= ~(sum & 0xFF) + 1
}
val aSum2 = new checkSumAccumulator2
val bSum2 = new checkSumAccumulator2

aSum2.add(20)
println(aSum2.checkSum())

def f():Unit="This string will lost"
f()

def h():String="This will not lost"
h()

object checkSumAccumulator2{
  private val cache = scala.collection.mutable.Map[String,Int]()
  def calculate(s:String):Int={
    if(cache.contains(s)) cache(s)
    else {
      val acc = new checkSumAccumulator2
      for(c<-s)
        acc.add(c.toByte)
      val cs = acc.checkSum()
      cache += (s->cs)
      cs
    }
  }
}

checkSumAccumulator2.calculate("Hello everybody")
checkSumAccumulator2.calculate(20.toString)

object Summer{
  def main(args:Array[String]): Unit = {
    for(arg <- args)
      println(arg +" : "+checkSumAccumulator2.calculate(arg))
  }
}

Summer.main(Array("I'm Venki","doing good"))






























