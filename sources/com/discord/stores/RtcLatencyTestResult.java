package com.discord.stores;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullParameter(list, "latencyRankedRegions");
        C12238m.checkNotNullParameter(list2, "geoRankedRegions");
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
        C12238m.checkNotNullParameter(latencyRankedRegions, "latencyRankedRegions");
        C12238m.checkNotNullParameter(geoRankedRegions, "geoRankedRegions");
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
        return C12238m.areEqual(this.latencyRankedRegions, rtcLatencyTestResult.latencyRankedRegions) && C12238m.areEqual(this.geoRankedRegions, rtcLatencyTestResult.geoRankedRegions) && this.lastTestTimestampMs == rtcLatencyTestResult.lastTestTimestampMs;
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
        return C0002b.m3a(this.lastTestTimestampMs) + ((iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("RtcLatencyTestResult(latencyRankedRegions=");
        sbM833U.append(this.latencyRankedRegions);
        sbM833U.append(", geoRankedRegions=");
        sbM833U.append(this.geoRankedRegions);
        sbM833U.append(", lastTestTimestampMs=");
        return C1643a.m815C(sbM833U, this.lastTestTimestampMs, ")");
    }

    public /* synthetic */ RtcLatencyTestResult(List list, List list2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C12147n.emptyList() : list, (i & 2) != 0 ? C12147n.emptyList() : list2, (i & 4) != 0 ? 0L : j);
    }
}
