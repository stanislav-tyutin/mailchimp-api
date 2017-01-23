package com.tbrain.mailchimp_api.json_objects

/**
  * Created by stanislav on 18.01.17.
  */
case class OAuthMetadata(dc: String, login_url: String, api_endpoint: String) {
  def getApiEndPoint: String = api_endpoint
  def getDc:String = dc
}
