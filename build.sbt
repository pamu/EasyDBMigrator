name := """EasyDBMigrator"""

version := "1.0.0"

scalaVersion := "2.11.4"

mainClass := Some("""Main""")

libraryDependencies ++= Seq("mysql" % "mysql-connector-java" % "5.1.34",
                            "com.typesafe.slick" %% "slick" % "2.1.0")
