package com.example

import akka.actor.{Actor, Props}
import akka.event.Logging

class MyActor extends Actor {
  val log = Logging(context.system, this)

  val child = context.actorOf(Props[MyActor2], name = "myChild")

  def receive = {
    case s: String => {
      log.info(s)
      child.forward(s) // 転送
      child ! s // コピー送信
    }
    case _ => {
    }
  }
}
