package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSiteReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackMainNavigationMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMainNavigationMenu implements AnalyticsSchema, TrackBaseReceiver, TrackMarketingSiteReceiver {
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
        return C12238m.areEqual(this.linkclicked, trackMainNavigationMenu.linkclicked) && C12238m.areEqual(this.googleanalytics, trackMainNavigationMenu.googleanalytics) && C12238m.areEqual(this.pageName, trackMainNavigationMenu.pageName) && C12238m.areEqual(this.staticExperimentUuid, trackMainNavigationMenu.staticExperimentUuid);
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
        StringBuilder sbM833U = C1643a.m833U("TrackMainNavigationMenu(linkclicked=");
        sbM833U.append(this.linkclicked);
        sbM833U.append(", googleanalytics=");
        sbM833U.append(this.googleanalytics);
        sbM833U.append(", pageName=");
        sbM833U.append(this.pageName);
        sbM833U.append(", staticExperimentUuid=");
        return C1643a.m817E(sbM833U, this.staticExperimentUuid, ")");
    }
}
