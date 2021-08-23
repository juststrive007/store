package com.example.snakeyaml.utils.RestemplateTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class CreateVNF {


    public static void main(String[] args) throws IOException {
//        String postUrl = "http://192.168.137.129:30888/vnfpkgm/v1/vnf_packages/";
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//
//        HttpMethod httpMethod = HttpMethod.POST;
//
//        ResponseEntity<JSONObject>entity = restTemplate.postForEntity(postUrl,httpMethod,JSONObject.class);
//
//        System.out.println(entity.getBody());
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("http://192.168.137.129:30888/vnfpkgm/v1/vnf_packages/")
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());

    }
}
