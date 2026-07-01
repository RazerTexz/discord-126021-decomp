package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackAppOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAppOpened implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence openedFrom = null;
    private final CharSequence uriHost = null;
    private final CharSequence uriScheme = null;
    private final CharSequence uriPath = null;
    private final CharSequence loadId = null;
    private final CharSequence theme = null;
    private final transient String analyticsSchemaTypeName = "app_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAppOpened)) {
            return false;
        }
        TrackAppOpened trackAppOpened = (TrackAppOpened) other;
        return m.areEqual(this.openedFrom, trackAppOpened.openedFrom) && m.areEqual(this.uriHost, trackAppOpened.uriHost) && m.areEqual(this.uriScheme, trackAppOpened.uriScheme) && m.areEqual(this.uriPath, trackAppOpened.uriPath) && m.areEqual(this.loadId, trackAppOpened.loadId) && m.areEqual(this.theme, trackAppOpened.theme);
    }

    public int hashCode() {
        CharSequence charSequence = this.openedFrom;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.uriHost;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.uriScheme;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.uriPath;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.loadId;
        int iHashCode5 = (iHashCode4 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.theme;
        return iHashCode5 + (charSequence6 != null ? charSequence6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackAppOpened(openedFrom=");
        sbU.append(this.openedFrom);
        sbU.append(", uriHost=");
        sbU.append(this.uriHost);
        sbU.append(", uriScheme=");
        sbU.append(this.uriScheme);
        sbU.append(", uriPath=");
        sbU.append(this.uriPath);
        sbU.append(", loadId=");
        sbU.append(this.loadId);
        sbU.append(", theme=");
        return a.E(sbU, this.theme, ")");
    }
}
