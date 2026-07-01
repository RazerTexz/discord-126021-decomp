package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackOutboundPromotionCodeClaimed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOutboundPromotionCodeClaimed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long promotionId = null;
    private final transient String analyticsSchemaTypeName = "outbound_promotion_code_claimed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackOutboundPromotionCodeClaimed) && m.areEqual(this.promotionId, ((TrackOutboundPromotionCodeClaimed) other).promotionId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.promotionId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.G(a.U("TrackOutboundPromotionCodeClaimed(promotionId="), this.promotionId, ")");
    }
}
