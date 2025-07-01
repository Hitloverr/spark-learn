object collection_demo {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5)
    list.foreach(elem => println(elem)) //本行语句甚至可以简写为list.foreach(println)，或者写成：list foreach println

    val university = Map("XMU" -> "Xiamen University", "THU" -> "Tsinghua University","PKU"->"Peking University")
    for ((k,v) <- university) printf("Code is : %s and name is: %s\n",k,v)
    for (k<-university.keys) println(k)
    for (v<-university.values) println(v)

    university foreach {
      case (k,v) => printf("Code is : %s and name is: %s\n",k,v)
    }

    university foreach {
      kv => println(kv._1 + " : " + kv._2)
    }

    /**
     * map flatmap
     */
    val books = List("Hadoop", "Hive", "HDFS")
    println(books.map(s => s.toUpperCase))
    println(books.flatMap(s => s.toList))

    val university2 = Map("XMU" -> "Xiamen University", "THU" -> "Tsinghua University","PKU"->"Peking University","XMUT"->"Xiamen University of Technology")
    val filterUniversity = university2 filter {
      kv => kv._2.contains("Xiamen")
    }
    filterUniversity foreach {
      kv => println(kv._1 + " : " + kv._2)
    }
    val list2 = List(1,2,3,4,5)
    list2.reduceLeft(_ - _) //从左到右累加
    list2.reduceRight(_ - _) //从右到左累加
    list2.reduce(_ - _) //默认是reduceLeft

    // fold: 类似reduce，但是有初始值
    list2.fold(10)(_ - _)
    list2.foldLeft(10)(_ - _)
    list2.foldRight(10)(_ - _)

  }
}
