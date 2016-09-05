package com.example

import akka.actor.{ActorSystem, Props}

object Hello {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("mySystem")

    // アクターの生成
    val props = Props[MyActor]
    val actor = system.actorOf(props, name = "myActor")

    // メッセージを送信
    actor ! "hi"
    Thread.sleep(1000)

    // 終了
    system.terminate
  }
}
