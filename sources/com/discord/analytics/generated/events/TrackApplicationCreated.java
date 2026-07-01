package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackApplicationCreated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationCreated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Long botId = null;
    private final CharSequence name = null;
    private final Boolean hasBot = null;
    private final Boolean hasRedirectUri = null;
    private final CharSequence description = null;
    private final CharSequence iconHash = null;
    private final CharSequence coverImageHash = null;
    private final transient String analyticsSchemaTypeName = "application_created";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackApplicationCreated)) {
            return false;
        }
        TrackApplicationCreated trackApplicationCreated = (TrackApplicationCreated) other;
        return Intrinsics3.areEqual(this.applicationId, trackApplicationCreated.applicationId) && Intrinsics3.areEqual(this.botId, trackApplicationCreated.botId) && Intrinsics3.areEqual(this.name, trackApplicationCreated.name) && Intrinsics3.areEqual(this.hasBot, trackApplicationCreated.hasBot) && Intrinsics3.areEqual(this.hasRedirectUri, trackApplicationCreated.hasRedirectUri) && Intrinsics3.areEqual(this.description, trackApplicationCreated.description) && Intrinsics3.areEqual(this.iconHash, trackApplicationCreated.iconHash) && Intrinsics3.areEqual(this.coverImageHash, trackApplicationCreated.coverImageHash);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.botId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.name;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.hasBot;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasRedirectUri;
        int iHashCode5 = (iHashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.description;
        int iHashCode6 = (iHashCode5 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.iconHash;
        int iHashCode7 = (iHashCode6 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.coverImageHash;
        return iHashCode7 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackApplicationCreated(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", botId=");
        sbU.append(this.botId);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", hasBot=");
        sbU.append(this.hasBot);
        sbU.append(", hasRedirectUri=");
        sbU.append(this.hasRedirectUri);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", iconHash=");
        sbU.append(this.iconHash);
        sbU.append(", coverImageHash=");
        return outline.E(sbU, this.coverImageHash, ")");
    }
}
