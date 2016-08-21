name := "ag-server"
version := "1.0"
scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.jsuereth" %% "scala-arm" % "1.4",
  "org.slf4j" % "slf4j-api" % "1.7.6",
  "ch.qos.logback" % "logback-classic" % "1.1.1" % "runtime",
  "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided",
  "com.thetransactioncompany" % "cors-filter" % "1.9.2"
)

libraryDependencies ++= Seq(
  "org.glassfish.jersey.containers" % "jersey-container-servlet",
  "org.glassfish.jersey.media" % "jersey-media-json-jackson",
  "org.glassfish.jersey.media" % "jersey-media-multipart"
) map (_ % "2.22")

libraryDependencies ++= Seq(
  "io.swagger" %% "swagger-scala-module" % "1.0.0",
  "io.swagger" % "swagger-jersey2-jaxrs" % "1.5.6",
  "io.swagger" % "swagger-annotations" % "1.5.6"
)

libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.3"


enablePlugins(JettyPlugin)

