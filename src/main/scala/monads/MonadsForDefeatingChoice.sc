import scala.util.Random

val i = Random.nextInt(10)

val either: Either[Int, String] = if(i>4) {
  Right(i.toString)
} else {
  Left(i)
}

val leftResult = either.left.flatMap(x => Right((x * 10).toString))
leftResult.right.get


