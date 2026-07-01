package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackDmSafety.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDmSafety implements AnalyticsSchema, TrackBase2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private final CharSequence safetyPrompt = null;
    private final CharSequence response = null;
    private final Long messageId = null;
    private final transient String analyticsSchemaTypeName = "dm_safety";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDmSafety)) {
            return false;
        }
        TrackDmSafety trackDmSafety = (TrackDmSafety) other;
        return Intrinsics3.areEqual(this.safetyPrompt, trackDmSafety.safetyPrompt) && Intrinsics3.areEqual(this.response, trackDmSafety.response) && Intrinsics3.areEqual(this.messageId, trackDmSafety.messageId);
    }

    public int hashCode() {
        CharSequence charSequence = this.safetyPrompt;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.response;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.messageId;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackDmSafety(safetyPrompt=");
        sbU.append(this.safetyPrompt);
        sbU.append(", response=");
        sbU.append(this.response);
        sbU.append(", messageId=");
        return outline.G(sbU, this.messageId, ")");
    }
}
