package com.discord.utilities.messagesend;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.rest.SendUtils$SendPayload$ReadyToSend;
import j0.k.b;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue$doSend$$inlined$filterIs$1<T, R> implements b<Object, Boolean> {
    public static final MessageQueue$doSend$$inlined$filterIs$1 INSTANCE = new MessageQueue$doSend$$inlined$filterIs$1();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // j0.k.b
    public final Boolean call(Object obj) {
        return Boolean.valueOf(obj instanceof SendUtils$SendPayload$ReadyToSend);
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Object obj) {
        return call(obj);
    }
}
