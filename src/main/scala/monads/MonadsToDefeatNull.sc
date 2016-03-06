val myOption: Option[String] = Some("hi")

val result = myOption match {
  case Some(s) => s
  case None => "default"
}

class OptionalChildrenClass(val id: Int, val gender: String) {
  def getGender: Option[String] = {
    Option(gender)
  }
}

var optionalChildren = new OptionalChildrenClass(12, "Male")
var optionalNullChildren = new OptionalChildrenClass(15, null)

optionalChildren.id

def downCaseFirstChar(s: String) = {
  s.replaceAll("M", "m")
}

def defaultIfNotFound[String](op: Option[String]) = {
  op match {
    case Some(s) => s
    case None => "Default"
  }
}

defaultIfNotFound(optionalChildren.getGender.map(downCaseFirstChar))
defaultIfNotFound(optionalNullChildren.getGender.map(downCaseFirstChar))

class LastNode(val id: Int, val name: String) {
  def getName: Option[String] = {
    Option(name)
  }
}

class SecondNode(val id: Int, val node: LastNode) {
  def getLastNode: Option[LastNode] = {
    Option(node)
  }
}

class FirstNode(val id: Int, val node: SecondNode) {
  def getSecondNode: Option[SecondNode] = {
    Option(node)
  }
}

class RootClassForChain(val id: Int, val node: FirstNode) {
  def getNode: Option[FirstNode] = {
    Option(node)
  }
}

val root = new RootClassForChain(
  1, new FirstNode(
    2, new SecondNode(
      3, new LastNode(
        4, "Neato"))))

val rootWithNull = new RootClassForChain(1, new FirstNode(2, null))

def maybeGetDeepNameLongSignature[Option[String]] = (rootNode: RootClassForChain) => {
  rootNode.getNode
    .flatMap((firstNode: FirstNode) => firstNode.getSecondNode)
    .flatMap((secondNode: SecondNode) => secondNode.getLastNode)
    .flatMap((lastNode: LastNode) => lastNode.getName)
}

def maybeGetDeepName = (rootNode: RootClassForChain) => {
  rootNode.getNode
    .flatMap(_.getSecondNode)
    .flatMap(_.getLastNode)
    .flatMap(_.getName)
}

var deepName = maybeGetDeepNameLongSignature(root)
var deepNameWithNull = maybeGetDeepNameLongSignature(rootWithNull)
//
//def matchResult[String] = (opString: Option[String]) => {
//  opString match {
//    case Some(s) => s
//    case None => "Default"
//  }
//}
//
//matchResult(deepName)
//matchResult(deepNameWithNull)
//
//def someFunction[String] = (i: Int, j: String) => {
//  String.valueOf(i) + j
//}
//
//
//class LastNode2(val id: Int, val name: String)
//class SecondNode2(val id: Int, val node: LastNode2)
//class FirstNode2(val id: Int, val node: SecondNode2)
//class RootClassForChain2(val id: Int, val node: FirstNode2)
//
//val root2 = new RootClassForChain2(
//  1, new FirstNode2(
//    2, new SecondNode2(
//      3, new LastNode2(
//        4, "value"
//      )
//    )
//  )
//)
//
//val root2WithNull = new RootClassForChain2(1, new FirstNode2(2, null))
//
//def getDeepValue = (local_root: RootClassForChain2) => {
//  Option(local_root)
//    .flatMap(root => Option(root.node))
//    .flatMap(first => Option(first.node))
//    .flatMap(second => Option(second.node))
//    .flatMap(last => Option(last.name))
//  match {
//    case Some(s) => s
//    case None => "Default"
//  }
//}
//
//getDeepValue(root2)
//getDeepValue(root2WithNull)
//
//
//def getDeepValue2 = (local_root: RootClassForChain2) => {
//  Option(local_root)
//    .map(root => root.node)
//    .map(first => first.node)
//    .map(second => second.node)
//    .map(last => last.name)
//  match {
//    case Some(s) => s
//    case None => "Default"
//  }
//}
//
//getDeepValue2(root2)
//getDeepValue2(root2WithNull)
