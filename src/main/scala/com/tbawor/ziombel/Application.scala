package com.tbawor.ziombel

import java.io.IOException

import zio.{App, ZIO}
import zio.console._

object Application extends App {

  override def run(args: List[String]): ZIO[zio.ZEnv, Nothing, Int] =
    myAppLogic.fold(_ => 1, _ => 0)

  val myAppLogic: ZIO[Console, IOException, Unit] = for {
    _ <- putStrLn("Hello, what is your name?")
    name <- getStrLn
    _ <- putStrLn(s"Hello $name")
  } yield ()
}
