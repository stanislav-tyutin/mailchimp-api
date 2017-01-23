package com.tbrain.mailchimp_api.rest_request

/**
  * Created by stanislav on 16.01.17.
  */

import scalaj.http._

class RestRequest(val authType: String, val authValue: String, val endPoint: String,
                  val requestPath: String, val requestMethod: String,
                  val requestData: Map[String, String], val requestBody: String) {

  def execute: RestResponse = {
    var request = Http(getRestPath)
    authType match {
      case "OAuth" => request = request.header("Authorization", "OAuth " + authValue)
      case "ApiKey" => request = request.auth("api", authValue)
    }
    if (List("POST", "PUT", "PATCH").contains(requestMethod)) {
      request = request.postData(requestBody)
    }
    request = request.method(requestMethod.toUpperCase())
    RestResponse(request.asString)
  }

  private def getRestPath: String = {
    var resultPath = requestPath
    requestData.foreach { case (k, v) => resultPath = resultPath.replaceAll("<" + k + ">", v) }
    endPoint + resultPath
  }
}

