package com.tbrain.mailchimp_api

/**
  * Created by stanislav on 18.01.17.
  */
object MailChimpApiByAccessToken {
  def apply(accessToken: String): MailChimpApi = {
    val endPoint = Auth.getEndPoint(Auth.requestMetadata(accessToken))
    new MailChimpApi("OAuth", accessToken, endPoint)
  }
}
