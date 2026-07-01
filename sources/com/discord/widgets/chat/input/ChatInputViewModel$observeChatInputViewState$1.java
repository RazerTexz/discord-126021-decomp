package com.discord.widgets.chat.input;

import androidx.core.app.NotificationCompat;
import j0.k.b;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$observeChatInputViewState$1<T, R> implements b<Long, Long> {
    public final /* synthetic */ ChatInputViewModel this$0;

    public ChatInputViewModel$observeChatInputViewState$1(ChatInputViewModel chatInputViewModel) {
        this.this$0 = chatInputViewModel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Long call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(Long l) {
        if (ChatInputViewModel.access$getUseTimeoutUpdateInterval$p(this.this$0)) {
            return l;
        }
        return 0L;
    }
}
