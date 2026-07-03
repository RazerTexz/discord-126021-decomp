package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackAutomatedMessageReceived.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAutomatedMessageReceived implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence messageAuthor = null;
    private final CharSequence messageName = null;
    private final transient String analyticsSchemaTypeName = "automated_message_received";

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
        if (!(other instanceof TrackAutomatedMessageReceived)) {
            return false;
        }
        TrackAutomatedMessageReceived trackAutomatedMessageReceived = (TrackAutomatedMessageReceived) other;
        return C12238m.areEqual(this.messageAuthor, trackAutomatedMessageReceived.messageAuthor) && C12238m.areEqual(this.messageName, trackAutomatedMessageReceived.messageName);
    }

    public int hashCode() {
        CharSequence charSequence = this.messageAuthor;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.messageName;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackAutomatedMessageReceived(messageAuthor=");
        sbM833U.append(this.messageAuthor);
        sbM833U.append(", messageName=");
        return C1643a.m817E(sbM833U, this.messageName, ")");
    }
}
