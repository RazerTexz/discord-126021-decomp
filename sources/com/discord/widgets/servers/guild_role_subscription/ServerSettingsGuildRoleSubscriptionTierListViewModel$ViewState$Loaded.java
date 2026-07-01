package com.discord.widgets.servers.guild_role_subscription;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded extends ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState {
    private final List<ServerSettingsGuildRoleSubscriptionTierAdapterItem> adapterItems;
    private final long groupListingId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded(List<? extends ServerSettingsGuildRoleSubscriptionTierAdapterItem> list, long j) {
        super(null);
        m.checkNotNullParameter(list, "adapterItems");
        this.adapterItems = list;
        this.groupListingId = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded copy$default(ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded serverSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded, List list, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            list = serverSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded.adapterItems;
        }
        if ((i & 2) != 0) {
            j = serverSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded.groupListingId;
        }
        return serverSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded.copy(list, j);
    }

    public final List<ServerSettingsGuildRoleSubscriptionTierAdapterItem> component1() {
        return this.adapterItems;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGroupListingId() {
        return this.groupListingId;
    }

    public final ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded copy(List<? extends ServerSettingsGuildRoleSubscriptionTierAdapterItem> adapterItems, long groupListingId) {
        m.checkNotNullParameter(adapterItems, "adapterItems");
        return new ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded(adapterItems, groupListingId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded)) {
            return false;
        }
        ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded serverSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded = (ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded) other;
        return m.areEqual(this.adapterItems, serverSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded.adapterItems) && this.groupListingId == serverSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded.groupListingId;
    }

    public final List<ServerSettingsGuildRoleSubscriptionTierAdapterItem> getAdapterItems() {
        return this.adapterItems;
    }

    public final long getGroupListingId() {
        return this.groupListingId;
    }

    public int hashCode() {
        List<ServerSettingsGuildRoleSubscriptionTierAdapterItem> list = this.adapterItems;
        return b.a(this.groupListingId) + ((list != null ? list.hashCode() : 0) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(adapterItems=");
        sbU.append(this.adapterItems);
        sbU.append(", groupListingId=");
        return a.C(sbU, this.groupListingId, ")");
    }
}
