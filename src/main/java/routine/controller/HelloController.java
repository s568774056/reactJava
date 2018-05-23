package routine.controller;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private String mUrl = " http://bn8iyt.natappfree.cc/pages/user/login";

    @GetMapping(value = "/test2")
    public String weChat(@RequestParam(value = "signature") String signature,
                         @RequestParam(value = "timestamp") String timestamp, @RequestParam(value = "nonce") String nonce, @RequestParam(value = "echostr") String echostr) {
        return echostr;
    }

    /**
     * 处理微信服务器发来的消息
     */
    @PostMapping(value = "/test")
    @ResponseBody
    protected String weixin(HttpServletRequest request, HttpServletResponse response) {
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");
        System.out.println("请求进入,域名为："+request.getServerName());
        Map<String, String> map = new HashMap<String, String>();

        try {
            //解析微信发来的请求,将解析后的结果封装成Map返回


            // 从request中取得输入流
            InputStream inputStream = request.getInputStream();
            // 读取输入流
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            // 得到xml根元素
            Element root = document.getRootElement();
            // 得到根元素的所有子节点
            List<Element> elementList = root.elements();

            for (Element e : elementList) {
                map.put(e.getName(), e.getText());
                System.out.println("内容：" + "[Name()]" + e.getName() + "【Text()】" + e.getText());
            }
            // 释放资源
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("发生异常：" + e.getMessage());
        }
        //   sendMessage(map);
        return "<xml><Articles><item>" +
                "<Description>zzxz" +
                "</Description><Title>oBbKy05Yir</Title>" +
                "<PicUrl>" +
                "http://img.zcool.cn/community/010a1b554c01d1000001bf72a68b37.jpg@1280w_1l_2o_100sh.png" +
                "</PicUrl>" +
                "<Url>" +
                mUrl +
                "</Url>" +
                "</item></Articles><CreateTime>1522406880</CreateTime><ArticleCount>1</ArticleCount><ToUserName>" +
                map.get("FromUserName")+
                "</ToUserName><FromUserName>"+
                map.get("ToUserName")+
                "</FromUserName><MsgType>news</MsgType></xml>";
    }

  /*  private void sendMessage(Map map){
        String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+ WechatUtil.getToken();
        System.out.println("sendMessage()........................................................." );
        HttpClientUtil.https(url,"post"," {" +
                "           \"touser\":"+map.get("FromUserName")+"," +
                "           \"template_id\":\"xkhqYzFF_LLi03n5j1UHaw_erzCzDkuviy727aHFWlk\"," +
                "           \"url\":\"http://weixin.qq.com/download\",  " +
                "           \"miniprogram\":,          " +
                "           \"data\":{" +
                "                   \"first\": {" +
                "                       \"value\":\"恭喜你购买成功巧克力！\"," +
                "                       \"color\":\"#173177\"" +
                "                   }," +
                "                   \"keyword1\":{" +
                "                       \"value\":\"巧克力\"," +
                "                       \"color\":\"#173177\"" +
                "                   }," +
                "                   \"remark\":{\n" +
                "                       \"value\":\"欢迎再次购买！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }");
    }*/
}
