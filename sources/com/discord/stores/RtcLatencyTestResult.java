package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreRtcRegion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class RtcLatencyTestResult {
    private final List<String> geoRankedRegions;
    private final long lastTestTimestampMs;
    private final List<String> latencyRankedRegions;

    public RtcLatencyTestResult() {
        this(null, null, 0L, 7, null);
    }

    public RtcLatencyTestResult(List<String> list, List<String> list2, long j) {
        m.checkNotNullParameter(list, "latencyRankedRegions");
        m.checkNotNullParameter(list2, "geoRankedRegions");
        this.latencyRankedRegions = list;
        this.geoRankedRegions = list2;
        this.lastTestTimestampMs = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RtcLatencyTestResult copy$default(RtcLatencyTestResult rtcLatencyTestResult, List list, List list2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            list = rtcLatencyTestResult.latencyRankedRegions;
        }
        if ((i & 2) != 0) {
            list2 = rtcLatencyTestResult.geoRankedRegions;
        }
        if ((i & 4) != 0) {
            j = rtcLatencyTestResult.lastTestTimestampMs;
        }
        return rtcLatencyTestResult.copy(list, list2, j);
    }

    public final List<String> component1() {
        return this.latencyRankedRegions;
    }

    public final List<String> component2() {
        return this.geoRankedRegions;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getLastTestTimestampMs() {
        return this.lastTestTimestampMs;
    }

    public final RtcLatencyTestResult copy(List<String> latencyRankedRegions, List<String> geoRankedRegions, long lastTestTimestampMs) {
        m.checkNotNullParameter(latencyRankedRegions, "latencyRankedRegions");
        m.checkNotNullParameter(geoRankedRegions, "geoRankedRegions");
        return new RtcLatencyTestResult(latencyRankedRegions, geoRankedRegions, lastTestTimestampMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RtcLatencyTestResult)) {
            return false;
        }
        RtcLatencyTestResult rtcLatencyTestResult = (RtcLatencyTestResult) other;
        return m.areEqual(this.latencyRankedRegions, rtcLatencyTestResult.latencyRankedRegions) && m.areEqual(this.geoRankedRegions, rtcLatencyTestResult.geoRankedRegions) && this.lastTestTimestampMs == rtcLatencyTestResult.lastTestTimestampMs;
    }

    public final List<String> getGeoRankedRegions() {
        return this.geoRankedRegions;
    }

    public final long getLastTestTimestampMs() {
        return this.lastTestTimestampMs;
    }

    public final List<String> getLatencyRankedRegions() {
        return this.latencyRankedRegions;
    }

    public int hashCode() {
        List<String> list = this.latencyRankedRegions;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<String> list2 = this.geoRankedRegions;
        return b.a(this.lastTestTimestampMs) + ((iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("RtcLatencyTestResult(latencyRankedRegions=");
        sbU.append(this.latencyRankedRegions);
        sbU.append(", geoRankedRegions=");
        sbU.append(this.geoRankedRegions);
        sbU.append(", lastTestTimestampMs=");
        return a.C(sbU, this.lastTestTimestampMs, ")");
    }

    public /* synthetic */ RtcLatencyTestResult(List list, List list2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? n.emptyList() : list, (i & 2) != 0 ? n.emptyList() : list2, (i & 4) != 0 ? 0L : j);
    }
}
