name := "chatServerClient"

scalaVersion := "2.12.5"

libraryDependencies ++= Seq("com.chat.server" %% "chatserverschema" % "0.1-SNAPSHOT")

val ivyLocal = Resolver.file("local", file(Path.userHome.absolutePath + "/.ivy2/local"))(Resolver.ivyStylePatterns)
externalResolvers := Seq(ivyLocal)
