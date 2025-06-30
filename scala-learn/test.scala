import java.io.PrintWriter
import scala.io.Source
object HelloWorld {
  def main(args: Array[String]){
    println("Hello, world!")
    //scalac test.scala
    //scala HelloWorld

    // val 是不可变的， var是变量
    val myStr = "HelloWorld!" // 自动有类型推断功能
    val myString: String = "HelloWorld!"
    // 自动 import java.lang._

    println(myStr)
    println(myString)

    var myPrice: Double = 9.9
    myPrice = 10.6
    println(myPrice)

    // 字面量可以直接调用方法
    println(5.toString())
    println("abc".intersect("bcd"))
    // scala中。操作符 + - 也是Int类的一个方法

    println((1).+ (2))

    /**
     * range
     */
    println(1 to 5)
    println(1 until 5)
    println(1 to 10 by 2) // 步长
    println(0.5f to 5.9f by 0.8f)

    /**
    打印语句
     */
    printf("My name is %s, I have %d apples. \n", "Alice", 10)

    /**
     * 输入输出
     */
    val out = new PrintWriter("test.txt")
    for (i <- 1 to 5) {
      out.println(i)
    }
    out.close()

    val lines = Source.fromFile("test.txt").getLines // 迭代器
    for(line <- lines) {
      println(line)
    }
  }
}
