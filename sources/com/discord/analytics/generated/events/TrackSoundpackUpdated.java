package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.soundpack, trackSoundpackUpdated.soundpack) && C12238m.areEqual(this.previousSoundpack, trackSoundpackUpdated.previousSoundpack);
    }

    public int hashCode() {
        CharSequence charSequence = this.soundpack;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.previousSoundpack;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackSoundpackUpdated(soundpack=");
        sbM833U.append(this.soundpack);
        sbM833U.append(", previousSoundpack=");
        return C1643a.m817E(sbM833U, this.previousSoundpack, ")");
    }
}
