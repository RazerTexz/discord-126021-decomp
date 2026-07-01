package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackExpressionPickerStickerShopViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackExpressionPickerStickerShopViewed implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
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
            return (other instanceof TrackExpressionPickerStickerShopViewed) && m.areEqual(this.badged, ((TrackExpressionPickerStickerShopViewed) other).badged);
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
        return a.D(a.U("TrackExpressionPickerStickerShopViewed(badged="), this.badged, ")");
    }
}
