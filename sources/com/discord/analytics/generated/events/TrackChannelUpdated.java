package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackChannelUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackChannelUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private final Long guildId = null;
    private final CharSequence guildName = null;
    private final CharSequence oldName = null;
    private final CharSequence newName = null;
    private final Boolean oldNsfw = null;
    private final Boolean newNsfw = null;
    private final Long bitrate = null;
    private final Long oldBitrate = null;
    private final CharSequence rtcRegion = null;
    private final CharSequence oldRtcRegion = null;
    private final Long videoQualityMode = null;
    private final Long oldVideoQualityMode = null;
    private final Long defaultAutoArchiveDurationMinutes = null;
    private final Long oldDefaultAutoArchiveDurationMinutes = null;
    private final Boolean oldArchived = null;
    private final Boolean newArchived = null;
    private final Boolean oldLocked = null;
    private final Boolean newLocked = null;
    private final Boolean oldInvitable = null;
    private final Boolean newInvitable = null;
    private final Long oldAutoArchiveDurationMinutes = null;
    private final Long newAutoArchiveDurationMinutes = null;
    private final CharSequence oldBannerHash = null;
    private final CharSequence newBannerHash = null;
    private final Long oldFlags = null;
    private final Long newFlags = null;
    private final transient String analyticsSchemaTypeName = "channel_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackChannelUpdated)) {
            return false;
        }
        TrackChannelUpdated trackChannelUpdated = (TrackChannelUpdated) other;
        return m.areEqual(this.guildId, trackChannelUpdated.guildId) && m.areEqual(this.guildName, trackChannelUpdated.guildName) && m.areEqual(this.oldName, trackChannelUpdated.oldName) && m.areEqual(this.newName, trackChannelUpdated.newName) && m.areEqual(this.oldNsfw, trackChannelUpdated.oldNsfw) && m.areEqual(this.newNsfw, trackChannelUpdated.newNsfw) && m.areEqual(this.bitrate, trackChannelUpdated.bitrate) && m.areEqual(this.oldBitrate, trackChannelUpdated.oldBitrate) && m.areEqual(this.rtcRegion, trackChannelUpdated.rtcRegion) && m.areEqual(this.oldRtcRegion, trackChannelUpdated.oldRtcRegion) && m.areEqual(this.videoQualityMode, trackChannelUpdated.videoQualityMode) && m.areEqual(this.oldVideoQualityMode, trackChannelUpdated.oldVideoQualityMode) && m.areEqual(this.defaultAutoArchiveDurationMinutes, trackChannelUpdated.defaultAutoArchiveDurationMinutes) && m.areEqual(this.oldDefaultAutoArchiveDurationMinutes, trackChannelUpdated.oldDefaultAutoArchiveDurationMinutes) && m.areEqual(this.oldArchived, trackChannelUpdated.oldArchived) && m.areEqual(this.newArchived, trackChannelUpdated.newArchived) && m.areEqual(this.oldLocked, trackChannelUpdated.oldLocked) && m.areEqual(this.newLocked, trackChannelUpdated.newLocked) && m.areEqual(this.oldInvitable, trackChannelUpdated.oldInvitable) && m.areEqual(this.newInvitable, trackChannelUpdated.newInvitable) && m.areEqual(this.oldAutoArchiveDurationMinutes, trackChannelUpdated.oldAutoArchiveDurationMinutes) && m.areEqual(this.newAutoArchiveDurationMinutes, trackChannelUpdated.newAutoArchiveDurationMinutes) && m.areEqual(this.oldBannerHash, trackChannelUpdated.oldBannerHash) && m.areEqual(this.newBannerHash, trackChannelUpdated.newBannerHash) && m.areEqual(this.oldFlags, trackChannelUpdated.oldFlags) && m.areEqual(this.newFlags, trackChannelUpdated.newFlags);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.guildName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.oldName;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.newName;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.oldNsfw;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.newNsfw;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l2 = this.bitrate;
        int iHashCode7 = (iHashCode6 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.oldBitrate;
        int iHashCode8 = (iHashCode7 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.rtcRegion;
        int iHashCode9 = (iHashCode8 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.oldRtcRegion;
        int iHashCode10 = (iHashCode9 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l4 = this.videoQualityMode;
        int iHashCode11 = (iHashCode10 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.oldVideoQualityMode;
        int iHashCode12 = (iHashCode11 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.defaultAutoArchiveDurationMinutes;
        int iHashCode13 = (iHashCode12 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.oldDefaultAutoArchiveDurationMinutes;
        int iHashCode14 = (iHashCode13 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Boolean bool3 = this.oldArchived;
        int iHashCode15 = (iHashCode14 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.newArchived;
        int iHashCode16 = (iHashCode15 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.oldLocked;
        int iHashCode17 = (iHashCode16 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.newLocked;
        int iHashCode18 = (iHashCode17 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Boolean bool7 = this.oldInvitable;
        int iHashCode19 = (iHashCode18 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        Boolean bool8 = this.newInvitable;
        int iHashCode20 = (iHashCode19 + (bool8 != null ? bool8.hashCode() : 0)) * 31;
        Long l8 = this.oldAutoArchiveDurationMinutes;
        int iHashCode21 = (iHashCode20 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.newAutoArchiveDurationMinutes;
        int iHashCode22 = (iHashCode21 + (l9 != null ? l9.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.oldBannerHash;
        int iHashCode23 = (iHashCode22 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.newBannerHash;
        int iHashCode24 = (iHashCode23 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        Long l10 = this.oldFlags;
        int iHashCode25 = (iHashCode24 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.newFlags;
        return iHashCode25 + (l11 != null ? l11.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackChannelUpdated(guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", oldName=");
        sbU.append(this.oldName);
        sbU.append(", newName=");
        sbU.append(this.newName);
        sbU.append(", oldNsfw=");
        sbU.append(this.oldNsfw);
        sbU.append(", newNsfw=");
        sbU.append(this.newNsfw);
        sbU.append(", bitrate=");
        sbU.append(this.bitrate);
        sbU.append(", oldBitrate=");
        sbU.append(this.oldBitrate);
        sbU.append(", rtcRegion=");
        sbU.append(this.rtcRegion);
        sbU.append(", oldRtcRegion=");
        sbU.append(this.oldRtcRegion);
        sbU.append(", videoQualityMode=");
        sbU.append(this.videoQualityMode);
        sbU.append(", oldVideoQualityMode=");
        sbU.append(this.oldVideoQualityMode);
        sbU.append(", defaultAutoArchiveDurationMinutes=");
        sbU.append(this.defaultAutoArchiveDurationMinutes);
        sbU.append(", oldDefaultAutoArchiveDurationMinutes=");
        sbU.append(this.oldDefaultAutoArchiveDurationMinutes);
        sbU.append(", oldArchived=");
        sbU.append(this.oldArchived);
        sbU.append(", newArchived=");
        sbU.append(this.newArchived);
        sbU.append(", oldLocked=");
        sbU.append(this.oldLocked);
        sbU.append(", newLocked=");
        sbU.append(this.newLocked);
        sbU.append(", oldInvitable=");
        sbU.append(this.oldInvitable);
        sbU.append(", newInvitable=");
        sbU.append(this.newInvitable);
        sbU.append(", oldAutoArchiveDurationMinutes=");
        sbU.append(this.oldAutoArchiveDurationMinutes);
        sbU.append(", newAutoArchiveDurationMinutes=");
        sbU.append(this.newAutoArchiveDurationMinutes);
        sbU.append(", oldBannerHash=");
        sbU.append(this.oldBannerHash);
        sbU.append(", newBannerHash=");
        sbU.append(this.newBannerHash);
        sbU.append(", oldFlags=");
        sbU.append(this.oldFlags);
        sbU.append(", newFlags=");
        return a.G(sbU, this.newFlags, ")");
    }
}
