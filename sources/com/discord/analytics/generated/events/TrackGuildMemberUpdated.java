package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackGuildMemberUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildMemberUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final CharSequence guildName = null;
    private final Long targetUserId = null;
    private final CharSequence updateType = null;
    private final List<CharSequence> fieldsUpdated = null;
    private final CharSequence oldNickname = null;
    private final CharSequence newNickname = null;
    private final Boolean mute = null;
    private final Boolean deaf = null;
    private final List<Long> oldRoles = null;
    private final List<Long> newRoles = null;
    private final CharSequence reason = null;
    private final Long deleteMessageDays = null;
    private final CharSequence avatarUpdateType = null;
    private final Long userPremiumTier = null;
    private final CharSequence nicknameUpdateType = null;
    private final CharSequence bannerUpdateType = null;
    private final CharSequence bioUpdateType = null;
    private final Float duration = null;
    private final Long communicationDisabledUntil = null;
    private final Long bioCustomEmojiCount = null;
    private final Long accessibleTextChannels = null;
    private final Long accessibleVoiceChannels = null;
    private final Long accessibleStageChannels = null;
    private final transient String analyticsSchemaTypeName = "guild_member_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildMemberUpdated)) {
            return false;
        }
        TrackGuildMemberUpdated trackGuildMemberUpdated = (TrackGuildMemberUpdated) other;
        return Intrinsics3.areEqual(this.guildId, trackGuildMemberUpdated.guildId) && Intrinsics3.areEqual(this.guildName, trackGuildMemberUpdated.guildName) && Intrinsics3.areEqual(this.targetUserId, trackGuildMemberUpdated.targetUserId) && Intrinsics3.areEqual(this.updateType, trackGuildMemberUpdated.updateType) && Intrinsics3.areEqual(this.fieldsUpdated, trackGuildMemberUpdated.fieldsUpdated) && Intrinsics3.areEqual(this.oldNickname, trackGuildMemberUpdated.oldNickname) && Intrinsics3.areEqual(this.newNickname, trackGuildMemberUpdated.newNickname) && Intrinsics3.areEqual(this.mute, trackGuildMemberUpdated.mute) && Intrinsics3.areEqual(this.deaf, trackGuildMemberUpdated.deaf) && Intrinsics3.areEqual(this.oldRoles, trackGuildMemberUpdated.oldRoles) && Intrinsics3.areEqual(this.newRoles, trackGuildMemberUpdated.newRoles) && Intrinsics3.areEqual(this.reason, trackGuildMemberUpdated.reason) && Intrinsics3.areEqual(this.deleteMessageDays, trackGuildMemberUpdated.deleteMessageDays) && Intrinsics3.areEqual(this.avatarUpdateType, trackGuildMemberUpdated.avatarUpdateType) && Intrinsics3.areEqual(this.userPremiumTier, trackGuildMemberUpdated.userPremiumTier) && Intrinsics3.areEqual(this.nicknameUpdateType, trackGuildMemberUpdated.nicknameUpdateType) && Intrinsics3.areEqual(this.bannerUpdateType, trackGuildMemberUpdated.bannerUpdateType) && Intrinsics3.areEqual(this.bioUpdateType, trackGuildMemberUpdated.bioUpdateType) && Intrinsics3.areEqual(this.duration, trackGuildMemberUpdated.duration) && Intrinsics3.areEqual(this.communicationDisabledUntil, trackGuildMemberUpdated.communicationDisabledUntil) && Intrinsics3.areEqual(this.bioCustomEmojiCount, trackGuildMemberUpdated.bioCustomEmojiCount) && Intrinsics3.areEqual(this.accessibleTextChannels, trackGuildMemberUpdated.accessibleTextChannels) && Intrinsics3.areEqual(this.accessibleVoiceChannels, trackGuildMemberUpdated.accessibleVoiceChannels) && Intrinsics3.areEqual(this.accessibleStageChannels, trackGuildMemberUpdated.accessibleStageChannels);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.guildName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.targetUserId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.updateType;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        List<CharSequence> list = this.fieldsUpdated;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.oldNickname;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.newNickname;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool = this.mute;
        int iHashCode8 = (iHashCode7 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.deaf;
        int iHashCode9 = (iHashCode8 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        List<Long> list2 = this.oldRoles;
        int iHashCode10 = (iHashCode9 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Long> list3 = this.newRoles;
        int iHashCode11 = (iHashCode10 + (list3 != null ? list3.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.reason;
        int iHashCode12 = (iHashCode11 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l3 = this.deleteMessageDays;
        int iHashCode13 = (iHashCode12 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.avatarUpdateType;
        int iHashCode14 = (iHashCode13 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Long l4 = this.userPremiumTier;
        int iHashCode15 = (iHashCode14 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.nicknameUpdateType;
        int iHashCode16 = (iHashCode15 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.bannerUpdateType;
        int iHashCode17 = (iHashCode16 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.bioUpdateType;
        int iHashCode18 = (iHashCode17 + (charSequence9 != null ? charSequence9.hashCode() : 0)) * 31;
        Float f = this.duration;
        int iHashCode19 = (iHashCode18 + (f != null ? f.hashCode() : 0)) * 31;
        Long l5 = this.communicationDisabledUntil;
        int iHashCode20 = (iHashCode19 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.bioCustomEmojiCount;
        int iHashCode21 = (iHashCode20 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.accessibleTextChannels;
        int iHashCode22 = (iHashCode21 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.accessibleVoiceChannels;
        int iHashCode23 = (iHashCode22 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.accessibleStageChannels;
        return iHashCode23 + (l9 != null ? l9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildMemberUpdated(guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", targetUserId=");
        sbU.append(this.targetUserId);
        sbU.append(", updateType=");
        sbU.append(this.updateType);
        sbU.append(", fieldsUpdated=");
        sbU.append(this.fieldsUpdated);
        sbU.append(", oldNickname=");
        sbU.append(this.oldNickname);
        sbU.append(", newNickname=");
        sbU.append(this.newNickname);
        sbU.append(", mute=");
        sbU.append(this.mute);
        sbU.append(", deaf=");
        sbU.append(this.deaf);
        sbU.append(", oldRoles=");
        sbU.append(this.oldRoles);
        sbU.append(", newRoles=");
        sbU.append(this.newRoles);
        sbU.append(", reason=");
        sbU.append(this.reason);
        sbU.append(", deleteMessageDays=");
        sbU.append(this.deleteMessageDays);
        sbU.append(", avatarUpdateType=");
        sbU.append(this.avatarUpdateType);
        sbU.append(", userPremiumTier=");
        sbU.append(this.userPremiumTier);
        sbU.append(", nicknameUpdateType=");
        sbU.append(this.nicknameUpdateType);
        sbU.append(", bannerUpdateType=");
        sbU.append(this.bannerUpdateType);
        sbU.append(", bioUpdateType=");
        sbU.append(this.bioUpdateType);
        sbU.append(", duration=");
        sbU.append(this.duration);
        sbU.append(", communicationDisabledUntil=");
        sbU.append(this.communicationDisabledUntil);
        sbU.append(", bioCustomEmojiCount=");
        sbU.append(this.bioCustomEmojiCount);
        sbU.append(", accessibleTextChannels=");
        sbU.append(this.accessibleTextChannels);
        sbU.append(", accessibleVoiceChannels=");
        sbU.append(this.accessibleVoiceChannels);
        sbU.append(", accessibleStageChannels=");
        return outline.G(sbU, this.accessibleStageChannels, ")");
    }
}
