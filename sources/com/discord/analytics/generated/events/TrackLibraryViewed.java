package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackLibraryViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLibraryViewed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence loadId = null;
    private final Long numApplicationsTotal = null;
    private final Long numApplicationsBattlenet = null;
    private final Long numApplicationsDiscord = null;
    private final Long numApplicationsSteam = null;
    private final Long numApplicationsTwitch = null;
    private final Long numApplicationsUplay = null;
    private final Long numApplicationsOrigin = null;
    private final Long numApplicationsGog = null;
    private final Long numApplicationsEpic = null;
    private final transient String analyticsSchemaTypeName = "library_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLibraryViewed)) {
            return false;
        }
        TrackLibraryViewed trackLibraryViewed = (TrackLibraryViewed) other;
        return C12238m.areEqual(this.loadId, trackLibraryViewed.loadId) && C12238m.areEqual(this.numApplicationsTotal, trackLibraryViewed.numApplicationsTotal) && C12238m.areEqual(this.numApplicationsBattlenet, trackLibraryViewed.numApplicationsBattlenet) && C12238m.areEqual(this.numApplicationsDiscord, trackLibraryViewed.numApplicationsDiscord) && C12238m.areEqual(this.numApplicationsSteam, trackLibraryViewed.numApplicationsSteam) && C12238m.areEqual(this.numApplicationsTwitch, trackLibraryViewed.numApplicationsTwitch) && C12238m.areEqual(this.numApplicationsUplay, trackLibraryViewed.numApplicationsUplay) && C12238m.areEqual(this.numApplicationsOrigin, trackLibraryViewed.numApplicationsOrigin) && C12238m.areEqual(this.numApplicationsGog, trackLibraryViewed.numApplicationsGog) && C12238m.areEqual(this.numApplicationsEpic, trackLibraryViewed.numApplicationsEpic);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.numApplicationsTotal;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.numApplicationsBattlenet;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numApplicationsDiscord;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.numApplicationsSteam;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.numApplicationsTwitch;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.numApplicationsUplay;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.numApplicationsOrigin;
        int iHashCode8 = (iHashCode7 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.numApplicationsGog;
        int iHashCode9 = (iHashCode8 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.numApplicationsEpic;
        return iHashCode9 + (l9 != null ? l9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackLibraryViewed(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", numApplicationsTotal=");
        sbM833U.append(this.numApplicationsTotal);
        sbM833U.append(", numApplicationsBattlenet=");
        sbM833U.append(this.numApplicationsBattlenet);
        sbM833U.append(", numApplicationsDiscord=");
        sbM833U.append(this.numApplicationsDiscord);
        sbM833U.append(", numApplicationsSteam=");
        sbM833U.append(this.numApplicationsSteam);
        sbM833U.append(", numApplicationsTwitch=");
        sbM833U.append(this.numApplicationsTwitch);
        sbM833U.append(", numApplicationsUplay=");
        sbM833U.append(this.numApplicationsUplay);
        sbM833U.append(", numApplicationsOrigin=");
        sbM833U.append(this.numApplicationsOrigin);
        sbM833U.append(", numApplicationsGog=");
        sbM833U.append(this.numApplicationsGog);
        sbM833U.append(", numApplicationsEpic=");
        return C1643a.m819G(sbM833U, this.numApplicationsEpic, ")");
    }
}
