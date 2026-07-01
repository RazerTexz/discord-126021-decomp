package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackNavDrawerOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNavDrawerOpened implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence drawer = null;
    private final CharSequence source = null;
    private final transient String analyticsSchemaTypeName = "nav_drawer_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNavDrawerOpened)) {
            return false;
        }
        TrackNavDrawerOpened trackNavDrawerOpened = (TrackNavDrawerOpened) other;
        return m.areEqual(this.drawer, trackNavDrawerOpened.drawer) && m.areEqual(this.source, trackNavDrawerOpened.source);
    }

    public int hashCode() {
        CharSequence charSequence = this.drawer;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.source;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackNavDrawerOpened(drawer=");
        sbU.append(this.drawer);
        sbU.append(", source=");
        return a.E(sbU, this.source, ")");
    }
}
