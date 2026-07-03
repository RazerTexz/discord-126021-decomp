package com.discord.analytics.generated.events;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackVideoInputInitialized.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVideoInputInitialized implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence deviceName = null;
    private final Long timeToFirstFrameMs = null;
    private final Boolean timedOut = null;
    private final Float activity = null;
    private final transient String analyticsSchemaTypeName = "video_input_initialized";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVideoInputInitialized)) {
            return false;
        }
        TrackVideoInputInitialized trackVideoInputInitialized = (TrackVideoInputInitialized) other;
        return C12238m.areEqual(this.deviceName, trackVideoInputInitialized.deviceName) && C12238m.areEqual(this.timeToFirstFrameMs, trackVideoInputInitialized.timeToFirstFrameMs) && C12238m.areEqual(this.timedOut, trackVideoInputInitialized.timedOut) && C12238m.areEqual(this.activity, trackVideoInputInitialized.activity);
    }

    public int hashCode() {
        CharSequence charSequence = this.deviceName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.timeToFirstFrameMs;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool = this.timedOut;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Float f = this.activity;
        return iHashCode3 + (f != null ? f.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackVideoInputInitialized(deviceName=");
        sbM833U.append(this.deviceName);
        sbM833U.append(", timeToFirstFrameMs=");
        sbM833U.append(this.timeToFirstFrameMs);
        sbM833U.append(", timedOut=");
        sbM833U.append(this.timedOut);
        sbM833U.append(", activity=");
        sbM833U.append(this.activity);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
