package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuildTemplate;
import com.discord.analytics.generated.traits.TrackGuildTemplateReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackCreateGuild.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCreateGuild implements AnalyticsSchema, TrackBaseReceiver, TrackGuildTemplateReceiver {
    private TrackBase trackBase;
    private TrackGuildTemplate trackGuildTemplate;
    private final Long guildId = null;
    private final CharSequence guildName = null;
    private final transient String analyticsSchemaTypeName = "create_guild";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCreateGuild)) {
            return false;
        }
        TrackCreateGuild trackCreateGuild = (TrackCreateGuild) other;
        return C12238m.areEqual(this.guildId, trackCreateGuild.guildId) && C12238m.areEqual(this.guildName, trackCreateGuild.guildName);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.guildName;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackCreateGuild(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", guildName=");
        return C1643a.m817E(sbM833U, this.guildName, ")");
    }
}
