package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackGuildWelcomeScreen;
import com.discord.analytics.generated.traits.TrackGuildWelcomeScreen2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackGuildWelcomeScreenOptionSelected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildWelcomeScreenOptionSelected implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackGuildWelcomeScreen2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private TrackGuildWelcomeScreen trackGuildWelcomeScreen;
    private final Long index = null;
    private final transient String analyticsSchemaTypeName = "guild_welcome_screen_option_selected";

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
        if (this != other) {
            return (other instanceof TrackGuildWelcomeScreenOptionSelected) && Intrinsics3.areEqual(this.index, ((TrackGuildWelcomeScreenOptionSelected) other).index);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.index;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.G(outline.U("TrackGuildWelcomeScreenOptionSelected(index="), this.index, ")");
    }
}
