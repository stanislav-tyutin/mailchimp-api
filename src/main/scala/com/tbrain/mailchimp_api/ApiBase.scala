package com.tbrain.mailchimp_api

import com.tbrain.mailchimp_api.json_objects._
import com.tbrain.mailchimp_api.rest_request._
import MailchimpJsonProtocol._
import spray.json._

/**
  * Created by stanislav on 18.01.17.
  */
trait ApiBase {
  this: MailChimpApi =>

  def createRequest(requestPath: String, requestData: Map[String, String] = Map(),
                    requestMethod: String = "GET", requestObject: JsValue = null): RestRequest = {

    val requestString = if (requestObject == null) "" else requestObject.toString

    new RestRequest(authType, authValue, endPoint, requestPath, requestMethod, requestData, requestString)
  }

  def testRequest() {
    println(createRequest("/").execute.getBody)
  }

  def getAccountDetails: AccountDetails = {
    createRequest("/").execute.tryParseJson[AccountDetails]
  }
}
