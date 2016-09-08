package com.example

import akka.actor.Actor
import akka.event.Logging

class MyActor2 extends Actor {
  val log = Logging(context.system, this)

  def receive = {
    case s: String => {
      log.info(s)
      // senderはメッセージの送り主のアクターを参照するものだから、メッセージの送り主のアクターがなかったらdead letter
      log.info(sender.toString)
    }
    case _ => {
    }
  }

}
