package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackNotificationSettingsUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNotificationSettingsUpdated implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence updateType = null;
    private final Boolean guildSuppressEveryone = null;
    private final Boolean guildSuppressRoles = null;
    private final Boolean guildIsMuted = null;
    private final Long guildMutedUntil = null;
    private final Boolean guildReceiveMobilePush = null;
    private final CharSequence guildMessageNotificationSettings = null;
    private final Long parentId = null;
    private final Boolean channelIsOverridden = null;
    private final Boolean channelIsMuted = null;
    private final Long channeMutedUntil = null;
    private final Long channelMutedUntil = null;
    private final CharSequence channelMessageNotificationSettings = null;
    private final Boolean guildScheduledEventsMuted = null;
    private final Long guildNotifyHighlights = null;
    private final transient String analyticsSchemaTypeName = "notification_settings_updated";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNotificationSettingsUpdated)) {
            return false;
        }
        TrackNotificationSettingsUpdated trackNotificationSettingsUpdated = (TrackNotificationSettingsUpdated) other;
        return Intrinsics3.areEqual(this.updateType, trackNotificationSettingsUpdated.updateType) && Intrinsics3.areEqual(this.guildSuppressEveryone, trackNotificationSettingsUpdated.guildSuppressEveryone) && Intrinsics3.areEqual(this.guildSuppressRoles, trackNotificationSettingsUpdated.guildSuppressRoles) && Intrinsics3.areEqual(this.guildIsMuted, trackNotificationSettingsUpdated.guildIsMuted) && Intrinsics3.areEqual(this.guildMutedUntil, trackNotificationSettingsUpdated.guildMutedUntil) && Intrinsics3.areEqual(this.guildReceiveMobilePush, trackNotificationSettingsUpdated.guildReceiveMobilePush) && Intrinsics3.areEqual(this.guildMessageNotificationSettings, trackNotificationSettingsUpdated.guildMessageNotificationSettings) && Intrinsics3.areEqual(this.parentId, trackNotificationSettingsUpdated.parentId) && Intrinsics3.areEqual(this.channelIsOverridden, trackNotificationSettingsUpdated.channelIsOverridden) && Intrinsics3.areEqual(this.channelIsMuted, trackNotificationSettingsUpdated.channelIsMuted) && Intrinsics3.areEqual(this.channeMutedUntil, trackNotificationSettingsUpdated.channeMutedUntil) && Intrinsics3.areEqual(this.channelMutedUntil, trackNotificationSettingsUpdated.channelMutedUntil) && Intrinsics3.areEqual(this.channelMessageNotificationSettings, trackNotificationSettingsUpdated.channelMessageNotificationSettings) && Intrinsics3.areEqual(this.guildScheduledEventsMuted, trackNotificationSettingsUpdated.guildScheduledEventsMuted) && Intrinsics3.areEqual(this.guildNotifyHighlights, trackNotificationSettingsUpdated.guildNotifyHighlights);
    }

    public int hashCode() {
        CharSequence charSequence = this.updateType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.guildSuppressEveryone;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.guildSuppressRoles;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.guildIsMuted;
        int iHashCode4 = (iHashCode3 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l = this.guildMutedUntil;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool4 = this.guildReceiveMobilePush;
        int iHashCode6 = (iHashCode5 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.guildMessageNotificationSettings;
        int iHashCode7 = (iHashCode6 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l2 = this.parentId;
        int iHashCode8 = (iHashCode7 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool5 = this.channelIsOverridden;
        int iHashCode9 = (iHashCode8 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.channelIsMuted;
        int iHashCode10 = (iHashCode9 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Long l3 = this.channeMutedUntil;
        int iHashCode11 = (iHashCode10 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.channelMutedUntil;
        int iHashCode12 = (iHashCode11 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.channelMessageNotificationSettings;
        int iHashCode13 = (iHashCode12 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool7 = this.guildScheduledEventsMuted;
        int iHashCode14 = (iHashCode13 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        Long l5 = this.guildNotifyHighlights;
        return iHashCode14 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNotificationSettingsUpdated(updateType=");
        sbU.append(this.updateType);
        sbU.append(", guildSuppressEveryone=");
        sbU.append(this.guildSuppressEveryone);
        sbU.append(", guildSuppressRoles=");
        sbU.append(this.guildSuppressRoles);
        sbU.append(", guildIsMuted=");
        sbU.append(this.guildIsMuted);
        sbU.append(", guildMutedUntil=");
        sbU.append(this.guildMutedUntil);
        sbU.append(", guildReceiveMobilePush=");
        sbU.append(this.guildReceiveMobilePush);
        sbU.append(", guildMessageNotificationSettings=");
        sbU.append(this.guildMessageNotificationSettings);
        sbU.append(", parentId=");
        sbU.append(this.parentId);
        sbU.append(", channelIsOverridden=");
        sbU.append(this.channelIsOverridden);
        sbU.append(", channelIsMuted=");
        sbU.append(this.channelIsMuted);
        sbU.append(", channeMutedUntil=");
        sbU.append(this.channeMutedUntil);
        sbU.append(", channelMutedUntil=");
        sbU.append(this.channelMutedUntil);
        sbU.append(", channelMessageNotificationSettings=");
        sbU.append(this.channelMessageNotificationSettings);
        sbU.append(", guildScheduledEventsMuted=");
        sbU.append(this.guildScheduledEventsMuted);
        sbU.append(", guildNotifyHighlights=");
        return outline.G(sbU, this.guildNotifyHighlights, ")");
    }
}
