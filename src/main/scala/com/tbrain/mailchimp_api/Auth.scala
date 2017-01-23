package com.tbrain.mailchimp_api

/**
  * Created by stanislav on 16.01.17.
  */

import com.tbrain.mailchimp_api.json_objects._
import MailchimpJsonProtocol._

import scalaj.http._
import scalaj.http.Http
import spray.json._

class Auth(code: String, client_id: String, client_secret: String, redirectUri: String) {

  List(code, client_id, client_secret, redirectUri)
    .foreach((el: String) => if (el == null || el.length == 0) {
      throw new IllegalArgumentException("Empty argument")
    })

  def auth: AuthResult = {

    val response = Http("https://login.mailchimp.com/oauth2/token")
      .postData(Seq("grant_type" -> "authorization_code", "client_id" -> client_id,
        "client_secret" -> client_secret, "redirect_uri" -> encodeUrl(redirectUri),
        "code" -> code).map(t => t._1 + "=" + t._2).mkString("&"))
      .asString.body

    val authResult = response.parseJson.convertTo[AuthResult]

    if (authResult.success) {
      val metadata = Auth.requestMetadata(authResult.access_token)
      authResult.setApiEndPoint(Auth.getEndPoint(metadata))
      return authResult
    }

    throw new RuntimeException("Error in getting access token")
  }

  def encodeUrl(url: String): String = {
    java.net.URLEncoder.encode(url, "UTF-8")
  }
}

object Auth {
  def requestMetadata(access_token: String): OAuthMetadata = {
    Http("https://login.mailchimp.com/oauth2/metadata")
      .header("Authorization", "OAuth " + access_token).asString.body.parseJson.asJsObject.convertTo[OAuthMetadata]
  }

  def getEndPoint(metadata: OAuthMetadata): String = {
    "https://" + metadata.getDc + ".api.mailchimp.com/3.0"
  }
}