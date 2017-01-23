package com.tbrain.mailchimp_api

/**
  * Created by stanislav on 18.01.17.
  */
object MailChimpApiByApiKey {
  def apply(apiKey: String): MailChimpApi = {
    val endPoint = "https://" + apiKey.split("-").last + ".api.mailchimp.com/3.0"
    new MailChimpApi("ApiKey", apiKey, endPoint)
  }
}
