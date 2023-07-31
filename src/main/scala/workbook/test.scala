package workbook

object test extends App{
  println("Hello world")
  val msg="Hello Scala"
  println(msg)
  //msg = "Good bye"
  println(msg)
//  println("Hello scala "+args(0))

//  var i = 0;
//  while(i<args.length){
//    println(args(i))
//    i+=1
//  }

  args.foreach(println) //will give same result as above code

  import scala.io
  import scala.io.Source

  if (args.length>0)
    for (line <- Source.fromFile(args(0)).getLines)
      println(line.length + " "+ line)
  else
    println("file not found")

  val lines = Source.fromFile(args(0)).getLines.toList

  def widthOfLength(s:String)=s.length.toString.length
  var maxWidth = 0
  for(l <- lines) {
    maxWidth = maxWidth.max(widthOfLength(l))
  }
  println(maxWidth)

}
