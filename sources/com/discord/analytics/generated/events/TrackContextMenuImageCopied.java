package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackContextMenuImageCopied.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackContextMenuImageCopied implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final CharSequence url = null;
    private final transient String analyticsSchemaTypeName = "context_menu_image_copied";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackContextMenuImageCopied)) {
            return false;
        }
        TrackContextMenuImageCopied trackContextMenuImageCopied = (TrackContextMenuImageCopied) other;
        return m.areEqual(this.channelId, trackContextMenuImageCopied.channelId) && m.areEqual(this.url, trackContextMenuImageCopied.url);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.url;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackContextMenuImageCopied(channelId=");
        sbU.append(this.channelId);
        sbU.append(", url=");
        return a.E(sbU, this.url, ")");
    }
}
