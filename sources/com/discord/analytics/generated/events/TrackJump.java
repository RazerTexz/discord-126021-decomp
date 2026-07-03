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

/* JADX INFO: compiled from: TrackJump.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackJump implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence context = null;
    private final Long messageId = null;
    private final CharSequence searchId = null;
    private final transient String analyticsSchemaTypeName = "jump";

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
        if (!(other instanceof TrackJump)) {
            return false;
        }
        TrackJump trackJump = (TrackJump) other;
        return C12238m.areEqual(this.context, trackJump.context) && C12238m.areEqual(this.messageId, trackJump.messageId) && C12238m.areEqual(this.searchId, trackJump.searchId);
    }

    public int hashCode() {
        CharSequence charSequence = this.context;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.messageId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.searchId;
        return iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackJump(context=");
        sbM833U.append(this.context);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", searchId=");
        return C1643a.m817E(sbM833U, this.searchId, ")");
    }
}
