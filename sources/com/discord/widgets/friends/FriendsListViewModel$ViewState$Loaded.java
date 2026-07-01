package com.discord.widgets.friends;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FriendsListViewModel$ViewState$Loaded extends FriendsListViewModel$ViewState {
    private final List<FriendsListViewModel$Item> items;
    private final boolean showContactSyncIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FriendsListViewModel$ViewState$Loaded(boolean z2, List<? extends FriendsListViewModel$Item> list) {
        super(null);
        m.checkNotNullParameter(list, "items");
        this.showContactSyncIcon = z2;
        this.items = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FriendsListViewModel$ViewState$Loaded copy$default(FriendsListViewModel$ViewState$Loaded friendsListViewModel$ViewState$Loaded, boolean z2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = friendsListViewModel$ViewState$Loaded.showContactSyncIcon;
        }
        if ((i & 2) != 0) {
            list = friendsListViewModel$ViewState$Loaded.items;
        }
        return friendsListViewModel$ViewState$Loaded.copy(z2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShowContactSyncIcon() {
        return this.showContactSyncIcon;
    }

    public final List<FriendsListViewModel$Item> component2() {
        return this.items;
    }

    public final FriendsListViewModel$ViewState$Loaded copy(boolean showContactSyncIcon, List<? extends FriendsListViewModel$Item> items) {
        m.checkNotNullParameter(items, "items");
        return new FriendsListViewModel$ViewState$Loaded(showContactSyncIcon, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendsListViewModel$ViewState$Loaded)) {
            return false;
        }
        FriendsListViewModel$ViewState$Loaded friendsListViewModel$ViewState$Loaded = (FriendsListViewModel$ViewState$Loaded) other;
        return this.showContactSyncIcon == friendsListViewModel$ViewState$Loaded.showContactSyncIcon && m.areEqual(this.items, friendsListViewModel$ViewState$Loaded.items);
    }

    public final List<FriendsListViewModel$Item> getItems() {
        return this.items;
    }

    public final boolean getShowContactSyncIcon() {
        return this.showContactSyncIcon;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z2 = this.showContactSyncIcon;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        List<FriendsListViewModel$Item> list = this.items;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(showContactSyncIcon=");
        sbU.append(this.showContactSyncIcon);
        sbU.append(", items=");
        return a.L(sbU, this.items, ")");
    }
}
