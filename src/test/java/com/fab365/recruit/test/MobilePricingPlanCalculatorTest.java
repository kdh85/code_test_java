package com.fab365.recruit.test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MobilePricingPlanCalculatorTest {
  @Test
  void test() {
    MobilePricingPlanCalculator calculator = new MobilePricingPlanCalculator();
    // 1메가
    assertThat(calculator.minimumPricePlan(1)).isEqualTo("?");

    // 10기가
    assertThat(calculator.minimumPricePlan(10 * 1000)).isEqualTo("?");
  }
}
