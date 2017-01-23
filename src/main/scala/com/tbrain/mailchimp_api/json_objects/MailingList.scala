package com.tbrain.mailchimp_api.json_objects

/**
  * Created by stanislav on 18.01.17.
  */
//case class MailingList(id: String, name: String, contact: Contact,
//                       permission_reminder: String,
//                       use_archive_base: Option[Boolean],
//                       campaign_defaults: MailingListCampaignDefaults,
//                       notify_on_subscribe: Option[String],
//                       notify_on_unsubscribe: Option[String],
//                       date_created: Option[String],
//                       list_rating: Option[Int],
//                       email_type_option: Boolean,
//                       subscribe_url_short: Option[String],
//                       subscribe_url_long: Option[String],
//                       beamer_address: Option[String],
//                       visiblity: Option[String]) {}

case class MailingList(id: Option[String], name: String, contact: Contact,
                       permission_reminder: String,
                       campaign_defaults: MailingListCampaignDefaults,
                       email_type_option: Boolean) {}

case class MailingListCampaignDefaults(from_name: String, from_email: String, subject: String, language: String) {}

case class MailingListArray(lists: Seq[MailingList]) {}