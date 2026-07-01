package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.messagesend.MessageResult$NoValidContent;
import rx.Emitter;
import rx.functions.Action1;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$sendMessage$2<T> implements Action1<Emitter<MessageResult>> {
    public static final StoreMessages$sendMessage$2 INSTANCE = new StoreMessages$sendMessage$2();

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Emitter<MessageResult> emitter) {
        call2(emitter);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Emitter<MessageResult> emitter) {
        emitter.onNext(MessageResult$NoValidContent.INSTANCE);
        emitter.onCompleted();
    }
}
