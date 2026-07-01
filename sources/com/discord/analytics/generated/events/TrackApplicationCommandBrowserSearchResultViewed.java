package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackApplicationCommandBrowserSearchResultViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationCommandBrowserSearchResultViewed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence query = null;
    private final List<Long> commandIds = null;
    private final transient String analyticsSchemaTypeName = "application_command_browser_search_result_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackApplicationCommandBrowserSearchResultViewed)) {
            return false;
        }
        TrackApplicationCommandBrowserSearchResultViewed trackApplicationCommandBrowserSearchResultViewed = (TrackApplicationCommandBrowserSearchResultViewed) other;
        return Intrinsics3.areEqual(this.query, trackApplicationCommandBrowserSearchResultViewed.query) && Intrinsics3.areEqual(this.commandIds, trackApplicationCommandBrowserSearchResultViewed.commandIds);
    }

    public int hashCode() {
        CharSequence charSequence = this.query;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        List<Long> list = this.commandIds;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackApplicationCommandBrowserSearchResultViewed(query=");
        sbU.append(this.query);
        sbU.append(", commandIds=");
        return outline.L(sbU, this.commandIds, ")");
    }
}
