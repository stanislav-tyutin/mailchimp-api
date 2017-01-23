package com.tbrain.mailchimp_api.rest_request

/**
  * Created by stanislav on 16.01.17.
  */

import scalaj.http.HttpResponse
import spray.json._
import com.tbrain.mailchimp_api.json_objects._

case class RestResponse(source: HttpResponse[String]) {

  def getCode: Integer = source.code

  def getBody: String = source.body

  println(getBody)

  def tryParseJson(): JsObject = {
    try {
      val parsed = getBody.parseJson.asJsObject
      parsed
    }
    catch {
      case e: JsonParser.ParsingException => null
    }
  }

  def tryParseJson[T: JsonReader]: T = {
    try {
      val parsed = getBody.parseJson.asJsObject.convertTo[T]
      parsed
    }
    catch {
      case e: JsonParser.ParsingException => null.asInstanceOf[T]
    }
  }

}
