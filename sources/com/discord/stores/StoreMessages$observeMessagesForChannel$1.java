package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.message.Message;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;
import rx.functions.Func3;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$observeMessagesForChannel$1<T1, T2, T3, R> implements Func3<List<? extends Message>, List<? extends Message>, Boolean, List<? extends Message>> {
    public static final StoreMessages$observeMessagesForChannel$1 INSTANCE = new StoreMessages$observeMessagesForChannel$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ List<? extends Message> call(List<? extends Message> list, List<? extends Message> list2, Boolean bool) {
        return call2((List<Message>) list, (List<Message>) list2, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<Message> call2(List<Message> list, List<Message> list2, Boolean bool) {
        m.checkNotNullExpressionValue(bool, "isDetached");
        if (bool.booleanValue()) {
            return list;
        }
        m.checkNotNullExpressionValue(list, "messages");
        m.checkNotNullExpressionValue(list2, "localMessages");
        return u.plus((Collection) list, (Iterable) list2);
    }
}
