package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackCaptchaServed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCaptchaServed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence captchaService = null;
    private final CharSequence sitekey = null;
    private final CharSequence userFlow = null;
    private final Boolean forceBad = null;
    private final Boolean captchaRequired = null;
    private final Long locationGuildId = null;
    private final Long locationChannelId = null;
    private final Long locationChannelType = null;
    private final Long locationMessageId = null;
    private final transient String analyticsSchemaTypeName = "captcha_served";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCaptchaServed)) {
            return false;
        }
        TrackCaptchaServed trackCaptchaServed = (TrackCaptchaServed) other;
        return C12238m.areEqual(this.captchaService, trackCaptchaServed.captchaService) && C12238m.areEqual(this.sitekey, trackCaptchaServed.sitekey) && C12238m.areEqual(this.userFlow, trackCaptchaServed.userFlow) && C12238m.areEqual(this.forceBad, trackCaptchaServed.forceBad) && C12238m.areEqual(this.captchaRequired, trackCaptchaServed.captchaRequired) && C12238m.areEqual(this.locationGuildId, trackCaptchaServed.locationGuildId) && C12238m.areEqual(this.locationChannelId, trackCaptchaServed.locationChannelId) && C12238m.areEqual(this.locationChannelType, trackCaptchaServed.locationChannelType) && C12238m.areEqual(this.locationMessageId, trackCaptchaServed.locationMessageId);
    }

    public int hashCode() {
        CharSequence charSequence = this.captchaService;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.sitekey;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.userFlow;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.forceBad;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.captchaRequired;
        int iHashCode5 = (iHashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l = this.locationGuildId;
        int iHashCode6 = (iHashCode5 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.locationChannelId;
        int iHashCode7 = (iHashCode6 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.locationChannelType;
        int iHashCode8 = (iHashCode7 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.locationMessageId;
        return iHashCode8 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackCaptchaServed(captchaService=");
        sbM833U.append(this.captchaService);
        sbM833U.append(", sitekey=");
        sbM833U.append(this.sitekey);
        sbM833U.append(", userFlow=");
        sbM833U.append(this.userFlow);
        sbM833U.append(", forceBad=");
        sbM833U.append(this.forceBad);
        sbM833U.append(", captchaRequired=");
        sbM833U.append(this.captchaRequired);
        sbM833U.append(", locationGuildId=");
        sbM833U.append(this.locationGuildId);
        sbM833U.append(", locationChannelId=");
        sbM833U.append(this.locationChannelId);
        sbM833U.append(", locationChannelType=");
        sbM833U.append(this.locationChannelType);
        sbM833U.append(", locationMessageId=");
        return C1643a.m819G(sbM833U, this.locationMessageId, ")");
    }
}
