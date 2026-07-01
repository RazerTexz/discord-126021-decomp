package com.discord.gateway;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.functions.Function0;
import rx.functions.Action1;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$Timer$postInterval$1<T> implements Action1<Long> {
    public final /* synthetic */ Function0 $callback;

    public GatewaySocket$Timer$postInterval$1(Function0 function0) {
        this.$callback = function0;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Long l) {
        call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Long l) {
        this.$callback.invoke();
    }
}
