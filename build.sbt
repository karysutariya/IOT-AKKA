import play.core.PlayVersion.{akkaHttpVersion, akkaVersion}

lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .settings(
    name := """RedditLytics using akka""",
    version := "2.5",
    scalaVersion:= "2.13.6",
    libraryDependencies ++= Seq(
      guice,
      // Test Database
      "com.h2database" % "h2" % "2.0.202",
      // Testing libraries for dealing with CompletionStage...
      "org.assertj" % "assertj-core" % "3.21.0" % Test,
      "org.awaitility" % "awaitility" % "4.1.1" % Test,
      "com.typesafe.akka" %% "akka-actor" % akkaVersion,
      "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
      "com.typesafe.akka" %% "akka-stream" % akkaVersion,
      "com.typesafe.akka" %% "akka-http-jackson" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
      "org.mockito" % "mockito-core" % "4.1.0" % "test",
      "org.scalatest" %% "scalatest" % "3.2.9" % "test",
    ),
    javacOptions ++= Seq(
      "-encoding", "UTF-8",
      "-parameters",
      "-Xlint:unchecked",
      "-Xlint:deprecation"
    ),
    // Make verbose tests
    testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))
  )
