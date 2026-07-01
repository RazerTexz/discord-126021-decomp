package com.discord.utilities.networking;

import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Backoff.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Backoff$TimerScheduler$schedule$1 extends TimerTask {
    public final /* synthetic */ Function0 $action;
    public final /* synthetic */ Backoff$TimerScheduler this$0;

    public Backoff$TimerScheduler$schedule$1(Backoff$TimerScheduler backoff$TimerScheduler, Function0 function0) {
        this.this$0 = backoff$TimerScheduler;
        this.$action = function0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Object backoff$sam$java_lang_Runnable$0;
        if (Backoff$TimerScheduler.access$getDelegateExecutor$p(this.this$0) == null) {
            this.$action.invoke();
            return;
        }
        Logger logger = LoggingProvider.INSTANCE.get();
        if (Backoff$TimerScheduler.access$getDelegateExecutor$p(this.this$0).isShutdown()) {
            Logger.i$default(logger, Backoff$TimerScheduler.access$getTag$p(this.this$0), "skipping delayed task. executor is not running", null, 4, null);
            return;
        }
        Logger.v$default(logger, Backoff$TimerScheduler.access$getTag$p(this.this$0), "TimerScheduler posting to delegate scheduler", null, 4, null);
        ExecutorService executorServiceAccess$getDelegateExecutor$p = Backoff$TimerScheduler.access$getDelegateExecutor$p(this.this$0);
        Function0 function0 = this.$action;
        if (function0 != null) {
            backoff$sam$java_lang_Runnable$0 = function0;
            backoff$sam$java_lang_Runnable$0 = new Backoff$sam$java_lang_Runnable$0(function0);
        }
        backoff$sam$java_lang_Runnable$0 = function0;
        executorServiceAccess$getDelegateExecutor$p.execute((Runnable) backoff$sam$java_lang_Runnable$0);
    }
}
