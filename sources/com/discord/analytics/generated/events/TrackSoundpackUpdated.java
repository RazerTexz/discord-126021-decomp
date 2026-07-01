package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackSoundpackUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSoundpackUpdated implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence soundpack = null;
    private final CharSequence previousSoundpack = null;
    private final transient String analyticsSchemaTypeName = "soundpack_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSoundpackUpdated)) {
            return false;
        }
        TrackSoundpackUpdated trackSoundpackUpdated = (TrackSoundpackUpdated) other;
        return m.areEqual(this.soundpack, trackSoundpackUpdated.soundpack) && m.areEqual(this.previousSoundpack, trackSoundpackUpdated.previousSoundpack);
    }

    public int hashCode() {
        CharSequence charSequence = this.soundpack;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.previousSoundpack;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackSoundpackUpdated(soundpack=");
        sbU.append(this.soundpack);
        sbU.append(", previousSoundpack=");
        return a.E(sbU, this.previousSoundpack, ")");
    }
}
