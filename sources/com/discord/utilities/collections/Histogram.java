package com.discord.utilities.collections;

import a0.a.a.a;
import a0.a.a.b;
import androidx.annotation.VisibleForTesting;
import b.d.b.a.outline;
import d0.t.Collections2;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Histogram.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Histogram {
    private final int bucketLimit;
    private long count;
    private final int halfPrecision;
    private final TreeMap<Long, Long> histogram;
    private Long max;
    private Long min;
    private final int precision;
    private long total;

    /* JADX INFO: compiled from: Histogram.kt */
    public static final /* data */ class Report {
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

        public Report(long j, long j2, double d, long j3, int i, long j4, long j5, long j6, long j7, long j8) {
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

        public final Report copy(long min, long max, double average, long count, int bucketCount, long percentile25, long percentile50, long percentile75, long percentile90, long percentile95) {
            return new Report(min, max, average, count, bucketCount, percentile25, percentile50, percentile75, percentile90, percentile95);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Report)) {
                return false;
            }
            Report report = (Report) other;
            return this.min == report.min && this.max == report.max && Double.compare(this.average, report.average) == 0 && this.count == report.count && this.bucketCount == report.bucketCount && this.percentile25 == report.percentile25 && this.percentile50 == report.percentile50 && this.percentile75 == report.percentile75 && this.percentile90 == report.percentile90 && this.percentile95 == report.percentile95;
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
            StringBuilder sbU = outline.U("Report(min=");
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
            return outline.C(sbU, this.percentile95, ")");
        }
    }

    public Histogram(int i, int i2) {
        this.precision = i;
        this.bucketLimit = i2;
        this.histogram = new TreeMap<>();
        this.halfPrecision = i / 2;
    }

    public final void addSample(long value) {
        this.count++;
        this.total += value;
        Long l = this.min;
        Long l2 = this.max;
        if (l == null || l.longValue() > value) {
            this.min = Long.valueOf(value);
        }
        if (l2 == null || l2.longValue() < value) {
            this.max = Long.valueOf(value);
        }
        long jRoundValue$utils_release = roundValue$utils_release(value);
        Long l3 = this.histogram.get(Long.valueOf(jRoundValue$utils_release));
        if (l3 != null || this.histogram.size() <= this.bucketLimit) {
            this.histogram.put(Long.valueOf(jRoundValue$utils_release), Long.valueOf((l3 != null ? l3.longValue() : 0L) + 1));
        }
    }

    public final Report getReport() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Integer num = 50;
        ArrayDeque arrayDeque = new ArrayDeque(Collections2.listOf((Object[]) new Integer[]{25, num, 75, 90, 95}));
        long j = 0;
        for (Map.Entry<Long, Long> entry : this.histogram.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            long jLongValue2 = entry.getValue().longValue();
            if (arrayDeque.isEmpty()) {
                break;
            }
            j += jLongValue2;
            Integer num2 = num;
            double d = (j / this.count) * ((double) 100);
            while ((!arrayDeque.isEmpty()) && ((Number) arrayDeque.get(0)).doubleValue() <= d) {
                linkedHashMap.put(Integer.valueOf(((Number) arrayDeque.removeFirst()).intValue()), Long.valueOf(jLongValue));
            }
            num = num2;
        }
        Integer num3 = num;
        Long l = this.min;
        long jLongValue3 = l != null ? l.longValue() : 0L;
        Long l2 = this.max;
        long jLongValue4 = l2 != null ? l2.longValue() : 0L;
        long j2 = this.count;
        double d2 = j2 == 0 ? 0.0d : this.total / j2;
        int size = this.histogram.size();
        Long l3 = (Long) linkedHashMap.get(25);
        long jLongValue5 = l3 != null ? l3.longValue() : 0L;
        Long l4 = (Long) linkedHashMap.get(num3);
        long jLongValue6 = l4 != null ? l4.longValue() : 0L;
        Long l5 = (Long) linkedHashMap.get(75);
        long jLongValue7 = l5 != null ? l5.longValue() : 0L;
        Long l6 = (Long) linkedHashMap.get(90);
        long jLongValue8 = l6 != null ? l6.longValue() : 0L;
        Long l7 = (Long) linkedHashMap.get(95);
        return new Report(jLongValue3, jLongValue4, d2, j2, size, jLongValue5, jLongValue6, jLongValue7, jLongValue8, l7 != null ? l7.longValue() : 0L);
    }

    @VisibleForTesting
    public final long roundValue$utils_release(long value) {
        int i = this.precision;
        long j = value % ((long) i);
        long j2 = value - j;
        return j <= ((long) this.halfPrecision) ? j2 : j2 + ((long) i);
    }

    public /* synthetic */ Histogram(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 1000 : i2);
    }
}
