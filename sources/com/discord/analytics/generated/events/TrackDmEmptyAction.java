package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackDmEmptyAction.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDmEmptyAction implements AnalyticsSchema, TrackBaseReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private final CharSequence source = null;
    private final CharSequence type = null;
    private final transient String analyticsSchemaTypeName = "dm_empty_action";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDmEmptyAction)) {
            return false;
        }
        TrackDmEmptyAction trackDmEmptyAction = (TrackDmEmptyAction) other;
        return m.areEqual(this.source, trackDmEmptyAction.source) && m.areEqual(this.type, trackDmEmptyAction.type);
    }

    public int hashCode() {
        CharSequence charSequence = this.source;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.type;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackDmEmptyAction(source=");
        sbU.append(this.source);
        sbU.append(", type=");
        return a.E(sbU, this.type, ")");
    }
}
