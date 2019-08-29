package com.unity.wabao.user.mobilecheck;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Response;

import org.springframework.stereotype.Controller;

import com.unity.wabao.user.utils.ResponseCode;

import net.sf.json.JSONObject;
 
//短信API验证开始
public class MoblieCheckUtil {
	public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
    
    
    //配置申请的key,在申请成功接口值后会在接口的上面有这个key
    public static final String APPKEY ="05fda9e20aa5337c6e0023e3308e6da8";
    
    private static String randomCode;	
    
    /**
     * 设置一个静态方法来访问randomCode，因为这个randomCode是private的，设置set方法才能访问
     */
    public static String getRandomCode(){
    	return randomCode;
    }
    
    //生成一个随机的从1-9的六位数
    
    public static String randomData(){
    	StringBuilder builder = new StringBuilder();
    	for(int i=0;i<6;i++){
    		int random = (int)((Math.random()*9+1));
    		builder.append(random);
    	}
    	String randomDataa = builder.toString();
		return randomDataa;
    	
    } 
    
    
    //.发送短信
    public static String getRequest2(String tel){
        String result =null;
        String randomcode = randomData();		//调用生成随机数的方法
        String url ="http://v.juhe.cn/sms/send";//请求接口地址
        Map<String, Object> params = new HashMap();//请求参数
            params.put("mobile",tel);//接收短信的手机号码
            params.put("tpl_id","182821");//短信模板ID，请参考个人中心短信模板设置
            params.put("tpl_value","%23code%23%3d"+randomcode);//变量名和变量值对。如果你的变量名或者变量值中带有#&=中的任意一个特殊符号，请先分别进行urlencode编码后再传递，<a href="http://www.juhe.cn/news/index/id/50" target="_blank">详细说明></a>
            params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
            params.put("dtype","json");//返回数据的格式,xml或json，默认json
 
        try {
            result =net(url, params, "GET");
            System.out.println(result);
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
                System.out.println(ResponseCode.SUCCESS.getCode());
                
                //如果成功,将全局变量中的randomCode赋值成这个随机数
                randomCode = randomcode;
               return ResponseCode.SUCCESS.getCode();
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
                System.out.println(ResponseCode.ERROR.getCode());
                return ResponseCode.ERROR.getCode();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return "0";
    }
    
    
    
    
    
    
    public static String net(String strUrl, Map params,String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if(method==null || method.equals("GET")){
                strUrl = strUrl+"?"+urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if(method==null || method.equals("GET")){
                conn.setRequestMethod("GET");
            }else{
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params!= null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                        out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }
 
    //将map型转为请求参数型
    public static String urlencode(Map<String,Object>data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    
    
}
