package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackExternalDynamicLinkReceived.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackExternalDynamicLinkReceived implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long fingerprint = null;
    private final CharSequence attemptId = null;
    private final Boolean hasAuthToken = null;
    private final CharSequence inviteCode = null;
    private final CharSequence guildTemplateCode = null;
    private final Boolean isBackgrounded = null;
    private final CharSequence linkType = null;
    private final CharSequence deeplinkSource = null;
    private final transient String analyticsSchemaTypeName = "external_dynamic_link_received";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackExternalDynamicLinkReceived)) {
            return false;
        }
        TrackExternalDynamicLinkReceived trackExternalDynamicLinkReceived = (TrackExternalDynamicLinkReceived) other;
        return Intrinsics3.areEqual(this.fingerprint, trackExternalDynamicLinkReceived.fingerprint) && Intrinsics3.areEqual(this.attemptId, trackExternalDynamicLinkReceived.attemptId) && Intrinsics3.areEqual(this.hasAuthToken, trackExternalDynamicLinkReceived.hasAuthToken) && Intrinsics3.areEqual(this.inviteCode, trackExternalDynamicLinkReceived.inviteCode) && Intrinsics3.areEqual(this.guildTemplateCode, trackExternalDynamicLinkReceived.guildTemplateCode) && Intrinsics3.areEqual(this.isBackgrounded, trackExternalDynamicLinkReceived.isBackgrounded) && Intrinsics3.areEqual(this.linkType, trackExternalDynamicLinkReceived.linkType) && Intrinsics3.areEqual(this.deeplinkSource, trackExternalDynamicLinkReceived.deeplinkSource);
    }

    public int hashCode() {
        Long l = this.fingerprint;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.attemptId;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.hasAuthToken;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.inviteCode;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.guildTemplateCode;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool2 = this.isBackgrounded;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.linkType;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.deeplinkSource;
        return iHashCode7 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackExternalDynamicLinkReceived(fingerprint=");
        sbU.append(this.fingerprint);
        sbU.append(", attemptId=");
        sbU.append(this.attemptId);
        sbU.append(", hasAuthToken=");
        sbU.append(this.hasAuthToken);
        sbU.append(", inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", guildTemplateCode=");
        sbU.append(this.guildTemplateCode);
        sbU.append(", isBackgrounded=");
        sbU.append(this.isBackgrounded);
        sbU.append(", linkType=");
        sbU.append(this.linkType);
        sbU.append(", deeplinkSource=");
        return outline.E(sbU, this.deeplinkSource, ")");
    }
}
