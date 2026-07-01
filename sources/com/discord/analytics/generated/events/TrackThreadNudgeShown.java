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

/* JADX INFO: compiled from: TrackThreadNudgeShown.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackThreadNudgeShown implements AnalyticsSchema, TrackBase2, TrackChannel2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence type = null;
    private final Long replyChainLength = null;
    private final transient String analyticsSchemaTypeName = "thread_nudge_shown";

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
        if (!(other instanceof TrackThreadNudgeShown)) {
            return false;
        }
        TrackThreadNudgeShown trackThreadNudgeShown = (TrackThreadNudgeShown) other;
        return Intrinsics3.areEqual(this.type, trackThreadNudgeShown.type) && Intrinsics3.areEqual(this.replyChainLength, trackThreadNudgeShown.replyChainLength);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.replyChainLength;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackThreadNudgeShown(type=");
        sbU.append(this.type);
        sbU.append(", replyChainLength=");
        return outline.G(sbU, this.replyChainLength, ")");
    }
}
