package org.webrtc;

import b.d.b.a.a;
import java.util.Map;

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
        StringBuilder sbU = a.U("{ timestampUs: ");
        sbU.append(this.timestampUs);
        sbU.append(", stats: [\n");
        boolean z2 = true;
        for (RTCStats rTCStats : this.stats.values()) {
            if (!z2) {
                sbU.append(",\n");
            }
            sbU.append(rTCStats);
            z2 = false;
        }
        sbU.append(" ] }");
        return sbU.toString();
    }
}
