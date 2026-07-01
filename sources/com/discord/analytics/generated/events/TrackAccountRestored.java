package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackAccountRestored.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAccountRestored implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence restoredFrom = null;
    private final transient String analyticsSchemaTypeName = "account_restored";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackAccountRestored) && Intrinsics3.areEqual(this.restoredFrom, ((TrackAccountRestored) other).restoredFrom);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.restoredFrom;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.E(outline.U("TrackAccountRestored(restoredFrom="), this.restoredFrom, ")");
    }
}
