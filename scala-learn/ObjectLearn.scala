/**
 * 伴生类：
 * 在Scala里面的class和object在Java层面都会被合二为一，
 * class里面的成员成了实例成员，object成员成了static成员。
 */
class Person {
  private val id = Person.newPersonId()
  private var name = ""
  def this(name:String) {
    this()
    this.name = name
  }

  /**
   * 经常会用到对象的apply方法和update方法，虽然我们表面上并没有察觉，但是，实际上，
   * 在Scala中，apply方法和update方法都会遵循相关的约定被调用，约定如下：用括号传递给变量(对象)一个或多个参数时，
   * Scala 会把它转换成对apply方法的调用；与此相似的，当对带有括号并包括一到若干参数的对象进行赋值时，
   * 编译器将调用对象的update方法，在调用时，是把括号里的参数和等号右边的对象一起作为update方法的输入参数来执行调用
   */
  def apply(param: String):String = {
    println("apply method called, parameter is: " + param)

    "Hello World!"
  }
}

// 使用object关键字实现单例对象，具备和java静态方法同样功能
object Person {
  private var lastId = 0
  def newPersonId() = {
    lastId += 1
    lastId
  }

  def apply(param1: String, param2: String): String = {
    println("apply method called")
    param1 + " and " + param2
  }

  def main(args: Array[String]) = {
    println("id is %d",Person.newPersonId())
    println("id is %d",Person.newPersonId())
    println("id is %d",Person.newPersonId())
    val person1 = new Person("Zoy")
    println(person1.id)
    println(person1("Scala"))
    val group = Person("Scala", "Java")
    println(group)
  }
}

/**
 * 利用伴生对象来作为工厂方法
 * @param name
 */
class Car(name:String) {
  def info(): Unit = {
    println(name)
  }
}

object Car {
  def apply(name: String) = new Car(name)

  def main(args: Array[String]) = {
    val myCar = Car("Tesla")
    print(myCar.info())
  }
}

abstract class Phone { // 抽象类
  val phoneBrand: String // 没有初始化就是一个抽象字段
  def info() // 抽象方法，不需要使用abstract关键字
  def greeting() {println("Hello, " + phoneBrand)}
}

class IPhone extends Phone {
  // 字段重写必须override
  override val phoneBrand: String = "iphone"

  // 方法重写也可以不加override
  override def info(): Unit = {
    println("I am " + phoneBrand)
  }

  // 非抽象方法，必须override
  override def greeting(): Unit = {
    println("Hello, " + phoneBrand)
  }
}

object MyPhone {
  def main(args: Array[String]): Unit = {
    val myPhone = new IPhone
    myPhone.info()
    myPhone.greeting()
  }
}

/**
 * Scala中没有接口，有特质trait
 */
trait CarId {
  var id:Int // 抽象字段
  def currentId():Int // 定义了一个抽象方法
  def greeting(msg:String) {println(msg)} // 特质可以包含具体实现

}
trait CarGreeting {
//  def greeting(msg:String) {println("Hello, " + msg)}
}
class BYDCarId extends CarId with CarGreeting {

  override var id: Int = 1000

  override def currentId(): Int = {id += 1; id}
}

object myCar {
  def main(args: Array[String]): Unit = {
    val myCar = new BYDCarId
    println(myCar.currentId())
  }
}