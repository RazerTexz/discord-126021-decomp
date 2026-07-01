package com.discord.utilities.websocket;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocket$2<T> implements Action1<Throwable> {
    public final /* synthetic */ WebSocket this$0;

    public WebSocket$2(WebSocket webSocket) {
        this.this$0 = webSocket;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Throwable th) {
        call2(th);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Throwable th) {
        WebSocket webSocket = this.this$0;
        m.checkNotNullExpressionValue(th, "it");
        WebSocket.access$handleOnFailure(webSocket, th, null, this.this$0.getState() == WebSocket$State.CLOSED);
    }
}
