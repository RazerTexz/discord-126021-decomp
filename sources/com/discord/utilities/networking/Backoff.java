package com.discord.utilities.networking;

import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Backoff.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Backoff {
    private long current;
    private int fails;
    private final int failureThreshold;
    private boolean isPending;
    private final boolean jitter;
    private final long maxBackoffMs;
    private final long minBackoffMs;
    private final Scheduler scheduler;

    /* JADX INFO: compiled from: Backoff.kt */
    public interface Scheduler {
        void cancel();

        void schedule(Function0<Unit> action, long delayMs);
    }

    /* JADX INFO: compiled from: Backoff.kt */
    public static final class TimerScheduler extends Timer implements Scheduler {
        private final ExecutorService delegateExecutor;
        private final String tag;
        private TimerTask timeoutTimerTask;

        /* JADX WARN: Multi-variable type inference failed */
        public TimerScheduler() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ TimerScheduler(String str, ExecutorService executorService, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "TimerScheduler" : str, (i & 2) != 0 ? null : executorService);
        }

        @Override // java.util.Timer, com.discord.utilities.networking.Backoff.Scheduler
        public synchronized void cancel() {
            TimerTask timerTask = this.timeoutTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
            }
        }

        @Override // com.discord.utilities.networking.Backoff.Scheduler
        public synchronized void schedule(final Function0<Unit> action, long delayMs) {
            Intrinsics3.checkNotNullParameter(action, "action");
            TimerTask timerTask = this.timeoutTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
            }
            TimerTask timerTask2 = new TimerTask() { // from class: com.discord.utilities.networking.Backoff$TimerScheduler$schedule$1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Object obj;
                    if (this.this$0.delegateExecutor == null) {
                        action.invoke();
                        return;
                    }
                    Logger logger = LoggingProvider.INSTANCE.get();
                    if (this.this$0.delegateExecutor.isShutdown()) {
                        Logger.i$default(logger, this.this$0.tag, "skipping delayed task. executor is not running", null, 4, null);
                        return;
                    }
                    Logger.v$default(logger, this.this$0.tag, "TimerScheduler posting to delegate scheduler", null, 4, null);
                    ExecutorService executorService = this.this$0.delegateExecutor;
                    final Function0 function0 = action;
                    if (function0 != null) {
                        obj = function0;
                        obj = new Runnable() { // from class: com.discord.utilities.networking.Backoff$sam$java_lang_Runnable$0
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                Intrinsics3.checkNotNullExpressionValue(function0.invoke(), "invoke(...)");
                            }
                        };
                    }
                    obj = function0;
                    executorService.execute((Runnable) obj);
                }
            };
            this.timeoutTimerTask = timerTask2;
            schedule(timerTask2, delayMs);
        }

        public TimerScheduler(String str, ExecutorService executorService) {
            Intrinsics3.checkNotNullParameter(str, "tag");
            this.tag = str;
            this.delegateExecutor = executorService;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.networking.Backoff$fail$1, reason: invalid class name */
    /* JADX INFO: compiled from: Backoff.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0) {
            super(0);
            this.$callback = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Backoff.this.executeFailureCallback(this.$callback);
        }
    }

    public Backoff() {
        this(0L, 0L, 0, false, null, 31, null);
    }

    public Backoff(long j, long j2, int i, boolean z2, Scheduler scheduler) {
        Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
        this.minBackoffMs = j;
        this.maxBackoffMs = j2;
        this.failureThreshold = i;
        this.jitter = z2;
        this.scheduler = scheduler;
        this.current = j;
    }

    private final synchronized void executeFailureCallback(Function0<Unit> callback) {
        this.isPending = false;
        callback.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ long fail$default(Backoff backoff, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return backoff.fail(function0);
    }

    public final synchronized void cancel() {
        this.scheduler.cancel();
        this.isPending = false;
    }

    public final synchronized long fail(Function0<Unit> callback) {
        this.fails++;
        double dRandom = this.jitter ? Math.random() : 1.0d;
        long j = this.current;
        this.current = Math.min(j + ((long) (((long) 2) * j * dRandom)), this.maxBackoffMs);
        if (callback != null && !this.isPending) {
            this.isPending = true;
            this.scheduler.schedule(new AnonymousClass1(callback), this.current);
        }
        return this.current;
    }

    public final boolean hasReachedFailureThreshold() {
        return this.fails > this.failureThreshold;
    }

    /* JADX INFO: renamed from: isPending, reason: from getter */
    public final boolean getIsPending() {
        return this.isPending;
    }

    public final synchronized void succeed() {
        cancel();
        this.fails = 0;
        this.current = this.minBackoffMs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Backoff(long j, long j2, int i, boolean z2, Scheduler scheduler, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        Scheduler timerScheduler;
        long j3 = (i2 & 1) != 0 ? 500L : j;
        long j4 = (i2 & 2) != 0 ? ((long) 10) * j3 : j2;
        int i3 = (i2 & 4) != 0 ? Integer.MAX_VALUE : i;
        boolean z3 = (i2 & 8) != 0 ? true : z2;
        if ((i2 & 16) != 0) {
            timerScheduler = new TimerScheduler(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        } else {
            timerScheduler = scheduler;
        }
        this(j3, j4, i3, z3, timerScheduler);
    }
}
