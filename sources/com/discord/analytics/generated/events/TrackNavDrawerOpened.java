package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.drawer, trackNavDrawerOpened.drawer) && C12238m.areEqual(this.source, trackNavDrawerOpened.source);
    }

    public int hashCode() {
        CharSequence charSequence = this.drawer;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.source;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackNavDrawerOpened(drawer=");
        sbM833U.append(this.drawer);
        sbM833U.append(", source=");
        return C1643a.m817E(sbM833U, this.source, ")");
    }
}
