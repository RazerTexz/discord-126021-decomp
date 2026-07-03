package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGuildDefaultDmsUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildDefaultDmsUpdated implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.defaultGuildsRestricted, trackGuildDefaultDmsUpdated.defaultGuildsRestricted) && C12238m.areEqual(this.appliedToExistingGuilds, trackGuildDefaultDmsUpdated.appliedToExistingGuilds);
    }

    public int hashCode() {
        Boolean bool = this.defaultGuildsRestricted;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.appliedToExistingGuilds;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGuildDefaultDmsUpdated(defaultGuildsRestricted=");
        sbM833U.append(this.defaultGuildsRestricted);
        sbM833U.append(", appliedToExistingGuilds=");
        return C1643a.m816D(sbM833U, this.appliedToExistingGuilds, ")");
    }
}
