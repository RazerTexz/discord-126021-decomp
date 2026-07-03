package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.guildId, trackChannelUpdated.guildId) && C12238m.areEqual(this.guildName, trackChannelUpdated.guildName) && C12238m.areEqual(this.oldName, trackChannelUpdated.oldName) && C12238m.areEqual(this.newName, trackChannelUpdated.newName) && C12238m.areEqual(this.oldNsfw, trackChannelUpdated.oldNsfw) && C12238m.areEqual(this.newNsfw, trackChannelUpdated.newNsfw) && C12238m.areEqual(this.bitrate, trackChannelUpdated.bitrate) && C12238m.areEqual(this.oldBitrate, trackChannelUpdated.oldBitrate) && C12238m.areEqual(this.rtcRegion, trackChannelUpdated.rtcRegion) && C12238m.areEqual(this.oldRtcRegion, trackChannelUpdated.oldRtcRegion) && C12238m.areEqual(this.videoQualityMode, trackChannelUpdated.videoQualityMode) && C12238m.areEqual(this.oldVideoQualityMode, trackChannelUpdated.oldVideoQualityMode) && C12238m.areEqual(this.defaultAutoArchiveDurationMinutes, trackChannelUpdated.defaultAutoArchiveDurationMinutes) && C12238m.areEqual(this.oldDefaultAutoArchiveDurationMinutes, trackChannelUpdated.oldDefaultAutoArchiveDurationMinutes) && C12238m.areEqual(this.oldArchived, trackChannelUpdated.oldArchived) && C12238m.areEqual(this.newArchived, trackChannelUpdated.newArchived) && C12238m.areEqual(this.oldLocked, trackChannelUpdated.oldLocked) && C12238m.areEqual(this.newLocked, trackChannelUpdated.newLocked) && C12238m.areEqual(this.oldInvitable, trackChannelUpdated.oldInvitable) && C12238m.areEqual(this.newInvitable, trackChannelUpdated.newInvitable) && C12238m.areEqual(this.oldAutoArchiveDurationMinutes, trackChannelUpdated.oldAutoArchiveDurationMinutes) && C12238m.areEqual(this.newAutoArchiveDurationMinutes, trackChannelUpdated.newAutoArchiveDurationMinutes) && C12238m.areEqual(this.oldBannerHash, trackChannelUpdated.oldBannerHash) && C12238m.areEqual(this.newBannerHash, trackChannelUpdated.newBannerHash) && C12238m.areEqual(this.oldFlags, trackChannelUpdated.oldFlags) && C12238m.areEqual(this.newFlags, trackChannelUpdated.newFlags);
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
        StringBuilder sbM833U = C1643a.m833U("TrackChannelUpdated(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", guildName=");
        sbM833U.append(this.guildName);
        sbM833U.append(", oldName=");
        sbM833U.append(this.oldName);
        sbM833U.append(", newName=");
        sbM833U.append(this.newName);
        sbM833U.append(", oldNsfw=");
        sbM833U.append(this.oldNsfw);
        sbM833U.append(", newNsfw=");
        sbM833U.append(this.newNsfw);
        sbM833U.append(", bitrate=");
        sbM833U.append(this.bitrate);
        sbM833U.append(", oldBitrate=");
        sbM833U.append(this.oldBitrate);
        sbM833U.append(", rtcRegion=");
        sbM833U.append(this.rtcRegion);
        sbM833U.append(", oldRtcRegion=");
        sbM833U.append(this.oldRtcRegion);
        sbM833U.append(", videoQualityMode=");
        sbM833U.append(this.videoQualityMode);
        sbM833U.append(", oldVideoQualityMode=");
        sbM833U.append(this.oldVideoQualityMode);
        sbM833U.append(", defaultAutoArchiveDurationMinutes=");
        sbM833U.append(this.defaultAutoArchiveDurationMinutes);
        sbM833U.append(", oldDefaultAutoArchiveDurationMinutes=");
        sbM833U.append(this.oldDefaultAutoArchiveDurationMinutes);
        sbM833U.append(", oldArchived=");
        sbM833U.append(this.oldArchived);
        sbM833U.append(", newArchived=");
        sbM833U.append(this.newArchived);
        sbM833U.append(", oldLocked=");
        sbM833U.append(this.oldLocked);
        sbM833U.append(", newLocked=");
        sbM833U.append(this.newLocked);
        sbM833U.append(", oldInvitable=");
        sbM833U.append(this.oldInvitable);
        sbM833U.append(", newInvitable=");
        sbM833U.append(this.newInvitable);
        sbM833U.append(", oldAutoArchiveDurationMinutes=");
        sbM833U.append(this.oldAutoArchiveDurationMinutes);
        sbM833U.append(", newAutoArchiveDurationMinutes=");
        sbM833U.append(this.newAutoArchiveDurationMinutes);
        sbM833U.append(", oldBannerHash=");
        sbM833U.append(this.oldBannerHash);
        sbM833U.append(", newBannerHash=");
        sbM833U.append(this.newBannerHash);
        sbM833U.append(", oldFlags=");
        sbM833U.append(this.oldFlags);
        sbM833U.append(", newFlags=");
        return C1643a.m819G(sbM833U, this.newFlags, ")");
    }
}
