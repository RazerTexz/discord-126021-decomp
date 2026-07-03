package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGuildSettingsUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildSettingsUpdated implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.guildId, trackGuildSettingsUpdated.guildId) && C12238m.areEqual(this.iconEditType, trackGuildSettingsUpdated.iconEditType) && C12238m.areEqual(this.guildName, trackGuildSettingsUpdated.guildName) && C12238m.areEqual(this.oldGuildName, trackGuildSettingsUpdated.oldGuildName) && C12238m.areEqual(this.animatedIcon, trackGuildSettingsUpdated.animatedIcon) && C12238m.areEqual(this.bannerEditType, trackGuildSettingsUpdated.bannerEditType) && C12238m.areEqual(this.splashEditType, trackGuildSettingsUpdated.splashEditType) && C12238m.areEqual(this.vanityUrlCodeEditType, trackGuildSettingsUpdated.vanityUrlCodeEditType) && C12238m.areEqual(this.vanityUrlCode, trackGuildSettingsUpdated.vanityUrlCode) && C12238m.areEqual(this.oldVanityUrlCode, trackGuildSettingsUpdated.oldVanityUrlCode) && C12238m.areEqual(this.discoverySplashEditType, trackGuildSettingsUpdated.discoverySplashEditType) && C12238m.areEqual(this.description, trackGuildSettingsUpdated.description) && C12238m.areEqual(this.preferredLocale, trackGuildSettingsUpdated.preferredLocale) && C12238m.areEqual(this.isPublic, trackGuildSettingsUpdated.isPublic) && C12238m.areEqual(this.isDiscoverable, trackGuildSettingsUpdated.isDiscoverable) && C12238m.areEqual(this.isFeaturable, trackGuildSettingsUpdated.isFeaturable) && C12238m.areEqual(this.rulesChannelId, trackGuildSettingsUpdated.rulesChannelId) && C12238m.areEqual(this.publicUpdatesChannelId, trackGuildSettingsUpdated.publicUpdatesChannelId) && C12238m.areEqual(this.premiumProgressBarEnabled, trackGuildSettingsUpdated.premiumProgressBarEnabled) && C12238m.areEqual(this.animatedBanner, trackGuildSettingsUpdated.animatedBanner);
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
        StringBuilder sbM833U = C1643a.m833U("TrackGuildSettingsUpdated(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", iconEditType=");
        sbM833U.append(this.iconEditType);
        sbM833U.append(", guildName=");
        sbM833U.append(this.guildName);
        sbM833U.append(", oldGuildName=");
        sbM833U.append(this.oldGuildName);
        sbM833U.append(", animatedIcon=");
        sbM833U.append(this.animatedIcon);
        sbM833U.append(", bannerEditType=");
        sbM833U.append(this.bannerEditType);
        sbM833U.append(", splashEditType=");
        sbM833U.append(this.splashEditType);
        sbM833U.append(", vanityUrlCodeEditType=");
        sbM833U.append(this.vanityUrlCodeEditType);
        sbM833U.append(", vanityUrlCode=");
        sbM833U.append(this.vanityUrlCode);
        sbM833U.append(", oldVanityUrlCode=");
        sbM833U.append(this.oldVanityUrlCode);
        sbM833U.append(", discoverySplashEditType=");
        sbM833U.append(this.discoverySplashEditType);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", preferredLocale=");
        sbM833U.append(this.preferredLocale);
        sbM833U.append(", isPublic=");
        sbM833U.append(this.isPublic);
        sbM833U.append(", isDiscoverable=");
        sbM833U.append(this.isDiscoverable);
        sbM833U.append(", isFeaturable=");
        sbM833U.append(this.isFeaturable);
        sbM833U.append(", rulesChannelId=");
        sbM833U.append(this.rulesChannelId);
        sbM833U.append(", publicUpdatesChannelId=");
        sbM833U.append(this.publicUpdatesChannelId);
        sbM833U.append(", premiumProgressBarEnabled=");
        sbM833U.append(this.premiumProgressBarEnabled);
        sbM833U.append(", animatedBanner=");
        return C1643a.m816D(sbM833U, this.animatedBanner, ")");
    }
}
