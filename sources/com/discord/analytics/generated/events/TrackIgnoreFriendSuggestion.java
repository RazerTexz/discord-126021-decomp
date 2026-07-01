package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackIgnoreFriendSuggestion.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackIgnoreFriendSuggestion implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long suggestedUserId = null;
    private final transient String analyticsSchemaTypeName = "ignore_friend_suggestion";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackIgnoreFriendSuggestion) && m.areEqual(this.suggestedUserId, ((TrackIgnoreFriendSuggestion) other).suggestedUserId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.suggestedUserId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.G(a.U("TrackIgnoreFriendSuggestion(suggestedUserId="), this.suggestedUserId, ")");
    }
}
