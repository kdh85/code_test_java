package com.fab365.recruit.test.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.fab365.recruit.test.model.fee.OverFeeType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OverFeeTypeTest {

  @DisplayName("초과용량과 초과요금제를 주입받아 초과 요금을 연산한다.")
  @Test
  void calculateTest() {
    assertAll(
        () -> assertThat(OverFeeType.BASIC_TYPE.calculateOverPay(300)).isEqualTo(
            6000),
        () -> assertThat(OverFeeType.LIGHT_TYPE.calculateOverPay(300)).isEqualTo(
            3000)
    );

  }
}