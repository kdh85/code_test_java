package com.fab365.recruit.test.model.fee;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RecommendFee {

  private static final String ERROR_FEES_VALUE = "생성된 사용자 요금객체가 없습니다.";

  private final List<FeeType> fees;

  private RecommendFee(final List<FeeType> fees) {
    validationFees(fees);
    this.fees = Collections.unmodifiableList(fees);
  }

  private void validationFees(final List<FeeType> fees) {
    if (fees.isEmpty()) {
      throw new IllegalArgumentException(ERROR_FEES_VALUE);
    }
  }

  public static RecommendFee of(final List<FeeType> feesTypes) {
    return new RecommendFee(feesTypes);
  }

  public String bestFeeRecommend(Integer usageDataInMegabyte) {

    FeeType smallFee = null;

    for (FeeType allFee : fees) {
      smallFee = findFeesForEachType(usageDataInMegabyte, smallFee, allFee);
    }

    return Objects.requireNonNull(smallFee).feeName();
  }

  private FeeType findFeesForEachType(final Integer usageDataInMegabyte, FeeType smallFee,
                                      final FeeType allFee) {
    if (allFee.isUnLimitFee()) {
      return findUnLimitFee(smallFee, allFee);
    }
    return findLimitFee(usageDataInMegabyte, smallFee, allFee);
  }

  private FeeType findLimitFee(final Integer usageDataInMegabyte, FeeType smallFee,
                               final FeeType allFee) {
    if (isFirstFee(smallFee)) {
      return allFee.resultFee(allFee.calculateTotalCapacity(usageDataInMegabyte));
    }
    return allFee.resultFee(allFee.calculateTotalCapacity(usageDataInMegabyte)).recommendFeeType(
        smallFee);
  }

  private boolean isFirstFee(final FeeType smallFee) {
    return smallFee == null;
  }

  private FeeType findUnLimitFee(FeeType smallFee, final FeeType allFee) {
    if (isFirstFee(smallFee)) {
      return allFee.resultFee();
    }
    return allFee.resultFee().recommendFeeType(smallFee);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final RecommendFee that = (RecommendFee) o;
    return Objects.equals(fees, that.fees);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fees);
  }

  @Override
  public String toString() {
    return "RecommendFee{" +
        "fees=" + fees +
        '}';
  }
}
