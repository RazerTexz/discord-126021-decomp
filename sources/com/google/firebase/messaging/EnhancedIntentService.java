package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.EnhancedIntentService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p299e.p308o.p309j.ThreadFactoryC3408a;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;
import p007b.p225i.p361c.p398s.BinderC4806a0;
import p007b.p225i.p361c.p398s.C4834y;
import p007b.p225i.p361c.p406w.ExecutorC4867e;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
public abstract class EnhancedIntentService extends Service {
    private Binder binder;

    @VisibleForTesting
    public final ExecutorService executor;
    private int lastStartId;
    private final Object lock;
    private int runningTasks;

    /* JADX INFO: renamed from: com.google.firebase.messaging.EnhancedIntentService$a */
    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public class C11087a implements BinderC4806a0.a {
        public C11087a() {
        }
    }

    public EnhancedIntentService() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC3408a("Firebase-Messaging-Intent-Handle"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.executor = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.lock = new Object();
        this.runningTasks = 0;
    }

    private void finishTask(Intent intent) {
        if (intent != null) {
            synchronized (C4834y.f12915b) {
                if (C4834y.f12916c != null && intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false)) {
                    intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                    C4834y.f12916c.m6002b();
                }
            }
        }
        synchronized (this.lock) {
            int i = this.runningTasks - 1;
            this.runningTasks = i;
            if (i == 0) {
                stopSelfResultHook(this.lastStartId);
            }
        }
    }

    @MainThread
    private Task<Void> processIntent(final Intent intent) {
        if (handleIntentOnMainThread(intent)) {
            return C3404f.m4264Z(null);
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.executor.execute(new Runnable(this, intent, taskCompletionSource) { // from class: b.i.c.w.d

            /* JADX INFO: renamed from: j */
            public final EnhancedIntentService f13017j;

            /* JADX INFO: renamed from: k */
            public final Intent f13018k;

            /* JADX INFO: renamed from: l */
            public final TaskCompletionSource f13019l;

            {
                this.f13017j = this;
                this.f13018k = intent;
                this.f13019l = taskCompletionSource;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13017j.lambda$processIntent$0$EnhancedIntentService(this.f13018k, this.f13019l);
            }
        });
        return taskCompletionSource.f20845a;
    }

    public Intent getStartCommandIntent(Intent intent) {
        return intent;
    }

    public abstract void handleIntent(Intent intent);

    public boolean handleIntentOnMainThread(Intent intent) {
        return false;
    }

    public final /* synthetic */ void lambda$onStartCommand$1$EnhancedIntentService(Intent intent, Task task) {
        finishTask(intent);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void lambda$processIntent$0$EnhancedIntentService(Intent intent, TaskCompletionSource taskCompletionSource) {
        try {
            handleIntent(intent);
        } finally {
            taskCompletionSource.f20845a.m6024s(null);
        }
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.binder == null) {
            this.binder = new BinderC4806a0(new C11087a());
        }
        return this.binder;
    }

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        this.executor.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i, int i2) {
        synchronized (this.lock) {
            this.lastStartId = i2;
            this.runningTasks++;
        }
        Intent startCommandIntent = getStartCommandIntent(intent);
        if (startCommandIntent == null) {
            finishTask(intent);
            return 2;
        }
        Task<Void> taskProcessIntent = processIntent(startCommandIntent);
        if (taskProcessIntent.mo6020o()) {
            finishTask(intent);
            return 2;
        }
        taskProcessIntent.mo6008c(ExecutorC4867e.f13020j, new InterfaceC4357c(this, intent) { // from class: b.i.c.w.f

            /* JADX INFO: renamed from: a */
            public final EnhancedIntentService f13021a;

            /* JADX INFO: renamed from: b */
            public final Intent f13022b;

            {
                this.f13021a = this;
                this.f13022b = intent;
            }

            @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
            public final void onComplete(Task task) {
                this.f13021a.lambda$onStartCommand$1$EnhancedIntentService(this.f13022b, task);
            }
        });
        return 3;
    }

    public boolean stopSelfResultHook(int i) {
        return stopSelfResult(i);
    }
}
