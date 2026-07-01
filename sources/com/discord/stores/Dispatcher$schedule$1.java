package com.discord.stores;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.functions.Function0;
import rx.functions.Action0;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Dispatcher$schedule$1 implements Action0 {
    public final /* synthetic */ Function0 $action;
    public final /* synthetic */ Dispatcher this$0;

    public Dispatcher$schedule$1(Dispatcher dispatcher, Function0 function0) {
        this.this$0 = dispatcher;
        this.$action = function0;
    }

    @Override // rx.functions.Action0
    public final void call() {
        if (Dispatcher.access$getDispatcherThread$p(this.this$0) == null) {
            Dispatcher.access$setDispatcherThread$p(this.this$0, Thread.currentThread());
        }
        this.$action.invoke();
        this.this$0.onDispatchEnded();
    }
}
