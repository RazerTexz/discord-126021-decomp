package com.discord.widgets.chat;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.utilities.messagesend.MessageResult;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: MessageManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageManager$sendMessage$1<T1, T2, R> implements Func2<MessageResult, Guild, MessageManager$MessageSendResult> {
    public static final MessageManager$sendMessage$1 INSTANCE = new MessageManager$sendMessage$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ MessageManager$MessageSendResult call(MessageResult messageResult, Guild guild) {
        return call2(messageResult, guild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final MessageManager$MessageSendResult call2(MessageResult messageResult, Guild guild) {
        m.checkNotNullExpressionValue(messageResult, "messageResult");
        return new MessageManager$MessageSendResult(messageResult, guild);
    }
}
