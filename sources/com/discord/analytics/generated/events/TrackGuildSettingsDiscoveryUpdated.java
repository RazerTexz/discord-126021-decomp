package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGuildSettingsDiscoveryUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildSettingsDiscoveryUpdated implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.guildId, trackGuildSettingsDiscoveryUpdated.guildId) && C12238m.areEqual(this.automatic, trackGuildSettingsDiscoveryUpdated.automatic) && C12238m.areEqual(this.discoverySplashEditType, trackGuildSettingsDiscoveryUpdated.discoverySplashEditType) && C12238m.areEqual(this.rulesChannelId, trackGuildSettingsDiscoveryUpdated.rulesChannelId) && C12238m.areEqual(this.isDiscoverable, trackGuildSettingsDiscoveryUpdated.isDiscoverable) && C12238m.areEqual(this.failedReasons, trackGuildSettingsDiscoveryUpdated.failedReasons);
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
        StringBuilder sbM833U = C1643a.m833U("TrackGuildSettingsDiscoveryUpdated(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", automatic=");
        sbM833U.append(this.automatic);
        sbM833U.append(", discoverySplashEditType=");
        sbM833U.append(this.discoverySplashEditType);
        sbM833U.append(", rulesChannelId=");
        sbM833U.append(this.rulesChannelId);
        sbM833U.append(", isDiscoverable=");
        sbM833U.append(this.isDiscoverable);
        sbM833U.append(", failedReasons=");
        return C1643a.m824L(sbM833U, this.failedReasons, ")");
    }
}
