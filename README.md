# ontoplay-java-seed.g8

Giter8 template for generating a Play project using [OntoPlay](https://github.com/mdrozdo/OntoPlay) in Java.

This template is built on the default [play-java-seed.g8 template](https://github.com/playframework/play-java-seed.g8).

## Running

If you want to create a project, run:

```
sbt new mdrozdo/ontoplay-java-seed.g8

```

Then cd into the generated project folder and fetch the ontoplay module:

```
sbt getOntoPlay
sbt run
```

## Scaffolding 

Type `g8Scaffold form` from sbt to create the scaffold controller, template and tests needed to process a form.
