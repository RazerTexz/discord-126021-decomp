package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSiteReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackPressButton.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPressButton implements AnalyticsSchema, TrackBaseReceiver, TrackMarketingSiteReceiver {
    private TrackBase trackBase;
    private TrackMarketingSite trackMarketingSite;
    private final CharSequence game = null;
    private final CharSequence name = null;
    private final transient String analyticsSchemaTypeName = "press_button";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPressButton)) {
            return false;
        }
        TrackPressButton trackPressButton = (TrackPressButton) other;
        return C12238m.areEqual(this.game, trackPressButton.game) && C12238m.areEqual(this.name, trackPressButton.name);
    }

    public int hashCode() {
        CharSequence charSequence = this.game;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.name;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackPressButton(game=");
        sbM833U.append(this.game);
        sbM833U.append(", name=");
        return C1643a.m817E(sbM833U, this.name, ")");
    }
}
