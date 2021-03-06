import Dependencies._
import sbtrelease.ReleaseStateTransformations._

ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "$scalaVersion$"
ThisBuild / description  := "$desc$"

Global / onChangedBuildSource := ReloadOnSourceChanges

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

releaseProcess := Seq[ReleaseStep](
    checkSnapshotDependencies,
    inquireVersions,
    runTest,
    setReleaseVersion,
    // publishArtifacts,
    commitReleaseVersion,
    tagRelease, 
    inquireVersions, 
    setNextVersion, 
    commitNextVersion, 
    pushChanges  
  )