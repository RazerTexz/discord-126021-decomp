package com.discord.widgets.chat.input;

import androidx.core.app.NotificationCompat;
import j0.k.b;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$Companion$getIsOnCooldownObservable$1<T, R> implements b<Integer, Boolean> {
    public static final ChatInputViewModel$Companion$getIsOnCooldownObservable$1 INSTANCE = new ChatInputViewModel$Companion$getIsOnCooldownObservable$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Integer num) {
        return call(num.intValue());
    }

    public final Boolean call(int i) {
        return Boolean.valueOf(i > 0);
    }
}
