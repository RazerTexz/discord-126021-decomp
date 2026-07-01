package com.discord.widgets.settings.account;

import b.d.b.a.a;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsBlockedUsersViewModel$StoreState {
    private final Map<Long, User> users;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetSettingsBlockedUsersViewModel$StoreState(Map<Long, ? extends User> map) {
        m.checkNotNullParameter(map, "users");
        this.users = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetSettingsBlockedUsersViewModel$StoreState copy$default(WidgetSettingsBlockedUsersViewModel$StoreState widgetSettingsBlockedUsersViewModel$StoreState, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = widgetSettingsBlockedUsersViewModel$StoreState.users;
        }
        return widgetSettingsBlockedUsersViewModel$StoreState.copy(map);
    }

    public final Map<Long, User> component1() {
        return this.users;
    }

    public final WidgetSettingsBlockedUsersViewModel$StoreState copy(Map<Long, ? extends User> users) {
        m.checkNotNullParameter(users, "users");
        return new WidgetSettingsBlockedUsersViewModel$StoreState(users);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetSettingsBlockedUsersViewModel$StoreState) && m.areEqual(this.users, ((WidgetSettingsBlockedUsersViewModel$StoreState) other).users);
        }
        return true;
    }

    public final Map<Long, User> getUsers() {
        return this.users;
    }

    public int hashCode() {
        Map<Long, User> map = this.users;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.M(a.U("StoreState(users="), this.users, ")");
    }
}
