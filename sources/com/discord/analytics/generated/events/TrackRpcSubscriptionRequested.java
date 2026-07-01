package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackRpcSubscriptionRequested.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRpcSubscriptionRequested implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence scope = null;
    private final transient String analyticsSchemaTypeName = "rpc_subscription_requested";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackRpcSubscriptionRequested) && Intrinsics3.areEqual(this.scope, ((TrackRpcSubscriptionRequested) other).scope);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.scope;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.E(outline.U("TrackRpcSubscriptionRequested(scope="), this.scope, ")");
    }
}
