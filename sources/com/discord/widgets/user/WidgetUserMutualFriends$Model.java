package com.discord.widgets.user;

import b.d.b.a.a;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserMutualFriends$Model {
    public static final WidgetUserMutualFriends$Model$Companion Companion = new WidgetUserMutualFriends$Model$Companion(null);
    private final List<WidgetUserMutualFriends$Model$Item> items;
    private final int numMutualFriends;
    private final User user;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetUserMutualFriends$Model(User user, List<? extends WidgetUserMutualFriends$Model$Item> list, int i) {
        m.checkNotNullParameter(list, "items");
        this.user = user;
        this.items = list;
        this.numMutualFriends = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetUserMutualFriends$Model copy$default(WidgetUserMutualFriends$Model widgetUserMutualFriends$Model, User user, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            user = widgetUserMutualFriends$Model.user;
        }
        if ((i2 & 2) != 0) {
            list = widgetUserMutualFriends$Model.items;
        }
        if ((i2 & 4) != 0) {
            i = widgetUserMutualFriends$Model.numMutualFriends;
        }
        return widgetUserMutualFriends$Model.copy(user, list, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public final List<WidgetUserMutualFriends$Model$Item> component2() {
        return this.items;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getNumMutualFriends() {
        return this.numMutualFriends;
    }

    public final WidgetUserMutualFriends$Model copy(User user, List<? extends WidgetUserMutualFriends$Model$Item> items, int numMutualFriends) {
        m.checkNotNullParameter(items, "items");
        return new WidgetUserMutualFriends$Model(user, items, numMutualFriends);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetUserMutualFriends$Model)) {
            return false;
        }
        WidgetUserMutualFriends$Model widgetUserMutualFriends$Model = (WidgetUserMutualFriends$Model) other;
        return m.areEqual(this.user, widgetUserMutualFriends$Model.user) && m.areEqual(this.items, widgetUserMutualFriends$Model.items) && this.numMutualFriends == widgetUserMutualFriends$Model.numMutualFriends;
    }

    public final List<WidgetUserMutualFriends$Model$Item> getItems() {
        return this.items;
    }

    public final int getNumMutualFriends() {
        return this.numMutualFriends;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        List<WidgetUserMutualFriends$Model$Item> list = this.items;
        return ((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + this.numMutualFriends;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(user=");
        sbU.append(this.user);
        sbU.append(", items=");
        sbU.append(this.items);
        sbU.append(", numMutualFriends=");
        return a.B(sbU, this.numMutualFriends, ")");
    }
}
