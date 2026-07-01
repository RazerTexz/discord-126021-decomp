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

/* JADX INFO: compiled from: TrackNotificationCtaClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNotificationCtaClicked implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence notificationType = null;
    private final CharSequence action = null;
    private final Boolean dismissed = null;
    private final transient String analyticsSchemaTypeName = "notification_cta_clicked";

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
        if (!(other instanceof TrackNotificationCtaClicked)) {
            return false;
        }
        TrackNotificationCtaClicked trackNotificationCtaClicked = (TrackNotificationCtaClicked) other;
        return m.areEqual(this.notificationType, trackNotificationCtaClicked.notificationType) && m.areEqual(this.action, trackNotificationCtaClicked.action) && m.areEqual(this.dismissed, trackNotificationCtaClicked.dismissed);
    }

    public int hashCode() {
        CharSequence charSequence = this.notificationType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.action;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.dismissed;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackNotificationCtaClicked(notificationType=");
        sbU.append(this.notificationType);
        sbU.append(", action=");
        sbU.append(this.action);
        sbU.append(", dismissed=");
        return a.D(sbU, this.dismissed, ")");
    }
}
