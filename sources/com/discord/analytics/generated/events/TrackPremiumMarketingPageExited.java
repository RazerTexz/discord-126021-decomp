package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackPremiumMarketingPageExited.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPremiumMarketingPageExited implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence loadId = null;
    private final List<Long> applicationIdsViewed = null;
    private final List<Long> skuIdsViewed = null;
    private final Long durationMs = null;
    private final transient String analyticsSchemaTypeName = "premium_marketing_page_exited";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPremiumMarketingPageExited)) {
            return false;
        }
        TrackPremiumMarketingPageExited trackPremiumMarketingPageExited = (TrackPremiumMarketingPageExited) other;
        return Intrinsics3.areEqual(this.loadId, trackPremiumMarketingPageExited.loadId) && Intrinsics3.areEqual(this.applicationIdsViewed, trackPremiumMarketingPageExited.applicationIdsViewed) && Intrinsics3.areEqual(this.skuIdsViewed, trackPremiumMarketingPageExited.skuIdsViewed) && Intrinsics3.areEqual(this.durationMs, trackPremiumMarketingPageExited.durationMs);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        List<Long> list = this.applicationIdsViewed;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.skuIdsViewed;
        int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Long l = this.durationMs;
        return iHashCode3 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPremiumMarketingPageExited(loadId=");
        sbU.append(this.loadId);
        sbU.append(", applicationIdsViewed=");
        sbU.append(this.applicationIdsViewed);
        sbU.append(", skuIdsViewed=");
        sbU.append(this.skuIdsViewed);
        sbU.append(", durationMs=");
        return outline.G(sbU, this.durationMs, ")");
    }
}
