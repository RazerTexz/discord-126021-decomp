package com.discord.stores;

import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;
import p658rx.Scheduler;
import p658rx.functions.Action0;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Dispatcher {
    private final boolean assertCleanDispatches;
    private final ArrayList<DispatchHandler> dispatchHandlers;
    private Thread dispatcherThread;
    private final Scheduler scheduler;

    public Dispatcher(Scheduler scheduler, boolean z2) {
        C12238m.checkNotNullParameter(scheduler, "scheduler");
        this.scheduler = scheduler;
        this.assertCleanDispatches = z2;
        this.dispatchHandlers = new ArrayList<>();
    }

    private final void assertCleanDispatch() {
        if (Thread.currentThread() == this.dispatcherThread) {
            AppLog.f14950g.mo8370w("dirty dispatch", new RuntimeException());
        }
    }

    public final Scheduler getScheduler() {
        return this.scheduler;
    }

    @StoreThread
    public final void onDispatchEnded() {
        Iterator<DispatchHandler> it = this.dispatchHandlers.iterator();
        while (it.hasNext()) {
            it.next().onDispatchEnded();
        }
    }

    @StoreThread
    public final void registerDispatchHandlers(DispatchHandler... dispatchHandlerArgs) {
        C12238m.checkNotNullParameter(dispatchHandlerArgs, "dispatchHandlerArgs");
        for (DispatchHandler dispatchHandler : dispatchHandlerArgs) {
            this.dispatchHandlers.add(dispatchHandler);
        }
    }

    public final void schedule(final Function0<Unit> action) {
        C12238m.checkNotNullParameter(action, "action");
        if (this.dispatchHandlers.isEmpty()) {
            AppLog appLog = AppLog.f14950g;
            String name = Dispatcher.class.getName();
            C12238m.checkNotNullExpressionValue(name, "javaClass.name");
            Logger.e$default(appLog, name, "scheduled an action without registering DispatchHandlers", null, null, 12, null);
        }
        if (this.assertCleanDispatches) {
            assertCleanDispatch();
        }
        this.scheduler.mo10739a().mo10740a(new Action0() { // from class: com.discord.stores.Dispatcher.schedule.1
            @Override // p658rx.functions.Action0
            public final void call() {
                if (Dispatcher.this.dispatcherThread == null) {
                    Dispatcher.this.dispatcherThread = Thread.currentThread();
                }
                action.invoke();
                Dispatcher.this.onDispatchEnded();
            }
        });
    }

    @StoreThread
    public final void unregisterDispatchHandlers(DispatchHandler... dispatchHandlerArgs) {
        C12238m.checkNotNullParameter(dispatchHandlerArgs, "dispatchHandlerArgs");
        for (DispatchHandler dispatchHandler : dispatchHandlerArgs) {
            this.dispatchHandlers.remove(dispatchHandler);
        }
    }

    public /* synthetic */ Dispatcher(Scheduler scheduler, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(scheduler, (i & 2) != 0 ? false : z2);
    }
}
