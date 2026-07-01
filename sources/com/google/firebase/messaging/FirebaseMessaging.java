package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.b.TransportFactory;
import b.i.a.f.e.o.f;
import b.i.a.f.n.c0;
import b.i.a.f.n.e;
import b.i.a.f.n.v;
import b.i.c.DataCollectionDefaultChange;
import b.i.c.FirebaseApp2;
import b.i.c.q.Event3;
import b.i.c.q.EventHandler2;
import b.i.c.q.Subscriber2;
import b.i.c.r.HeartBeatInfo;
import b.i.c.s.n;
import b.i.c.s.q;
import b.i.c.t.Provider2;
import b.i.c.u.g;
import b.i.c.w.y;
import b.i.c.x.UserAgentPublisher;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class FirebaseMessaging {

    @Nullable
    @SuppressLint({"FirebaseUnknownNullness"})
    @VisibleForTesting
    public static TransportFactory a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f3112b;
    public final FirebaseApp2 c;
    public final FirebaseInstanceId d;
    public final a e;
    public final Executor f;
    public final Task<y> g;

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public class a {
        public final Subscriber2 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3113b;

        @Nullable
        public EventHandler2<DataCollectionDefaultChange> c;

        @Nullable
        public Boolean d;

        public a(Subscriber2 subscriber2) {
            this.a = subscriber2;
        }

        public synchronized void a() {
            if (this.f3113b) {
                return;
            }
            Boolean boolC = c();
            this.d = boolC;
            if (boolC == null) {
                EventHandler2<DataCollectionDefaultChange> eventHandler2 = new EventHandler2(this) { // from class: b.i.c.w.j
                    public final FirebaseMessaging.a a;

                    {
                        this.a = this;
                    }

                    @Override // b.i.c.q.EventHandler2
                    public final void a(Event3 event3) {
                        final FirebaseMessaging.a aVar = this.a;
                        if (aVar.b()) {
                            FirebaseMessaging.this.f.execute(new Runnable(aVar) { // from class: b.i.c.w.k
                                public final FirebaseMessaging.a j;

                                {
                                    this.j = aVar;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    FirebaseMessaging.this.d.i();
                                }
                            });
                        }
                    }
                };
                this.c = eventHandler2;
                this.a.a(DataCollectionDefaultChange.class, eventHandler2);
            }
            this.f3113b = true;
        }

        public synchronized boolean b() {
            a();
            Boolean bool = this.d;
            if (bool != null) {
                return bool.booleanValue();
            }
            return FirebaseMessaging.this.c.g();
        }

        @Nullable
        public final Boolean c() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            FirebaseApp2 firebaseApp2 = FirebaseMessaging.this.c;
            firebaseApp2.a();
            Context context = firebaseApp2.d;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public FirebaseMessaging(FirebaseApp2 firebaseApp2, final FirebaseInstanceId firebaseInstanceId, Provider2<UserAgentPublisher> provider2, Provider2<HeartBeatInfo> provider3, g gVar, @Nullable TransportFactory transportFactory, Subscriber2 subscriber2) {
        try {
            Class.forName("com.google.firebase.iid.FirebaseInstanceIdReceiver");
            a = transportFactory;
            this.c = firebaseApp2;
            this.d = firebaseInstanceId;
            this.e = new a(subscriber2);
            firebaseApp2.a();
            final Context context = firebaseApp2.d;
            this.f3112b = context;
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new b.i.a.f.e.o.j.a("Firebase-Messaging-Init"));
            this.f = scheduledThreadPoolExecutor;
            scheduledThreadPoolExecutor.execute(new Runnable(this, firebaseInstanceId) { // from class: b.i.c.w.g
                public final FirebaseMessaging j;
                public final FirebaseInstanceId k;

                {
                    this.j = this;
                    this.k = firebaseInstanceId;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    FirebaseMessaging firebaseMessaging = this.j;
                    FirebaseInstanceId firebaseInstanceId2 = this.k;
                    if (firebaseMessaging.e.b()) {
                        firebaseInstanceId2.i();
                    }
                }
            });
            final q qVar = new q(context);
            final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(1, new b.i.a.f.e.o.j.a("Firebase-Messaging-Topics-Io"));
            int i = y.f1800b;
            final n nVar = new n(firebaseApp2, qVar, provider2, provider3, gVar);
            Task<y> taskO = f.o(scheduledThreadPoolExecutor2, new Callable(context, scheduledThreadPoolExecutor2, firebaseInstanceId, qVar, nVar) { // from class: b.i.c.w.x
                public final Context j;
                public final ScheduledExecutorService k;
                public final FirebaseInstanceId l;
                public final b.i.c.s.q m;
                public final b.i.c.s.n n;

                {
                    this.j = context;
                    this.k = scheduledThreadPoolExecutor2;
                    this.l = firebaseInstanceId;
                    this.m = qVar;
                    this.n = nVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    w wVar;
                    Context context2 = this.j;
                    ScheduledExecutorService scheduledExecutorService = this.k;
                    FirebaseInstanceId firebaseInstanceId2 = this.l;
                    b.i.c.s.q qVar2 = this.m;
                    b.i.c.s.n nVar2 = this.n;
                    synchronized (w.class) {
                        WeakReference<w> weakReference = w.a;
                        wVar = weakReference != null ? weakReference.get() : null;
                        if (wVar == null) {
                            SharedPreferences sharedPreferences = context2.getSharedPreferences("com.google.android.gms.appid", 0);
                            w wVar2 = new w(sharedPreferences, scheduledExecutorService);
                            synchronized (wVar2) {
                                wVar2.c = u.a(sharedPreferences, "topic_operation_queue", ",", scheduledExecutorService);
                            }
                            w.a = new WeakReference<>(wVar2);
                            wVar = wVar2;
                        }
                    }
                    return new y(firebaseInstanceId2, qVar2, wVar, nVar2, context2, scheduledExecutorService);
                }
            });
            this.g = taskO;
            c0 c0Var = (c0) taskO;
            c0Var.f1592b.a(new v(new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b.i.a.f.e.o.j.a("Firebase-Messaging-Trigger-Topics-Io")), new e(this) { // from class: b.i.c.w.h
                public final FirebaseMessaging a;

                {
                    this.a = this;
                }

                @Override // b.i.a.f.n.e
                public final void onSuccess(Object obj) {
                    boolean z2;
                    y yVar = (y) obj;
                    if (this.a.e.b()) {
                        if (yVar.j.a() != null) {
                            synchronized (yVar) {
                                z2 = yVar.i;
                            }
                            if (z2) {
                                return;
                            }
                            yVar.g(0L);
                        }
                    }
                }
            }));
            c0Var.w();
        } catch (ClassNotFoundException unused) {
            throw new IllegalStateException("FirebaseMessaging and FirebaseInstanceId versions not compatible. Update to latest version of firebase-messaging.");
        }
    }

    @NonNull
    @Keep
    public static synchronized FirebaseMessaging getInstance(@NonNull FirebaseApp2 firebaseApp2) {
        FirebaseMessaging firebaseMessaging;
        firebaseApp2.a();
        firebaseMessaging = (FirebaseMessaging) firebaseApp2.g.a(FirebaseMessaging.class);
        AnimatableValueParser.z(firebaseMessaging, "Firebase Messaging component is not present");
        return firebaseMessaging;
    }
}
