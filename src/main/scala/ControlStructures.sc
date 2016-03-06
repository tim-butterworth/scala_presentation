//

var i = if (true) 10 else 11

//inclusive
for (i <- 0 to 10) {
  println(i)
}
//
for (i <- 0 until 10) {
  println(i)
}
var list = 1 :: 2 :: 3 :: Nil
var forred = for (i <- list) yield {
  i + 3
}

var forsome = for (i <- Some(10)) yield {
  i
}

for (i <- 0 to 10; j <- 0 to 10) {
  println(i+":"+j)
}


for (i <- 0 to 10; j <- 0 to 10) {
  println(i+j)
}