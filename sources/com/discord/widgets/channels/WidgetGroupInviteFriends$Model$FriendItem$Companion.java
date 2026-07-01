package com.discord.widgets.channels;

import com.discord.models.user.User;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$FriendItem$Companion {
    private WidgetGroupInviteFriends$Model$FriendItem$Companion() {
    }

    public final List<WidgetGroupInviteFriends$Model$FriendItem> createData(WidgetGroupInviteFriends$Model$ModelAppUserRelationship friends, Collection<? extends User> alreadyAddedUsers) {
        m.checkNotNullParameter(friends, "friends");
        m.checkNotNullParameter(alreadyAddedUsers, "alreadyAddedUsers");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(alreadyAddedUsers, 10));
        Iterator<T> it = alreadyAddedUsers.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((User) it.next()).getId()));
        }
        Set set = u.toSet(arrayList);
        Set<Long> setKeySet = friends.getUsers().keySet();
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(setKeySet, 10));
        Iterator<T> it2 = setKeySet.iterator();
        while (it2.hasNext()) {
            long jLongValue = ((Number) it2.next()).longValue();
            arrayList2.add(new WidgetGroupInviteFriends$Model$FriendItem(friends.getUsers().get(Long.valueOf(jLongValue)), friends.getPresences().get(Long.valueOf(jLongValue)), set.contains(Long.valueOf(jLongValue)), friends.getStreams().containsKey(Long.valueOf(jLongValue))));
        }
        return arrayList2;
    }

    public /* synthetic */ WidgetGroupInviteFriends$Model$FriendItem$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
