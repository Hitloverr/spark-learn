object function_demo {
  def main(args: Array[String]): Unit = {
    val counter: Int => Int = {(value)=> {value + 1}}
    val myNumFunc: Int => Int = (num: Int) => num * 2
    println(myNumFunc(1))

    val myNumFunc2: Int => Int = num => num * 2

    // 闭包,引用函数外部的变量
    def plusStep(step:Int) = (num: Int) => num + step
    val myFunc = plusStep(3)
    println(myFunc(10))
    // 高阶函数
    def sum(f:Int=> Int, a: Int, b: Int): Int = {
      if (a> b) 0 else f(a) + sum(f, a+ 1,b)

    }

    var more = 1
    val addMore = (x:Int) => x+ more
    println(addMore(10))
    more = 9
    println(addMore(10))

    // 占位符
    val numList = List(1,2,3,4)
    numList.filter(_ % 2 == 0)
  }

  // 函数的类型 (Int) => Int
  // 函数的值 (value)=> {value + 1}
  def counter(value: Int): Int = {value  + 1}


}
