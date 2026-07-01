package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.application.Unread;
import com.discord.models.application.Unread$Marker;
import com.discord.models.message.Message;
import d0.z.d.m;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: StoreReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreReadStates$computeUnreadMarker$4$1<T, R> implements b<List<? extends Message>, Unread> {
    public final /* synthetic */ Unread$Marker $marker;

    public StoreReadStates$computeUnreadMarker$4$1(Unread$Marker unread$Marker) {
        this.$marker = unread$Marker;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Unread call(List<? extends Message> list) {
        return call2((List<Message>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Unread call2(List<Message> list) {
        Unread$Marker unread$Marker = this.$marker;
        m.checkNotNullExpressionValue(list, "messages");
        return new Unread(unread$Marker, list);
    }
}
