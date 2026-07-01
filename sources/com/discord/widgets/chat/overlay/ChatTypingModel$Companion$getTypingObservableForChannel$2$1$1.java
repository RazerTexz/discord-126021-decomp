package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import java.util.List;
import rx.functions.Func2;

/* JADX INFO: compiled from: ChatTypingModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatTypingModel$Companion$getTypingObservableForChannel$2$1$1<T1, T2, R> implements Func2<List<? extends CharSequence>, Integer, ChatTypingModel$Typing> {
    public final /* synthetic */ ChatTypingModel$Companion$getTypingObservableForChannel$2$1 this$0;

    public ChatTypingModel$Companion$getTypingObservableForChannel$2$1$1(ChatTypingModel$Companion$getTypingObservableForChannel$2$1 chatTypingModel$Companion$getTypingObservableForChannel$2$1) {
        this.this$0 = chatTypingModel$Companion$getTypingObservableForChannel$2$1;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ ChatTypingModel$Typing call(List<? extends CharSequence> list, Integer num) {
        return call2(list, num);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ChatTypingModel$Typing call2(List<? extends CharSequence> list, Integer num) {
        m.checkNotNullExpressionValue(list, "typingUsers");
        int rateLimitPerUser = this.this$0.$channel.getRateLimitPerUser();
        m.checkNotNullExpressionValue(num, "cooldownSecs");
        return new ChatTypingModel$Typing(list, rateLimitPerUser, num.intValue());
    }
}
