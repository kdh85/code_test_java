package com.fab365.recruit.test.model.fee;

import com.fab365.recruit.test.model.Amount;
import com.fab365.recruit.test.model.Capacity;
import java.util.Objects;

public class UserLimitFee extends LimitFee {

  private final Amount amount;
  private final Capacity capacity;
  private final FeeName feeName;

  protected UserLimitFee(final int money, final int capacity, final String feeName) {
    this(new Amount(money), new Capacity(capacity), new FeeName(feeName));
  }

  private UserLimitFee(final Amount amount, final Capacity capacity,
                       final FeeName feeName) {
    this.amount = amount;
    this.capacity = capacity;
    this.feeName = feeName;
  }

  public static UserLimitFee of(BasicFeeType feeType) {
    return new UserLimitFee(feeType.feeAmount(), feeType.feeCapacity(), feeType.feeName());
  }

  @Override
  public Capacity calculateTotalCapacity(final int spendCapacity) {
    return this.capacity.getOverCapacity(spendCapacity);
  }

  @Override
  public UserLimitFee resultFee(Capacity userCapacity) {
    return new UserLimitFee(this.amount.calculate(userCapacity), this.capacity, feeName);
  }

  @Override
  public FeeType recommendFeeType(final FeeType targetFeeType) {
    if(this.amount.isExpensiveThan(targetFeeType)){
      return targetFeeType;
    }
    return this;
  }

  @Override
  public Amount getAmount() {
    return this.amount;
  }

  @Override
  public String feeName() {
    return this.feeName.getFeeName();
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final UserLimitFee that = (UserLimitFee) o;
    return Objects.equals(amount, that.amount) && Objects.equals(capacity,
        that.capacity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, capacity);
  }

  @Override
  public String toString() {
    return "UserLimitFee{" +
        "amount=" + amount +
        ", capacity=" + capacity +
        '}';
  }
}
