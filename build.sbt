organization := "tv.cntt"

name := "xitrum-swagger"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.2"
//scalaVersion := "2.10.4"

crossScalaVersions := Seq("2.11.2", "2.10.4")

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")

// Xitrum 3.2+ requires Java 7
javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

// Most Scala projects are published to Sonatype, but Sonatype is not default
// and it takes several hours to sync from Sonatype to Maven Central
resolvers += "SonatypeReleases" at "http://oss.sonatype.org/content/repositories/releases/"

libraryDependencies += "tv.cntt" %% "xitrum" % "3.18-SNAPSHOT" % "provided"

libraryDependencies += "org.webjars" % "swagger-ui" % "2.0.21"

//------------------------------------------------------------------------------

// Skip API doc generation to speedup "publish-local" while developing.
// Comment out this line when publishing to Sonatype.
publishArtifact in (Compile, packageDoc) := false
