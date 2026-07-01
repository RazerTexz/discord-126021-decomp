package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import d0.o;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$setupFAB$2$2<T1, T2, R> implements Func2<Channel, Long, Pair<? extends Channel, ? extends Long>> {
    public static final WidgetGroupInviteFriends$setupFAB$2$2 INSTANCE = new WidgetGroupInviteFriends$setupFAB$2$2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends Channel, ? extends Long> call(Channel channel, Long l) {
        return call2(channel, l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<Channel, Long> call2(Channel channel, Long l) {
        return o.to(channel, l);
    }
}
