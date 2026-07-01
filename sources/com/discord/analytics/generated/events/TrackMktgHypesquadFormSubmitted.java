package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSiteReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
            return (other instanceof TrackMktgHypesquadFormSubmitted) && m.areEqual(this.referredByCode, ((TrackMktgHypesquadFormSubmitted) other).referredByCode);
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
        return a.E(a.U("TrackMktgHypesquadFormSubmitted(referredByCode="), this.referredByCode, ")");
    }
}
