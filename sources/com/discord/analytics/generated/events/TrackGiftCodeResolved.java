package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadata;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadataReceiver;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGiftCodeResolved.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGiftCodeResolved implements AnalyticsSchema, TrackBaseReceiver, TrackStoreSkuMetadataReceiver, TrackGiftCodeMetadataReceiver {
    private TrackBase trackBase;
    private TrackGiftCodeMetadata trackGiftCodeMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private final Boolean resolved = null;
    private final transient String analyticsSchemaTypeName = "gift_code_resolved";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackGiftCodeResolved) && C12238m.areEqual(this.resolved, ((TrackGiftCodeResolved) other).resolved);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.resolved;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m816D(C1643a.m833U("TrackGiftCodeResolved(resolved="), this.resolved, ")");
    }
}
