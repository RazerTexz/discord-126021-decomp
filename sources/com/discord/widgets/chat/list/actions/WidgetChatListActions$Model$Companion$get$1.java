package com.discord.widgets.chat.list.actions;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.message.Message;
import d0.o;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$Model$Companion$get$1<T1, T2, R> implements Func2<Message, Channel, Pair<? extends Message, ? extends Channel>> {
    public static final WidgetChatListActions$Model$Companion$get$1 INSTANCE = new WidgetChatListActions$Model$Companion$get$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends Message, ? extends Channel> call(Message message, Channel channel) {
        return call2(message, channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<Message, Channel> call2(Message message, Channel channel) {
        return o.to(message, channel);
    }
}
