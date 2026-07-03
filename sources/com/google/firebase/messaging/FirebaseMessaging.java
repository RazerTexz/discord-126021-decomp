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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p228b.InterfaceC2412g;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p299e.p308o.p309j.ThreadFactoryC3408a;
import p007b.p225i.p226a.p288f.p340n.C4358c0;
import p007b.p225i.p226a.p288f.p340n.C4378v;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4361e;
import p007b.p225i.p361c.C4540a;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p396q.C4796a;
import p007b.p225i.p361c.p396q.InterfaceC4797b;
import p007b.p225i.p361c.p396q.InterfaceC4799d;
import p007b.p225i.p361c.p397r.InterfaceC4803d;
import p007b.p225i.p361c.p398s.C4823n;
import p007b.p225i.p361c.p398s.C4826q;
import p007b.p225i.p361c.p400t.InterfaceC4836a;
import p007b.p225i.p361c.p401u.InterfaceC4843g;
import p007b.p225i.p361c.p406w.C4887y;
import p007b.p225i.p361c.p407x.InterfaceC4896h;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class FirebaseMessaging {

    /* JADX INFO: renamed from: a */
    @Nullable
    @SuppressLint({"FirebaseUnknownNullness"})
    @VisibleForTesting
    public static InterfaceC2412g f21448a;

    /* JADX INFO: renamed from: b */
    public final Context f21449b;

    /* JADX INFO: renamed from: c */
    public final C4542c f21450c;

    /* JADX INFO: renamed from: d */
    public final FirebaseInstanceId f21451d;

    /* JADX INFO: renamed from: e */
    public final C11088a f21452e;

    /* JADX INFO: renamed from: f */
    public final Executor f21453f;

    /* JADX INFO: renamed from: g */
    public final Task<C4887y> f21454g;

    /* JADX INFO: renamed from: com.google.firebase.messaging.FirebaseMessaging$a */
    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public class C11088a {

        /* JADX INFO: renamed from: a */
        public final InterfaceC4799d f21455a;

        /* JADX INFO: renamed from: b */
        public boolean f21456b;

        /* JADX INFO: renamed from: c */
        @Nullable
        public InterfaceC4797b<C4540a> f21457c;

        /* JADX INFO: renamed from: d */
        @Nullable
        public Boolean f21458d;

        public C11088a(InterfaceC4799d interfaceC4799d) {
            this.f21455a = interfaceC4799d;
        }

        /* JADX INFO: renamed from: a */
        public synchronized void m9193a() {
            if (this.f21456b) {
                return;
            }
            Boolean boolM9195c = m9195c();
            this.f21458d = boolM9195c;
            if (boolM9195c == null) {
                InterfaceC4797b<C4540a> interfaceC4797b = new InterfaceC4797b(this) { // from class: b.i.c.w.j

                    /* JADX INFO: renamed from: a */
                    public final FirebaseMessaging.C11088a f13027a;

                    {
                        this.f13027a = this;
                    }

                    @Override // p007b.p225i.p361c.p396q.InterfaceC4797b
                    /* JADX INFO: renamed from: a */
                    public final void mo6343a(C4796a c4796a) {
                        final FirebaseMessaging.C11088a c11088a = this.f13027a;
                        if (c11088a.m9194b()) {
                            FirebaseMessaging.this.f21453f.execute(new Runnable(c11088a) { // from class: b.i.c.w.k

                                /* JADX INFO: renamed from: j */
                                public final FirebaseMessaging.C11088a f13028j;

                                {
                                    this.f13028j = c11088a;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    FirebaseMessaging.this.f21451d.m9186i();
                                }
                            });
                        }
                    }
                };
                this.f21457c = interfaceC4797b;
                this.f21455a.mo6359a(C4540a.class, interfaceC4797b);
            }
            this.f21456b = true;
        }

        /* JADX INFO: renamed from: b */
        public synchronized boolean m9194b() {
            m9193a();
            Boolean bool = this.f21458d;
            if (bool != null) {
                return bool.booleanValue();
            }
            return FirebaseMessaging.this.f21450c.m6333g();
        }

        @Nullable
        /* JADX INFO: renamed from: c */
        public final Boolean m9195c() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            C4542c c4542c = FirebaseMessaging.this.f21450c;
            c4542c.m6330a();
            Context context = c4542c.f12118d;
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
    public FirebaseMessaging(C4542c c4542c, final FirebaseInstanceId firebaseInstanceId, InterfaceC4836a<InterfaceC4896h> interfaceC4836a, InterfaceC4836a<InterfaceC4803d> interfaceC4836a2, InterfaceC4843g interfaceC4843g, @Nullable InterfaceC2412g interfaceC2412g, InterfaceC4799d interfaceC4799d) {
        try {
            Class.forName("com.google.firebase.iid.FirebaseInstanceIdReceiver");
            f21448a = interfaceC2412g;
            this.f21450c = c4542c;
            this.f21451d = firebaseInstanceId;
            this.f21452e = new C11088a(interfaceC4799d);
            c4542c.m6330a();
            final Context context = c4542c.f12118d;
            this.f21449b = context;
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC3408a("Firebase-Messaging-Init"));
            this.f21453f = scheduledThreadPoolExecutor;
            scheduledThreadPoolExecutor.execute(new Runnable(this, firebaseInstanceId) { // from class: b.i.c.w.g

                /* JADX INFO: renamed from: j */
                public final FirebaseMessaging f13023j;

                /* JADX INFO: renamed from: k */
                public final FirebaseInstanceId f13024k;

                {
                    this.f13023j = this;
                    this.f13024k = firebaseInstanceId;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    FirebaseMessaging firebaseMessaging = this.f13023j;
                    FirebaseInstanceId firebaseInstanceId2 = this.f13024k;
                    if (firebaseMessaging.f21452e.m9194b()) {
                        firebaseInstanceId2.m9186i();
                    }
                }
            });
            final C4826q c4826q = new C4826q(context);
            final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC3408a("Firebase-Messaging-Topics-Io"));
            int i = C4887y.f13060b;
            final C4823n c4823n = new C4823n(c4542c, c4826q, interfaceC4836a, interfaceC4836a2, interfaceC4843g);
            Task<C4887y> taskM4323o = C3404f.m4323o(scheduledThreadPoolExecutor2, new Callable(context, scheduledThreadPoolExecutor2, firebaseInstanceId, c4826q, c4823n) { // from class: b.i.c.w.x

                /* JADX INFO: renamed from: j */
                public final Context f13054j;

                /* JADX INFO: renamed from: k */
                public final ScheduledExecutorService f13055k;

                /* JADX INFO: renamed from: l */
                public final FirebaseInstanceId f13056l;

                /* JADX INFO: renamed from: m */
                public final C4826q f13057m;

                /* JADX INFO: renamed from: n */
                public final C4823n f13058n;

                {
                    this.f13054j = context;
                    this.f13055k = scheduledThreadPoolExecutor2;
                    this.f13056l = firebaseInstanceId;
                    this.f13057m = c4826q;
                    this.f13058n = c4823n;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    C4885w c4885w;
                    Context context2 = this.f13054j;
                    ScheduledExecutorService scheduledExecutorService = this.f13055k;
                    FirebaseInstanceId firebaseInstanceId2 = this.f13056l;
                    C4826q c4826q2 = this.f13057m;
                    C4823n c4823n2 = this.f13058n;
                    synchronized (C4885w.class) {
                        WeakReference<C4885w> weakReference = C4885w.f13050a;
                        c4885w = weakReference != null ? weakReference.get() : null;
                        if (c4885w == null) {
                            SharedPreferences sharedPreferences = context2.getSharedPreferences("com.google.android.gms.appid", 0);
                            C4885w c4885w2 = new C4885w(sharedPreferences, scheduledExecutorService);
                            synchronized (c4885w2) {
                                c4885w2.f13052c = C4883u.m6828a(sharedPreferences, "topic_operation_queue", ",", scheduledExecutorService);
                            }
                            C4885w.f13050a = new WeakReference<>(c4885w2);
                            c4885w = c4885w2;
                        }
                    }
                    return new C4887y(firebaseInstanceId2, c4826q2, c4885w, c4823n2, context2, scheduledExecutorService);
                }
            });
            this.f21454g = taskM4323o;
            C4358c0 c4358c0 = (C4358c0) taskM4323o;
            c4358c0.f11472b.m6031a(new C4378v(new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC3408a("Firebase-Messaging-Trigger-Topics-Io")), new InterfaceC4361e(this) { // from class: b.i.c.w.h

                /* JADX INFO: renamed from: a */
                public final FirebaseMessaging f13025a;

                {
                    this.f13025a = this;
                }

                @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4361e
                public final void onSuccess(Object obj) {
                    boolean z2;
                    C4887y c4887y = (C4887y) obj;
                    if (this.f13025a.f21452e.m9194b()) {
                        if (c4887y.f13068j.m6829a() != null) {
                            synchronized (c4887y) {
                                z2 = c4887y.f13067i;
                            }
                            if (z2) {
                                return;
                            }
                            c4887y.m6836g(0L);
                        }
                    }
                }
            }));
            c4358c0.m6028w();
        } catch (ClassNotFoundException unused) {
            throw new IllegalStateException("FirebaseMessaging and FirebaseInstanceId versions not compatible. Update to latest version of firebase-messaging.");
        }
    }

    @NonNull
    @Keep
    public static synchronized FirebaseMessaging getInstance(@NonNull C4542c c4542c) {
        FirebaseMessaging firebaseMessaging;
        c4542c.m6330a();
        firebaseMessaging = (FirebaseMessaging) c4542c.f12121g.mo6346a(FirebaseMessaging.class);
        C1460d.m595z(firebaseMessaging, "Firebase Messaging component is not present");
        return firebaseMessaging;
    }
}
