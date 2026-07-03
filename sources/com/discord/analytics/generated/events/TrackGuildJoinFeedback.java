package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGuildJoinFeedback.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildJoinFeedback implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final CharSequence reason = null;
    private final CharSequence rating = null;
    private final CharSequence feedback = null;
    private final Boolean skipped = null;
    private final transient String analyticsSchemaTypeName = "guild_join_feedback";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildJoinFeedback)) {
            return false;
        }
        TrackGuildJoinFeedback trackGuildJoinFeedback = (TrackGuildJoinFeedback) other;
        return C12238m.areEqual(this.reason, trackGuildJoinFeedback.reason) && C12238m.areEqual(this.rating, trackGuildJoinFeedback.rating) && C12238m.areEqual(this.feedback, trackGuildJoinFeedback.feedback) && C12238m.areEqual(this.skipped, trackGuildJoinFeedback.skipped);
    }

    public int hashCode() {
        CharSequence charSequence = this.reason;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.rating;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.feedback;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.skipped;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGuildJoinFeedback(reason=");
        sbM833U.append(this.reason);
        sbM833U.append(", rating=");
        sbM833U.append(this.rating);
        sbM833U.append(", feedback=");
        sbM833U.append(this.feedback);
        sbM833U.append(", skipped=");
        return C1643a.m816D(sbM833U, this.skipped, ")");
    }
}
