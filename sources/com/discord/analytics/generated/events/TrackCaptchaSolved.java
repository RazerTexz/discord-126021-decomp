package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: TrackCaptchaSolved.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCaptchaSolved implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean success = null;
    private final Boolean forceBad = null;
    private final Long challengeTs = null;
    private final CharSequence hostname = null;
    private final CharSequence scopedUid0 = null;
    private final CharSequence scopedUid1 = null;
    private final CharSequence sitekey = null;
    private final Float score = null;
    private final List<CharSequence> scoreReason = null;
    private final List<CharSequence> errorCodes = null;
    private final CharSequence userFlow = null;
    private final CharSequence captchaService = null;
    private final Boolean captchaRequired = null;
    private final Long locationGuildId = null;
    private final Long locationChannelId = null;
    private final Long locationChannelType = null;
    private final Long locationMessageId = null;
    private final transient String analyticsSchemaTypeName = "captcha_solved";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCaptchaSolved)) {
            return false;
        }
        TrackCaptchaSolved trackCaptchaSolved = (TrackCaptchaSolved) other;
        return m.areEqual(this.success, trackCaptchaSolved.success) && m.areEqual(this.forceBad, trackCaptchaSolved.forceBad) && m.areEqual(this.challengeTs, trackCaptchaSolved.challengeTs) && m.areEqual(this.hostname, trackCaptchaSolved.hostname) && m.areEqual(this.scopedUid0, trackCaptchaSolved.scopedUid0) && m.areEqual(this.scopedUid1, trackCaptchaSolved.scopedUid1) && m.areEqual(this.sitekey, trackCaptchaSolved.sitekey) && m.areEqual(this.score, trackCaptchaSolved.score) && m.areEqual(this.scoreReason, trackCaptchaSolved.scoreReason) && m.areEqual(this.errorCodes, trackCaptchaSolved.errorCodes) && m.areEqual(this.userFlow, trackCaptchaSolved.userFlow) && m.areEqual(this.captchaService, trackCaptchaSolved.captchaService) && m.areEqual(this.captchaRequired, trackCaptchaSolved.captchaRequired) && m.areEqual(this.locationGuildId, trackCaptchaSolved.locationGuildId) && m.areEqual(this.locationChannelId, trackCaptchaSolved.locationChannelId) && m.areEqual(this.locationChannelType, trackCaptchaSolved.locationChannelType) && m.areEqual(this.locationMessageId, trackCaptchaSolved.locationMessageId);
    }

    public int hashCode() {
        Boolean bool = this.success;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.forceBad;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l = this.challengeTs;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence = this.hostname;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.scopedUid0;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.scopedUid1;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.sitekey;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Float f = this.score;
        int iHashCode8 = (iHashCode7 + (f != null ? f.hashCode() : 0)) * 31;
        List<CharSequence> list = this.scoreReason;
        int iHashCode9 = (iHashCode8 + (list != null ? list.hashCode() : 0)) * 31;
        List<CharSequence> list2 = this.errorCodes;
        int iHashCode10 = (iHashCode9 + (list2 != null ? list2.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.userFlow;
        int iHashCode11 = (iHashCode10 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.captchaService;
        int iHashCode12 = (iHashCode11 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Boolean bool3 = this.captchaRequired;
        int iHashCode13 = (iHashCode12 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l2 = this.locationGuildId;
        int iHashCode14 = (iHashCode13 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.locationChannelId;
        int iHashCode15 = (iHashCode14 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.locationChannelType;
        int iHashCode16 = (iHashCode15 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.locationMessageId;
        return iHashCode16 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackCaptchaSolved(success=");
        sbU.append(this.success);
        sbU.append(", forceBad=");
        sbU.append(this.forceBad);
        sbU.append(", challengeTs=");
        sbU.append(this.challengeTs);
        sbU.append(", hostname=");
        sbU.append(this.hostname);
        sbU.append(", scopedUid0=");
        sbU.append(this.scopedUid0);
        sbU.append(", scopedUid1=");
        sbU.append(this.scopedUid1);
        sbU.append(", sitekey=");
        sbU.append(this.sitekey);
        sbU.append(", score=");
        sbU.append(this.score);
        sbU.append(", scoreReason=");
        sbU.append(this.scoreReason);
        sbU.append(", errorCodes=");
        sbU.append(this.errorCodes);
        sbU.append(", userFlow=");
        sbU.append(this.userFlow);
        sbU.append(", captchaService=");
        sbU.append(this.captchaService);
        sbU.append(", captchaRequired=");
        sbU.append(this.captchaRequired);
        sbU.append(", locationGuildId=");
        sbU.append(this.locationGuildId);
        sbU.append(", locationChannelId=");
        sbU.append(this.locationChannelId);
        sbU.append(", locationChannelType=");
        sbU.append(this.locationChannelType);
        sbU.append(", locationMessageId=");
        return a.G(sbU, this.locationMessageId, ")");
    }
}
