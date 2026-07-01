package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackGuildTemplate;
import com.discord.analytics.generated.traits.TrackGuildTemplateReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackGuildTemplateLinkUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildTemplateLinkUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackGuildTemplateReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private TrackGuildTemplate trackGuildTemplate;
    private final CharSequence updateType = null;
    private final transient String analyticsSchemaTypeName = "guild_template_link_updated";

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
            return (other instanceof TrackGuildTemplateLinkUpdated) && m.areEqual(this.updateType, ((TrackGuildTemplateLinkUpdated) other).updateType);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.updateType;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.E(a.U("TrackGuildTemplateLinkUpdated(updateType="), this.updateType, ")");
    }
}
