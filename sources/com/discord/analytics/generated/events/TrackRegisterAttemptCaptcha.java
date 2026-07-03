package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadata;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadataReceiver;
import com.discord.analytics.generated.traits.TrackGuildTemplate;
import com.discord.analytics.generated.traits.TrackGuildTemplateReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackRegisterAttemptCaptcha.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRegisterAttemptCaptcha implements AnalyticsSchema, TrackBaseReceiver, TrackGiftCodeMetadataReceiver, TrackGuildTemplateReceiver {
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
        return C12238m.areEqual(this.registrationSource, trackRegisterAttemptCaptcha.registrationSource) && C12238m.areEqual(this.full, trackRegisterAttemptCaptcha.full) && C12238m.areEqual(this.instantInvite, trackRegisterAttemptCaptcha.instantInvite) && C12238m.areEqual(this.inviteCode, trackRegisterAttemptCaptcha.inviteCode) && C12238m.areEqual(this.inviteGuildId, trackRegisterAttemptCaptcha.inviteGuildId) && C12238m.areEqual(this.inviteChannelId, trackRegisterAttemptCaptcha.inviteChannelId) && C12238m.areEqual(this.inviteChannelType, trackRegisterAttemptCaptcha.inviteChannelType) && C12238m.areEqual(this.inviteInviterId, trackRegisterAttemptCaptcha.inviteInviterId) && C12238m.areEqual(this.ipBlacklists, trackRegisterAttemptCaptcha.ipBlacklists) && C12238m.areEqual(this.hasInvalidFingerprint, trackRegisterAttemptCaptcha.hasInvalidFingerprint) && C12238m.areEqual(this.forceBadCaptcha, trackRegisterAttemptCaptcha.forceBadCaptcha) && C12238m.areEqual(this.email, trackRegisterAttemptCaptcha.email) && C12238m.areEqual(this.phone, trackRegisterAttemptCaptcha.phone) && C12238m.areEqual(this.identityType, trackRegisterAttemptCaptcha.identityType) && C12238m.areEqual(this.phoneCarrierName, trackRegisterAttemptCaptcha.phoneCarrierName) && C12238m.areEqual(this.phoneCountry, trackRegisterAttemptCaptcha.phoneCountry);
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
        StringBuilder sbM833U = C1643a.m833U("TrackRegisterAttemptCaptcha(registrationSource=");
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
        sbM833U.append(", ipBlacklists=");
        sbM833U.append(this.ipBlacklists);
        sbM833U.append(", hasInvalidFingerprint=");
        sbM833U.append(this.hasInvalidFingerprint);
        sbM833U.append(", forceBadCaptcha=");
        sbM833U.append(this.forceBadCaptcha);
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
