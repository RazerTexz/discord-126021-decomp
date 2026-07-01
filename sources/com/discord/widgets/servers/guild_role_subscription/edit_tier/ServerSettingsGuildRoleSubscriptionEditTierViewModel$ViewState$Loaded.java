package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded extends ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState {
    private final boolean hasChanges;
    private final boolean isPublished;
    private final boolean isSubmitting;
    private final String tierName;

    public ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded() {
        this(false, false, null, false, 15, null);
    }

    public /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded(boolean z2, boolean z3, String str, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? null : str, (i & 8) != 0 ? false : z4);
    }

    public static /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded copy$default(ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded, boolean z2, boolean z3, String str, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded.hasChanges;
        }
        if ((i & 2) != 0) {
            z3 = serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded.isPublished;
        }
        if ((i & 4) != 0) {
            str = serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded.tierName;
        }
        if ((i & 8) != 0) {
            z4 = serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded.isSubmitting;
        }
        return serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded.copy(z2, z3, str, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getHasChanges() {
        return this.hasChanges;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsPublished() {
        return this.isPublished;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTierName() {
        return this.tierName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsSubmitting() {
        return this.isSubmitting;
    }

    public final ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded copy(boolean hasChanges, boolean isPublished, String tierName, boolean isSubmitting) {
        return new ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded(hasChanges, isPublished, tierName, isSubmitting);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded)) {
            return false;
        }
        ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded = (ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded) other;
        return this.hasChanges == serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded.hasChanges && this.isPublished == serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded.isPublished && m.areEqual(this.tierName, serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded.tierName) && this.isSubmitting == serverSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded.isSubmitting;
    }

    public final boolean getHasChanges() {
        return this.hasChanges;
    }

    public final String getTierName() {
        return this.tierName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        boolean z2 = this.hasChanges;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.isPublished;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        String str = this.tierName;
        int iHashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z4 = this.isSubmitting;
        return iHashCode + (z4 ? 1 : z4);
    }

    public final boolean isPublished() {
        return this.isPublished;
    }

    public final boolean isSubmitting() {
        return this.isSubmitting;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(hasChanges=");
        sbU.append(this.hasChanges);
        sbU.append(", isPublished=");
        sbU.append(this.isPublished);
        sbU.append(", tierName=");
        sbU.append(this.tierName);
        sbU.append(", isSubmitting=");
        return a.O(sbU, this.isSubmitting, ")");
    }

    public ServerSettingsGuildRoleSubscriptionEditTierViewModel$ViewState$Loaded(boolean z2, boolean z3, String str, boolean z4) {
        super(null);
        this.hasChanges = z2;
        this.isPublished = z3;
        this.tierName = str;
        this.isSubmitting = z4;
    }
}
