package com.tbrain.mailchimp_api.json_objects

import java.security.MessageDigest

/**
  * Created by stanislav on 19.01.17.
  */
case class MailingListMember(email_address: String, status: String) {
  def hash: String = {
    val md5 = MessageDigest.getInstance("MD5")
    val bytes = email_address.toLowerCase.getBytes
    md5.update(bytes,0, bytes.length)
    BigInt(1, md5.digest()).toString(16)
  }
}

case class MailingListMemberArray(members: Seq[MailingListMember]) {}