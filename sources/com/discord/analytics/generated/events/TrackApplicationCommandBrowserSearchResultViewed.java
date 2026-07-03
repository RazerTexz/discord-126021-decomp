package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackApplicationCommandBrowserSearchResultViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationCommandBrowserSearchResultViewed implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.query, trackApplicationCommandBrowserSearchResultViewed.query) && C12238m.areEqual(this.commandIds, trackApplicationCommandBrowserSearchResultViewed.commandIds);
    }

    public int hashCode() {
        CharSequence charSequence = this.query;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        List<Long> list = this.commandIds;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackApplicationCommandBrowserSearchResultViewed(query=");
        sbM833U.append(this.query);
        sbM833U.append(", commandIds=");
        return C1643a.m824L(sbM833U, this.commandIds, ")");
    }
}
