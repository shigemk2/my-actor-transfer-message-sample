package com.example

import akka.actor.Actor
import akka.event.Logging

class MyActor2 extends Actor {
  val log = Logging(context.system, this)

  def receive = {
    case "You are Lucky!" => {
      log.info("test")
    }

    case s: String => {
      log.info(s)
      // senderはメッセージの送り主のアクターを参照するものだから、メッセージの送り主のアクターがなかったらdead letter
      // sender ! "You are lucky!"
      log.info(sender.toString)

    }
    case _ => {
    }
  }

}
