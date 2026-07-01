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

/* JADX INFO: compiled from: TrackServerSetupCtaClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackServerSetupCtaClicked implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence setupType = null;
    private final CharSequence action = null;
    private final Boolean actionCompleted = null;
    private final Long numTotalActions = null;
    private final Long numActionsCompleted = null;
    private final transient String analyticsSchemaTypeName = "server_setup_cta_clicked";

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
        if (!(other instanceof TrackServerSetupCtaClicked)) {
            return false;
        }
        TrackServerSetupCtaClicked trackServerSetupCtaClicked = (TrackServerSetupCtaClicked) other;
        return m.areEqual(this.setupType, trackServerSetupCtaClicked.setupType) && m.areEqual(this.action, trackServerSetupCtaClicked.action) && m.areEqual(this.actionCompleted, trackServerSetupCtaClicked.actionCompleted) && m.areEqual(this.numTotalActions, trackServerSetupCtaClicked.numTotalActions) && m.areEqual(this.numActionsCompleted, trackServerSetupCtaClicked.numActionsCompleted);
    }

    public int hashCode() {
        CharSequence charSequence = this.setupType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.action;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.actionCompleted;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l = this.numTotalActions;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.numActionsCompleted;
        return iHashCode4 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackServerSetupCtaClicked(setupType=");
        sbU.append(this.setupType);
        sbU.append(", action=");
        sbU.append(this.action);
        sbU.append(", actionCompleted=");
        sbU.append(this.actionCompleted);
        sbU.append(", numTotalActions=");
        sbU.append(this.numTotalActions);
        sbU.append(", numActionsCompleted=");
        return a.G(sbU, this.numActionsCompleted, ")");
    }
}
