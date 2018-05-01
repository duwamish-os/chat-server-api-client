name := "chatServerClient"

scalaVersion := "2.12.5"

libraryDependencies ++= Seq(
  "com.chat.server" %% "chatserverschema" % "0.1-SNAPSHOT",
  "io.github.finagle" %% "featherbed" % "0.3.3",
  "io.github.finagle" %% "featherbed-circe" % "0.3.3"
)

resolvers += "mvncentral" at "http://central.maven.org/maven2"

//val ivyLocal = Resolver.file("local", file(Path.userHome.absolutePath + "/.ivy2/local"))(Resolver.ivyStylePatterns)
//externalResolvers := Seq(ivyLocal)