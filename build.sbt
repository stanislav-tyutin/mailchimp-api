name := "mailchimp_api"

version := "1.0"

organization := "com.tbrain"

scalaVersion := "2.12.1"

publishMavenStyle := true

libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.2"
libraryDependencies += "com.netaporter" %% "scala-uri" % "0.4.16"
libraryDependencies += "io.spray" %%  "spray-json" % "1.3.3"
libraryDependencies +=  "org.scalaj" %% "scalaj-http" % "2.3.0"