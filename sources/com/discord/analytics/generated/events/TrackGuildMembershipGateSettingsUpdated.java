package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildMembershipGateMetadata;
import com.discord.analytics.generated.traits.TrackGuildMembershipGateMetadataReceiver;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGuildMembershipGateSettingsUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildMembershipGateSettingsUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackGuildMembershipGateMetadataReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private TrackGuildMembershipGateMetadata trackGuildMembershipGateMetadata;
    private final Boolean isEnabled = null;
    private final transient String analyticsSchemaTypeName = "guild_membership_gate_settings_updated";

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
        if (this != other) {
            return (other instanceof TrackGuildMembershipGateSettingsUpdated) && C12238m.areEqual(this.isEnabled, ((TrackGuildMembershipGateSettingsUpdated) other).isEnabled);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.isEnabled;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m816D(C1643a.m833U("TrackGuildMembershipGateSettingsUpdated(isEnabled="), this.isEnabled, ")");
    }
}
