package com.fab365.recruit.test.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FeeTest {

	@DisplayName("각 요금제의 요금을 검증한다.")
	@Test
	void feeAmountTest() {
		assertAll(
			() -> assertThat(Fee.FEE_29900.getAmount()).isEqualTo(29900),
			() -> assertThat(Fee.FEE_34900.getAmount()).isEqualTo(34900),
			() -> assertThat(Fee.FEE_69900.getAmount()).isEqualTo(69900)
		);
	}

	@DisplayName("각 요금제의 기본 제공 데이터용량을 검증한다.")
	@Test
	void feeBasicCapacityTest() {
		assertAll(
			() -> assertThat(Fee.FEE_29900.getBasicFreeCapacity()).isEqualTo(300),
			() -> assertThat(Fee.FEE_34900.getBasicFreeCapacity()).isEqualTo(3000),
			() -> assertThat(Fee.FEE_69900.getBasicFreeCapacity()).isEqualTo(Integer.MAX_VALUE)
		);
	}

	@DisplayName("주입받은 총사용액에 맞는 요금제를 반환 검증.")
	@ParameterizedTest
	@CsvSource(value = {"29900,29900","34900,34900","69900,69900"})
	void recommendFeeTest(int amount, String amountName) {
		assertThat(Fee.recommendFee(new TotalUserAmount(amount))).isEqualTo(amountName);
	}

	@DisplayName("추천요금제가 없는 경우 에러를 반환 검증.")
	@Test
	void validationRecommendFeeTest() {
		assertThatThrownBy(
			() -> Fee.recommendFee(new TotalUserAmount(-100))
		).isInstanceOf(IllegalArgumentException.class);
	}
}