package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackSoundboardSoundDeleted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSoundboardSoundDeleted implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final transient String analyticsSchemaTypeName = "soundboard_sound_deleted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackSoundboardSoundDeleted) && C12238m.areEqual(this.guildId, ((TrackSoundboardSoundDeleted) other).guildId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.guildId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m819G(C1643a.m833U("TrackSoundboardSoundDeleted(guildId="), this.guildId, ")");
    }
}
