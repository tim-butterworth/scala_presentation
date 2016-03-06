class ParentClass {
  override def toString() = {
    "A string for the class"
  }
}

trait T1 {

  def method
  override def toString() = {
    super.toString() + " T1 wuz here"
  }
}

trait T2 {
  override def toString() ={
    super.toString() + " string by T2"
  }
}

class ChildClass extends ParentClass{

}

def f1(child:ChildClass with T1) = "Imma T1"
def f2(child:ChildClass) = "Normal child"
var c1 = new ChildClass
var child = new ChildClass with T1 {
  override def method: Unit = ???
}


child.toString()



