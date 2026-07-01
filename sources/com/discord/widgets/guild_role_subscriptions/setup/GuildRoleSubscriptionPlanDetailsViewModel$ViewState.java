package com.discord.widgets.guild_role_subscriptions.setup;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionPlanDetailsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionPlanDetailsViewModel$ViewState {
    private final Long applicationId;
    private final String coverImage;
    private final Long coverImageAssetId;
    private final String description;
    private final boolean isFullServerGate;

    public GuildRoleSubscriptionPlanDetailsViewModel$ViewState() {
        this(null, null, null, null, false, 31, null);
    }

    public GuildRoleSubscriptionPlanDetailsViewModel$ViewState(String str, Long l, Long l2, String str2, boolean z2) {
        this.coverImage = str;
        this.applicationId = l;
        this.coverImageAssetId = l2;
        this.description = str2;
        this.isFullServerGate = z2;
    }

    public static /* synthetic */ GuildRoleSubscriptionPlanDetailsViewModel$ViewState copy$default(GuildRoleSubscriptionPlanDetailsViewModel$ViewState guildRoleSubscriptionPlanDetailsViewModel$ViewState, String str, Long l, Long l2, String str2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guildRoleSubscriptionPlanDetailsViewModel$ViewState.coverImage;
        }
        if ((i & 2) != 0) {
            l = guildRoleSubscriptionPlanDetailsViewModel$ViewState.applicationId;
        }
        Long l3 = l;
        if ((i & 4) != 0) {
            l2 = guildRoleSubscriptionPlanDetailsViewModel$ViewState.coverImageAssetId;
        }
        Long l4 = l2;
        if ((i & 8) != 0) {
            str2 = guildRoleSubscriptionPlanDetailsViewModel$ViewState.description;
        }
        String str3 = str2;
        if ((i & 16) != 0) {
            z2 = guildRoleSubscriptionPlanDetailsViewModel$ViewState.isFullServerGate;
        }
        return guildRoleSubscriptionPlanDetailsViewModel$ViewState.copy(str, l3, l4, str3, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCoverImage() {
        return this.coverImage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getCoverImageAssetId() {
        return this.coverImageAssetId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsFullServerGate() {
        return this.isFullServerGate;
    }

    public final GuildRoleSubscriptionPlanDetailsViewModel$ViewState copy(String coverImage, Long applicationId, Long coverImageAssetId, String description, boolean isFullServerGate) {
        return new GuildRoleSubscriptionPlanDetailsViewModel$ViewState(coverImage, applicationId, coverImageAssetId, description, isFullServerGate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionPlanDetailsViewModel$ViewState)) {
            return false;
        }
        GuildRoleSubscriptionPlanDetailsViewModel$ViewState guildRoleSubscriptionPlanDetailsViewModel$ViewState = (GuildRoleSubscriptionPlanDetailsViewModel$ViewState) other;
        return m.areEqual(this.coverImage, guildRoleSubscriptionPlanDetailsViewModel$ViewState.coverImage) && m.areEqual(this.applicationId, guildRoleSubscriptionPlanDetailsViewModel$ViewState.applicationId) && m.areEqual(this.coverImageAssetId, guildRoleSubscriptionPlanDetailsViewModel$ViewState.coverImageAssetId) && m.areEqual(this.description, guildRoleSubscriptionPlanDetailsViewModel$ViewState.description) && this.isFullServerGate == guildRoleSubscriptionPlanDetailsViewModel$ViewState.isFullServerGate;
    }

    public final Long getApplicationId() {
        return this.applicationId;
    }

    public final String getCoverImage() {
        return this.coverImage;
    }

    public final Long getCoverImageAssetId() {
        return this.coverImageAssetId;
    }

    public final String getDescription() {
        return this.description;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.coverImage;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.applicationId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.coverImageAssetId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.isFullServerGate;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode4 + r1;
    }

    public final boolean isFullServerGate() {
        return this.isFullServerGate;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(coverImage=");
        sbU.append(this.coverImage);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", coverImageAssetId=");
        sbU.append(this.coverImageAssetId);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", isFullServerGate=");
        return a.O(sbU, this.isFullServerGate, ")");
    }

    public /* synthetic */ GuildRoleSubscriptionPlanDetailsViewModel$ViewState(String str, Long l, Long l2, String str2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) == 0 ? str2 : null, (i & 16) != 0 ? false : z2);
    }
}
