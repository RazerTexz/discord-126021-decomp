package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackRequestRateLimited.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRequestRateLimited implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence bucket = null;
    private final transient String analyticsSchemaTypeName = "request_rate_limited";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackRequestRateLimited) && m.areEqual(this.bucket, ((TrackRequestRateLimited) other).bucket);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.bucket;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.E(a.U("TrackRequestRateLimited(bucket="), this.bucket, ")");
    }
}
