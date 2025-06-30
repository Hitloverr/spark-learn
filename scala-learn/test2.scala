import scala.collection.mutable.Map
import scala.collection.mutable.Set

object HelloWorld2 {
  def main(args: Array[String]) {
    val x = 5
    if (x > 0) {
      print("positive")
    } else {
      print("negative")
    }

    // 表达式的值可以赋值给变量
    val a = if (x > 4) 1 else -1
    println(a)

    /**
     * 循环
     */
    var i = 9
    while (i > 0) {
      i -= 1
      println(i)
    }

    i = 0
    do {
      i += 1
      println(i)
    } while (i < 5)

    for (i <- 1 to 5 by 2) {
      println(i)
    }

    for (i <- 1 to 5 if i % 2 == 0) {
      println(i)
    }

    // 支持多个生成器
    for (i <- 1 to 5; j <- 1 to 3) {
      println(i * j)
    }
    println("-------------")

    // 对过滤后的结果构建一个集合
    for (i <- 1 to 5 if i % 2 == 0) yield i
    println(i)

    /**
     * 数组
     */
    val intArray = new Array[Int](3)
    intArray(0) = 12
    val myStrAray = Array("hello", "world")

    /**
     * 列表
     */
    val myList = List(1, 2, 3)
    val intListOther = 0::myList
    val intList = 1::2::3::Nil
    val intList2 = myList::intList
    println(myList.sum)

    /**
     * 元祖
     */
    val myTuple = (1, "hello")
    println(myTuple._1)
    println(myTuple._2)

    /**
     * 集合
     */
    var mySet = Set("Hello", "Word")
    // 对不可变集合进行操作，会产生一个新的集合，原来集合不会变化
    mySet += "Scale"
    println(mySet.contains("Scale"))

    /**
     * 映射
     */
    val myMap = Map("a" -> 1, "b" -> 2)
    println(myMap("a"))
    val xNum = if (myMap.contains("a")) myMap("a") else 0
    println(xNum)
    myMap += ("c" -> 3)
    for ((x,y) <- myMap) println(x + " -> " + y)
    for (x <- myMap.keys) println(x)
    for (y <- myMap.values) println(y)

    /**
     * 迭代器
     */
    val iter = Iterator(1, 2, 3)
    while (iter.hasNext) {
      println(iter.next())
    }

    for (ele <- iter) {
      println(ele)
    }

  }
}