package com.discord.analytics.generated.traits;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.previewEnabled, trackGuildMembershipGateMetadata.previewEnabled) && C12238m.areEqual(this.requirements, trackGuildMembershipGateMetadata.requirements);
    }

    public int hashCode() {
        Boolean bool = this.previewEnabled;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        List<CharSequence> list = this.requirements;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGuildMembershipGateMetadata(previewEnabled=");
        sbM833U.append(this.previewEnabled);
        sbM833U.append(", requirements=");
        return C1643a.m824L(sbM833U, this.requirements, ")");
    }
}
