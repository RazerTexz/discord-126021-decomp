package co.discord.media_engine;

import a0.a.a.a;
import b.d.b.a.outline;

/* JADX INFO: compiled from: Statistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class PlayoutMetric {
    private final double last;
    private final double max;
    private final double mean;
    private final double p75;
    private final double p95;
    private final double p99;

    public PlayoutMetric(double d, double d2, double d3, double d4, double d5, double d6) {
        this.last = d;
        this.mean = d2;
        this.p75 = d3;
        this.p95 = d4;
        this.p99 = d5;
        this.max = d6;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getLast() {
        return this.last;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getMean() {
        return this.mean;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getP75() {
        return this.p75;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getP95() {
        return this.p95;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final double getP99() {
        return this.p99;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final double getMax() {
        return this.max;
    }

    public final PlayoutMetric copy(double last, double mean, double p75, double p95, double p99, double max) {
        return new PlayoutMetric(last, mean, p75, p95, p99, max);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayoutMetric)) {
            return false;
        }
        PlayoutMetric playoutMetric = (PlayoutMetric) other;
        return Double.compare(this.last, playoutMetric.last) == 0 && Double.compare(this.mean, playoutMetric.mean) == 0 && Double.compare(this.p75, playoutMetric.p75) == 0 && Double.compare(this.p95, playoutMetric.p95) == 0 && Double.compare(this.p99, playoutMetric.p99) == 0 && Double.compare(this.max, playoutMetric.max) == 0;
    }

    public final double getLast() {
        return this.last;
    }

    public final double getMax() {
        return this.max;
    }

    public final double getMean() {
        return this.mean;
    }

    public final double getP75() {
        return this.p75;
    }

    public final double getP95() {
        return this.p95;
    }

    public final double getP99() {
        return this.p99;
    }

    public int hashCode() {
        return a.a(this.max) + ((a.a(this.p99) + ((a.a(this.p95) + ((a.a(this.p75) + ((a.a(this.mean) + (a.a(this.last) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("PlayoutMetric(last=");
        sbU.append(this.last);
        sbU.append(", mean=");
        sbU.append(this.mean);
        sbU.append(", p75=");
        sbU.append(this.p75);
        sbU.append(", p95=");
        sbU.append(this.p95);
        sbU.append(", p99=");
        sbU.append(this.p99);
        sbU.append(", max=");
        sbU.append(this.max);
        sbU.append(")");
        return sbU.toString();
    }
}
