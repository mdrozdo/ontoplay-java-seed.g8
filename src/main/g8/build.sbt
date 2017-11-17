name := """$name$"""
organization := "$organization$"

version := "1.0-SNAPSHOT"

lazy val module = (project in file("ontoplay"))
  .enablePlugins(PlayJava)

lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .aggregate(module)
  .dependsOn(module)

scalaVersion := "2.11.11"

libraryDependencies += filters

lazy val getOntoPlay = TaskKey[Unit]("getOntoPlay", "Download the OntoPlay release and extract it to ./ontoplay", KeyRanks.ATask)

getOntoPlay := {
		val tempDir = IO.createTemporaryDirectory
    IO.unzipURL(new URL("https://github.com/mdrozdo/ontoplay/archive/$ontoplay_branch$.zip"), tempDir)
    val files: Seq[File] = ((tempDir / "OntoPlay-$ontoplay_branch$") ** "*").get
    val baseDirectories: Seq[File] = (tempDir / "OntoPlay-$ontoplay_branch$") :: Nil
		val newBase: File = file("ontoplay")
		val mappings: Seq[(File,File)] = files pair rebase(baseDirectories, newBase)
		IO.copy(mappings)
	}
