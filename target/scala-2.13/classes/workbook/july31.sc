import scala.::
import scala.annotation.tailrec

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
val git_status="I'm connected"

object FallWinterSpringSummer extends App {
  for(season <-List("Fall","Winter","Spring","Summer"))
    println(season +" : "+checkSumAccumulator2.calculate(season))
}
FallWinterSpringSummer.executionStart

val hex = 0x5
val hex2 = 0xFF
val magic = 0xcafebabe

val oct = 0x1d
val nov = 0x1ff

val dec1 =31
val dec2 = 255

val tower = 35L
val t1 = 0xCAFEBABABL
val t2 = 31L
val little:Short = 367
val littler:Byte = 38
val l2:Byte = 120

val big = 1.2345
val big1 = 1.2345e1
val big2 = 1234E5
val f1 = 1.23f
val f2 = 3e5f
val d2 = 3e5d
val i2 = 3e5

val a= 'A'
val a1 = '\u0041'
val a1 = '\u0042'

val backslash = "\\\"\'"
val raw1 = """\"' """
println("""Welcome to Ultamix 3000.
             Type "HELP" for help.""")
println("""|Welcome to Ultamix 3000.
             |Type "HELP" for help.""".stripMargin)
val s1 = 'aSymbol
s1.name
val s2 = Symbol("bSymbol")
s2.name
val s3 = 'aSymbolaSymbol
s3.name
val bool1 = true
val bool2 = false

val sum = 1 + 2
val lSum = 1 + 2L

val s1 = "Hello World"
s1.indexOf("l")
s1.indexOf("l",8)

-2.0
val a1 = -2
2.unary_-

val a2 = 3.unary_-

val s1 = "Hello World"
s1.toLowerCase()
s1.toLowerCase

1 > 2
1 < 2
1 <= 1
3.5f > 3.6f
'a' >= 'A'
val thisIsBoring = !true
!thisIsBoring

val toBeTrue = true
val question = toBeTrue || !toBeTrue
toBeTrue && !toBeTrue //and
!toBeTrue || !toBeTrue
toBeTrue && toBeTrue

def salt()={println("salt");false}
def pepper()={println("pepper");true}

salt() && pepper()
pepper() && salt()

salt() || pepper()
pepper() || salt()

1 & 2
1 | 2
~1
1 ^ 3

1 == 2
1 != 2
2 == 2

List(1,2,3) == List(1,2,3)
List(1,2,3) == List(4,5,6)

1 == 1.0
1 == "Hello world"
"abc" == "xyz"

import scala.language.postfixOps
0 max 5
0 min 5
-2.7.abs
-2.7.round
1.5.isInfinity
(1.0/0).isInfinity
4 to 6
4.to(6)
"bob".capitalize
"bob".capitalize
"robert".drop(2)

val fruits = List("apples","oranges","pears")
val nums = List(1,2,3,4)
val diag3 = List(
  List(1,0,0),
  List(0,1,0),
  List(0,0,1)
)
val empty = List()

val xs:List[String] = List()
//xs.head

empty.isEmpty
fruits.isEmpty
fruits.head
fruits.tail
fruits.last
fruits.init
fruits
fruits.inits
fruits.tail.head
diag3.head

def insert(x:Int,l:List[Int]):List[Int]={
  if(l.isEmpty || x <= l.head) x::l
  else l.head :: insert(x,l.tail)
}

def isSort(l:List[Int]):List[Int]={
  if(l.isEmpty) Nil
  else insert(l.head,isSort(l.tail))
}

isSort(List(3,6,2,8,5,9))

val List(a,b,c) = fruits
a
b
c

def insert1(x:Int,l1:List[Int]):List[Int]= l1 match{
    case List() => List(x)
    case y :: l2 => if(x <= y) x :: l1
                    else y :: insert1(x,l2)
}

def doSort(l1:List[Int]):List[Int]=l1 match{
  case List()=> List()
  case x::l2 => insert1(x,doSort(l2))
}
doSort(List(3,6,2,8,5,9))

def calculator[A,B](x:A,y:A,f:(A,A)=>B)=f(x,y)
calculator[Int,Int](2,3,_+_)
calculator[Int,Int](2,3,_- _)
calculator[Int,Int](2,3,_*_)
calculator[Int,Int](2,3,_ /_)
calculator[Int,Int](2,3,_%_)
calculator[Int,Boolean](2,3,_<_)

List(1,2,3) ::: List(4,5)
List() ::: List(1,2,3)
List(1,2,3) ::: List(4)
List() ::: List(1,2,3) ::: List(4,5)

val abcde = List('a','b','c','d','e')
abcde.last
abcde.init
abcde.reverse

abcde.take(2)
abcde.drop(2)
abcde.dropRight(2)
abcde.take(10)
abcde.drop(10)
abcde.splitAt(2)
abcde(2)
abcde.apply(2)
abcde.indices
abcde.zipWithIndex
abcde.zip(List(1,2,3))
abcde.toString()
abcde.mkString(" ")
abcde.mkString
abcde.mkString("["," ","]")
abcde.mkString("")
abcde.mkString("List(",",",")")

val buf = new StringBuilder()
abcde.addString(buf,"(",":",")")

//conversions
val arr=abcde.toArray
arr.toString
arr.toList

val arr2 = new Array[String](10)
List(1,2,3).map(_+1)
val words = List("the","quick","brown","fox")
words.map(_.length)
words.map(x=>x.length)
words.map(_.toList.reverse.mkString)
words.map(_.toList)
words.flatMap(_.toList)
List(1,2,3,4,5).foreach(println)
var sum = 0
List(1,2,3,4,5).foreach(sum += _)
sum
List(1,2,3,4,5).filter(_ %2 == 0)
words.filter(_.length == 3)
List(1,2,3,4,5).partition(_ %2 == 0)
List(1,2,3,4,5).find(_ %2 == 0).get
List(1,2,3,4,5).find(_ <= 0)
List(1,2,3,-4,5).take(2)
List(1,2,3,-4,5).takeWhile(_>=0)
words.takeWhile(_.startsWith("t"))
words.dropWhile(_.startsWith("t"))













































































