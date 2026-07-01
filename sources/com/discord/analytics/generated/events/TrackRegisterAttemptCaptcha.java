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
import java.util.List;

/* JADX INFO: compiled from: TrackRegisterAttemptCaptcha.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRegisterAttemptCaptcha implements AnalyticsSchema, TrackBase2, TrackGiftCodeMetadata2, TrackGuildTemplate2 {
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
    private final List<CharSequence> ipBlacklists = null;
    private final Boolean hasInvalidFingerprint = null;
    private final Boolean forceBadCaptcha = null;
    private final CharSequence email = null;
    private final CharSequence phone = null;
    private final CharSequence identityType = null;
    private final CharSequence phoneCarrierName = null;
    private final CharSequence phoneCountry = null;
    private final transient String analyticsSchemaTypeName = "register_attempt_captcha";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRegisterAttemptCaptcha)) {
            return false;
        }
        TrackRegisterAttemptCaptcha trackRegisterAttemptCaptcha = (TrackRegisterAttemptCaptcha) other;
        return Intrinsics3.areEqual(this.registrationSource, trackRegisterAttemptCaptcha.registrationSource) && Intrinsics3.areEqual(this.full, trackRegisterAttemptCaptcha.full) && Intrinsics3.areEqual(this.instantInvite, trackRegisterAttemptCaptcha.instantInvite) && Intrinsics3.areEqual(this.inviteCode, trackRegisterAttemptCaptcha.inviteCode) && Intrinsics3.areEqual(this.inviteGuildId, trackRegisterAttemptCaptcha.inviteGuildId) && Intrinsics3.areEqual(this.inviteChannelId, trackRegisterAttemptCaptcha.inviteChannelId) && Intrinsics3.areEqual(this.inviteChannelType, trackRegisterAttemptCaptcha.inviteChannelType) && Intrinsics3.areEqual(this.inviteInviterId, trackRegisterAttemptCaptcha.inviteInviterId) && Intrinsics3.areEqual(this.ipBlacklists, trackRegisterAttemptCaptcha.ipBlacklists) && Intrinsics3.areEqual(this.hasInvalidFingerprint, trackRegisterAttemptCaptcha.hasInvalidFingerprint) && Intrinsics3.areEqual(this.forceBadCaptcha, trackRegisterAttemptCaptcha.forceBadCaptcha) && Intrinsics3.areEqual(this.email, trackRegisterAttemptCaptcha.email) && Intrinsics3.areEqual(this.phone, trackRegisterAttemptCaptcha.phone) && Intrinsics3.areEqual(this.identityType, trackRegisterAttemptCaptcha.identityType) && Intrinsics3.areEqual(this.phoneCarrierName, trackRegisterAttemptCaptcha.phoneCarrierName) && Intrinsics3.areEqual(this.phoneCountry, trackRegisterAttemptCaptcha.phoneCountry);
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
        List<CharSequence> list = this.ipBlacklists;
        int iHashCode9 = (iHashCode8 + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool3 = this.hasInvalidFingerprint;
        int iHashCode10 = (iHashCode9 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.forceBadCaptcha;
        int iHashCode11 = (iHashCode10 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.email;
        int iHashCode12 = (iHashCode11 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.phone;
        int iHashCode13 = (iHashCode12 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.identityType;
        int iHashCode14 = (iHashCode13 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.phoneCarrierName;
        int iHashCode15 = (iHashCode14 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.phoneCountry;
        return iHashCode15 + (charSequence7 != null ? charSequence7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackRegisterAttemptCaptcha(registrationSource=");
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
        sbU.append(", ipBlacklists=");
        sbU.append(this.ipBlacklists);
        sbU.append(", hasInvalidFingerprint=");
        sbU.append(this.hasInvalidFingerprint);
        sbU.append(", forceBadCaptcha=");
        sbU.append(this.forceBadCaptcha);
        sbU.append(", email=");
        sbU.append(this.email);
        sbU.append(", phone=");
        sbU.append(this.phone);
        sbU.append(", identityType=");
        sbU.append(this.identityType);
        sbU.append(", phoneCarrierName=");
        sbU.append(this.phoneCarrierName);
        sbU.append(", phoneCountry=");
        return outline.E(sbU, this.phoneCountry, ")");
    }
}
