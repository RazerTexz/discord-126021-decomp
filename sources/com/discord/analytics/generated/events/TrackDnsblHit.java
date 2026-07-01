package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackDnsblHit.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDnsblHit implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence provider = null;
    private final transient String analyticsSchemaTypeName = "dnsbl_hit";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackDnsblHit) && Intrinsics3.areEqual(this.provider, ((TrackDnsblHit) other).provider);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.provider;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.E(outline.U("TrackDnsblHit(provider="), this.provider, ")");
    }
}
