package com.wallet.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class StockPricingService {

    @Value("${sa.id.url}")
    private String saIdUrl;

    @Value("${sa.id.url.suffix}")
    private String saIdUrlSuffix;

    @Value("${rapid.api.key}")
    private String rapidApiKey;

    @Value("${rapid.api.host}")
    private String rapidApiHost;

    @Value("${sa.pricing.url}")
    private String saPricingUrl;

    public int getSaId(String ticker) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(saIdUrl + ticker + saIdUrlSuffix)
                .get()
                .addHeader("X-RapidAPI-Key", rapidApiKey)
                .addHeader("X-RapidAPI-Host", rapidApiHost)
                .build();

        Response response = client.newCall(request).execute();

        JsonObject result = new JsonParser().parse(response.body().string()).getAsJsonObject();

        return result.get("symbols").getAsJsonArray()
                .get(0).getAsJsonObject()
                .get("id").getAsInt();
    }

    public BigDecimal getPrice(String ticker) throws IOException {
        int saId = getSaId(ticker);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(saPricingUrl + saId)
                .get()
                .addHeader("X-RapidAPI-Key", rapidApiKey)
                .addHeader("X-RapidAPI-Host", rapidApiHost)
                .build();

        //add await or try with resource ??
        Response response = client.newCall(request).execute();

        JsonObject result = new JsonParser().parse(response.body().string()).getAsJsonObject();
        return result.get("real_time_quotes").getAsJsonArray()
                .get(0).getAsJsonObject()
                .get("last").getAsBigDecimal().setScale(2, RoundingMode.HALF_UP);
    }
}
