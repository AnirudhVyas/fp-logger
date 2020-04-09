name := "fp-logger"
version := "0.1"
scalaVersion := "2.12.10"
libraryDependencies ++= Seq(
  "io.chrisdavenport" %% "log4cats-core"    % "1.0.1",  // Only if you want to Support Any Backend
  "io.chrisdavenport" %% "log4cats-slf4j"   % "1.0.1",  // Direct Slf4j Support - Recommended
)
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"
resolvers += Resolver.DefaultMavenRepository
libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
libraryDependencies += "org.typelevel" %% "cats-effect" % "2.0.0"
val catsRetryVersion = "1.1.0"
libraryDependencies += "com.github.cb372" %% "cats-retry" % catsRetryVersion
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.1"