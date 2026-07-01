package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackApplicationUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationUpdated implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Long botId = null;
    private final CharSequence name = null;
    private final Boolean hasBot = null;
    private final Boolean hasRedirectUri = null;
    private final CharSequence description = null;
    private final CharSequence iconHash = null;
    private final CharSequence coverImageHash = null;
    private final Long linkedGuildId = null;
    private final CharSequence previousStoreState = null;
    private final CharSequence currentStoreState = null;
    private final transient String analyticsSchemaTypeName = "application_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackApplicationUpdated)) {
            return false;
        }
        TrackApplicationUpdated trackApplicationUpdated = (TrackApplicationUpdated) other;
        return m.areEqual(this.applicationId, trackApplicationUpdated.applicationId) && m.areEqual(this.botId, trackApplicationUpdated.botId) && m.areEqual(this.name, trackApplicationUpdated.name) && m.areEqual(this.hasBot, trackApplicationUpdated.hasBot) && m.areEqual(this.hasRedirectUri, trackApplicationUpdated.hasRedirectUri) && m.areEqual(this.description, trackApplicationUpdated.description) && m.areEqual(this.iconHash, trackApplicationUpdated.iconHash) && m.areEqual(this.coverImageHash, trackApplicationUpdated.coverImageHash) && m.areEqual(this.linkedGuildId, trackApplicationUpdated.linkedGuildId) && m.areEqual(this.previousStoreState, trackApplicationUpdated.previousStoreState) && m.areEqual(this.currentStoreState, trackApplicationUpdated.currentStoreState);
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
        int iHashCode8 = (iHashCode7 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l3 = this.linkedGuildId;
        int iHashCode9 = (iHashCode8 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.previousStoreState;
        int iHashCode10 = (iHashCode9 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.currentStoreState;
        return iHashCode10 + (charSequence6 != null ? charSequence6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackApplicationUpdated(applicationId=");
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
        sbU.append(this.coverImageHash);
        sbU.append(", linkedGuildId=");
        sbU.append(this.linkedGuildId);
        sbU.append(", previousStoreState=");
        sbU.append(this.previousStoreState);
        sbU.append(", currentStoreState=");
        return a.E(sbU, this.currentStoreState, ")");
    }
}
