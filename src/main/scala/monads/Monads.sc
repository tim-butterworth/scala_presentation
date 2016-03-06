import scala.util.{Failure, Success, Try}

val stringStringMap = Map[String, String](
  "key" -> "value",
  "key2" -> "value2"
)
val existingEntry = stringStringMap.get("key")
val nonExistingEntry = stringStringMap.get("bad_key")

val appended = existingEntry.map {
  s: String => s + " appended"
}
val appendedFlat = existingEntry.flatMap {
  s: String => Some(s + " appended");
}
appended match {
  case Some(s: String) => s
  case None => "nothing in there"
}
nonExistingEntry match {
  case Some(s: String) => s + " more appended"
  case None => "what???"
}

val myTry = Try {
  appended.get
}.map {
  s: String => s + " ...and so much more"
}

val tryToGetData = (s: Option[String]) => {
  Try(s.get) map {
    (x) => x
  }
}

val list = "key" :: "bad_key" :: "key2" :: Nil
val filtered = list map {
  stringStringMap.get(_)
} map {
  tryToGetData
} collect {
  case Success(s: String) => s + "... all collected"
  case Failure(e) => "failure -> " + e.getMessage
}

filtered.size
//for (s <- list) {
//  println(s)
//}
//var some3 = Some(3)
//for (n: Int <- some3) {
//  println(n)
//}
