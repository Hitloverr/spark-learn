object ObjectLearn {
   // 必须要求把声明（比如val myCounter = new Counter以及myCounter.increment()等）都封装在对象中
    def main(args:Array[String]): Unit = {
      val counter = new Counter
      counter.increment(2)
      println(counter.current())
      counter.Value = 10 // 设置新的值
      println(counter.Value)

      val myCounter2 = new Counter2("abc")
      myCounter2.myName

      val myCounter3 = new Counter3("abc", 1)
      println(myCounter3.name)
      println(myCounter3.mode)
    }
}

class Counter {
  // 定义类的字段和方法
  private var value = 0 // 不加修饰符就是public
  def Value = value // 定义一个方法，方法名称是原来我们想要字段的名称
  def Value_= (newValue:Int): Unit = {
    if (newValue >= 0) value = newValue
  }
  // 不返回任何值就是Unit，类似于void
  // 方法里面最后一个表达式的值就是返回值
  def increment(step:Int): Unit = {
    value += step
  }
  // 只有一句可以去掉大括号。
  def current(): Int = {value}
  //也可以去掉返回值类型和等号
  def increment2() {
    value += 1
  }
}

class Counter2 {
  private var name = ""

  // 构造器
  def this(name:String){
    this()
    this.name = name
  }

  def myName = this.name
  def myName_=(newName:String): Unit = {
    this.name = newName
  }
}
// 主构造器
class Counter3(val name:String, val mode:Int) {

}
