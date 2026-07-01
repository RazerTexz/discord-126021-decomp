package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackVoiceWatchdogTimeout.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVoiceWatchdogTimeout implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long minidumpSubmissionError = null;
    private final transient String analyticsSchemaTypeName = "voice_watchdog_timeout";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackVoiceWatchdogTimeout) && m.areEqual(this.minidumpSubmissionError, ((TrackVoiceWatchdogTimeout) other).minidumpSubmissionError);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.minidumpSubmissionError;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.G(a.U("TrackVoiceWatchdogTimeout(minidumpSubmissionError="), this.minidumpSubmissionError, ")");
    }
}
