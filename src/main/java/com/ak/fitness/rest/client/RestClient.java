/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.rest.client;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author wais
 */
@Component
public class RestClient {

    private static final Logger LOGGER = Logger.getLogger(RestClient.class.getName());
    public String PAYPAL_SANDBOX = "https://www.sandbox.paypal.com/cgi-bin/webscr";
    public String PAYPAL = "https://www.paypal.com/cgi-bin/webscr";
    
    public String tokenId= "w-FNzou8a6WaHwCQxpOR9mzzJyYdOwE9ToF64iOLhcP3iSYQ8Rhhttzg5Ji";
    
    @Autowired
    private RestTemplate restTemplate;
    
    public boolean isPaypalTokenValid(String transactionToken) {
        
        try {
            HttpEntity<String> request = new HttpEntity<>(createPaypalHeaders());

            //int appointmentType1 = Integer.valueOf(json.get("slotId").toString());
            String url = PAYPAL_SANDBOX + "?tx=" + transactionToken + "&cmd=_notify-synch" + "&at=" + tokenId;

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

            Map<String, String> map = new HashMap();
            if (StringUtils.isNotBlank(response.getBody())) {
                String responseDecoded = URLDecoder.decode(response.getBody(), "utf-8");
                String mainResponse = responseDecoded.substring(0, 7);
                String bodyReponse = responseDecoded.substring(8);
                map = splitToMap(bodyReponse, "\\r?\\n", "=");
                System.out.println("first response = " + mainResponse);
                System.out.println("payment status = " + map.get("payment_status").toString());
                if(StringUtils.equals("SUCCESS", mainResponse) && StringUtils.equals("Completed", map.get("payment_status"))){
                    return true;
                }
            }
            
            return false;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            return false;
        }
    }
  
    public static Map<String, String> splitToMap(String source, String entriesSeparator, String keyValueSeparator) throws Exception{
        
        Map<String, String> map = new HashMap<String, String>();
        String[] entries = source.split(entriesSeparator);
        for (String entry : entries) {
            if (!StringUtils.isEmpty(entry) && entry.contains(keyValueSeparator)) {
                String[] keyValue = entry.split(keyValueSeparator);
                String value = "";
                try{
                    value = keyValue[1];
                }catch(ArrayIndexOutOfBoundsException ex){
                    LOGGER.log(Level.INFO, null, keyValue[0] + " has no value");
                    value = "";
                }
                map.put(keyValue[0], value);
            }
        }
        return map;
    }
    
    
    
    private HttpHeaders createPaypalHeaders() {
        //TODO find the appropriate token for the user
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        return headers;
    }
}
