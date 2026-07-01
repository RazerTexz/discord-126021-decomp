package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackContextMenuLinkOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackContextMenuLinkOpened implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final CharSequence href = null;
    private final transient String analyticsSchemaTypeName = "context_menu_link_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackContextMenuLinkOpened)) {
            return false;
        }
        TrackContextMenuLinkOpened trackContextMenuLinkOpened = (TrackContextMenuLinkOpened) other;
        return Intrinsics3.areEqual(this.channelId, trackContextMenuLinkOpened.channelId) && Intrinsics3.areEqual(this.href, trackContextMenuLinkOpened.href);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.href;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackContextMenuLinkOpened(channelId=");
        sbU.append(this.channelId);
        sbU.append(", href=");
        return outline.E(sbU, this.href, ")");
    }
}
