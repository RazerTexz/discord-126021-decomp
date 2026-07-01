package com.discord.widgets.channels.memberlist;

import androidx.core.app.NotificationCompat;
import com.discord.api.user.User;
import j0.k.b;

/* JADX INFO: compiled from: PrivateChannelMemberListService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PrivateChannelMemberListService$observeStateForGroupDm$1<T, R> implements b<User, Long> {
    public static final PrivateChannelMemberListService$observeStateForGroupDm$1 INSTANCE = new PrivateChannelMemberListService$observeStateForGroupDm$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Long call(User user) {
        return call2(user);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(User user) {
        return Long.valueOf(user.getId());
    }
}
