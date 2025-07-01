object match_demo {
  def main(args: Array[String]): Unit = {
    val a = 3
    a match {
      case 1 => println("one")
      case _ => println("other")
    }
    val color = a match {
      case 1 => "red"
      case 2 => "blue"
      case unexpected => "unknown"
    }
    println(color)

    // 对表达式的类型匹配
    for (elem <- List(1, 2, "a", 'b')) {
      val str = elem match {
        case i: Int => i + "is int"
        case s: String => s + "is string"
        case c: Char => c + "is char"
        case unexpected => "unknown"
      }
      println(str)
      // 必要的处理逻辑
      for (elem <- List(1,2,3,4)){
        elem match {
          case _ if (elem %2 == 0) => println(elem + " is even.")
          case _ => println(elem + " is odd.")
        }
      }

      // case 类的匹配
      case class Car(brand: String, price: Int)
      val myBYDCar = new Car("BYD", 89000)
      val myBMWCar = new Car("BMW", 1200000)
      val myBenzCar = new Car("Benz", 1500000)
      for (car <- List(myBYDCar, myBMWCar, myBenzCar)) {
        car match{
          case Car("BYD", 89000) => println("Hello, BYD!")
          case Car("BMW", 1200000) => println("Hello, BMW!")
          case Car(brand, price) => println("Brand:"+ brand +", Price:"+price+", do you want it?")
        }
      }

      // Optional
      val books=Map("hadoop"->5,"spark"->10,"hbase"->7)
      println(books.get("hadoop"))
      println(books.get("hive")) // None
      println(books.getOrElse("hive",0))
    }
  }
}
