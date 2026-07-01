package com.discord.utilities.networking;

import d0.z.d.m;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Backoff.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Backoff$TimerScheduler extends Timer implements Backoff$Scheduler {
    private final ExecutorService delegateExecutor;
    private final String tag;
    private TimerTask timeoutTimerTask;

    public Backoff$TimerScheduler() {
        this(null, null, 3, null);
    }

    public /* synthetic */ Backoff$TimerScheduler(String str, ExecutorService executorService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "TimerScheduler" : str, (i & 2) != 0 ? null : executorService);
    }

    public static final /* synthetic */ ExecutorService access$getDelegateExecutor$p(Backoff$TimerScheduler backoff$TimerScheduler) {
        return backoff$TimerScheduler.delegateExecutor;
    }

    public static final /* synthetic */ String access$getTag$p(Backoff$TimerScheduler backoff$TimerScheduler) {
        return backoff$TimerScheduler.tag;
    }

    @Override // java.util.Timer, com.discord.utilities.networking.Backoff$Scheduler
    public synchronized void cancel() {
        TimerTask timerTask = this.timeoutTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
    }

    @Override // com.discord.utilities.networking.Backoff$Scheduler
    public synchronized void schedule(Function0<Unit> action, long delayMs) {
        m.checkNotNullParameter(action, "action");
        TimerTask timerTask = this.timeoutTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Backoff$TimerScheduler$schedule$1 backoff$TimerScheduler$schedule$1 = new Backoff$TimerScheduler$schedule$1(this, action);
        this.timeoutTimerTask = backoff$TimerScheduler$schedule$1;
        schedule(backoff$TimerScheduler$schedule$1, delayMs);
    }

    public Backoff$TimerScheduler(String str, ExecutorService executorService) {
        m.checkNotNullParameter(str, "tag");
        this.tag = str;
        this.delegateExecutor = executorService;
    }
}
