package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSite2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackMainNavigationMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMainNavigationMenu implements AnalyticsSchema, TrackBase2, TrackMarketingSite2 {
    private TrackBase trackBase;
    private TrackMarketingSite trackMarketingSite;
    private final CharSequence linkclicked = null;
    private final Boolean googleanalytics = null;
    private final CharSequence pageName = null;
    private final CharSequence staticExperimentUuid = null;
    private final transient String analyticsSchemaTypeName = "main_navigation_menu";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMainNavigationMenu)) {
            return false;
        }
        TrackMainNavigationMenu trackMainNavigationMenu = (TrackMainNavigationMenu) other;
        return Intrinsics3.areEqual(this.linkclicked, trackMainNavigationMenu.linkclicked) && Intrinsics3.areEqual(this.googleanalytics, trackMainNavigationMenu.googleanalytics) && Intrinsics3.areEqual(this.pageName, trackMainNavigationMenu.pageName) && Intrinsics3.areEqual(this.staticExperimentUuid, trackMainNavigationMenu.staticExperimentUuid);
    }

    public int hashCode() {
        CharSequence charSequence = this.linkclicked;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.googleanalytics;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.pageName;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.staticExperimentUuid;
        return iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackMainNavigationMenu(linkclicked=");
        sbU.append(this.linkclicked);
        sbU.append(", googleanalytics=");
        sbU.append(this.googleanalytics);
        sbU.append(", pageName=");
        sbU.append(this.pageName);
        sbU.append(", staticExperimentUuid=");
        return outline.E(sbU, this.staticExperimentUuid, ")");
    }
}
