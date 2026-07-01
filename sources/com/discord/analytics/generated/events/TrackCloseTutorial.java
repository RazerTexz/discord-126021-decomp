package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackCloseTutorial.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCloseTutorial implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean acknowledged = null;
    private final CharSequence tutorial = null;
    private final Long applicationId = null;
    private final transient String analyticsSchemaTypeName = "close_tutorial";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCloseTutorial)) {
            return false;
        }
        TrackCloseTutorial trackCloseTutorial = (TrackCloseTutorial) other;
        return Intrinsics3.areEqual(this.acknowledged, trackCloseTutorial.acknowledged) && Intrinsics3.areEqual(this.tutorial, trackCloseTutorial.tutorial) && Intrinsics3.areEqual(this.applicationId, trackCloseTutorial.applicationId);
    }

    public int hashCode() {
        Boolean bool = this.acknowledged;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.tutorial;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l = this.applicationId;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackCloseTutorial(acknowledged=");
        sbU.append(this.acknowledged);
        sbU.append(", tutorial=");
        sbU.append(this.tutorial);
        sbU.append(", applicationId=");
        return outline.G(sbU, this.applicationId, ")");
    }
}
