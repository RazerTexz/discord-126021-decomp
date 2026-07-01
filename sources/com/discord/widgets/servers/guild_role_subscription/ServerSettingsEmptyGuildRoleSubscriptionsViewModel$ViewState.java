package com.discord.widgets.servers.guild_role_subscription;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ServerSettingsEmptyGuildRoleSubscriptionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState {
    private final boolean isLoading;
    private final Boolean isMonetizationEnabled;

    public ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState() {
        this(false, null, 3, null);
    }

    public ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState(boolean z2, Boolean bool) {
        this.isLoading = z2;
        this.isMonetizationEnabled = bool;
    }

    public static /* synthetic */ ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState copy$default(ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState serverSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState, boolean z2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = serverSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState.isLoading;
        }
        if ((i & 2) != 0) {
            bool = serverSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState.isMonetizationEnabled;
        }
        return serverSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState.copy(z2, bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getIsMonetizationEnabled() {
        return this.isMonetizationEnabled;
    }

    public final ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState copy(boolean isLoading, Boolean isMonetizationEnabled) {
        return new ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState(isLoading, isMonetizationEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState)) {
            return false;
        }
        ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState serverSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState = (ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState) other;
        return this.isLoading == serverSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState.isLoading && m.areEqual(this.isMonetizationEnabled, serverSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState.isMonetizationEnabled);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z2 = this.isLoading;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        Boolean bool = this.isMonetizationEnabled;
        return i + (bool != null ? bool.hashCode() : 0);
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final Boolean isMonetizationEnabled() {
        return this.isMonetizationEnabled;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(isLoading=");
        sbU.append(this.isLoading);
        sbU.append(", isMonetizationEnabled=");
        return a.D(sbU, this.isMonetizationEnabled, ")");
    }

    public /* synthetic */ ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState(boolean z2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z2, (i & 2) != 0 ? null : bool);
    }
}
