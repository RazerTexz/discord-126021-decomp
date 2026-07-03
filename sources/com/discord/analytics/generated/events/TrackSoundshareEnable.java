package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackSoundshareEnable.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSoundshareEnable implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long statusCode = null;
    private final CharSequence message = null;
    private final transient String analyticsSchemaTypeName = "soundshare_enable";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSoundshareEnable)) {
            return false;
        }
        TrackSoundshareEnable trackSoundshareEnable = (TrackSoundshareEnable) other;
        return C12238m.areEqual(this.statusCode, trackSoundshareEnable.statusCode) && C12238m.areEqual(this.message, trackSoundshareEnable.message);
    }

    public int hashCode() {
        Long l = this.statusCode;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.message;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackSoundshareEnable(statusCode=");
        sbM833U.append(this.statusCode);
        sbM833U.append(", message=");
        return C1643a.m817E(sbM833U, this.message, ")");
    }
}
