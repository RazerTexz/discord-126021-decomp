package com.discord.widgets.share;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.user.MeUser;
import d0.o;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$onSendClicked$1<T1, T2, R> implements Func2<MeUser, Channel, Pair<? extends MeUser, ? extends Channel>> {
    public static final WidgetIncomingShare$onSendClicked$1 INSTANCE = new WidgetIncomingShare$onSendClicked$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends MeUser, ? extends Channel> call(MeUser meUser, Channel channel) {
        return call2(meUser, channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<MeUser, Channel> call2(MeUser meUser, Channel channel) {
        return o.to(meUser, channel);
    }
}
