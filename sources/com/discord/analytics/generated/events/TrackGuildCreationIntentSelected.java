package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGuildCreationIntentSelected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildCreationIntentSelected implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.isCommunity, trackGuildCreationIntentSelected.isCommunity) && C12238m.areEqual(this.skipped, trackGuildCreationIntentSelected.skipped);
    }

    public int hashCode() {
        Boolean bool = this.isCommunity;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.skipped;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGuildCreationIntentSelected(isCommunity=");
        sbM833U.append(this.isCommunity);
        sbM833U.append(", skipped=");
        return C1643a.m816D(sbM833U, this.skipped, ")");
    }
}
