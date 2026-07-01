package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackGuildCreationIntentSelected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildCreationIntentSelected implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean isCommunity = null;
    private final Boolean skipped = null;
    private final transient String analyticsSchemaTypeName = "guild_creation_intent_selected";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildCreationIntentSelected)) {
            return false;
        }
        TrackGuildCreationIntentSelected trackGuildCreationIntentSelected = (TrackGuildCreationIntentSelected) other;
        return Intrinsics3.areEqual(this.isCommunity, trackGuildCreationIntentSelected.isCommunity) && Intrinsics3.areEqual(this.skipped, trackGuildCreationIntentSelected.skipped);
    }

    public int hashCode() {
        Boolean bool = this.isCommunity;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.skipped;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildCreationIntentSelected(isCommunity=");
        sbU.append(this.isCommunity);
        sbU.append(", skipped=");
        return outline.D(sbU, this.skipped, ")");
    }
}
