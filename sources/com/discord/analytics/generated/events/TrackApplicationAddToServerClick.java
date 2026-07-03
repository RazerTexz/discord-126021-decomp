package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackApplicationAddToServerClick.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationAddToServerClick implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final CharSequence authType = null;
    private final transient String analyticsSchemaTypeName = "application_add_to_server_click";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackApplicationAddToServerClick)) {
            return false;
        }
        TrackApplicationAddToServerClick trackApplicationAddToServerClick = (TrackApplicationAddToServerClick) other;
        return C12238m.areEqual(this.applicationId, trackApplicationAddToServerClick.applicationId) && C12238m.areEqual(this.authType, trackApplicationAddToServerClick.authType);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.authType;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackApplicationAddToServerClick(applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", authType=");
        return C1643a.m817E(sbM833U, this.authType, ")");
    }
}
