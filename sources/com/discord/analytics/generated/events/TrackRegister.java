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

/* JADX INFO: compiled from: TrackRegister.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRegister implements AnalyticsSchema, TrackBaseReceiver, TrackGiftCodeMetadataReceiver, TrackGuildTemplateReceiver {
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
    private final Boolean smiteCaptchaRequested = null;
    private final Boolean solvedCaptcha = null;
    private final Float captchaScore = null;
    private final Boolean requireVerifiedPhone = null;
    private final Boolean requireVerifiedEmail = null;
    private final Boolean requireVerifiedPhoneThenEmail = null;
    private final CharSequence email = null;
    private final CharSequence phone = null;
    private final CharSequence identityType = null;
    private final CharSequence phoneCarrierName = null;
    private final CharSequence phoneCountry = null;
    private final transient String analyticsSchemaTypeName = "register";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRegister)) {
            return false;
        }
        TrackRegister trackRegister = (TrackRegister) other;
        return C12238m.areEqual(this.registrationSource, trackRegister.registrationSource) && C12238m.areEqual(this.full, trackRegister.full) && C12238m.areEqual(this.instantInvite, trackRegister.instantInvite) && C12238m.areEqual(this.inviteCode, trackRegister.inviteCode) && C12238m.areEqual(this.inviteGuildId, trackRegister.inviteGuildId) && C12238m.areEqual(this.inviteChannelId, trackRegister.inviteChannelId) && C12238m.areEqual(this.inviteChannelType, trackRegister.inviteChannelType) && C12238m.areEqual(this.inviteInviterId, trackRegister.inviteInviterId) && C12238m.areEqual(this.smiteCaptchaRequested, trackRegister.smiteCaptchaRequested) && C12238m.areEqual(this.solvedCaptcha, trackRegister.solvedCaptcha) && C12238m.areEqual(this.captchaScore, trackRegister.captchaScore) && C12238m.areEqual(this.requireVerifiedPhone, trackRegister.requireVerifiedPhone) && C12238m.areEqual(this.requireVerifiedEmail, trackRegister.requireVerifiedEmail) && C12238m.areEqual(this.requireVerifiedPhoneThenEmail, trackRegister.requireVerifiedPhoneThenEmail) && C12238m.areEqual(this.email, trackRegister.email) && C12238m.areEqual(this.phone, trackRegister.phone) && C12238m.areEqual(this.identityType, trackRegister.identityType) && C12238m.areEqual(this.phoneCarrierName, trackRegister.phoneCarrierName) && C12238m.areEqual(this.phoneCountry, trackRegister.phoneCountry);
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
        Boolean bool3 = this.smiteCaptchaRequested;
        int iHashCode9 = (iHashCode8 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.solvedCaptcha;
        int iHashCode10 = (iHashCode9 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Float f = this.captchaScore;
        int iHashCode11 = (iHashCode10 + (f != null ? f.hashCode() : 0)) * 31;
        Boolean bool5 = this.requireVerifiedPhone;
        int iHashCode12 = (iHashCode11 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.requireVerifiedEmail;
        int iHashCode13 = (iHashCode12 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Boolean bool7 = this.requireVerifiedPhoneThenEmail;
        int iHashCode14 = (iHashCode13 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.email;
        int iHashCode15 = (iHashCode14 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.phone;
        int iHashCode16 = (iHashCode15 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.identityType;
        int iHashCode17 = (iHashCode16 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.phoneCarrierName;
        int iHashCode18 = (iHashCode17 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.phoneCountry;
        return iHashCode18 + (charSequence7 != null ? charSequence7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackRegister(registrationSource=");
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
        sbM833U.append(", smiteCaptchaRequested=");
        sbM833U.append(this.smiteCaptchaRequested);
        sbM833U.append(", solvedCaptcha=");
        sbM833U.append(this.solvedCaptcha);
        sbM833U.append(", captchaScore=");
        sbM833U.append(this.captchaScore);
        sbM833U.append(", requireVerifiedPhone=");
        sbM833U.append(this.requireVerifiedPhone);
        sbM833U.append(", requireVerifiedEmail=");
        sbM833U.append(this.requireVerifiedEmail);
        sbM833U.append(", requireVerifiedPhoneThenEmail=");
        sbM833U.append(this.requireVerifiedPhoneThenEmail);
        sbM833U.append(", email=");
        sbM833U.append(this.email);
        sbM833U.append(", phone=");
        sbM833U.append(this.phone);
        sbM833U.append(", identityType=");
        sbM833U.append(this.identityType);
        sbM833U.append(", phoneCarrierName=");
        sbM833U.append(this.phoneCarrierName);
        sbM833U.append(", phoneCountry=");
        return C1643a.m817E(sbM833U, this.phoneCountry, ")");
    }
}
