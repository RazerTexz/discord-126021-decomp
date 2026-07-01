package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSlashCommandSuggestionsToggled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSlashCommandSuggestionsToggled implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean enabled = null;
    private final transient String analyticsSchemaTypeName = "slash_command_suggestions_toggled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackSlashCommandSuggestionsToggled) && Intrinsics3.areEqual(this.enabled, ((TrackSlashCommandSuggestionsToggled) other).enabled);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.enabled;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.D(outline.U("TrackSlashCommandSuggestionsToggled(enabled="), this.enabled, ")");
    }
}
