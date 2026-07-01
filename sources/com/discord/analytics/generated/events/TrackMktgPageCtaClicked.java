package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackMktgPageCtaClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMktgPageCtaClicked implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence pageName = null;
    private final Boolean rpcConnected = null;
    private final transient String analyticsSchemaTypeName = "mktg_page_cta_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMktgPageCtaClicked)) {
            return false;
        }
        TrackMktgPageCtaClicked trackMktgPageCtaClicked = (TrackMktgPageCtaClicked) other;
        return m.areEqual(this.pageName, trackMktgPageCtaClicked.pageName) && m.areEqual(this.rpcConnected, trackMktgPageCtaClicked.rpcConnected);
    }

    public int hashCode() {
        CharSequence charSequence = this.pageName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.rpcConnected;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackMktgPageCtaClicked(pageName=");
        sbU.append(this.pageName);
        sbU.append(", rpcConnected=");
        return a.D(sbU, this.rpcConnected, ")");
    }
}
