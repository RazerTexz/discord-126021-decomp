package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackAccountDeletionCanceled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAccountDeletionCanceled implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence initiatedBy = null;
    private final transient String analyticsSchemaTypeName = "account_deletion_canceled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackAccountDeletionCanceled) && C12238m.areEqual(this.initiatedBy, ((TrackAccountDeletionCanceled) other).initiatedBy);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.initiatedBy;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m817E(C1643a.m833U("TrackAccountDeletionCanceled(initiatedBy="), this.initiatedBy, ")");
    }
}
