name := "uap-scala"
organization := "org.uaparser"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-unchecked",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Xfuture"
)

scalaVersion := "2.11.11"
crossScalaVersions := Seq("2.10.6", "2.11.11", "2.12.2")

libraryDependencies ++= Seq(
  "org.yaml" % "snakeyaml" % "1.18",
  "org.specs2" %% "specs2-core" % "2.4.17" % "test"
)

mimaPreviousArtifacts := Set("org.uaparser" %% "uap-scala" % "0.1.0")

unmanagedResourceDirectories in Compile += baseDirectory.value / "core"
includeFilter in (Compile, unmanagedResources) := "regexes.yaml"
unmanagedResourceDirectories in Test += baseDirectory.value / "core"
includeFilter in (Test, unmanagedResources) := "*.yaml"

// Publishing
publishMavenStyle := true
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}
publishArtifact in Test := false
releaseCrossBuild := true
releasePublishArtifactsAction := PgpKeys.publishSigned.value

pomExtra := (
  <url>https://github.com/ua-parser/uap-scala</url>
  <licenses>
      <license>
        <name>WTFPL</name>
        <url>http://www.wtfpl.net/about</url>
        <distribution>repo</distribution>
      </license>
  </licenses>
  <scm>
    <url>git@github.com:ua-parser/uap-scala.git</url>
    <connection>scm:git:git@github.com:ua-parser/uap-scala.git</connection>
  </scm>
  <developers>
    <developer>
      <id>mcveat</id>
      <name>Piotr Adamski</name>
      <url>https://twitter.com/mcveat</url>
    </developer>
    <developer>
      <id>humanzz</id>
      <name>Ahmed Sobhi</name>
      <url>https://twitter.com/humanzz</url>
    </developer>
  </developers>)
