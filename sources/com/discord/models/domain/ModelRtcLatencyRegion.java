package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ModelRtcLatencyRegion.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelRtcLatencyRegion {
    private final List<String> ips;
    private final String region;

    public ModelRtcLatencyRegion(String str, List<String> list) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REGION);
        m.checkNotNullParameter(list, "ips");
        this.region = str;
        this.ips = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelRtcLatencyRegion copy$default(ModelRtcLatencyRegion modelRtcLatencyRegion, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelRtcLatencyRegion.region;
        }
        if ((i & 2) != 0) {
            list = modelRtcLatencyRegion.ips;
        }
        return modelRtcLatencyRegion.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    public final List<String> component2() {
        return this.ips;
    }

    public final ModelRtcLatencyRegion copy(String region, List<String> ips) {
        m.checkNotNullParameter(region, ModelAuditLogEntry.CHANGE_KEY_REGION);
        m.checkNotNullParameter(ips, "ips");
        return new ModelRtcLatencyRegion(region, ips);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelRtcLatencyRegion)) {
            return false;
        }
        ModelRtcLatencyRegion modelRtcLatencyRegion = (ModelRtcLatencyRegion) other;
        return m.areEqual(this.region, modelRtcLatencyRegion.region) && m.areEqual(this.ips, modelRtcLatencyRegion.ips);
    }

    public final List<String> getIps() {
        return this.ips;
    }

    public final String getRegion() {
        return this.region;
    }

    public int hashCode() {
        String str = this.region;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.ips;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelRtcLatencyRegion(region=");
        sbU.append(this.region);
        sbU.append(", ips=");
        return a.L(sbU, this.ips, ")");
    }
}
