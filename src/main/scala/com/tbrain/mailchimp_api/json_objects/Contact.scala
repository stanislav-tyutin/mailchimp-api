package com.tbrain.mailchimp_api.json_objects

/**
  * Created by stanislav on 18.01.17.
  */
//case class Contact(company: String, address1: Option[String], address2: Option[String], city: String, state: String,
//                   zip: String, phone: Option[String]) {
//
//}


case class Contact(company: String, address1: String, city: String, state: String, zip: String, country: String) {

}
