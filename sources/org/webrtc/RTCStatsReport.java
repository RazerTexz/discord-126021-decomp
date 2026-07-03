package org.webrtc;

import java.util.Map;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes3.dex */
public class RTCStatsReport {
    private final Map<String, RTCStats> stats;
    private final long timestampUs;

    public RTCStatsReport(long j, Map<String, RTCStats> map) {
        this.timestampUs = j;
        this.stats = map;
    }

    @CalledByNative
    private static RTCStatsReport create(long j, Map map) {
        return new RTCStatsReport(j, map);
    }

    public Map<String, RTCStats> getStatsMap() {
        return this.stats;
    }

    public double getTimestampUs() {
        return this.timestampUs;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("{ timestampUs: ");
        sbM833U.append(this.timestampUs);
        sbM833U.append(", stats: [\n");
        boolean z2 = true;
        for (RTCStats rTCStats : this.stats.values()) {
            if (!z2) {
                sbM833U.append(",\n");
            }
            sbM833U.append(rTCStats);
            z2 = false;
        }
        sbM833U.append(" ] }");
        return sbM833U.toString();
    }
}
