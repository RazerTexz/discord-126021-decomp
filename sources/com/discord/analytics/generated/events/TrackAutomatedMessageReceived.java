package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
        if (!(other instanceof TrackAutomatedMessageReceived)) {
            return false;
        }
        TrackAutomatedMessageReceived trackAutomatedMessageReceived = (TrackAutomatedMessageReceived) other;
        return m.areEqual(this.messageAuthor, trackAutomatedMessageReceived.messageAuthor) && m.areEqual(this.messageName, trackAutomatedMessageReceived.messageName);
    }

    public int hashCode() {
        CharSequence charSequence = this.messageAuthor;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.messageName;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackAutomatedMessageReceived(messageAuthor=");
        sbU.append(this.messageAuthor);
        sbU.append(", messageName=");
        return a.E(sbU, this.messageName, ")");
    }
}
