package com.example.demo01.scala

import java.io.InputStream

import javax.annotation.Resource
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import lombok.extern.slf4j.Slf4j
import org.apache.commons.io.{FileUtils, IOUtils}
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
class HellController @Resource()(val request: HttpServletRequest, val resp: HttpServletResponse) {
  //TODO 获取request
  //  TODO 日志记录器
  val log = LoggerFactory.getLogger(getClass)

  @RequestMapping(value = Array("hello"))
  def hello(): String = {
    log.info("saveArticle：{}", "scala")
    "hello ,scala"
  }

  /**
   * 打成jar需要通过 流的方式读取文件
   *
   * @param ids
   * @param response
   * @return
   */
  @RequestMapping(Array("schel2/{ids}"))
  @ResponseBody
  def howHel2(@PathVariable ids: String, response: HttpServletResponse): Any = {
    println(s"scala 例子${new DateTime().toString("yyyy-MM-dd-HH:mm:ss")}")
    val classLoader = Thread.currentThread().getContextClassLoader
    val readLines = IOUtils.readLines(classLoader.getResourceAsStream("pic/CHD.txt"), "UTF-8").toArray()
    for (elem <- readLines) {
      println(elem)
    }
    //TODO SpringBoot 获取资源文件路劲|https://blog.csdn.net/napoay/article/details/81048724|
    // 打成jar包获取文件有问题(https://blog.csdn.net/cscscssjsp/article/details/84822706)
    val stream: InputStream = classLoader.getResourceAsStream(s"pic/${ids}.jpg")
    IOUtils.copy(stream, response.getOutputStream)
  }

  /**
   * 打包时 配置文件分开 这样也可获取资源路劲
   *
   * @param ids
   */
  @RequestMapping(Array("showpic/{ids}"))
  def showPicByIds(@PathVariable ids: String, resp: HttpServletResponse): Unit = {
    //TODO 打包后有个单独的config存放 文件
    import org.springframework.core.io.ClassPathResource
    val resource = new ClassPathResource(s"pic/${ids}.jpg")
    IOUtils.copy(FileUtils.openInputStream(resource.getFile()), resp.getOutputStream)
  }


  @RequestMapping(value = Array("schel"))
  @ResponseBody
  def howHel(): String = {
    log.info("当前时间是{}", new DateTime().toString("yyyy-MM-dd-HH:mm:ss"))
    s"scala 例子${new DateTime().toString("yyyy-MM-dd-HH:mm:ss")} "
  }

}


