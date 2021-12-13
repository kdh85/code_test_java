package com.fab365.recruit.test.model;

import com.fab365.recruit.test.model.fee.FeeType;
import com.fab365.recruit.test.model.fee.OverFeeType;
import java.util.Objects;

public class Amount {

  private static final int DEFAULT_AMOUNT = 0;
  private static final String ERROR_AMOUNT_VALUE = String.format("생성 가능한 최소 금액은 %d이상 부터 입니다.",
      DEFAULT_AMOUNT);
  private static final int MAX_AMOUNT = 180000;

  private final int amount;

  public Amount(final int amount) {
    validationAmount(amount);
    this.amount = amount;
  }

  private void validationAmount(final int amount) {
    if (isLessThanDefault(amount)) {
      throw new IllegalArgumentException(ERROR_AMOUNT_VALUE);
    }
  }

  private boolean isLessThanDefault(final int money) {
    return DEFAULT_AMOUNT > money;
  }

  public Amount findMinimumMoney(final Amount targetMoney) {

    if (isExpensiveThan(targetMoney)) {
      return targetMoney;
    }
    return this;
  }

  private boolean isExpensiveThan(final Amount targetMoney) {
    return this.amount > targetMoney.amount;
  }

  public Amount calculate(final Capacity capacity) {
    int totalMoney = getTotalMoney(capacity, OverFeeType.BASIC_TYPE);

    if (totalMoney > MAX_AMOUNT) {
      return new Amount(getTotalMoney(capacity, OverFeeType.LIGHT_TYPE));
    }
    return new Amount(totalMoney);
  }

  private int getTotalMoney(final Capacity capacity, final OverFeeType overFeeType) {
    return this.amount + overFeeType.calculateOverPay(capacity.getCapacity());
  }

  public boolean isExpensiveThan(final FeeType targetFeeType) {
    return this.isExpensiveThan(targetFeeType.getAmount());
  }

  @Override
  public boolean equals(final Object o) {

    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Amount amount1 = (Amount) o;
    return amount == amount1.amount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount);
  }

  @Override
  public String toString() {
    return "Amount{" +
        "amount=" + amount +
        '}';
  }
}
