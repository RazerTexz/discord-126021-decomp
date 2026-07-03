package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackCloseTutorial.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCloseTutorial implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.acknowledged, trackCloseTutorial.acknowledged) && C12238m.areEqual(this.tutorial, trackCloseTutorial.tutorial) && C12238m.areEqual(this.applicationId, trackCloseTutorial.applicationId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackCloseTutorial(acknowledged=");
        sbM833U.append(this.acknowledged);
        sbM833U.append(", tutorial=");
        sbM833U.append(this.tutorial);
        sbM833U.append(", applicationId=");
        return C1643a.m819G(sbM833U, this.applicationId, ")");
    }
}
