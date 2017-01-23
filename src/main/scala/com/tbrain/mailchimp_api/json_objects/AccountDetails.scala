package com.tbrain.mailchimp_api.json_objects

/**
  * Created by stanislav on 18.01.17.
  */
case class AccountDetails(account_id: String, account_name: String, email: String, username: String, contact: Contact,
                          role: String, pro_enabled: Boolean, last_login: String, total_subscribers: Int) {}
