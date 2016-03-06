var l = 7
l = l + 1
val m = l + 8


class WithConstructor(val item: String, var count: Int) {

  private val constructed = item + count
  private val argMap = Map(item -> count, "default" -> 2)

  def this(item: String) {
    this(item, 2)
  }
}

var constructedObj = new WithConstructor("hi", 12)
constructedObj = new WithConstructor("hi")
object WithConstructor {
  def apply() = new WithConstructor("default", -1)

  def apply(name: String) = new WithConstructor(name, -4)

  def unapply(obj: WithConstructor): Option[(String, Int)] = {
    Some(obj.item, obj.count)
  }
}


var matchable = WithConstructor()
var list = 1 :: 2 :: Nil

matchable match {
  case WithConstructor(_, 4) => println("WOAHHH!")
  case WithConstructor("default", _) => println("The default I guess")
  case WithConstructor(item, count) => println(item + " " + count)
}



case class CaseClass(name: String, breeds: List[String])
val fidoTurtle = CaseClass("fido", "turtle" :: "t-rex" :: Nil)

fidoTurtle.name
fidoTurtle.breeds


sealed trait TimeOfDay {
  def startHour: Int
  def duration: Int = {
    24
  }
}

case class Morning() extends TimeOfDay {
  def startHour = 6
}
Morning().duration

case class Afternoon(startHour: Int = 12) extends TimeOfDay
Morning().startHour
Afternoon(16).startHour

trait Animal {
  def typeName: String = {
    "Animal"
  }
}

trait cat extends Animal {
  override def typeName: String = {
    "Cat"
  }
}

class SomeCat extends cat {

}

var thisCat = new SomeCat
thisCat.typeName

var someAnimal = new Animal {
  def whatever = {
    "whatever"
  }
  override def typeName = {
    "someAnimal"
  }
}


someAnimal.whatever

class AnimalUtil {
  def callsAnimalMethod(animal :Animal) = {
    animal.typeName
  }
}

var util = new AnimalUtil

util.callsAnimalMethod(someAnimal)
util.callsAnimalMethod(new SomeCat)








