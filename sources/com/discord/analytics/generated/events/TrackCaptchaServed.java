package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackCaptchaServed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCaptchaServed implements AnalyticsSchema, TrackBase2 {
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
        return Intrinsics3.areEqual(this.captchaService, trackCaptchaServed.captchaService) && Intrinsics3.areEqual(this.sitekey, trackCaptchaServed.sitekey) && Intrinsics3.areEqual(this.userFlow, trackCaptchaServed.userFlow) && Intrinsics3.areEqual(this.forceBad, trackCaptchaServed.forceBad) && Intrinsics3.areEqual(this.captchaRequired, trackCaptchaServed.captchaRequired) && Intrinsics3.areEqual(this.locationGuildId, trackCaptchaServed.locationGuildId) && Intrinsics3.areEqual(this.locationChannelId, trackCaptchaServed.locationChannelId) && Intrinsics3.areEqual(this.locationChannelType, trackCaptchaServed.locationChannelType) && Intrinsics3.areEqual(this.locationMessageId, trackCaptchaServed.locationMessageId);
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
        StringBuilder sbU = outline.U("TrackCaptchaServed(captchaService=");
        sbU.append(this.captchaService);
        sbU.append(", sitekey=");
        sbU.append(this.sitekey);
        sbU.append(", userFlow=");
        sbU.append(this.userFlow);
        sbU.append(", forceBad=");
        sbU.append(this.forceBad);
        sbU.append(", captchaRequired=");
        sbU.append(this.captchaRequired);
        sbU.append(", locationGuildId=");
        sbU.append(this.locationGuildId);
        sbU.append(", locationChannelId=");
        sbU.append(this.locationChannelId);
        sbU.append(", locationChannelType=");
        sbU.append(this.locationChannelType);
        sbU.append(", locationMessageId=");
        return outline.G(sbU, this.locationMessageId, ")");
    }
}
