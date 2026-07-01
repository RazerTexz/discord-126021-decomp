package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackDismissAllTutorials.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDismissAllTutorials implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence tutorial = null;
    private final transient String analyticsSchemaTypeName = "dismiss_all_tutorials";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackDismissAllTutorials) && Intrinsics3.areEqual(this.tutorial, ((TrackDismissAllTutorials) other).tutorial);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.tutorial;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.E(outline.U("TrackDismissAllTutorials(tutorial="), this.tutorial, ")");
    }
}
