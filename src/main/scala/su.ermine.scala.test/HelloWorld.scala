package su.ermine.scala.test

import java.io.{FileNotFoundException, IOException}

import scala.io.Source

object HelloWorld {
  def main(args: Array[String]): Unit = {
    print("Please, enter your name: ")
    val name = scala.io.StdIn.readLine()

    println(s"Hello, $name")

    printIntroduction()
    enterCommand()
  }

  def printIntroduction(): Unit = {
    val filename = "intro.txt"
    val file = Source.fromFile(filename)
    try {
      for (line <- file.getLines) {
        println(line)
      }
    } catch {
      case e: FileNotFoundException => println("Couldn't find that file.")
      case e: IOException => println("Got an IOException!")
    } finally {
      file.close()
    }
  }

  def enterCommand(): Unit = {
    print("Command: ")
    val cmd = scala.io.StdIn.readLine()

    println(s"Command $cmd has been added")
  }
}
