package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.source, trackDmEmptyAction.source) && C12238m.areEqual(this.type, trackDmEmptyAction.type);
    }

    public int hashCode() {
        CharSequence charSequence = this.source;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.type;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackDmEmptyAction(source=");
        sbM833U.append(this.source);
        sbM833U.append(", type=");
        return C1643a.m817E(sbM833U, this.type, ")");
    }
}
