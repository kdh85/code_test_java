package com.fab365.recruit.test.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountTest {

  @DisplayName("돈 액수를 주입하여 돈 객체 생성을 반환 검증.")
  @Test
  void createMoneyTest() {
    assertThat(new Amount(1000)).isEqualTo(new Amount(1000));
  }

  @DisplayName("주입되는 금액 값이 0 미만일 경우 에러를 반환 검증.")
  @Test
  void validationMoneyTest() {
    assertThatThrownBy(() -> new Amount(-1)).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("두개의 금액을 비교하여 더 작은 금액을 반환 검증.")
  @Test
  void compareMoneyTest() {
    Amount firstMoney = new Amount(1000);
    assertAll(
        () -> assertThat(firstMoney.findMinimumMoney(new Amount(2000))).isEqualTo(firstMoney),
        () -> assertThat(firstMoney.findMinimumMoney(new Amount(1000))).isEqualTo(firstMoney)
    );

  }
}