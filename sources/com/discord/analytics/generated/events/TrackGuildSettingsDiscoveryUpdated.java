package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackGuildSettingsDiscoveryUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildSettingsDiscoveryUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Boolean automatic = null;
    private final CharSequence discoverySplashEditType = null;
    private final Long rulesChannelId = null;
    private final Boolean isDiscoverable = null;
    private final List<CharSequence> failedReasons = null;
    private final transient String analyticsSchemaTypeName = "guild_settings_discovery_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildSettingsDiscoveryUpdated)) {
            return false;
        }
        TrackGuildSettingsDiscoveryUpdated trackGuildSettingsDiscoveryUpdated = (TrackGuildSettingsDiscoveryUpdated) other;
        return Intrinsics3.areEqual(this.guildId, trackGuildSettingsDiscoveryUpdated.guildId) && Intrinsics3.areEqual(this.automatic, trackGuildSettingsDiscoveryUpdated.automatic) && Intrinsics3.areEqual(this.discoverySplashEditType, trackGuildSettingsDiscoveryUpdated.discoverySplashEditType) && Intrinsics3.areEqual(this.rulesChannelId, trackGuildSettingsDiscoveryUpdated.rulesChannelId) && Intrinsics3.areEqual(this.isDiscoverable, trackGuildSettingsDiscoveryUpdated.isDiscoverable) && Intrinsics3.areEqual(this.failedReasons, trackGuildSettingsDiscoveryUpdated.failedReasons);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Boolean bool = this.automatic;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence = this.discoverySplashEditType;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.rulesChannelId;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool2 = this.isDiscoverable;
        int iHashCode5 = (iHashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        List<CharSequence> list = this.failedReasons;
        return iHashCode5 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildSettingsDiscoveryUpdated(guildId=");
        sbU.append(this.guildId);
        sbU.append(", automatic=");
        sbU.append(this.automatic);
        sbU.append(", discoverySplashEditType=");
        sbU.append(this.discoverySplashEditType);
        sbU.append(", rulesChannelId=");
        sbU.append(this.rulesChannelId);
        sbU.append(", isDiscoverable=");
        sbU.append(this.isDiscoverable);
        sbU.append(", failedReasons=");
        return outline.L(sbU, this.failedReasons, ")");
    }
}
