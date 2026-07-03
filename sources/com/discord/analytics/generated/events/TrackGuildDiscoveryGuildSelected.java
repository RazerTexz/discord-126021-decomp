package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGuildDiscoveryGuildSelected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildDiscoveryGuildSelected implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
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
        return C12238m.areEqual(this.guildId, trackGuildDiscoveryGuildSelected.guildId) && C12238m.areEqual(this.loadId, trackGuildDiscoveryGuildSelected.loadId) && C12238m.areEqual(this.cardIndex, trackGuildDiscoveryGuildSelected.cardIndex) && C12238m.areEqual(this.categoryId, trackGuildDiscoveryGuildSelected.categoryId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackGuildDiscoveryGuildSelected(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", cardIndex=");
        sbM833U.append(this.cardIndex);
        sbM833U.append(", categoryId=");
        return C1643a.m819G(sbM833U, this.categoryId, ")");
    }
}
