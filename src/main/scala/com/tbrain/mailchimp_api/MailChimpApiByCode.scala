package com.tbrain.mailchimp_api

/**
  * Created by stanislav on 18.01.17.
  */
object MailChimpApiByCode {
  def apply(code: String, client_id: String, client_secret: String, redirectUri: String): MailChimpApi = {
    val authResult = new Auth(code, client_id, client_secret, redirectUri).auth
    new MailChimpApi("OAuth", authResult.getAccessToken, authResult.getApiEndPoint)
  }
}
