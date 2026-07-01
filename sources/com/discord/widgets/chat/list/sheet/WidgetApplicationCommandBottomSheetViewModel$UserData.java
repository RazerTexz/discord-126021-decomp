package com.discord.widgets.chat.list.sheet;

import b.d.b.a.a;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetApplicationCommandBottomSheetViewModel$UserData {
    private final Set<Long> mentionedUserIds;
    private final Map<Long, User> users;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetApplicationCommandBottomSheetViewModel$UserData(Set<Long> set, Map<Long, ? extends User> map) {
        m.checkNotNullParameter(set, "mentionedUserIds");
        m.checkNotNullParameter(map, "users");
        this.mentionedUserIds = set;
        this.users = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetApplicationCommandBottomSheetViewModel$UserData copy$default(WidgetApplicationCommandBottomSheetViewModel$UserData widgetApplicationCommandBottomSheetViewModel$UserData, Set set, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            set = widgetApplicationCommandBottomSheetViewModel$UserData.mentionedUserIds;
        }
        if ((i & 2) != 0) {
            map = widgetApplicationCommandBottomSheetViewModel$UserData.users;
        }
        return widgetApplicationCommandBottomSheetViewModel$UserData.copy(set, map);
    }

    public final Set<Long> component1() {
        return this.mentionedUserIds;
    }

    public final Map<Long, User> component2() {
        return this.users;
    }

    public final WidgetApplicationCommandBottomSheetViewModel$UserData copy(Set<Long> mentionedUserIds, Map<Long, ? extends User> users) {
        m.checkNotNullParameter(mentionedUserIds, "mentionedUserIds");
        m.checkNotNullParameter(users, "users");
        return new WidgetApplicationCommandBottomSheetViewModel$UserData(mentionedUserIds, users);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetApplicationCommandBottomSheetViewModel$UserData)) {
            return false;
        }
        WidgetApplicationCommandBottomSheetViewModel$UserData widgetApplicationCommandBottomSheetViewModel$UserData = (WidgetApplicationCommandBottomSheetViewModel$UserData) other;
        return m.areEqual(this.mentionedUserIds, widgetApplicationCommandBottomSheetViewModel$UserData.mentionedUserIds) && m.areEqual(this.users, widgetApplicationCommandBottomSheetViewModel$UserData.users);
    }

    public final Set<Long> getMentionedUserIds() {
        return this.mentionedUserIds;
    }

    public final Map<Long, User> getUsers() {
        return this.users;
    }

    public int hashCode() {
        Set<Long> set = this.mentionedUserIds;
        int iHashCode = (set != null ? set.hashCode() : 0) * 31;
        Map<Long, User> map = this.users;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("UserData(mentionedUserIds=");
        sbU.append(this.mentionedUserIds);
        sbU.append(", users=");
        return a.M(sbU, this.users, ")");
    }
}
