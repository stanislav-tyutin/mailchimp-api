package com.tbrain.mailchimp_api

import com.tbrain.mailchimp_api.json_objects._
import com.tbrain.mailchimp_api.rest_request._
import MailchimpJsonProtocol._

/**
  * Created by stanislav on 18.01.17.
  */
trait ReportApi {
  this: MailChimpApi =>

  def getReports: Seq[Report] = {
    createRequest("/reports").execute.tryParseJson[ReportArray].reports
  }

  def getReport(campaign_id: String): Report = {
    createRequest("/reports/<campaign_id>", Map("campaign_id" -> campaign_id)).execute.tryParseJson[Report]
  }

}
