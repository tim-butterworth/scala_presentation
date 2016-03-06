import scala.concurrent.{Await, Future}
import scala.util.Try
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

var futureOne = Future {
  Thread.sleep(1000)
  "the future"
}
//var futureTwo = futureOne.map {
//  s: String => Future {
//    Thread.sleep(1000)
//    s + " and so much more"
//  }
//}
//var nestedFuture = Await.result(Await.result(futureTwo, 1000 millisecond), 10000 millisecond)
//var completeOne = futureOne.isCompleted
//var completeTwo = futureTwo.isCompleted
var futureThree = futureOne.flatMap {
  s: String => Future {
    Thread.sleep(1000)
    s + " and something something"
  }
}
futureThree.mapTo[Try[String]]
var futureResult = Await.result(futureThree, 10000 millisecond)
var completeThree = futureThree.isCompleted