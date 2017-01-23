package com.tbrain.mailchimp_api.json_objects

/**
  * Created by stanislav on 17.01.17.
  */
case class AuthResult(access_token: String = null, error: String = null) {
  def success: Boolean = access_token != null

  private var apiEndPoint: String = _

  def setApiEndPoint(value: String) {
    apiEndPoint = value
  }

  def getApiEndPoint: String = apiEndPoint

  def getAccessToken: String = access_token
}
