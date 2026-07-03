package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackHoverMenuOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackHoverMenuOpened implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence loadId = null;
    private final Long numUsers = null;
    private final transient String analyticsSchemaTypeName = "hover_menu_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackHoverMenuOpened)) {
            return false;
        }
        TrackHoverMenuOpened trackHoverMenuOpened = (TrackHoverMenuOpened) other;
        return C12238m.areEqual(this.loadId, trackHoverMenuOpened.loadId) && C12238m.areEqual(this.numUsers, trackHoverMenuOpened.numUsers);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.numUsers;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackHoverMenuOpened(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", numUsers=");
        return C1643a.m819G(sbM833U, this.numUsers, ")");
    }
}
