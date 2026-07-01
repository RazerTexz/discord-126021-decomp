package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackExpressionPickerStickerShopViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackExpressionPickerStickerShopViewed implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final Boolean badged = null;
    private final transient String analyticsSchemaTypeName = "expression_picker_sticker_shop_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackExpressionPickerStickerShopViewed) && Intrinsics3.areEqual(this.badged, ((TrackExpressionPickerStickerShopViewed) other).badged);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.badged;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.D(outline.U("TrackExpressionPickerStickerShopViewed(badged="), this.badged, ")");
    }
}
