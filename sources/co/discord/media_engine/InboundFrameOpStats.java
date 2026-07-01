package co.discord.media_engine;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.adjust.sdk.Constants;
import d0.z.d.m;

/* JADX INFO: compiled from: VoiceQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class InboundFrameOpStats {
    private final Long accelerated;
    private final Long cng;
    private final Long expanded;
    private final Long merged;
    private final Long normal;
    private final Long preemptiveExpanded;
    private final Long silent;

    public InboundFrameOpStats(Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7) {
        this.silent = l;
        this.normal = l2;
        this.merged = l3;
        this.expanded = l4;
        this.accelerated = l5;
        this.preemptiveExpanded = l6;
        this.cng = l7;
    }

    public static /* synthetic */ InboundFrameOpStats copy$default(InboundFrameOpStats inboundFrameOpStats, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, int i, Object obj) {
        if ((i & 1) != 0) {
            l = inboundFrameOpStats.silent;
        }
        if ((i & 2) != 0) {
            l2 = inboundFrameOpStats.normal;
        }
        Long l8 = l2;
        if ((i & 4) != 0) {
            l3 = inboundFrameOpStats.merged;
        }
        Long l9 = l3;
        if ((i & 8) != 0) {
            l4 = inboundFrameOpStats.expanded;
        }
        Long l10 = l4;
        if ((i & 16) != 0) {
            l5 = inboundFrameOpStats.accelerated;
        }
        Long l11 = l5;
        if ((i & 32) != 0) {
            l6 = inboundFrameOpStats.preemptiveExpanded;
        }
        Long l12 = l6;
        if ((i & 64) != 0) {
            l7 = inboundFrameOpStats.cng;
        }
        return inboundFrameOpStats.copy(l, l8, l9, l10, l11, l12, l7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getSilent() {
        return this.silent;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getNormal() {
        return this.normal;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getMerged() {
        return this.merged;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getExpanded() {
        return this.expanded;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getAccelerated() {
        return this.accelerated;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getPreemptiveExpanded() {
        return this.preemptiveExpanded;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getCng() {
        return this.cng;
    }

    public final InboundFrameOpStats copy(Long silent, Long normal, Long merged, Long expanded, Long accelerated, Long preemptiveExpanded, Long cng) {
        return new InboundFrameOpStats(silent, normal, merged, expanded, accelerated, preemptiveExpanded, cng);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboundFrameOpStats)) {
            return false;
        }
        InboundFrameOpStats inboundFrameOpStats = (InboundFrameOpStats) other;
        return m.areEqual(this.silent, inboundFrameOpStats.silent) && m.areEqual(this.normal, inboundFrameOpStats.normal) && m.areEqual(this.merged, inboundFrameOpStats.merged) && m.areEqual(this.expanded, inboundFrameOpStats.expanded) && m.areEqual(this.accelerated, inboundFrameOpStats.accelerated) && m.areEqual(this.preemptiveExpanded, inboundFrameOpStats.preemptiveExpanded) && m.areEqual(this.cng, inboundFrameOpStats.cng);
    }

    public final Long getAccelerated() {
        return this.accelerated;
    }

    public final Long getCng() {
        return this.cng;
    }

    public final Long getExpanded() {
        return this.expanded;
    }

    public final Long getMerged() {
        return this.merged;
    }

    public final Long getNormal() {
        return this.normal;
    }

    public final Long getPreemptiveExpanded() {
        return this.preemptiveExpanded;
    }

    public final Long getSilent() {
        return this.silent;
    }

    public int hashCode() {
        Long l = this.silent;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.normal;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.merged;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.expanded;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.accelerated;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.preemptiveExpanded;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.cng;
        return iHashCode6 + (l7 != null ? l7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("InboundFrameOpStats(silent=");
        sbU.append(this.silent);
        sbU.append(", normal=");
        sbU.append(this.normal);
        sbU.append(", merged=");
        sbU.append(this.merged);
        sbU.append(", expanded=");
        sbU.append(this.expanded);
        sbU.append(", accelerated=");
        sbU.append(this.accelerated);
        sbU.append(", preemptiveExpanded=");
        sbU.append(this.preemptiveExpanded);
        sbU.append(", cng=");
        return a.G(sbU, this.cng, ")");
    }
}
