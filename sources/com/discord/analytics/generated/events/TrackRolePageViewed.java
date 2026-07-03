package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRolePageViewed)) {
            return false;
        }
        TrackRolePageViewed trackRolePageViewed = (TrackRolePageViewed) other;
        return C12238m.areEqual(this.tabOpened, trackRolePageViewed.tabOpened) && C12238m.areEqual(this.isEveryone, trackRolePageViewed.isEveryone) && C12238m.areEqual(this.roleId, trackRolePageViewed.roleId) && C12238m.areEqual(this.roleMentionable, trackRolePageViewed.roleMentionable) && C12238m.areEqual(this.roleHoist, trackRolePageViewed.roleHoist) && C12238m.areEqual(this.rolePermissions, trackRolePageViewed.rolePermissions) && C12238m.areEqual(this.roleNumMembers, trackRolePageViewed.roleNumMembers);
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
        StringBuilder sbM833U = C1643a.m833U("TrackRolePageViewed(tabOpened=");
        sbM833U.append(this.tabOpened);
        sbM833U.append(", isEveryone=");
        sbM833U.append(this.isEveryone);
        sbM833U.append(", roleId=");
        sbM833U.append(this.roleId);
        sbM833U.append(", roleMentionable=");
        sbM833U.append(this.roleMentionable);
        sbM833U.append(", roleHoist=");
        sbM833U.append(this.roleHoist);
        sbM833U.append(", rolePermissions=");
        sbM833U.append(this.rolePermissions);
        sbM833U.append(", roleNumMembers=");
        return C1643a.m819G(sbM833U, this.roleNumMembers, ")");
    }
}
