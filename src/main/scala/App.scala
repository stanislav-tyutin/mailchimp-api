/**
  * Created by stanislav on 16.01.17.
  */

import com.tbrain.mailchimp_api._
import com.tbrain.mailchimp_api.json_objects.MailchimpJsonProtocol._
import com.tbrain.mailchimp_api.json_objects._
import spray.json._

object App {
  def main(args: Array[String]): Unit = {

    //    val obj = MailChimpApiByApiKey("7617479fbbff034b324462b2779b954a-us14")

    val obj = MailChimpApiByAccessToken("2c0367a035990b7b195c46a6cf758722")

    //    val code = readLine()
    //    val obj = MailChimpApiByCode(client_id = "469054286787", client_secret = "7e9ebde81ed4b2d8c48ad627de8e2271",
    //         redirectUri = "http://127.0.0.1/callback", code = code)

    //    val new_member = MailingListMember("test@tbrain.ru", Option(null), "subscribed")

    //val l = obj.getList("20b2645978") //Members("a82824389d")
    //    val m = obj.getListMembers("a82824389d").last
    //
    //    obj.deleteListMember(l,m)

    //    val m_list = MailingList(Option(null), "API",
    //      Contact("Tst com", "null addr", "VRN", "VOR", "394000", "RU"),
    //      "Mailing List",
    //      MailingListCampaignDefaults("TBrain", "api@tbrain.ru", "Test mail", "Russian"),
    //      true)

    //    obj.addList(m_list)

    // 20b2645978
    //    val member = MailingListMember("tyutin2@tbrain.ru", "subscribed")
    //    obj.addListMember(l, member)


//    val cam = Campaign(Option(null), "plaintext", CampaignRecipients("20b2645978"),
//      CampaignSettings("Test mail", "Test mail", "TBrain", "robot@tbrain.ru"))

    val cam = obj.getCampaigns.last
//    obj.setCampaignContent(cam, "Tro lo lo")
    obj.sendCampaign(cam)

//    obj.addCampaign(cam)

    //    println(l)
//    println(cam)

    //    2c0367a035990b7b195c46a6cf758722


    //    val obj = new MailChimpApi(client_id = "469054286787", client_secret = "7e9ebde81ed4b2d8c48ad627de8e2271",
    //      redirectUri = "http://127.0.0.1/callback", code = code)

    //    val obj = new MailChimpApi("7617479fbbff034b324462b2779b954a-us147617479fbbff034b324462b2779b954a-us14")

    //    https://login.mailchimp.com/oauth2/authorize?response_type=code&client_id=469054286787&redirect_uri=http%3A%2F%2F127.0.0.1
  }
}
