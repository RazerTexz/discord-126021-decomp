package com.discord.stores;

import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Scheduler;
import rx.functions.Action0;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Dispatcher {
    private final boolean assertCleanDispatches;
    private final ArrayList<Store2> dispatchHandlers;
    private Thread dispatcherThread;
    private final Scheduler scheduler;

    public Dispatcher(Scheduler scheduler, boolean z2) {
        Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
        this.scheduler = scheduler;
        this.assertCleanDispatches = z2;
        this.dispatchHandlers = new ArrayList<>();
    }

    private final void assertCleanDispatch() {
        if (Thread.currentThread() == this.dispatcherThread) {
            AppLog.g.w("dirty dispatch", new RuntimeException());
        }
    }

    public final Scheduler getScheduler() {
        return this.scheduler;
    }

    @Store3
    public final void onDispatchEnded() {
        Iterator<Store2> it = this.dispatchHandlers.iterator();
        while (it.hasNext()) {
            it.next().onDispatchEnded();
        }
    }

    @Store3
    public final void registerDispatchHandlers(Store2... dispatchHandlerArgs) {
        Intrinsics3.checkNotNullParameter(dispatchHandlerArgs, "dispatchHandlerArgs");
        for (Store2 store2 : dispatchHandlerArgs) {
            this.dispatchHandlers.add(store2);
        }
    }

    public final void schedule(final Function0<Unit> action) {
        Intrinsics3.checkNotNullParameter(action, "action");
        if (this.dispatchHandlers.isEmpty()) {
            AppLog appLog = AppLog.g;
            String name = Dispatcher.class.getName();
            Intrinsics3.checkNotNullExpressionValue(name, "javaClass.name");
            Logger.e$default(appLog, name, "scheduled an action without registering DispatchHandlers", null, null, 12, null);
        }
        if (this.assertCleanDispatches) {
            assertCleanDispatch();
        }
        this.scheduler.a().a(new Action0() { // from class: com.discord.stores.Dispatcher.schedule.1
            @Override // rx.functions.Action0
            public final void call() {
                if (Dispatcher.this.dispatcherThread == null) {
                    Dispatcher.this.dispatcherThread = Thread.currentThread();
                }
                action.invoke();
                Dispatcher.this.onDispatchEnded();
            }
        });
    }

    @Store3
    public final void unregisterDispatchHandlers(Store2... dispatchHandlerArgs) {
        Intrinsics3.checkNotNullParameter(dispatchHandlerArgs, "dispatchHandlerArgs");
        for (Store2 store2 : dispatchHandlerArgs) {
            this.dispatchHandlers.remove(store2);
        }
    }

    public /* synthetic */ Dispatcher(Scheduler scheduler, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(scheduler, (i & 2) != 0 ? false : z2);
    }
}
