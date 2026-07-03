package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGuildMemberUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildMemberUpdated implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.guildId, trackGuildMemberUpdated.guildId) && C12238m.areEqual(this.guildName, trackGuildMemberUpdated.guildName) && C12238m.areEqual(this.targetUserId, trackGuildMemberUpdated.targetUserId) && C12238m.areEqual(this.updateType, trackGuildMemberUpdated.updateType) && C12238m.areEqual(this.fieldsUpdated, trackGuildMemberUpdated.fieldsUpdated) && C12238m.areEqual(this.oldNickname, trackGuildMemberUpdated.oldNickname) && C12238m.areEqual(this.newNickname, trackGuildMemberUpdated.newNickname) && C12238m.areEqual(this.mute, trackGuildMemberUpdated.mute) && C12238m.areEqual(this.deaf, trackGuildMemberUpdated.deaf) && C12238m.areEqual(this.oldRoles, trackGuildMemberUpdated.oldRoles) && C12238m.areEqual(this.newRoles, trackGuildMemberUpdated.newRoles) && C12238m.areEqual(this.reason, trackGuildMemberUpdated.reason) && C12238m.areEqual(this.deleteMessageDays, trackGuildMemberUpdated.deleteMessageDays) && C12238m.areEqual(this.avatarUpdateType, trackGuildMemberUpdated.avatarUpdateType) && C12238m.areEqual(this.userPremiumTier, trackGuildMemberUpdated.userPremiumTier) && C12238m.areEqual(this.nicknameUpdateType, trackGuildMemberUpdated.nicknameUpdateType) && C12238m.areEqual(this.bannerUpdateType, trackGuildMemberUpdated.bannerUpdateType) && C12238m.areEqual(this.bioUpdateType, trackGuildMemberUpdated.bioUpdateType) && C12238m.areEqual(this.duration, trackGuildMemberUpdated.duration) && C12238m.areEqual(this.communicationDisabledUntil, trackGuildMemberUpdated.communicationDisabledUntil) && C12238m.areEqual(this.bioCustomEmojiCount, trackGuildMemberUpdated.bioCustomEmojiCount) && C12238m.areEqual(this.accessibleTextChannels, trackGuildMemberUpdated.accessibleTextChannels) && C12238m.areEqual(this.accessibleVoiceChannels, trackGuildMemberUpdated.accessibleVoiceChannels) && C12238m.areEqual(this.accessibleStageChannels, trackGuildMemberUpdated.accessibleStageChannels);
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
        StringBuilder sbM833U = C1643a.m833U("TrackGuildMemberUpdated(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", guildName=");
        sbM833U.append(this.guildName);
        sbM833U.append(", targetUserId=");
        sbM833U.append(this.targetUserId);
        sbM833U.append(", updateType=");
        sbM833U.append(this.updateType);
        sbM833U.append(", fieldsUpdated=");
        sbM833U.append(this.fieldsUpdated);
        sbM833U.append(", oldNickname=");
        sbM833U.append(this.oldNickname);
        sbM833U.append(", newNickname=");
        sbM833U.append(this.newNickname);
        sbM833U.append(", mute=");
        sbM833U.append(this.mute);
        sbM833U.append(", deaf=");
        sbM833U.append(this.deaf);
        sbM833U.append(", oldRoles=");
        sbM833U.append(this.oldRoles);
        sbM833U.append(", newRoles=");
        sbM833U.append(this.newRoles);
        sbM833U.append(", reason=");
        sbM833U.append(this.reason);
        sbM833U.append(", deleteMessageDays=");
        sbM833U.append(this.deleteMessageDays);
        sbM833U.append(", avatarUpdateType=");
        sbM833U.append(this.avatarUpdateType);
        sbM833U.append(", userPremiumTier=");
        sbM833U.append(this.userPremiumTier);
        sbM833U.append(", nicknameUpdateType=");
        sbM833U.append(this.nicknameUpdateType);
        sbM833U.append(", bannerUpdateType=");
        sbM833U.append(this.bannerUpdateType);
        sbM833U.append(", bioUpdateType=");
        sbM833U.append(this.bioUpdateType);
        sbM833U.append(", duration=");
        sbM833U.append(this.duration);
        sbM833U.append(", communicationDisabledUntil=");
        sbM833U.append(this.communicationDisabledUntil);
        sbM833U.append(", bioCustomEmojiCount=");
        sbM833U.append(this.bioCustomEmojiCount);
        sbM833U.append(", accessibleTextChannels=");
        sbM833U.append(this.accessibleTextChannels);
        sbM833U.append(", accessibleVoiceChannels=");
        sbM833U.append(this.accessibleVoiceChannels);
        sbM833U.append(", accessibleStageChannels=");
        return C1643a.m819G(sbM833U, this.accessibleStageChannels, ")");
    }
}
