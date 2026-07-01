package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackGameClickedLanding.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGameClickedLanding implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence game = null;
    private final transient String analyticsSchemaTypeName = "game_clicked_landing";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackGameClickedLanding) && Intrinsics3.areEqual(this.game, ((TrackGameClickedLanding) other).game);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.game;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.E(outline.U("TrackGameClickedLanding(game="), this.game, ")");
    }
}
