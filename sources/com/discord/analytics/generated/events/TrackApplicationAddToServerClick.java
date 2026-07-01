package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
        return m.areEqual(this.applicationId, trackApplicationAddToServerClick.applicationId) && m.areEqual(this.authType, trackApplicationAddToServerClick.authType);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.authType;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackApplicationAddToServerClick(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", authType=");
        return a.E(sbU, this.authType, ")");
    }
}
