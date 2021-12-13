package com.fab365.recruit.test.model.fee;

import com.fab365.recruit.test.model.Amount;
import java.util.Objects;

public class UserUnLimitFee extends UnlimitedFee {

  private final Amount amount;
  private final FeeName feeName;

  public UserUnLimitFee(final int amount, final String feeName) {
    this(new Amount(amount), new FeeName(feeName));
  }

  public UserUnLimitFee(final Amount amount,
                        final FeeName feeName) {
    this.amount = amount;
    this.feeName = feeName;
  }

  public static UserUnLimitFee of(BasicUnLimitFeeType feeType) {
    return new UserUnLimitFee(feeType.feeAmount(), feeType.feeName());
  }

  @Override
  public UserUnLimitFee resultFee() {
    return this;
  }

  @Override
  public FeeType recommendFeeType(final FeeType targetFeeType) {
    if (this.amount.isExpensiveThan(targetFeeType)) {
      return targetFeeType;
    }
    return this;
  }

  @Override
  public String feeName() {
    return this.feeName.getFeeName();
  }

  @Override
  public Amount getAmount() {
    return this.amount;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final UserUnLimitFee that = (UserUnLimitFee) o;
    return Objects.equals(amount, that.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount);
  }

  @Override
  public String toString() {
    return "UserUnLimitFee{" +
        "amount=" + amount +
        '}';
  }
}
