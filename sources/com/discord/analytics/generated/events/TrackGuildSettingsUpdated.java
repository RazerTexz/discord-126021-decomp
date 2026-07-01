package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackGuildSettingsUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildSettingsUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final CharSequence iconEditType = null;
    private final CharSequence guildName = null;
    private final CharSequence oldGuildName = null;
    private final Boolean animatedIcon = null;
    private final CharSequence bannerEditType = null;
    private final CharSequence splashEditType = null;
    private final CharSequence vanityUrlCodeEditType = null;
    private final CharSequence vanityUrlCode = null;
    private final CharSequence oldVanityUrlCode = null;
    private final CharSequence discoverySplashEditType = null;
    private final CharSequence description = null;
    private final CharSequence preferredLocale = null;
    private final Boolean isPublic = null;
    private final Boolean isDiscoverable = null;
    private final Boolean isFeaturable = null;
    private final Long rulesChannelId = null;
    private final Long publicUpdatesChannelId = null;
    private final Boolean premiumProgressBarEnabled = null;
    private final Boolean animatedBanner = null;
    private final transient String analyticsSchemaTypeName = "guild_settings_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildSettingsUpdated)) {
            return false;
        }
        TrackGuildSettingsUpdated trackGuildSettingsUpdated = (TrackGuildSettingsUpdated) other;
        return Intrinsics3.areEqual(this.guildId, trackGuildSettingsUpdated.guildId) && Intrinsics3.areEqual(this.iconEditType, trackGuildSettingsUpdated.iconEditType) && Intrinsics3.areEqual(this.guildName, trackGuildSettingsUpdated.guildName) && Intrinsics3.areEqual(this.oldGuildName, trackGuildSettingsUpdated.oldGuildName) && Intrinsics3.areEqual(this.animatedIcon, trackGuildSettingsUpdated.animatedIcon) && Intrinsics3.areEqual(this.bannerEditType, trackGuildSettingsUpdated.bannerEditType) && Intrinsics3.areEqual(this.splashEditType, trackGuildSettingsUpdated.splashEditType) && Intrinsics3.areEqual(this.vanityUrlCodeEditType, trackGuildSettingsUpdated.vanityUrlCodeEditType) && Intrinsics3.areEqual(this.vanityUrlCode, trackGuildSettingsUpdated.vanityUrlCode) && Intrinsics3.areEqual(this.oldVanityUrlCode, trackGuildSettingsUpdated.oldVanityUrlCode) && Intrinsics3.areEqual(this.discoverySplashEditType, trackGuildSettingsUpdated.discoverySplashEditType) && Intrinsics3.areEqual(this.description, trackGuildSettingsUpdated.description) && Intrinsics3.areEqual(this.preferredLocale, trackGuildSettingsUpdated.preferredLocale) && Intrinsics3.areEqual(this.isPublic, trackGuildSettingsUpdated.isPublic) && Intrinsics3.areEqual(this.isDiscoverable, trackGuildSettingsUpdated.isDiscoverable) && Intrinsics3.areEqual(this.isFeaturable, trackGuildSettingsUpdated.isFeaturable) && Intrinsics3.areEqual(this.rulesChannelId, trackGuildSettingsUpdated.rulesChannelId) && Intrinsics3.areEqual(this.publicUpdatesChannelId, trackGuildSettingsUpdated.publicUpdatesChannelId) && Intrinsics3.areEqual(this.premiumProgressBarEnabled, trackGuildSettingsUpdated.premiumProgressBarEnabled) && Intrinsics3.areEqual(this.animatedBanner, trackGuildSettingsUpdated.animatedBanner);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.iconEditType;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.guildName;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.oldGuildName;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.animatedIcon;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.bannerEditType;
        int iHashCode6 = (iHashCode5 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.splashEditType;
        int iHashCode7 = (iHashCode6 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.vanityUrlCodeEditType;
        int iHashCode8 = (iHashCode7 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.vanityUrlCode;
        int iHashCode9 = (iHashCode8 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.oldVanityUrlCode;
        int iHashCode10 = (iHashCode9 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.discoverySplashEditType;
        int iHashCode11 = (iHashCode10 + (charSequence9 != null ? charSequence9.hashCode() : 0)) * 31;
        CharSequence charSequence10 = this.description;
        int iHashCode12 = (iHashCode11 + (charSequence10 != null ? charSequence10.hashCode() : 0)) * 31;
        CharSequence charSequence11 = this.preferredLocale;
        int iHashCode13 = (iHashCode12 + (charSequence11 != null ? charSequence11.hashCode() : 0)) * 31;
        Boolean bool2 = this.isPublic;
        int iHashCode14 = (iHashCode13 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isDiscoverable;
        int iHashCode15 = (iHashCode14 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.isFeaturable;
        int iHashCode16 = (iHashCode15 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Long l2 = this.rulesChannelId;
        int iHashCode17 = (iHashCode16 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.publicUpdatesChannelId;
        int iHashCode18 = (iHashCode17 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool5 = this.premiumProgressBarEnabled;
        int iHashCode19 = (iHashCode18 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.animatedBanner;
        return iHashCode19 + (bool6 != null ? bool6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildSettingsUpdated(guildId=");
        sbU.append(this.guildId);
        sbU.append(", iconEditType=");
        sbU.append(this.iconEditType);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", oldGuildName=");
        sbU.append(this.oldGuildName);
        sbU.append(", animatedIcon=");
        sbU.append(this.animatedIcon);
        sbU.append(", bannerEditType=");
        sbU.append(this.bannerEditType);
        sbU.append(", splashEditType=");
        sbU.append(this.splashEditType);
        sbU.append(", vanityUrlCodeEditType=");
        sbU.append(this.vanityUrlCodeEditType);
        sbU.append(", vanityUrlCode=");
        sbU.append(this.vanityUrlCode);
        sbU.append(", oldVanityUrlCode=");
        sbU.append(this.oldVanityUrlCode);
        sbU.append(", discoverySplashEditType=");
        sbU.append(this.discoverySplashEditType);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", preferredLocale=");
        sbU.append(this.preferredLocale);
        sbU.append(", isPublic=");
        sbU.append(this.isPublic);
        sbU.append(", isDiscoverable=");
        sbU.append(this.isDiscoverable);
        sbU.append(", isFeaturable=");
        sbU.append(this.isFeaturable);
        sbU.append(", rulesChannelId=");
        sbU.append(this.rulesChannelId);
        sbU.append(", publicUpdatesChannelId=");
        sbU.append(this.publicUpdatesChannelId);
        sbU.append(", premiumProgressBarEnabled=");
        sbU.append(this.premiumProgressBarEnabled);
        sbU.append(", animatedBanner=");
        return outline.D(sbU, this.animatedBanner, ")");
    }
}
