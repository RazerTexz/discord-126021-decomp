package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStream;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetAuthForceChangePassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthForceChangePassword$onViewBound$1<R> implements Func0<Boolean> {
    public static final WidgetAuthForceChangePassword$onViewBound$1 INSTANCE = new WidgetAuthForceChangePassword$onViewBound$1();

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Boolean call() {
        StoreStream.Companion.getAuthentication().logout();
        return Boolean.TRUE;
    }
}
