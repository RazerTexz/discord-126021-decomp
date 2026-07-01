package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackDevPortalCtaViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDevPortalCtaViewed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence ctaName = null;
    private final transient String analyticsSchemaTypeName = "dev_portal_cta_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackDevPortalCtaViewed) && m.areEqual(this.ctaName, ((TrackDevPortalCtaViewed) other).ctaName);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.ctaName;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.E(a.U("TrackDevPortalCtaViewed(ctaName="), this.ctaName, ")");
    }
}
