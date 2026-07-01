package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackDeepLinkClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDeepLinkClicked implements AnalyticsSchema, TrackBase2 {
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
        return Intrinsics3.areEqual(this.fingerprint, trackDeepLinkClicked.fingerprint) && Intrinsics3.areEqual(this.attemptId, trackDeepLinkClicked.attemptId) && Intrinsics3.areEqual(this.source, trackDeepLinkClicked.source) && Intrinsics3.areEqual(this.inviteCode, trackDeepLinkClicked.inviteCode) && Intrinsics3.areEqual(this.guildTemplateCode, trackDeepLinkClicked.guildTemplateCode) && Intrinsics3.areEqual(this.destination, trackDeepLinkClicked.destination);
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
        StringBuilder sbU = outline.U("TrackDeepLinkClicked(fingerprint=");
        sbU.append(this.fingerprint);
        sbU.append(", attemptId=");
        sbU.append(this.attemptId);
        sbU.append(", source=");
        sbU.append(this.source);
        sbU.append(", inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", guildTemplateCode=");
        sbU.append(this.guildTemplateCode);
        sbU.append(", destination=");
        return outline.E(sbU, this.destination, ")");
    }
}
