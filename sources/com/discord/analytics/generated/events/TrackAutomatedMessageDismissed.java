package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackAutomatedMessageDismissed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAutomatedMessageDismissed implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence messageAuthor = null;
    private final CharSequence messageName = null;
    private final transient String analyticsSchemaTypeName = "automated_message_dismissed";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
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
        if (!(other instanceof TrackAutomatedMessageDismissed)) {
            return false;
        }
        TrackAutomatedMessageDismissed trackAutomatedMessageDismissed = (TrackAutomatedMessageDismissed) other;
        return Intrinsics3.areEqual(this.messageAuthor, trackAutomatedMessageDismissed.messageAuthor) && Intrinsics3.areEqual(this.messageName, trackAutomatedMessageDismissed.messageName);
    }

    public int hashCode() {
        CharSequence charSequence = this.messageAuthor;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.messageName;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAutomatedMessageDismissed(messageAuthor=");
        sbU.append(this.messageAuthor);
        sbU.append(", messageName=");
        return outline.E(sbU, this.messageName, ")");
    }
}
