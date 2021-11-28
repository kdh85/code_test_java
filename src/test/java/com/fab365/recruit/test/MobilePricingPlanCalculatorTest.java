package com.fab365.recruit.test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MobilePricingPlanCalculatorTest {

	private MobilePricingPlanCalculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new MobilePricingPlanCalculator();
	}

	@DisplayName("사용한 데이터 대비 최적의 요금제를 추천한다.")
	@Test
	void bestRecommendFeeTest() {
		// 1메가
		assertThat(calculator.minimumPricePlan(1)).isEqualTo("29900");
		// 4000메가
		assertThat(calculator.minimumPricePlan(4000)).isEqualTo("34900");
		// 10기가
		assertThat(calculator.minimumPricePlan(10 * 1000)).isEqualTo("69900");
	}
}
