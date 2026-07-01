package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import j0.k.b;
import java.util.List;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1<T, R> implements b<Map<Long, ? extends Integer>, Observable<? extends List<User>>> {
    public final /* synthetic */ Observable $addedUsers;

    public WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1(Observable observable) {
        this.$addedUsers = observable;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends List<User>> call(Map<Long, ? extends Integer> map) {
        return call2((Map<Long, Integer>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends List<User>> call2(Map<Long, Integer> map) {
        return this.$addedUsers.Y(new WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1$1(map));
    }
}
