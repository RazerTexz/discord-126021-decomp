package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackExternalDynamicLinkReceived.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackExternalDynamicLinkReceived implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.fingerprint, trackExternalDynamicLinkReceived.fingerprint) && C12238m.areEqual(this.attemptId, trackExternalDynamicLinkReceived.attemptId) && C12238m.areEqual(this.hasAuthToken, trackExternalDynamicLinkReceived.hasAuthToken) && C12238m.areEqual(this.inviteCode, trackExternalDynamicLinkReceived.inviteCode) && C12238m.areEqual(this.guildTemplateCode, trackExternalDynamicLinkReceived.guildTemplateCode) && C12238m.areEqual(this.isBackgrounded, trackExternalDynamicLinkReceived.isBackgrounded) && C12238m.areEqual(this.linkType, trackExternalDynamicLinkReceived.linkType) && C12238m.areEqual(this.deeplinkSource, trackExternalDynamicLinkReceived.deeplinkSource);
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
        StringBuilder sbM833U = C1643a.m833U("TrackExternalDynamicLinkReceived(fingerprint=");
        sbM833U.append(this.fingerprint);
        sbM833U.append(", attemptId=");
        sbM833U.append(this.attemptId);
        sbM833U.append(", hasAuthToken=");
        sbM833U.append(this.hasAuthToken);
        sbM833U.append(", inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", guildTemplateCode=");
        sbM833U.append(this.guildTemplateCode);
        sbM833U.append(", isBackgrounded=");
        sbM833U.append(this.isBackgrounded);
        sbM833U.append(", linkType=");
        sbM833U.append(this.linkType);
        sbM833U.append(", deeplinkSource=");
        return C1643a.m817E(sbM833U, this.deeplinkSource, ")");
    }
}
