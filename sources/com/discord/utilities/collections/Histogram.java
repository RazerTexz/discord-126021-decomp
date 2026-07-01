package com.discord.utilities.collections;

import androidx.annotation.VisibleForTesting;
import d0.t.n;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
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

    public final Histogram$Report getReport() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Integer num = 50;
        ArrayDeque arrayDeque = new ArrayDeque(n.listOf((Object[]) new Integer[]{25, num, 75, 90, 95}));
        long j = 0;
        for (Map$Entry<Long, Long> map$Entry : this.histogram.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            long jLongValue2 = map$Entry.getValue().longValue();
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
        return new Histogram$Report(jLongValue3, jLongValue4, d2, j2, size, jLongValue5, jLongValue6, jLongValue7, jLongValue8, l7 != null ? l7.longValue() : 0L);
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
