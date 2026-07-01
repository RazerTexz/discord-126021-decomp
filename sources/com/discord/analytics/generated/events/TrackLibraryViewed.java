package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackLibraryViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLibraryViewed implements AnalyticsSchema, TrackBase2 {
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
        return Intrinsics3.areEqual(this.loadId, trackLibraryViewed.loadId) && Intrinsics3.areEqual(this.numApplicationsTotal, trackLibraryViewed.numApplicationsTotal) && Intrinsics3.areEqual(this.numApplicationsBattlenet, trackLibraryViewed.numApplicationsBattlenet) && Intrinsics3.areEqual(this.numApplicationsDiscord, trackLibraryViewed.numApplicationsDiscord) && Intrinsics3.areEqual(this.numApplicationsSteam, trackLibraryViewed.numApplicationsSteam) && Intrinsics3.areEqual(this.numApplicationsTwitch, trackLibraryViewed.numApplicationsTwitch) && Intrinsics3.areEqual(this.numApplicationsUplay, trackLibraryViewed.numApplicationsUplay) && Intrinsics3.areEqual(this.numApplicationsOrigin, trackLibraryViewed.numApplicationsOrigin) && Intrinsics3.areEqual(this.numApplicationsGog, trackLibraryViewed.numApplicationsGog) && Intrinsics3.areEqual(this.numApplicationsEpic, trackLibraryViewed.numApplicationsEpic);
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
        StringBuilder sbU = outline.U("TrackLibraryViewed(loadId=");
        sbU.append(this.loadId);
        sbU.append(", numApplicationsTotal=");
        sbU.append(this.numApplicationsTotal);
        sbU.append(", numApplicationsBattlenet=");
        sbU.append(this.numApplicationsBattlenet);
        sbU.append(", numApplicationsDiscord=");
        sbU.append(this.numApplicationsDiscord);
        sbU.append(", numApplicationsSteam=");
        sbU.append(this.numApplicationsSteam);
        sbU.append(", numApplicationsTwitch=");
        sbU.append(this.numApplicationsTwitch);
        sbU.append(", numApplicationsUplay=");
        sbU.append(this.numApplicationsUplay);
        sbU.append(", numApplicationsOrigin=");
        sbU.append(this.numApplicationsOrigin);
        sbU.append(", numApplicationsGog=");
        sbU.append(this.numApplicationsGog);
        sbU.append(", numApplicationsEpic=");
        return outline.G(sbU, this.numApplicationsEpic, ")");
    }
}
