package com.discord.widgets.friends;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetFriendsFindNearby$Model$NearbyUsers extends WidgetFriendsFindNearby$Model {
    private final List<WidgetFriendsAddUserAdapter$ItemUser> items;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsFindNearby$Model$NearbyUsers(List<WidgetFriendsAddUserAdapter$ItemUser> list) {
        super(null);
        m.checkNotNullParameter(list, "items");
        this.items = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetFriendsFindNearby$Model$NearbyUsers copy$default(WidgetFriendsFindNearby$Model$NearbyUsers widgetFriendsFindNearby$Model$NearbyUsers, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetFriendsFindNearby$Model$NearbyUsers.items;
        }
        return widgetFriendsFindNearby$Model$NearbyUsers.copy(list);
    }

    public final List<WidgetFriendsAddUserAdapter$ItemUser> component1() {
        return this.items;
    }

    public final WidgetFriendsFindNearby$Model$NearbyUsers copy(List<WidgetFriendsAddUserAdapter$ItemUser> items) {
        m.checkNotNullParameter(items, "items");
        return new WidgetFriendsFindNearby$Model$NearbyUsers(items);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetFriendsFindNearby$Model$NearbyUsers) && m.areEqual(this.items, ((WidgetFriendsFindNearby$Model$NearbyUsers) other).items);
        }
        return true;
    }

    public final List<WidgetFriendsAddUserAdapter$ItemUser> getItems() {
        return this.items;
    }

    public int hashCode() {
        List<WidgetFriendsAddUserAdapter$ItemUser> list = this.items;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("NearbyUsers(items="), this.items, ")");
    }
}
