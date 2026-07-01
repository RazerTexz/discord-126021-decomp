package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSiteReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
        return m.areEqual(this.buttonstate, trackClickLandingCta.buttonstate) && m.areEqual(this.buttontype, trackClickLandingCta.buttontype) && m.areEqual(this.pageName, trackClickLandingCta.pageName) && m.areEqual(this.staticExperimentUuid, trackClickLandingCta.staticExperimentUuid);
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
        StringBuilder sbU = a.U("TrackClickLandingCta(buttonstate=");
        sbU.append(this.buttonstate);
        sbU.append(", buttontype=");
        sbU.append(this.buttontype);
        sbU.append(", pageName=");
        sbU.append(this.pageName);
        sbU.append(", staticExperimentUuid=");
        return a.E(sbU, this.staticExperimentUuid, ")");
    }
}
