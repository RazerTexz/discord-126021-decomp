package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSiteReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackMktgHypesquadFormSubmitted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMktgHypesquadFormSubmitted implements AnalyticsSchema, TrackBaseReceiver, TrackMarketingSiteReceiver {
    private TrackBase trackBase;
    private TrackMarketingSite trackMarketingSite;
    private final CharSequence referredByCode = null;
    private final transient String analyticsSchemaTypeName = "mktg_hypesquad_form_submitted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackMktgHypesquadFormSubmitted) && C12238m.areEqual(this.referredByCode, ((TrackMktgHypesquadFormSubmitted) other).referredByCode);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.referredByCode;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m817E(C1643a.m833U("TrackMktgHypesquadFormSubmitted(referredByCode="), this.referredByCode, ")");
    }
}
