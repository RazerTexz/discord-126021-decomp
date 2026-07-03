package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackDeepLinkClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDeepLinkClicked implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long fingerprint = null;
    private final CharSequence attemptId = null;
    private final CharSequence source = null;
    private final CharSequence inviteCode = null;
    private final CharSequence guildTemplateCode = null;
    private final CharSequence destination = null;
    private final transient String analyticsSchemaTypeName = "deep_link_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDeepLinkClicked)) {
            return false;
        }
        TrackDeepLinkClicked trackDeepLinkClicked = (TrackDeepLinkClicked) other;
        return C12238m.areEqual(this.fingerprint, trackDeepLinkClicked.fingerprint) && C12238m.areEqual(this.attemptId, trackDeepLinkClicked.attemptId) && C12238m.areEqual(this.source, trackDeepLinkClicked.source) && C12238m.areEqual(this.inviteCode, trackDeepLinkClicked.inviteCode) && C12238m.areEqual(this.guildTemplateCode, trackDeepLinkClicked.guildTemplateCode) && C12238m.areEqual(this.destination, trackDeepLinkClicked.destination);
    }

    public int hashCode() {
        Long l = this.fingerprint;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.attemptId;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.source;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.inviteCode;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.guildTemplateCode;
        int iHashCode5 = (iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.destination;
        return iHashCode5 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackDeepLinkClicked(fingerprint=");
        sbM833U.append(this.fingerprint);
        sbM833U.append(", attemptId=");
        sbM833U.append(this.attemptId);
        sbM833U.append(", source=");
        sbM833U.append(this.source);
        sbM833U.append(", inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", guildTemplateCode=");
        sbM833U.append(this.guildTemplateCode);
        sbM833U.append(", destination=");
        return C1643a.m817E(sbM833U, this.destination, ")");
    }
}
