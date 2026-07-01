package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackStickerAttached.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStickerAttached implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence source = null;
    private final Long stickerId = null;
    private final Boolean replaced = null;
    private final transient String analyticsSchemaTypeName = "sticker_attached";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStickerAttached)) {
            return false;
        }
        TrackStickerAttached trackStickerAttached = (TrackStickerAttached) other;
        return m.areEqual(this.source, trackStickerAttached.source) && m.areEqual(this.stickerId, trackStickerAttached.stickerId) && m.areEqual(this.replaced, trackStickerAttached.replaced);
    }

    public int hashCode() {
        CharSequence charSequence = this.source;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.stickerId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool = this.replaced;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackStickerAttached(source=");
        sbU.append(this.source);
        sbU.append(", stickerId=");
        sbU.append(this.stickerId);
        sbU.append(", replaced=");
        return a.D(sbU, this.replaced, ")");
    }
}
