package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackGuildWelcomeScreen;
import com.discord.analytics.generated.traits.TrackGuildWelcomeScreenReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackGuildWelcomeScreenSettingsUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildWelcomeScreenSettingsUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackGuildWelcomeScreenReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private TrackGuildWelcomeScreen trackGuildWelcomeScreen;
    private final Boolean isEnabled = null;
    private final transient String analyticsSchemaTypeName = "guild_welcome_screen_settings_updated";

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
        if (this != other) {
            return (other instanceof TrackGuildWelcomeScreenSettingsUpdated) && m.areEqual(this.isEnabled, ((TrackGuildWelcomeScreenSettingsUpdated) other).isEnabled);
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
        return a.D(a.U("TrackGuildWelcomeScreenSettingsUpdated(isEnabled="), this.isEnabled, ")");
    }
}
