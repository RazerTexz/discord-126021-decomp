package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadata;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadataReceiver;
import com.discord.analytics.generated.traits.TrackGuildTemplate;
import com.discord.analytics.generated.traits.TrackGuildTemplateReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackRegisterAttempted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRegisterAttempted implements AnalyticsSchema, TrackBaseReceiver, TrackGiftCodeMetadataReceiver, TrackGuildTemplateReceiver {
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
        return C12238m.areEqual(this.registrationSource, trackRegisterAttempted.registrationSource) && C12238m.areEqual(this.full, trackRegisterAttempted.full) && C12238m.areEqual(this.instantInvite, trackRegisterAttempted.instantInvite) && C12238m.areEqual(this.inviteCode, trackRegisterAttempted.inviteCode) && C12238m.areEqual(this.inviteGuildId, trackRegisterAttempted.inviteGuildId) && C12238m.areEqual(this.inviteChannelId, trackRegisterAttempted.inviteChannelId) && C12238m.areEqual(this.inviteChannelType, trackRegisterAttempted.inviteChannelType) && C12238m.areEqual(this.inviteInviterId, trackRegisterAttempted.inviteInviterId) && C12238m.areEqual(this.ipBlacklisted, trackRegisterAttempted.ipBlacklisted) && C12238m.areEqual(this.hasInvalidFingerprint, trackRegisterAttempted.hasInvalidFingerprint) && C12238m.areEqual(this.discriminatorAttempts, trackRegisterAttempted.discriminatorAttempts) && C12238m.areEqual(this.cfClientTrustScore, trackRegisterAttempted.cfClientTrustScore) && C12238m.areEqual(this.username, trackRegisterAttempted.username) && C12238m.areEqual(this.email, trackRegisterAttempted.email) && C12238m.areEqual(this.phone, trackRegisterAttempted.phone) && C12238m.areEqual(this.identityType, trackRegisterAttempted.identityType) && C12238m.areEqual(this.discordAiSpamLikelihood, trackRegisterAttempted.discordAiSpamLikelihood) && C12238m.areEqual(this.discordAiModelVersion, trackRegisterAttempted.discordAiModelVersion) && C12238m.areEqual(this.phoneCarrierName, trackRegisterAttempted.phoneCarrierName) && C12238m.areEqual(this.phoneCountry, trackRegisterAttempted.phoneCountry);
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
        StringBuilder sbM833U = C1643a.m833U("TrackRegisterAttempted(registrationSource=");
        sbM833U.append(this.registrationSource);
        sbM833U.append(", full=");
        sbM833U.append(this.full);
        sbM833U.append(", instantInvite=");
        sbM833U.append(this.instantInvite);
        sbM833U.append(", inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", inviteGuildId=");
        sbM833U.append(this.inviteGuildId);
        sbM833U.append(", inviteChannelId=");
        sbM833U.append(this.inviteChannelId);
        sbM833U.append(", inviteChannelType=");
        sbM833U.append(this.inviteChannelType);
        sbM833U.append(", inviteInviterId=");
        sbM833U.append(this.inviteInviterId);
        sbM833U.append(", ipBlacklisted=");
        sbM833U.append(this.ipBlacklisted);
        sbM833U.append(", hasInvalidFingerprint=");
        sbM833U.append(this.hasInvalidFingerprint);
        sbM833U.append(", discriminatorAttempts=");
        sbM833U.append(this.discriminatorAttempts);
        sbM833U.append(", cfClientTrustScore=");
        sbM833U.append(this.cfClientTrustScore);
        sbM833U.append(", username=");
        sbM833U.append(this.username);
        sbM833U.append(", email=");
        sbM833U.append(this.email);
        sbM833U.append(", phone=");
        sbM833U.append(this.phone);
        sbM833U.append(", identityType=");
        sbM833U.append(this.identityType);
        sbM833U.append(", discordAiSpamLikelihood=");
        sbM833U.append(this.discordAiSpamLikelihood);
        sbM833U.append(", discordAiModelVersion=");
        sbM833U.append(this.discordAiModelVersion);
        sbM833U.append(", phoneCarrierName=");
        sbM833U.append(this.phoneCarrierName);
        sbM833U.append(", phoneCountry=");
        return C1643a.m817E(sbM833U, this.phoneCountry, ")");
    }
}
