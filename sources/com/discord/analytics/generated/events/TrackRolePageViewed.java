package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackRolePageViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRolePageViewed implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final CharSequence tabOpened = null;
    private final Boolean isEveryone = null;
    private final Long roleId = null;
    private final Boolean roleMentionable = null;
    private final Boolean roleHoist = null;
    private final Long rolePermissions = null;
    private final Long roleNumMembers = null;
    private final transient String analyticsSchemaTypeName = "role_page_viewed";

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
        if (!(other instanceof TrackRolePageViewed)) {
            return false;
        }
        TrackRolePageViewed trackRolePageViewed = (TrackRolePageViewed) other;
        return m.areEqual(this.tabOpened, trackRolePageViewed.tabOpened) && m.areEqual(this.isEveryone, trackRolePageViewed.isEveryone) && m.areEqual(this.roleId, trackRolePageViewed.roleId) && m.areEqual(this.roleMentionable, trackRolePageViewed.roleMentionable) && m.areEqual(this.roleHoist, trackRolePageViewed.roleHoist) && m.areEqual(this.rolePermissions, trackRolePageViewed.rolePermissions) && m.areEqual(this.roleNumMembers, trackRolePageViewed.roleNumMembers);
    }

    public int hashCode() {
        CharSequence charSequence = this.tabOpened;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.isEveryone;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l = this.roleId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool2 = this.roleMentionable;
        int iHashCode4 = (iHashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.roleHoist;
        int iHashCode5 = (iHashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l2 = this.rolePermissions;
        int iHashCode6 = (iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.roleNumMembers;
        return iHashCode6 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackRolePageViewed(tabOpened=");
        sbU.append(this.tabOpened);
        sbU.append(", isEveryone=");
        sbU.append(this.isEveryone);
        sbU.append(", roleId=");
        sbU.append(this.roleId);
        sbU.append(", roleMentionable=");
        sbU.append(this.roleMentionable);
        sbU.append(", roleHoist=");
        sbU.append(this.roleHoist);
        sbU.append(", rolePermissions=");
        sbU.append(this.rolePermissions);
        sbU.append(", roleNumMembers=");
        return a.G(sbU, this.roleNumMembers, ")");
    }
}
