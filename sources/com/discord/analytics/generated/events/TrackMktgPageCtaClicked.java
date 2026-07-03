package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.pageName, trackMktgPageCtaClicked.pageName) && C12238m.areEqual(this.rpcConnected, trackMktgPageCtaClicked.rpcConnected);
    }

    public int hashCode() {
        CharSequence charSequence = this.pageName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.rpcConnected;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackMktgPageCtaClicked(pageName=");
        sbM833U.append(this.pageName);
        sbM833U.append(", rpcConnected=");
        return C1643a.m816D(sbM833U, this.rpcConnected, ")");
    }
}
