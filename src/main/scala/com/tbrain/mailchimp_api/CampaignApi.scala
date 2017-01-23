package com.tbrain.mailchimp_api

import com.tbrain.mailchimp_api.json_objects._
import com.tbrain.mailchimp_api.rest_request._
import MailchimpJsonProtocol._
import spray.json._

/**
  * Created by stanislav on 18.01.17.
  */
trait CampaignApi {
  this: MailChimpApi =>

  def getCampaigns: Seq[Campaign] = {
    createRequest("/campaigns").execute.tryParseJson[CampaignArray].campaigns
  }

  def getCampaign(campaign_id: String): Campaign = {
    createRequest("/campaigns/<campaign_id>", Map("campaign_id" -> campaign_id)).execute.tryParseJson[Campaign]
  }

  def addCampaign(campaign: Campaign): Campaign = {
    createRequest("/campaigns", Map(), "POST", campaign.toJson)
      .execute.tryParseJson[Campaign]
  }

  def setCampaignContent(campaign: Campaign, content: String) {
    createRequest("/campaigns/<campaign_id>/content", Map("campaign_id" -> campaign.id.orNull), "PUT",
      CampaignContent(content).toJson).execute
  }

  def updateCampaign(campaign: Campaign): Campaign = {
    createRequest("/campaigns/<campaign_id>", Map("campaign_id" -> campaign.id.orNull), "PATCH", campaign.toJson)
      .execute.tryParseJson[Campaign]
  }

  def deleteCampaign(campaign: Campaign) {
    createRequest("/campaigns/<campaign_id>", Map("campaign_id" -> campaign.id.orNull), "DELETE").execute
  }

  def sendCampaign(campaign: Campaign) {
    createRequest("/campaigns/<campaign_id>/actions/send", Map("campaign_id" -> campaign.id.orNull), "POST").execute
  }

}
