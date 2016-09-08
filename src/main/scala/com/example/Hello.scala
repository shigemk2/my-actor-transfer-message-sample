package com.example

import akka.actor.{ActorSystem, Props}

object Hello {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("mySystem")

    // アクターの生成
    val props = Props[MyActor]
    val actor = system.actorOf(props, name = "myActor")
    // アクターの生成
    val props2 = Props[MyActor2]
    val actor2 = system.actorOf(props2, name = "myActor2")

    // メッセージを送信
    actor ! "hi"
    Thread.sleep(1000)
    actor2 ! "high"
    Thread.sleep(1000)

    // 終了
    system.terminate
  }
}
