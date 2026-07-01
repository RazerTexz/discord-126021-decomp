package com.discord.widgets.servers.guild_role_subscription;

import a0.a.a.b;
import b.d.b.a.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded extends ServerSettingsGuildRoleSubscriptionViewModel$ViewState {
    private final long groupListingId;
    private final boolean hasChanges;
    private final boolean isSubmitting;

    public /* synthetic */ ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded(boolean z2, boolean z3, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, j);
    }

    public static /* synthetic */ ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded copy$default(ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded, boolean z2, boolean z3, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded.hasChanges;
        }
        if ((i & 2) != 0) {
            z3 = serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded.isSubmitting;
        }
        if ((i & 4) != 0) {
            j = serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded.groupListingId;
        }
        return serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded.copy(z2, z3, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getHasChanges() {
        return this.hasChanges;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsSubmitting() {
        return this.isSubmitting;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getGroupListingId() {
        return this.groupListingId;
    }

    public final ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded copy(boolean hasChanges, boolean isSubmitting, long groupListingId) {
        return new ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded(hasChanges, isSubmitting, groupListingId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded)) {
            return false;
        }
        ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded = (ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded) other;
        return this.hasChanges == serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded.hasChanges && this.isSubmitting == serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded.isSubmitting && this.groupListingId == serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded.groupListingId;
    }

    public final long getGroupListingId() {
        return this.groupListingId;
    }

    public final boolean getHasChanges() {
        return this.hasChanges;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        boolean z2 = this.hasChanges;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.isSubmitting;
        return b.a(this.groupListingId) + ((i + (z3 ? 1 : z3)) * 31);
    }

    public final boolean isSubmitting() {
        return this.isSubmitting;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(hasChanges=");
        sbU.append(this.hasChanges);
        sbU.append(", isSubmitting=");
        sbU.append(this.isSubmitting);
        sbU.append(", groupListingId=");
        return a.C(sbU, this.groupListingId, ")");
    }

    public ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded(boolean z2, boolean z3, long j) {
        super(null);
        this.hasChanges = z2;
        this.isSubmitting = z3;
        this.groupListingId = j;
    }
}
