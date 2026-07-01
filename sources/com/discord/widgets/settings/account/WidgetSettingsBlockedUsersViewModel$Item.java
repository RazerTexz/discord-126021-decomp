package com.discord.widgets.settings.account;

import b.d.b.a.a;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsBlockedUsersViewModel$Item implements MGRecyclerDataPayload {
    private final String key;
    private final int type;
    private final User user;

    public WidgetSettingsBlockedUsersViewModel$Item(User user) {
        m.checkNotNullParameter(user, "user");
        this.user = user;
        this.key = String.valueOf(user.getId());
    }

    public static /* synthetic */ WidgetSettingsBlockedUsersViewModel$Item copy$default(WidgetSettingsBlockedUsersViewModel$Item widgetSettingsBlockedUsersViewModel$Item, User user, int i, Object obj) {
        if ((i & 1) != 0) {
            user = widgetSettingsBlockedUsersViewModel$Item.user;
        }
        return widgetSettingsBlockedUsersViewModel$Item.copy(user);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public final WidgetSettingsBlockedUsersViewModel$Item copy(User user) {
        m.checkNotNullParameter(user, "user");
        return new WidgetSettingsBlockedUsersViewModel$Item(user);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetSettingsBlockedUsersViewModel$Item) && m.areEqual(this.user, ((WidgetSettingsBlockedUsersViewModel$Item) other).user);
        }
        return true;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        if (user != null) {
            return user.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Item(user=");
        sbU.append(this.user);
        sbU.append(")");
        return sbU.toString();
    }
}
