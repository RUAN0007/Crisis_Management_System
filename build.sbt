name := "Crisis_Management_System"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.27",
  javaJdbc,
  javaEbean,
  cache
)     

play.Project.playJavaSettings
