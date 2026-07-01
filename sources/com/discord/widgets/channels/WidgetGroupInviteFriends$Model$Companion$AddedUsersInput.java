package com.discord.widgets.channels;

import b.d.b.a.a;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.Collection;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGroupInviteFriends$Model$Companion$AddedUsersInput {
    private final Collection<User> addedUsers;
    private final String filter;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGroupInviteFriends$Model$Companion$AddedUsersInput(Collection<? extends User> collection, String str) {
        m.checkNotNullParameter(collection, "addedUsers");
        m.checkNotNullParameter(str, "filter");
        this.addedUsers = collection;
        this.filter = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGroupInviteFriends$Model$Companion$AddedUsersInput copy$default(WidgetGroupInviteFriends$Model$Companion$AddedUsersInput widgetGroupInviteFriends$Model$Companion$AddedUsersInput, Collection collection, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            collection = widgetGroupInviteFriends$Model$Companion$AddedUsersInput.addedUsers;
        }
        if ((i & 2) != 0) {
            str = widgetGroupInviteFriends$Model$Companion$AddedUsersInput.filter;
        }
        return widgetGroupInviteFriends$Model$Companion$AddedUsersInput.copy(collection, str);
    }

    public final Collection<User> component1() {
        return this.addedUsers;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFilter() {
        return this.filter;
    }

    public final WidgetGroupInviteFriends$Model$Companion$AddedUsersInput copy(Collection<? extends User> addedUsers, String filter) {
        m.checkNotNullParameter(addedUsers, "addedUsers");
        m.checkNotNullParameter(filter, "filter");
        return new WidgetGroupInviteFriends$Model$Companion$AddedUsersInput(addedUsers, filter);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGroupInviteFriends$Model$Companion$AddedUsersInput)) {
            return false;
        }
        WidgetGroupInviteFriends$Model$Companion$AddedUsersInput widgetGroupInviteFriends$Model$Companion$AddedUsersInput = (WidgetGroupInviteFriends$Model$Companion$AddedUsersInput) other;
        return m.areEqual(this.addedUsers, widgetGroupInviteFriends$Model$Companion$AddedUsersInput.addedUsers) && m.areEqual(this.filter, widgetGroupInviteFriends$Model$Companion$AddedUsersInput.filter);
    }

    public final Collection<User> getAddedUsers() {
        return this.addedUsers;
    }

    public final String getFilter() {
        return this.filter;
    }

    public int hashCode() {
        Collection<User> collection = this.addedUsers;
        int iHashCode = (collection != null ? collection.hashCode() : 0) * 31;
        String str = this.filter;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("AddedUsersInput(addedUsers=");
        sbU.append(this.addedUsers);
        sbU.append(", filter=");
        return a.J(sbU, this.filter, ")");
    }
}
