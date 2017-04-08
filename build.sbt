name := "gitbucket-ipynb-plugin-test"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.seleniumhq.selenium" % "selenium-java" % "2.35.0" % "test"
)