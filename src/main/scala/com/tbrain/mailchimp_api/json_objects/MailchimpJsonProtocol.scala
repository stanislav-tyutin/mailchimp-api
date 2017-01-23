package com.tbrain.mailchimp_api.json_objects

import spray.json._
import DefaultJsonProtocol._

/**
  * Created by stanislav on 17.01.17.
  */
object MailchimpJsonProtocol extends DefaultJsonProtocol {

  implicit object authResultFormat extends RootJsonFormat[AuthResult] {
    def write(source: AuthResult) = null

    def read(value: JsValue): AuthResult = {
      val fields = value.asJsObject.fields

      val access_token = fields.get("access_token").fold(null.asInstanceOf[String])(_.convertTo[String])
      val error = fields.get("error").fold(null.asInstanceOf[String])(_.convertTo[String])

      AuthResult(access_token, error)
    }
  }

  implicit val oauthMetadataFormat = jsonFormat3(OAuthMetadata)
  implicit val contactFormat = jsonFormat6(Contact)
  implicit val accountDetailsFormat = jsonFormat9(AccountDetails)

  implicit val mailingListCampaignDefaultsFormat = jsonFormat4(MailingListCampaignDefaults)
  //  implicit val mailingListFormat = jsonFormat15(MailingList)
  implicit val mailingListFormat = jsonFormat6(MailingList)
  implicit val mailingListArrayFormat = jsonFormat1(MailingListArray)

  implicit val campaignRecipientsFormat = jsonFormat1(CampaignRecipients)
  implicit val campaignSettingsFormat = jsonFormat4(CampaignSettings)
  implicit val campaignFormat = jsonFormat4(Campaign)
  implicit val campaignArrayFormat = jsonFormat1(CampaignArray)
  implicit val campaignContentFormat = jsonFormat1(CampaignContent)

  implicit val reportBouncesFormat = jsonFormat3(ReportBounces)
  implicit val reportForwardsFormat = jsonFormat2(ReportForwards)
  implicit val reportOpensFormat = jsonFormat4(ReportOpens)
  implicit val reportClicksFormat = jsonFormat5(ReportClicks)
  implicit val reportFormat = jsonFormat14(Report)
  implicit val reportArrayFormat = jsonFormat1(ReportArray)

  implicit val mailingListMemberFormat = jsonFormat2(MailingListMember)
  implicit val mailingListMemberArrayFormat = jsonFormat1(MailingListMemberArray)

}
