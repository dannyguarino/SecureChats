package com.example.securechats.Fragments;

import com.example.securechats.Notifications.Response;
import com.example.securechats.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAuhkP2ds:APA91bG0q1q1VvxJrh94onPdt-ABIeuutvYjUc6MpJG_qcVJFF8fp7uqWk_WUf5nWCSHdJzRuZ70ZvNuNrew-0kaZGuVkmIeur38ZeBITlP7WznP9Bfrsv4OWSl2LKuTON2bile0Y9dW"
            }
    )

    @POST("fcm/send")
    Call<Response> sendNotification(@Body Sender body);
}
