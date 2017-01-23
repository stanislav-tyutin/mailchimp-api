package com.tbrain.mailchimp_api

import com.tbrain.mailchimp_api.json_objects._
import com.tbrain.mailchimp_api.rest_request._
import MailchimpJsonProtocol._
import spray.json._

/**
  * Created by stanislav on 18.01.17.
  */
trait ListsApi {
  this: MailChimpApi =>

  def getLists: Seq[MailingList] = {
    createRequest("/lists").execute.tryParseJson[MailingListArray].lists
  }

  def getList(listId: String): MailingList = {
    createRequest("/lists/<list_id>", Map("list_id" -> listId)).execute.tryParseJson[MailingList]
  }

  def addList(list: MailingList): MailingList = {
    createRequest("/lists", Map(), "POST", list.toJson).execute.tryParseJson[MailingList]
  }

  def updateList(list: MailingList): MailingList = {
    createRequest("/lists/<list_id>", Map("list_id" -> list.id.orNull), "PATCH", list.toJson).execute.tryParseJson[MailingList]
  }

  def deleteList(list:MailingList) {
    createRequest("/lists/<list_id>", Map("list_id" -> list.id.orNull), "DELETE").execute
  }

  def getListMembers(listId: String): Seq[MailingListMember] = {
    createRequest("/lists/<list_id>/members", Map("list_id" -> listId)).execute.
      tryParseJson[MailingListMemberArray].members
  }

  def getListMembers(list: MailingList): Seq[MailingListMember] = {
    getListMembers(list.id.orNull)
  }

  def addListMember(list: MailingList, obj: MailingListMember): MailingListMember = {
    createRequest("/lists/<list_id>/members", Map("list_id" -> list.id.orNull), "POST", obj.toJson).execute
      .tryParseJson[MailingListMember]
  }

  def deleteListMember(list: MailingList, obj: MailingListMember) {
    createRequest("/lists/<list_id>/members/<member_hash>",
      Map("list_id" -> list.id.orNull, "member_hash" -> obj.hash), "DELETE").execute
  }
}
