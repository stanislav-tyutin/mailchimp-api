package com.tbrain.mailchimp_api.json_objects

/**
  * Created by stanislav on 18.01.17.
  */
case class Campaign(id: Option[String], `type`: String, recipients: CampaignRecipients, settings: CampaignSettings) {}

case class CampaignRecipients(list_id: String) {}

case class CampaignSettings(subject_line: String, title: String, from_name: String, reply_to: String) {}

case class CampaignArray(campaigns: Seq[Campaign]) {}

case class CampaignContent(plain_text: String){}