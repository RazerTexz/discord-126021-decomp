package com.discord.widgets.forums;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.rest.SendUtils$SendPayload$ReadyToSend;
import j0.k.b;
import java.util.Objects;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumPostCreateManager$sendCreateForumPostWithMessageRequest$$inlined$filterIs$2<T, R> implements b<Object, T> {
    public static final ForumPostCreateManager$sendCreateForumPostWithMessageRequest$$inlined$filterIs$2 INSTANCE = new ForumPostCreateManager$sendCreateForumPostWithMessageRequest$$inlined$filterIs$2();

    @Override // j0.k.b
    public final T call(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.utilities.rest.SendUtils.SendPayload.ReadyToSend");
        return (T) ((SendUtils$SendPayload$ReadyToSend) obj);
    }
}
