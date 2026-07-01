package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackGuildDiscoveryGuildSelected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildDiscoveryGuildSelected implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final Long guildId = null;
    private final CharSequence loadId = null;
    private final Long cardIndex = null;
    private final Long categoryId = null;
    private final transient String analyticsSchemaTypeName = "guild_discovery_guild_selected";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildDiscoveryGuildSelected)) {
            return false;
        }
        TrackGuildDiscoveryGuildSelected trackGuildDiscoveryGuildSelected = (TrackGuildDiscoveryGuildSelected) other;
        return Intrinsics3.areEqual(this.guildId, trackGuildDiscoveryGuildSelected.guildId) && Intrinsics3.areEqual(this.loadId, trackGuildDiscoveryGuildSelected.loadId) && Intrinsics3.areEqual(this.cardIndex, trackGuildDiscoveryGuildSelected.cardIndex) && Intrinsics3.areEqual(this.categoryId, trackGuildDiscoveryGuildSelected.categoryId);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.loadId;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.cardIndex;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.categoryId;
        return iHashCode3 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildDiscoveryGuildSelected(guildId=");
        sbU.append(this.guildId);
        sbU.append(", loadId=");
        sbU.append(this.loadId);
        sbU.append(", cardIndex=");
        sbU.append(this.cardIndex);
        sbU.append(", categoryId=");
        return outline.G(sbU, this.categoryId, ")");
    }
}
