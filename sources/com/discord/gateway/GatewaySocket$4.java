package com.discord.gateway;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.utilities.logging.Logger;
import rx.functions.Action1;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$4<T> implements Action1<Throwable> {
    public final /* synthetic */ GatewaySocket this$0;

    public GatewaySocket$4(GatewaySocket gatewaySocket) {
        this.this$0 = gatewaySocket;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Throwable th) {
        call2(th);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Throwable th) {
        Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(this.this$0);
        StringBuilder sbU = a.U("failed to handle connectivity change in ");
        sbU.append(this.this$0.getClass().getSimpleName());
        Logger.e$default(loggerAccess$getLogger$p, sbU.toString(), th, null, 4, null);
    }
}
