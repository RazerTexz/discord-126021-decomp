package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import java.util.Map$Entry;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1$2<T, R> implements b<Map$Entry<? extends Long, ? extends Integer>, Long> {
    public static final WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1$2 INSTANCE = new WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Long call(Map$Entry<? extends Long, ? extends Integer> map$Entry) {
        return call2((Map$Entry<Long, Integer>) map$Entry);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(Map$Entry<Long, Integer> map$Entry) {
        return map$Entry.getKey();
    }
}
