package com.wallet;

import com.wallet.service.StockPricingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ApplicationTests {

	@Autowired
	StockPricingService stockPricingService;

	@Test
	void contextLoads() {
	}
}
