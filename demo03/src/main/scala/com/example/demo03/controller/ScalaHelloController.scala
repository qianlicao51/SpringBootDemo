package com.example.demo03.controller

import java.io.InputStream

import javax.servlet.http.HttpServletResponse
import lombok.extern.slf4j.Slf4j
import org.apache.commons.io.IOUtils
import org.joda.time.DateTime
import org.slf4j.LoggerFactory
import org.springframework.stereotype
import org.springframework.web.bind.annotation.{PathVariable, RequestMapping, ResponseBody}

/**
 * springBoot 和scala的整合
 * https://www.jb51.net/article/157321.htm
 */
@Slf4j
@stereotype.Controller
class ScalaHelloController {
  val logger = LoggerFactory.getLogger(this.getClass)

  /**
   * 打成jar需要通过 流的方式读取文件
   *
   * @param ids
   * @param response
   * @return
   */
  @RequestMapping(Array("showpic/{ids}"))
  @ResponseBody
  def howHel2(@PathVariable ids: String, response: HttpServletResponse): Any = {
    logger.info(ids)
    println(s"scala 例子${new DateTime().toString("yyyy-MM-dd-HH:mm:ss")}")
    val classLoader = Thread.currentThread().getContextClassLoader
    val readLines = IOUtils.readLines(classLoader.getResourceAsStream("pic/CHD.txt"), "UTF-8").toArray()
    for (elem <- readLines) {
      println(elem)
    }
    val file = classLoader.getResource("").getFile
    logger.info(s"文件位置是：$file")
    //TODO SpringBoot 获取资源文件路劲|https://blog.csdn.net/napoay/article/details/81048724|
    // 打成jar包获取文件有问题(https://blog.csdn.net/cscscssjsp/article/details/84822706)
    val stream: InputStream = classLoader.getResourceAsStream(s"pic/${ids}.jpg")
    IOUtils.copy(stream, response.getOutputStream)
  }
}
