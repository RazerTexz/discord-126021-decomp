package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackViewAsRolesSelected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackViewAsRolesSelected implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long numRoles = null;
    private final transient String analyticsSchemaTypeName = "view_as_roles_selected";

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
            return (other instanceof TrackViewAsRolesSelected) && C12238m.areEqual(this.numRoles, ((TrackViewAsRolesSelected) other).numRoles);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.numRoles;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m819G(C1643a.m833U("TrackViewAsRolesSelected(numRoles="), this.numRoles, ")");
    }
}
