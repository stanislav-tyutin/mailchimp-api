package com.tbrain.mailchimp_api

/**
  * Created by stanislav on 16.01.17.
  */
class MailChimpApi(val authType: String, val authValue: String, val endPoint: String) extends ApiBase
  with ListsApi with CampaignApi with ReportApi{

}

