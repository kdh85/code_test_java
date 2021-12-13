package com.fab365.recruit.test.model.fee;

import com.fab365.recruit.test.model.Capacity;

public abstract class UnlimitedFee extends FeeType {

  @Override
  public boolean isUnLimitFee() {
    return true;
  }

  @Override
  public UnlimitedFee resultFee(final Capacity useCapacity) {
    throw new RuntimeException("무제한 요금은 초과사용량이 필요하지 않습니다.");
  }

  @Override
  public Capacity calculateTotalCapacity(final int spendCapacity) {
    throw new RuntimeException("무제한 요금은 초과사용량을 계산하지 않습니다.");
  }
}
