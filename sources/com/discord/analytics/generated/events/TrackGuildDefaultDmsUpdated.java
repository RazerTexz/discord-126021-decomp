package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackGuildDefaultDmsUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildDefaultDmsUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean defaultGuildsRestricted = null;
    private final Boolean appliedToExistingGuilds = null;
    private final transient String analyticsSchemaTypeName = "guild_default_dms_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildDefaultDmsUpdated)) {
            return false;
        }
        TrackGuildDefaultDmsUpdated trackGuildDefaultDmsUpdated = (TrackGuildDefaultDmsUpdated) other;
        return Intrinsics3.areEqual(this.defaultGuildsRestricted, trackGuildDefaultDmsUpdated.defaultGuildsRestricted) && Intrinsics3.areEqual(this.appliedToExistingGuilds, trackGuildDefaultDmsUpdated.appliedToExistingGuilds);
    }

    public int hashCode() {
        Boolean bool = this.defaultGuildsRestricted;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.appliedToExistingGuilds;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildDefaultDmsUpdated(defaultGuildsRestricted=");
        sbU.append(this.defaultGuildsRestricted);
        sbU.append(", appliedToExistingGuilds=");
        return outline.D(sbU, this.appliedToExistingGuilds, ")");
    }
}
