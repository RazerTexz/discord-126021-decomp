package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackApplicationCreated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationCreated implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.applicationId, trackApplicationCreated.applicationId) && C12238m.areEqual(this.botId, trackApplicationCreated.botId) && C12238m.areEqual(this.name, trackApplicationCreated.name) && C12238m.areEqual(this.hasBot, trackApplicationCreated.hasBot) && C12238m.areEqual(this.hasRedirectUri, trackApplicationCreated.hasRedirectUri) && C12238m.areEqual(this.description, trackApplicationCreated.description) && C12238m.areEqual(this.iconHash, trackApplicationCreated.iconHash) && C12238m.areEqual(this.coverImageHash, trackApplicationCreated.coverImageHash);
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
        StringBuilder sbM833U = C1643a.m833U("TrackApplicationCreated(applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", botId=");
        sbM833U.append(this.botId);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", hasBot=");
        sbM833U.append(this.hasBot);
        sbM833U.append(", hasRedirectUri=");
        sbM833U.append(this.hasRedirectUri);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", iconHash=");
        sbM833U.append(this.iconHash);
        sbM833U.append(", coverImageHash=");
        return C1643a.m817E(sbM833U, this.coverImageHash, ")");
    }
}
