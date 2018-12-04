/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.apache.http.HttpResponse;
import org.apache.http.impl.DefaultHttpServerConnection;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;
import us.monoid.web.Resty;

/**
 *
 * @author clopez
 */
public class JavaApplication4 {

    /**
     */
    public static DecimalFormat df = new DecimalFormat("###,###.##");

    public static void main(String[] args) throws IOException, MalformedURLException, JAXBException, Exception {
        callApi();

    }

    public static String convertDocByCase(String number, String opt) {
        String numRetur = "";
        switch (opt) {
            case "nit":
                numRetur = number.substring(1, number.length() - 1) + "-" + number.substring(number.length() - 1, number.length());
                break;
            case "cc":
                System.out.println(Integer.parseInt(number));
                numRetur = df.format(Integer.parseInt(number));
                break;
        }
        return numRetur;
    }

    public static void callApi() throws MalformedURLException, IOException, JAXBException, Exception {

    }

}
