package com.discord.utilities.collections;

import a0.a.a.a;
import a0.a.a.b;

/* JADX INFO: compiled from: Histogram.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class Histogram$Report {
    private final double average;
    private final int bucketCount;
    private final long count;
    private final long max;
    private final long min;
    private final long percentile25;
    private final long percentile50;
    private final long percentile75;
    private final long percentile90;
    private final long percentile95;

    public Histogram$Report(long j, long j2, double d, long j3, int i, long j4, long j5, long j6, long j7, long j8) {
        this.min = j;
        this.max = j2;
        this.average = d;
        this.count = j3;
        this.bucketCount = i;
        this.percentile25 = j4;
        this.percentile50 = j5;
        this.percentile75 = j6;
        this.percentile90 = j7;
        this.percentile95 = j8;
    }

    public static /* synthetic */ Histogram$Report copy$default(Histogram$Report histogram$Report, long j, long j2, double d, long j3, int i, long j4, long j5, long j6, long j7, long j8, int i2, Object obj) {
        return histogram$Report.copy((i2 & 1) != 0 ? histogram$Report.min : j, (i2 & 2) != 0 ? histogram$Report.max : j2, (i2 & 4) != 0 ? histogram$Report.average : d, (i2 & 8) != 0 ? histogram$Report.count : j3, (i2 & 16) != 0 ? histogram$Report.bucketCount : i, (i2 & 32) != 0 ? histogram$Report.percentile25 : j4, (i2 & 64) != 0 ? histogram$Report.percentile50 : j5, (i2 & 128) != 0 ? histogram$Report.percentile75 : j6, (i2 & 256) != 0 ? histogram$Report.percentile90 : j7, (i2 & 512) != 0 ? histogram$Report.percentile95 : j8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getMin() {
        return this.min;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getPercentile95() {
        return this.percentile95;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMax() {
        return this.max;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getAverage() {
        return this.average;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getBucketCount() {
        return this.bucketCount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getPercentile25() {
        return this.percentile25;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getPercentile50() {
        return this.percentile50;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getPercentile75() {
        return this.percentile75;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getPercentile90() {
        return this.percentile90;
    }

    public final Histogram$Report copy(long min, long max, double average, long count, int bucketCount, long percentile25, long percentile50, long percentile75, long percentile90, long percentile95) {
        return new Histogram$Report(min, max, average, count, bucketCount, percentile25, percentile50, percentile75, percentile90, percentile95);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Histogram$Report)) {
            return false;
        }
        Histogram$Report histogram$Report = (Histogram$Report) other;
        return this.min == histogram$Report.min && this.max == histogram$Report.max && Double.compare(this.average, histogram$Report.average) == 0 && this.count == histogram$Report.count && this.bucketCount == histogram$Report.bucketCount && this.percentile25 == histogram$Report.percentile25 && this.percentile50 == histogram$Report.percentile50 && this.percentile75 == histogram$Report.percentile75 && this.percentile90 == histogram$Report.percentile90 && this.percentile95 == histogram$Report.percentile95;
    }

    public final double getAverage() {
        return this.average;
    }

    public final int getBucketCount() {
        return this.bucketCount;
    }

    public final long getCount() {
        return this.count;
    }

    public final long getMax() {
        return this.max;
    }

    public final long getMin() {
        return this.min;
    }

    public final long getPercentile25() {
        return this.percentile25;
    }

    public final long getPercentile50() {
        return this.percentile50;
    }

    public final long getPercentile75() {
        return this.percentile75;
    }

    public final long getPercentile90() {
        return this.percentile90;
    }

    public final long getPercentile95() {
        return this.percentile95;
    }

    public int hashCode() {
        return b.a(this.percentile95) + ((b.a(this.percentile90) + ((b.a(this.percentile75) + ((b.a(this.percentile50) + ((b.a(this.percentile25) + ((((b.a(this.count) + ((a.a(this.average) + ((b.a(this.max) + (b.a(this.min) * 31)) * 31)) * 31)) * 31) + this.bucketCount) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Report(min=");
        sbU.append(this.min);
        sbU.append(", max=");
        sbU.append(this.max);
        sbU.append(", average=");
        sbU.append(this.average);
        sbU.append(", count=");
        sbU.append(this.count);
        sbU.append(", bucketCount=");
        sbU.append(this.bucketCount);
        sbU.append(", percentile25=");
        sbU.append(this.percentile25);
        sbU.append(", percentile50=");
        sbU.append(this.percentile50);
        sbU.append(", percentile75=");
        sbU.append(this.percentile75);
        sbU.append(", percentile90=");
        sbU.append(this.percentile90);
        sbU.append(", percentile95=");
        return b.d.b.a.a.C(sbU, this.percentile95, ")");
    }
}
