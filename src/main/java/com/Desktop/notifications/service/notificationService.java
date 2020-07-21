package com.Desktop.notifications.service;


import com.Desktop.notifications.model.notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class notificationService {


    @Value("${httpconfig.Url}")
    private String url;

    @Autowired
    private  RestTemplate restTemplate;


    public  notification  getNOtification()
    {
        ResponseEntity<notification> res;
        try {
            res = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, notification.class);
        }
        catch(Exception e)
        {
            System.out.println(e);
            return new notification( "Notification fetching service is Down","Alert");
        }

        return res.getBody();
    }



}
