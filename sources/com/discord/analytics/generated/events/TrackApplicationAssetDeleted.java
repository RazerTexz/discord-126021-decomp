package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackApplicationAssetDeleted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationAssetDeleted implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long id = null;
    private final Long applicationId = null;
    private final Long botId = null;
    private final CharSequence applicationName = null;
    private final Boolean hasBot = null;
    private final Boolean hasRedirectUri = null;
    private final Long type = null;
    private final CharSequence name = null;
    private final transient String analyticsSchemaTypeName = "application_asset_deleted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackApplicationAssetDeleted)) {
            return false;
        }
        TrackApplicationAssetDeleted trackApplicationAssetDeleted = (TrackApplicationAssetDeleted) other;
        return m.areEqual(this.id, trackApplicationAssetDeleted.id) && m.areEqual(this.applicationId, trackApplicationAssetDeleted.applicationId) && m.areEqual(this.botId, trackApplicationAssetDeleted.botId) && m.areEqual(this.applicationName, trackApplicationAssetDeleted.applicationName) && m.areEqual(this.hasBot, trackApplicationAssetDeleted.hasBot) && m.areEqual(this.hasRedirectUri, trackApplicationAssetDeleted.hasRedirectUri) && m.areEqual(this.type, trackApplicationAssetDeleted.type) && m.areEqual(this.name, trackApplicationAssetDeleted.name);
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.applicationId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.botId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.applicationName;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.hasBot;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasRedirectUri;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l4 = this.type;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.name;
        return iHashCode7 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackApplicationAssetDeleted(id=");
        sbU.append(this.id);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", botId=");
        sbU.append(this.botId);
        sbU.append(", applicationName=");
        sbU.append(this.applicationName);
        sbU.append(", hasBot=");
        sbU.append(this.hasBot);
        sbU.append(", hasRedirectUri=");
        sbU.append(this.hasRedirectUri);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", name=");
        return a.E(sbU, this.name, ")");
    }
}
