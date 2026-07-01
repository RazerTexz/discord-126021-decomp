package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackUpsellClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUpsellClicked implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackSourceMetadata2 {
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
        return Intrinsics3.areEqual(this.type, trackUpsellClicked.type) && Intrinsics3.areEqual(this.subtype, trackUpsellClicked.subtype) && Intrinsics3.areEqual(this.action, trackUpsellClicked.action);
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
        StringBuilder sbU = outline.U("TrackUpsellClicked(type=");
        sbU.append(this.type);
        sbU.append(", subtype=");
        sbU.append(this.subtype);
        sbU.append(", action=");
        return outline.E(sbU, this.action, ")");
    }
}
