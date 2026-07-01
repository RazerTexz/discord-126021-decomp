package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.message.Message;
import java.util.List;
import rx.functions.Func2;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$observeLocalMessagesForChannel$2<T1, T2, R> implements Func2<List<? extends Message>, List<? extends Message>, Boolean> {
    public static final StoreMessages$observeLocalMessagesForChannel$2 INSTANCE = new StoreMessages$observeLocalMessagesForChannel$2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(List<? extends Message> list, List<? extends Message> list2) {
        return call2((List<Message>) list, (List<Message>) list2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(List<Message> list, List<Message> list2) {
        return Boolean.valueOf(list == list2);
    }
}
