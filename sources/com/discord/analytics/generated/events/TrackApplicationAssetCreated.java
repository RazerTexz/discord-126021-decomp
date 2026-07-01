package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackApplicationAssetCreated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationAssetCreated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long id = null;
    private final Long applicationId = null;
    private final Long botId = null;
    private final CharSequence applicationName = null;
    private final Boolean hasBot = null;
    private final Boolean hasRedirectUri = null;
    private final Long type = null;
    private final CharSequence name = null;
    private final transient String analyticsSchemaTypeName = "application_asset_created";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackApplicationAssetCreated)) {
            return false;
        }
        TrackApplicationAssetCreated trackApplicationAssetCreated = (TrackApplicationAssetCreated) other;
        return Intrinsics3.areEqual(this.id, trackApplicationAssetCreated.id) && Intrinsics3.areEqual(this.applicationId, trackApplicationAssetCreated.applicationId) && Intrinsics3.areEqual(this.botId, trackApplicationAssetCreated.botId) && Intrinsics3.areEqual(this.applicationName, trackApplicationAssetCreated.applicationName) && Intrinsics3.areEqual(this.hasBot, trackApplicationAssetCreated.hasBot) && Intrinsics3.areEqual(this.hasRedirectUri, trackApplicationAssetCreated.hasRedirectUri) && Intrinsics3.areEqual(this.type, trackApplicationAssetCreated.type) && Intrinsics3.areEqual(this.name, trackApplicationAssetCreated.name);
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
        StringBuilder sbU = outline.U("TrackApplicationAssetCreated(id=");
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
        return outline.E(sbU, this.name, ")");
    }
}
