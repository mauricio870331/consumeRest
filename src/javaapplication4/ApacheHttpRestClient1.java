/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import us.monoid.json.JSONException;
import us.monoid.json.JSONObject;

/**
 *
 * @author clopez
 */
public class ApacheHttpRestClient1 {

    public static void main(String[] args) throws UnsupportedEncodingException, JSONException {
        obtener2();
    }

    public static void obtener() throws JSONException {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
            // specify the host, protocol, and port
            HttpHost target = new HttpHost("192.168.10.200", 9991, "http");

            // specify the get request
            HttpGet getRequest = new HttpGet("/SampleWS/peoples");

//            System.out.println("executing request to " + target);
            HttpResponse httpResponse = httpclient.execute(target, getRequest);
            HttpEntity entity = httpResponse.getEntity();

//            Gson gson = new Gson();
//          
//            String content = EntityUtils.toString(entity);
//            System.out.println("content " + content);
//            String json = new Gson().toJson(content);
//
//            
//            
//
//            List<Personas> yourList = gson.fromJson(json, (Class<T>) Personas.class);
//
//            yourList.forEach((personas) -> {
//                System.out.println(personas.toString());
//            });

            String[] entidades = EntityUtils.toString(entity).replace("[", "{").replace("]", "}").replace("},{", "}-{").replace("{{", "{").replace("}}", "}").split("-");
            ArrayList<JSONObject> l = new ArrayList();
            for (String entidad : entidades) {
//                System.out.println("entidade " + entidad);
                l.add(new JSONObject(entidad));
            }

//            System.out.println("----------------------------------------");
//            System.out.println(httpResponse.getStatusLine());
//            Header[] headers = httpResponse.getAllHeaders();
//            for (Header header : headers) {
//                System.out.println(header);
//            }
//            System.out.println("----------------------------------------");
            if (entity != null) {
                ArrayList<Personas> p = new ArrayList();
                for (JSONObject json : l) {
                    System.out.println("json "+json);
//                    p.add(new Personas(Integer.parseInt(json.get("id").toString()), json.get("name").toString()));
                }

                p.forEach((personas) -> {
                    System.out.println(personas.toString());
                });
            }
        } catch (IOException | ParseException e) {
            System.out.println("error " + e);
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
    }

