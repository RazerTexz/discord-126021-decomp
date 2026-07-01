package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadata;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadata2;
import com.discord.analytics.generated.traits.TrackGuildTemplate;
import com.discord.analytics.generated.traits.TrackGuildTemplate2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackRegisterAttempted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRegisterAttempted implements AnalyticsSchema, TrackBase2, TrackGiftCodeMetadata2, TrackGuildTemplate2 {
    private TrackBase trackBase;
    private TrackGiftCodeMetadata trackGiftCodeMetadata;
    private TrackGuildTemplate trackGuildTemplate;
    private final CharSequence registrationSource = null;
    private final Boolean full = null;
    private final Boolean instantInvite = null;
    private final CharSequence inviteCode = null;
    private final Long inviteGuildId = null;
    private final Long inviteChannelId = null;
    private final Long inviteChannelType = null;
    private final Long inviteInviterId = null;
    private final Boolean ipBlacklisted = null;
    private final Boolean hasInvalidFingerprint = null;
    private final Long discriminatorAttempts = null;
    private final Long cfClientTrustScore = null;
    private final CharSequence username = null;
    private final CharSequence email = null;
    private final CharSequence phone = null;
    private final CharSequence identityType = null;
    private final Float discordAiSpamLikelihood = null;
    private final CharSequence discordAiModelVersion = null;
    private final CharSequence phoneCarrierName = null;
    private final CharSequence phoneCountry = null;
    private final transient String analyticsSchemaTypeName = "register_attempted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRegisterAttempted)) {
            return false;
        }
        TrackRegisterAttempted trackRegisterAttempted = (TrackRegisterAttempted) other;
        return Intrinsics3.areEqual(this.registrationSource, trackRegisterAttempted.registrationSource) && Intrinsics3.areEqual(this.full, trackRegisterAttempted.full) && Intrinsics3.areEqual(this.instantInvite, trackRegisterAttempted.instantInvite) && Intrinsics3.areEqual(this.inviteCode, trackRegisterAttempted.inviteCode) && Intrinsics3.areEqual(this.inviteGuildId, trackRegisterAttempted.inviteGuildId) && Intrinsics3.areEqual(this.inviteChannelId, trackRegisterAttempted.inviteChannelId) && Intrinsics3.areEqual(this.inviteChannelType, trackRegisterAttempted.inviteChannelType) && Intrinsics3.areEqual(this.inviteInviterId, trackRegisterAttempted.inviteInviterId) && Intrinsics3.areEqual(this.ipBlacklisted, trackRegisterAttempted.ipBlacklisted) && Intrinsics3.areEqual(this.hasInvalidFingerprint, trackRegisterAttempted.hasInvalidFingerprint) && Intrinsics3.areEqual(this.discriminatorAttempts, trackRegisterAttempted.discriminatorAttempts) && Intrinsics3.areEqual(this.cfClientTrustScore, trackRegisterAttempted.cfClientTrustScore) && Intrinsics3.areEqual(this.username, trackRegisterAttempted.username) && Intrinsics3.areEqual(this.email, trackRegisterAttempted.email) && Intrinsics3.areEqual(this.phone, trackRegisterAttempted.phone) && Intrinsics3.areEqual(this.identityType, trackRegisterAttempted.identityType) && Intrinsics3.areEqual(this.discordAiSpamLikelihood, trackRegisterAttempted.discordAiSpamLikelihood) && Intrinsics3.areEqual(this.discordAiModelVersion, trackRegisterAttempted.discordAiModelVersion) && Intrinsics3.areEqual(this.phoneCarrierName, trackRegisterAttempted.phoneCarrierName) && Intrinsics3.areEqual(this.phoneCountry, trackRegisterAttempted.phoneCountry);
    }

    public int hashCode() {
        CharSequence charSequence = this.registrationSource;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.full;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.instantInvite;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.inviteCode;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.inviteGuildId;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.inviteChannelId;
        int iHashCode6 = (iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.inviteChannelType;
        int iHashCode7 = (iHashCode6 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.inviteInviterId;
        int iHashCode8 = (iHashCode7 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool3 = this.ipBlacklisted;
        int iHashCode9 = (iHashCode8 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.hasInvalidFingerprint;
        int iHashCode10 = (iHashCode9 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Long l5 = this.discriminatorAttempts;
        int iHashCode11 = (iHashCode10 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.cfClientTrustScore;
        int iHashCode12 = (iHashCode11 + (l6 != null ? l6.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.username;
        int iHashCode13 = (iHashCode12 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.email;
        int iHashCode14 = (iHashCode13 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.phone;
        int iHashCode15 = (iHashCode14 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.identityType;
        int iHashCode16 = (iHashCode15 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Float f = this.discordAiSpamLikelihood;
        int iHashCode17 = (iHashCode16 + (f != null ? f.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.discordAiModelVersion;
        int iHashCode18 = (iHashCode17 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.phoneCarrierName;
        int iHashCode19 = (iHashCode18 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.phoneCountry;
        return iHashCode19 + (charSequence9 != null ? charSequence9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackRegisterAttempted(registrationSource=");
        sbU.append(this.registrationSource);
        sbU.append(", full=");
        sbU.append(this.full);
        sbU.append(", instantInvite=");
        sbU.append(this.instantInvite);
        sbU.append(", inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", inviteGuildId=");
        sbU.append(this.inviteGuildId);
        sbU.append(", inviteChannelId=");
        sbU.append(this.inviteChannelId);
        sbU.append(", inviteChannelType=");
        sbU.append(this.inviteChannelType);
        sbU.append(", inviteInviterId=");
        sbU.append(this.inviteInviterId);
        sbU.append(", ipBlacklisted=");
        sbU.append(this.ipBlacklisted);
        sbU.append(", hasInvalidFingerprint=");
        sbU.append(this.hasInvalidFingerprint);
        sbU.append(", discriminatorAttempts=");
        sbU.append(this.discriminatorAttempts);
        sbU.append(", cfClientTrustScore=");
        sbU.append(this.cfClientTrustScore);
        sbU.append(", username=");
        sbU.append(this.username);
        sbU.append(", email=");
        sbU.append(this.email);
        sbU.append(", phone=");
        sbU.append(this.phone);
        sbU.append(", identityType=");
        sbU.append(this.identityType);
        sbU.append(", discordAiSpamLikelihood=");
        sbU.append(this.discordAiSpamLikelihood);
        sbU.append(", discordAiModelVersion=");
        sbU.append(this.discordAiModelVersion);
        sbU.append(", phoneCarrierName=");
        sbU.append(this.phoneCarrierName);
        sbU.append(", phoneCountry=");
        return outline.E(sbU, this.phoneCountry, ")");
    }
}
