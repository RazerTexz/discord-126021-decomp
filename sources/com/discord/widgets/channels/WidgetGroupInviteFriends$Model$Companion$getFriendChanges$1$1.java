package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import j0.k.b;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1$1<T, R> implements b<Collection<? extends User>, Observable<? extends List<User>>> {
    public final /* synthetic */ Map $friends;

    public WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1$1(Map map) {
        this.$friends = map;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends List<User>> call(Collection<? extends User> collection) {
        return call2(collection);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends List<User>> call2(Collection<? extends User> collection) {
        return Observable.B(collection).y(new WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1$1$1(this)).f0();
    }
}
