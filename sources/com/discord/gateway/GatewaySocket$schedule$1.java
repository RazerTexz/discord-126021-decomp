package com.discord.gateway;

import androidx.core.app.NotificationCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.functions.Action1;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$schedule$1<T> implements Action1<Function0<? extends Unit>> {
    public static final GatewaySocket$schedule$1 INSTANCE = new GatewaySocket$schedule$1();

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Function0<? extends Unit> function0) {
        call2((Function0<Unit>) function0);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Function0<Unit> function0) {
        function0.invoke();
    }
}
