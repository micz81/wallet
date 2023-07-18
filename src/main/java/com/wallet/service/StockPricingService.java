package com.wallet.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Service
public class StockPricingService {

    public int getSaId(String ticker) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://seeking-alpha.p.rapidapi.com/v2/auto-complete?query=" + ticker + "&type=symbols&size=1")
                .get()
                .addHeader("X-RapidAPI-Key", "7b4458f0c9mshd301be4ebadf3f2p11c14djsn714398223539")
                .addHeader("X-RapidAPI-Host", "seeking-alpha.p.rapidapi.com")
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
                .url("https://seeking-alpha.p.rapidapi.com/market/get-realtime-quotes?sa_ids=" + saId)
                .get()
                .addHeader("X-RapidAPI-Key", "7b4458f0c9mshd301be4ebadf3f2p11c14djsn714398223539")
                .addHeader("X-RapidAPI-Host", "seeking-alpha.p.rapidapi.com")
                .build();

        //add await and try with resource !!!!!!!!!!
        Response response = client.newCall(request).execute();

        JsonObject result = new JsonParser().parse(response.body().string()).getAsJsonObject();
        return result.get("real_time_quotes").getAsJsonArray()
                .get(0).getAsJsonObject()
                .get("last").getAsBigDecimal().setScale(2, RoundingMode.HALF_UP);
    }
}
