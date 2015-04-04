name :="2DGameEngine"

scalaVersion :="2.11.1"

version := "1.0"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"

libraryDependencies += "org.scala-lang.modules" % "scala-swing_2.11" % "1.0.1"

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource
