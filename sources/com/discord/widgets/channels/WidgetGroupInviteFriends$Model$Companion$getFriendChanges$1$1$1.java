package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import j0.k.b;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1$1$1<T, R> implements b<User, Boolean> {
    public final /* synthetic */ WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1$1 this$0;

    public WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1$1$1(WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1$1 widgetGroupInviteFriends$Model$Companion$getFriendChanges$1$1) {
        this.this$0 = widgetGroupInviteFriends$Model$Companion$getFriendChanges$1$1;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(User user) {
        return call2(user);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(User user) {
        return Boolean.valueOf(this.this$0.$friends.containsKey(Long.valueOf(user.getId())));
    }
}
