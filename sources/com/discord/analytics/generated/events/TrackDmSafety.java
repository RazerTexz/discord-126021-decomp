package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackDmSafety.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDmSafety implements AnalyticsSchema, TrackBaseReceiver, TrackChannelReceiver {
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
        return C12238m.areEqual(this.safetyPrompt, trackDmSafety.safetyPrompt) && C12238m.areEqual(this.response, trackDmSafety.response) && C12238m.areEqual(this.messageId, trackDmSafety.messageId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackDmSafety(safetyPrompt=");
        sbM833U.append(this.safetyPrompt);
        sbM833U.append(", response=");
        sbM833U.append(this.response);
        sbM833U.append(", messageId=");
        return C1643a.m819G(sbM833U, this.messageId, ")");
    }
}
