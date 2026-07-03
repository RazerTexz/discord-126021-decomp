package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.openedFrom, trackAppOpened.openedFrom) && C12238m.areEqual(this.uriHost, trackAppOpened.uriHost) && C12238m.areEqual(this.uriScheme, trackAppOpened.uriScheme) && C12238m.areEqual(this.uriPath, trackAppOpened.uriPath) && C12238m.areEqual(this.loadId, trackAppOpened.loadId) && C12238m.areEqual(this.theme, trackAppOpened.theme);
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
        StringBuilder sbM833U = C1643a.m833U("TrackAppOpened(openedFrom=");
        sbM833U.append(this.openedFrom);
        sbM833U.append(", uriHost=");
        sbM833U.append(this.uriHost);
        sbM833U.append(", uriScheme=");
        sbM833U.append(this.uriScheme);
        sbM833U.append(", uriPath=");
        sbM833U.append(this.uriPath);
        sbM833U.append(", loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", theme=");
        return C1643a.m817E(sbM833U, this.theme, ")");
    }
}
