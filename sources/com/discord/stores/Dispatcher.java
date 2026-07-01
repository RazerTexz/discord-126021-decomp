package com.discord.stores;

import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Scheduler;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Dispatcher {
    private final boolean assertCleanDispatches;
    private final ArrayList<DispatchHandler> dispatchHandlers;
    private Thread dispatcherThread;
    private final Scheduler scheduler;

    public Dispatcher(Scheduler scheduler, boolean z2) {
        m.checkNotNullParameter(scheduler, "scheduler");
        this.scheduler = scheduler;
        this.assertCleanDispatches = z2;
        this.dispatchHandlers = new ArrayList<>();
    }

    public static final /* synthetic */ Thread access$getDispatcherThread$p(Dispatcher dispatcher) {
        return dispatcher.dispatcherThread;
    }

    public static final /* synthetic */ void access$setDispatcherThread$p(Dispatcher dispatcher, Thread thread) {
        dispatcher.dispatcherThread = thread;
    }

    private final void assertCleanDispatch() {
        if (Thread.currentThread() == this.dispatcherThread) {
            AppLog.g.w("dirty dispatch", new RuntimeException());
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
        m.checkNotNullParameter(dispatchHandlerArgs, "dispatchHandlerArgs");
        for (DispatchHandler dispatchHandler : dispatchHandlerArgs) {
            this.dispatchHandlers.add(dispatchHandler);
        }
    }

    public final void schedule(Function0<Unit> action) {
        m.checkNotNullParameter(action, "action");
        if (this.dispatchHandlers.isEmpty()) {
            AppLog appLog = AppLog.g;
            String name = Dispatcher.class.getName();
            m.checkNotNullExpressionValue(name, "javaClass.name");
            Logger.e$default(appLog, name, "scheduled an action without registering DispatchHandlers", null, null, 12, null);
        }
        if (this.assertCleanDispatches) {
            assertCleanDispatch();
        }
        this.scheduler.a().a(new Dispatcher$schedule$1(this, action));
    }

    @StoreThread
    public final void unregisterDispatchHandlers(DispatchHandler... dispatchHandlerArgs) {
        m.checkNotNullParameter(dispatchHandlerArgs, "dispatchHandlerArgs");
        for (DispatchHandler dispatchHandler : dispatchHandlerArgs) {
            this.dispatchHandlers.remove(dispatchHandler);
        }
    }

    public /* synthetic */ Dispatcher(Scheduler scheduler, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(scheduler, (i & 2) != 0 ? false : z2);
    }
}
