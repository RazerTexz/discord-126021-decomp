package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackPreviousAppSessionDetected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPreviousAppSessionDetected implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence deviceMemoryState = null;
    private final Boolean wasConnectedToVoice = null;
    private final Boolean wasAppBackgrounded = null;
    private final transient String analyticsSchemaTypeName = "previous_app_session_detected";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPreviousAppSessionDetected)) {
            return false;
        }
        TrackPreviousAppSessionDetected trackPreviousAppSessionDetected = (TrackPreviousAppSessionDetected) other;
        return m.areEqual(this.deviceMemoryState, trackPreviousAppSessionDetected.deviceMemoryState) && m.areEqual(this.wasConnectedToVoice, trackPreviousAppSessionDetected.wasConnectedToVoice) && m.areEqual(this.wasAppBackgrounded, trackPreviousAppSessionDetected.wasAppBackgrounded);
    }

    public int hashCode() {
        CharSequence charSequence = this.deviceMemoryState;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.wasConnectedToVoice;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.wasAppBackgrounded;
        return iHashCode2 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackPreviousAppSessionDetected(deviceMemoryState=");
        sbU.append(this.deviceMemoryState);
        sbU.append(", wasConnectedToVoice=");
        sbU.append(this.wasConnectedToVoice);
        sbU.append(", wasAppBackgrounded=");
        return a.D(sbU, this.wasAppBackgrounded, ")");
    }
}
