package com.wallet.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class StockPricingService {
    //seeking alpha from rapidapi


    public int getId(String ticker) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://seeking-alpha.p.rapidapi.com/v2/auto-complete?query=apple&type=people%2Csymbols%2Cpages&size=5")
                .get()
                .addHeader("X-RapidAPI-Key", "7b4458f0c9mshd301be4ebadf3f2p11c14djsn714398223539")
                .addHeader("X-RapidAPI-Host", "seeking-alpha.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();
        return 146;
    }
    public void getPrice() throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://seeking-alpha.p.rapidapi.com/market/get-realtime-quotes?sa_ids=146")
                .get()
                .addHeader("X-RapidAPI-Key", "7b4458f0c9mshd301be4ebadf3f2p11c14djsn714398223539")
                .addHeader("X-RapidAPI-Host", "seeking-alpha.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response);

    }


    public StockPricingService() throws IOException {
    }
}
