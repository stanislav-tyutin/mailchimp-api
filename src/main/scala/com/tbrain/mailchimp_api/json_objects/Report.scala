package com.tbrain.mailchimp_api.json_objects

/**
  * Created by stanislav on 18.01.17.
  */
case class Report(id: String, campaign_title: Option[String], list_id: String, list_name: Option[String],
                  subject_line: Option[String], emails_sent: Option[Int], abuse_reports: Option[Int],
                  unsubscribed: Option[Int], send_time: Option[String], rss_last_send: Option[String],
                  bounces: Option[ReportBounces], forwards: Option[ReportForwards],
                  opens: Option[ReportOpens], clicks: Option[ReportClicks]) {}

case class ReportArray(reports: Seq[Report]) {}

case class ReportBounces(hard_bounces: Option[Int], soft_bounces: Option[Int], syntax_error: Option[Int]) {}

case class ReportForwards(forwards_count: Option[Int], forwards_opens: Option[Int]) {}

case class ReportOpens(opens_total: Option[Int], unique_opens: Option[Int],
                       open_rate: Option[Double], last_open: Option[String]) {}

case class ReportClicks(clicks_total: Option[Int], unique_clicks: Option[Int], unique_subscriber_clicks: Option[Int],
                        click_rate: Option[Double], last_click: Option[String]) {}