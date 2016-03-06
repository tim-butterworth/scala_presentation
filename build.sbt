name := "firstScala"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies++=Seq(
  "org.json4s" %% "json4s-native" % "3.3.0",
  "org.specs2" %% "specs2-core" % "3.6.6",
  "org.specs2" %% "specs2-mock" % "3.6.6"
)

scalacOptions in Test ++= Seq("-Yrangepos")
