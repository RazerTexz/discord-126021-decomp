package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSiteReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackClickLandingCta.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackClickLandingCta implements AnalyticsSchema, TrackBaseReceiver, TrackMarketingSiteReceiver {
    private TrackBase trackBase;
    private TrackMarketingSite trackMarketingSite;
    private final CharSequence buttonstate = null;
    private final CharSequence buttontype = null;
    private final CharSequence pageName = null;
    private final CharSequence staticExperimentUuid = null;
    private final transient String analyticsSchemaTypeName = "click_landing_cta";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackClickLandingCta)) {
            return false;
        }
        TrackClickLandingCta trackClickLandingCta = (TrackClickLandingCta) other;
        return C12238m.areEqual(this.buttonstate, trackClickLandingCta.buttonstate) && C12238m.areEqual(this.buttontype, trackClickLandingCta.buttontype) && C12238m.areEqual(this.pageName, trackClickLandingCta.pageName) && C12238m.areEqual(this.staticExperimentUuid, trackClickLandingCta.staticExperimentUuid);
    }

    public int hashCode() {
        CharSequence charSequence = this.buttonstate;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.buttontype;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.pageName;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.staticExperimentUuid;
        return iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackClickLandingCta(buttonstate=");
        sbM833U.append(this.buttonstate);
        sbM833U.append(", buttontype=");
        sbM833U.append(this.buttontype);
        sbM833U.append(", pageName=");
        sbM833U.append(this.pageName);
        sbM833U.append(", staticExperimentUuid=");
        return C1643a.m817E(sbM833U, this.staticExperimentUuid, ")");
    }
}
