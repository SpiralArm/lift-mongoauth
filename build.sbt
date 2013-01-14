name := "mongoauth"

version := "2.5-M4-0.4"

organization := "net.liftmodules"

scalaVersion := "2.9.1"

crossScalaVersions := Seq("2.10.0", "2.9.1", "2.9.2")

libraryDependencies <++= (scalaVersion) { scalaVersion =>
  val liftVersion = "2.5-M4"
  Seq(
    "net.liftweb" %% "lift-mongodb-record" % liftVersion % "compile",
    "ch.qos.logback" % "logback-classic" % "1.0.3" % "provided",
    "org.scalatest" %% "scalatest" % "1.9.1" % "test",
    "org.mindrot" % "jbcrypt" % "0.3m" % "compile"
  )
}

scalacOptions ++= Seq("-deprecation", "-unchecked")

publishTo := Some("idtp repository" at "https://repository-idtp.forge.cloudbees.com/release/")

// NB: CloudBees requires the repository to have the directory structure created
// E.g., if you get "permission denied" it may be just that you need to do something
// like: 
// - mount the repository (Apple+K in Finder, and ender the https url; sign in with
//   you username -- not email -- as shown to you in Cloudbees Repositories page)
// - mkdir -p /Volumes/release/net/liftmodules/mongoauth_2.9.1/2.4-0.4

credentials += Credentials( file("/private/idtp/cloudbees.credentials") )

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
        <url>https://github.com/SpiralArm/lift-mongoauth</url>
        <licenses>
              <license>
              <name>Apache 2.0 License</name>
              <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
              <distribution>repo</distribution>
            </license>
         </licenses>
         <scm>
            <url>git@github.com:SpiralArm/lift-mongoauth.git</url>
            <connection>scm:git:ggit@github.com:SpiralArm/lift-mongoauth.git</connection>
         </scm>
         <developers>
          <developer>
              <id>eltimn</id>
              <name>Tim Nelson</name>
              <url>http://eltimn.com/</url>
          </developer>
          <developer>
              <id>jonoabroad</id>
              <name>Jonathan Fergusin</name>
              <url>https://github.com/jonoabroad</url>
          </developer>
          <developer>
              <id>d6y</id>
              <name>Richard Dallaway</name>
              <url>http://richard.dallaway.com</url>
          </developer>
         </developers> 
 )
  
