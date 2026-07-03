package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackUpsellClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUpsellClicked implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackSourceMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private final CharSequence type = null;
    private final CharSequence subtype = null;
    private final CharSequence action = null;
    private final transient String analyticsSchemaTypeName = "upsell_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUpsellClicked)) {
            return false;
        }
        TrackUpsellClicked trackUpsellClicked = (TrackUpsellClicked) other;
        return C12238m.areEqual(this.type, trackUpsellClicked.type) && C12238m.areEqual(this.subtype, trackUpsellClicked.subtype) && C12238m.areEqual(this.action, trackUpsellClicked.action);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.subtype;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.action;
        return iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackUpsellClicked(type=");
        sbM833U.append(this.type);
        sbM833U.append(", subtype=");
        sbM833U.append(this.subtype);
        sbM833U.append(", action=");
        return C1643a.m817E(sbM833U, this.action, ")");
    }
}
