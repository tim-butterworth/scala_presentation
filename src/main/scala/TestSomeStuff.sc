val myTuple = (1 -> "value")
var evilTuple = myTuple.copy(_1=7, _2="evil value")
myTuple._1
myTuple._2

evilTuple._1
evilTuple._2

def factorial(i: Int, result: Int = 1): Int = {
  if (i == 0) result
  else factorial(i - 1, result * i)
}

factorial(9)
factorial(7)
factorial(2)

(1 to 9).product

//def calculatePrimes(i: Int, primesList: List[Int]): List[Int] = {
//  primesList.map(Int => Int) {
//    return i % c
//  }
//  List()
//}
//
//def primes(i:Int): List[Int] = {
//  val primesList = 1 :: Nil
//  if(i==1) return primesList
//  else return calculatePrimes(i, primesList)
//}


val list = 9 :: 8 :: 7 :: 6 :: 5 :: 4 :: 3 :: 2 :: 1 :: Nil
def timesTwo(i: Int): Int = {
  i * 2
}
var timesTwoList = list map timesTwo

def jsonExample {
  import org.json4s.JsonDSL._
  import org.json4s.native.JsonMethods._

  case class Winner(id: Long, numbers: List[Int])
  case class Lotto(id: Long, winningNumbers: List[Int], winners: List[Winner], drawDate: Option[java.util.Date])

  val winners = List(Winner(23, List(2, 45, 34, 23, 3, 5)), Winner(54, List(52, 3, 12, 11, 18, 22)))
  val lotto = Lotto(5, List(2, 45, 34, 23, 7, 5, 3), winners, None)

  val json =
    "lotto" ->
      ("lotto-id" -> lotto.id) ~
        ("winning-numbers" -> lotto.winningNumbers) ~
        ("draw-date" -> lotto.drawDate.map(_.toString)) ~
        ("winners" ->
          lotto.winners.map { w =>
            ("winner-id" -> w.id) ~
              ("numbers" -> w.numbers)
          })

  println(pretty(render(json)))
}

jsonExample
class ClassToTest(name: String, age: Int) {
  def getName() = {
    name
  }
  def getAge = {
    age
  }
}
var cls = new ClassToTest("Kid",12)

import org.specs2.mock.Mockito

object TestSomeStuff extends Mockito {
  def apply() = {
    val map = mock[Map[String, String]]
    val mockClassToTest = mock[ClassToTest]

    mockClassToTest.getAge returns 100
    mockClassToTest.getName returns "100"
    mockClassToTest.getAge

    there was atLeastThree(mockClassToTest).getAge
    there was atLeastOne(mockClassToTest).getName

    map("0") returns "7"
    map - "12"

    there was atLeastOne(map).-("12")
  }
}

TestSomeStuff()