    public static void update() throws UnsupportedEncodingException {
        /* Create object of CloseableHttpClient */
        DefaultHttpClient httpclient = new DefaultHttpClient();
//     
        try {
            HttpHost target = new HttpHost("192.168.10.200", 9990, "http");
            /* Prepare put request */
            HttpPut httpPut = new HttpPut("/SampleWS/peoples/5");
            /* Add headers to get request */
//        httpPut.addHeader("Authorization", "value");

            /* Prepare StringEntity from JSON */
            StringEntity jsonData = new StringEntity("{\"name\":\"Vick ******\"}", "UTF-8");
            /* Body of request */
            httpPut.setEntity(jsonData);
            // specify the host, protocol, and port               // specify the get request

            System.out.println("executing request to " + target);

            HttpResponse httpResponse = httpclient.execute(target, httpPut);
            HttpEntity entity = httpResponse.getEntity();

            System.out.println("----------------------------------------");
            System.out.println(httpResponse.getStatusLine());
            Header[] headers = httpResponse.getAllHeaders();
            for (Header header : headers) {
                System.out.println(header);
            }
            System.out.println("----------------------------------------");

            if (entity != null) {
                System.out.println(EntityUtils.toString(entity));
            }

        } catch (IOException | ParseException e) {
            System.out.println("error " + e);
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
    }

    public static void create() throws UnsupportedEncodingException {
        /* Create object of CloseableHttpClient */
        DefaultHttpClient httpclient = new DefaultHttpClient();
//     
        try {
            HttpHost target = new HttpHost("192.168.10.200", 9990, "http");
            /* Prepare put request */
            HttpPost httpPost = new HttpPost("/SampleWS/peoples");
            /* Add headers to get request */
//        httpPut.addHeader("Authorization", "value");

            /* Prepare StringEntity from JSON */
            StringEntity jsonData = new StringEntity("{\"name\":\"pandora Thakor\"}", "UTF-8");
            /* Body of request */
            httpPost.setEntity(jsonData);
            // specify the host, protocol, and port               // specify the get request

            System.out.println("executing request to " + target);

            HttpResponse httpResponse = httpclient.execute(target, httpPost);
            HttpEntity entity = httpResponse.getEntity();

            System.out.println("----------------------------------------");
            System.out.println(httpResponse.getStatusLine());
            Header[] headers = httpResponse.getAllHeaders();
            for (Header header : headers) {
                System.out.println(header);
            }
            System.out.println("----------------------------------------");

            if (entity != null) {
                System.out.println(EntityUtils.toString(entity));
            }

        } catch (IOException | ParseException e) {
            System.out.println("error " + e);
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
    }

    public static void delete() throws UnsupportedEncodingException {
        /* Create object of CloseableHttpClient */
        DefaultHttpClient httpclient = new DefaultHttpClient();
//     
        try {
            HttpHost target = new HttpHost("192.168.10.200", 9990, "http");
            /* Prepare put request */
            HttpDelete httpd = new HttpDelete("/SampleWS/peoples/1");
            /* Add headers to get request */
//        httpPut.addHeader("Authorization", "value");

            // specify the host, protocol, and port               // specify the get request
            System.out.println("executing request to " + target);

            HttpResponse httpResponse = httpclient.execute(target, httpd);
            HttpEntity entity = httpResponse.getEntity();

            System.out.println("----------------------------------------");
            System.out.println(httpResponse.getStatusLine());
            Header[] headers = httpResponse.getAllHeaders();
            for (Header header : headers) {
                System.out.println(header);
            }
            System.out.println("----------------------------------------");

            if (entity != null) {
                System.out.println(EntityUtils.toString(entity));
            }

        } catch (IOException | ParseException e) {
            System.out.println("error " + e);
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
    }
    
    
    
    
    
    public static void obtener2() throws JSONException {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
            // specify the host, protocol, and port
            HttpHost target = new HttpHost("192.168.10.200", 8080, "http");

            // specify the get request
//            http://localhost:8080/WSExpal/webresources/Marcaciones
            HttpGet getRequest = new HttpGet("/WSExpal/webresources/Marcaciones");

//            System.out.println("executing request to " + target);
            HttpResponse httpResponse = httpclient.execute(target, getRequest);
            HttpEntity entity = httpResponse.getEntity();

//            Gson gson = new Gson();
//          
//            String content = EntityUtils.toString(entity);
//            System.out.println("content " + content);
//            String json = new Gson().toJson(content);
//
//            
//            
//
//            List<Personas> yourList = gson.fromJson(json, (Class<T>) Personas.class);
//
//            yourList.forEach((personas) -> {
//                System.out.println(personas.toString());
//            });

            String[] entidades = EntityUtils.toString(entity).replace("[", "{").replace("]", "}").replace("},{", "}-{").replace("{{", "{").replace("}}", "}").split("-");
            ArrayList<JSONObject> l = new ArrayList();
            for (String entidad : entidades) {
                System.out.println("entidade " + entidad);
                l.add(new JSONObject(entidad));
            }

//            System.out.println("----------------------------------------");
//            System.out.println(httpResponse.getStatusLine());
//            Header[] headers = httpResponse.getAllHeaders();
//            for (Header header : headers) {
//                System.out.println(header);
//            }
//            System.out.println("----------------------------------------");
//            if (entity != null) {
//                ArrayList<Personas> p = new ArrayList();
//                for (JSONObject json : l) {
//                    System.out.println("json "+json);
////                    p.add(new Personas(Integer.parseInt(json.get("id").toString()), json.get("name").toString()));
//                }
//
//                p.forEach((personas) -> {
//                    System.out.println(personas.toString());
//                });
//            }
        } catch (IOException | ParseException e) {
            System.out.println("error " + e);
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
    }
    
}
