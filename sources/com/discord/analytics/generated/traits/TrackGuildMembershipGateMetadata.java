package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: TrackGuildMembershipGateMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildMembershipGateMetadata {
    private final Boolean previewEnabled = null;
    private final List<CharSequence> requirements = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildMembershipGateMetadata)) {
            return false;
        }
        TrackGuildMembershipGateMetadata trackGuildMembershipGateMetadata = (TrackGuildMembershipGateMetadata) other;
        return m.areEqual(this.previewEnabled, trackGuildMembershipGateMetadata.previewEnabled) && m.areEqual(this.requirements, trackGuildMembershipGateMetadata.requirements);
    }

    public int hashCode() {
        Boolean bool = this.previewEnabled;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        List<CharSequence> list = this.requirements;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackGuildMembershipGateMetadata(previewEnabled=");
        sbU.append(this.previewEnabled);
        sbU.append(", requirements=");
        return a.L(sbU, this.requirements, ")");
    }
}
