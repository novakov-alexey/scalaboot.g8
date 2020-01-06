import Dependencies._

ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "$scalaVersion$"
ThisBuild / description  := "$description$"

lazy val root = (project in file(".")).
  settings(
    name := "$name;format="lower,hyphen"$",
    libraryDependencies ++= Seq(
      akkaHttp,
      akkaStreams,
      scalaLogging,
      logback,
      akkaCirce,
      circeGeneric,
      scalaTest % Test
    )
  )
