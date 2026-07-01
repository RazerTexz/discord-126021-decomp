package com.google.firebase.iid;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.o.f;
import b.i.a.f.e.o.j.a;
import b.i.a.f.n.c;
import b.i.c.FirebaseApp2;
import b.i.c.r.HeartBeatInfo;
import b.i.c.s.h;
import b.i.c.s.j;
import b.i.c.s.n;
import b.i.c.s.o;
import b.i.c.s.p;
import b.i.c.s.q;
import b.i.c.s.u;
import b.i.c.s.w;
import b.i.c.s.x;
import b.i.c.t.Provider2;
import b.i.c.u.g;
import b.i.c.x.UserAgentPublisher;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class FirebaseInstanceId {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static w f3111b;
    public static ScheduledExecutorService d;
    public final Executor e;
    public final FirebaseApp2 f;
    public final q g;
    public final n h;
    public final u i;
    public final g j;
    public boolean k;
    public static final long a = TimeUnit.HOURS.toSeconds(8);
    public static final Pattern c = Pattern.compile("\\AA[\\w-]{38}\\z");

    public FirebaseInstanceId(FirebaseApp2 firebaseApp2, Provider2<UserAgentPublisher> provider2, Provider2<HeartBeatInfo> provider3, g gVar) {
        firebaseApp2.a();
        q qVar = new q(firebaseApp2.d);
        ExecutorService executorServiceA = h.a();
        ExecutorService executorServiceA2 = h.a();
        this.k = false;
        if (q.b(firebaseApp2) == null) {
            throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
        }
        synchronized (FirebaseInstanceId.class) {
            if (f3111b == null) {
                firebaseApp2.a();
                f3111b = new w(firebaseApp2.d);
            }
        }
        this.f = firebaseApp2;
        this.g = qVar;
        this.h = new n(firebaseApp2, qVar, provider2, provider3, gVar);
        this.e = executorServiceA2;
        this.i = new u(executorServiceA);
        this.j = gVar;
    }

    public static <T> T a(@NonNull Task<T> task) throws InterruptedException {
        AnimatableValueParser.z(task, "Task must not be null");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        task.c(j.j, new c(countDownLatch) { // from class: b.i.c.s.k
            public final CountDownLatch a;

            {
                this.a = countDownLatch;
            }

            @Override // b.i.a.f.n.c
            public final void onComplete(Task task2) {
                CountDownLatch countDownLatch2 = this.a;
                w wVar = FirebaseInstanceId.f3111b;
                countDownLatch2.countDown();
            }
        });
        countDownLatch.await(30000L, TimeUnit.MILLISECONDS);
        if (task.p()) {
            return task.l();
        }
        if (task.n()) {
            throw new CancellationException("Task is already canceled");
        }
        if (task.o()) {
            throw new IllegalStateException(task.k());
        }
        throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
    }

    public static void c(@NonNull FirebaseApp2 firebaseApp2) {
        firebaseApp2.a();
        AnimatableValueParser.v(firebaseApp2.f.g, "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
        firebaseApp2.a();
        AnimatableValueParser.v(firebaseApp2.f.f1655b, "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
        firebaseApp2.a();
        AnimatableValueParser.v(firebaseApp2.f.a, "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
        firebaseApp2.a();
        AnimatableValueParser.o(firebaseApp2.f.f1655b.contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        firebaseApp2.a();
        AnimatableValueParser.o(c.matcher(firebaseApp2.f.a).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    @NonNull
    @Keep
    public static FirebaseInstanceId getInstance(@NonNull FirebaseApp2 firebaseApp2) {
        c(firebaseApp2);
        firebaseApp2.a();
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) firebaseApp2.g.a(FirebaseInstanceId.class);
        AnimatableValueParser.z(firebaseInstanceId, "Firebase Instance ID component is not present");
        return firebaseInstanceId;
    }

    public static boolean l() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
    }

    public String b() throws IOException {
        String strB = q.b(this.f);
        c(this.f);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        try {
            return ((o) f.k(g(strB, "*"), 30000L, TimeUnit.MILLISECONDS)).a();
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (!(cause instanceof IOException)) {
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new IOException(e);
            }
            if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                synchronized (this) {
                    f3111b.c();
                }
            }
            throw ((IOException) cause);
        }
    }

    public void d(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (d == null) {
                d = new ScheduledThreadPoolExecutor(1, new a("FirebaseInstanceId"));
            }
            d.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    public String e() {
        try {
            w wVar = f3111b;
            String strC = this.f.c();
            synchronized (wVar) {
                wVar.c.put(strC, Long.valueOf(wVar.d(strC)));
            }
            return (String) a(this.j.getId());
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    @NonNull
    @Deprecated
    public Task<o> f() {
        c(this.f);
        return g(q.b(this.f), "*");
    }

    public final Task<o> g(final String str, final String str2) {
        if (str2.isEmpty() || str2.equalsIgnoreCase("fcm") || str2.equalsIgnoreCase("gcm")) {
            str2 = "*";
        }
        return f.Z(null).j(this.e, new b.i.a.f.n.a(this, str, str2) { // from class: b.i.c.s.i
            public final FirebaseInstanceId a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f1767b;
            public final String c;

            {
                this.a = this;
                this.f1767b = str;
                this.c = str2;
            }

            @Override // b.i.a.f.n.a
            public final Object a(Task task) {
                return this.a.m(this.f1767b, this.c);
            }
        });
    }

    public final String h() {
        FirebaseApp2 firebaseApp2 = this.f;
        firebaseApp2.a();
        return "[DEFAULT]".equals(firebaseApp2.e) ? "" : this.f.c();
    }

    @Nullable
    @Deprecated
    public String i() {
        c(this.f);
        w.a aVarJ = j();
        if (p(aVarJ)) {
            synchronized (this) {
                if (!this.k) {
                    o(0L);
                }
            }
        }
        int i = w.a.f1776b;
        if (aVarJ == null) {
            return null;
        }
        return aVarJ.c;
    }

    @Nullable
    public w.a j() {
        return k(q.b(this.f), "*");
    }

    @Nullable
    public w.a k(String str, String str2) {
        w.a aVarB;
        w wVar = f3111b;
        String strH = h();
        synchronized (wVar) {
            aVarB = w.a.b(wVar.a.getString(wVar.b(strH, str, str2), null));
        }
        return aVarB;
    }

    public final Task m(final String str, final String str2) throws Exception {
        Task<o> taskJ;
        final String strE = e();
        w.a aVarK = k(str, str2);
        if (!p(aVarK)) {
            return f.Z(new p(strE, aVarK.c));
        }
        final u uVar = this.i;
        synchronized (uVar) {
            final Pair<String, String> pair = new Pair<>(str, str2);
            taskJ = uVar.f1773b.get(pair);
            if (taskJ == null) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String strValueOf = String.valueOf(pair);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
                    sb.append("Making new request for: ");
                    sb.append(strValueOf);
                    Log.d("FirebaseInstanceId", sb.toString());
                }
                n nVar = this.h;
                Objects.requireNonNull(nVar);
                taskJ = nVar.a(nVar.b(strE, str, str2, new Bundle())).r(this.e, new b.i.a.f.n.f(this, str, str2, strE) { // from class: b.i.c.s.l
                    public final FirebaseInstanceId a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final String f1768b;
                    public final String c;
                    public final String d;

                    {
                        this.a = this;
                        this.f1768b = str;
                        this.c = str2;
                        this.d = strE;
                    }

                    @Override // b.i.a.f.n.f
                    public final Task a(Object obj) {
                        FirebaseInstanceId firebaseInstanceId = this.a;
                        String str3 = this.f1768b;
                        String str4 = this.c;
                        String str5 = this.d;
                        String str6 = (String) obj;
                        w wVar = FirebaseInstanceId.f3111b;
                        String strH = firebaseInstanceId.h();
                        String strA = firebaseInstanceId.g.a();
                        synchronized (wVar) {
                            String strA2 = w.a.a(str6, strA, System.currentTimeMillis());
                            if (strA2 != null) {
                                SharedPreferences.Editor editorEdit = wVar.a.edit();
                                editorEdit.putString(wVar.b(strH, str3, str4), strA2);
                                editorEdit.commit();
                            }
                        }
                        return b.i.a.f.e.o.f.Z(new p(str5, str6));
                    }
                }).j(uVar.a, new b.i.a.f.n.a(uVar, pair) { // from class: b.i.c.s.t
                    public final u a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final Pair f1772b;

                    {
                        this.a = uVar;
                        this.f1772b = pair;
                    }

                    @Override // b.i.a.f.n.a
                    public final Object a(Task task) {
                        u uVar2 = this.a;
                        Pair pair2 = this.f1772b;
                        synchronized (uVar2) {
                            uVar2.f1773b.remove(pair2);
                        }
                        return task;
                    }
                });
                uVar.f1773b.put(pair, taskJ);
            } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf2 = String.valueOf(pair);
                StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 29);
                sb2.append("Joining ongoing request for: ");
                sb2.append(strValueOf2);
                Log.d("FirebaseInstanceId", sb2.toString());
            }
        }
        return taskJ;
    }

    public synchronized void n(boolean z2) {
        this.k = z2;
    }

    public synchronized void o(long j) {
        d(new x(this, Math.min(Math.max(30L, j << 1), a)), j);
        this.k = true;
    }

    public boolean p(@Nullable w.a aVar) {
        if (aVar != null) {
            if (!(System.currentTimeMillis() > aVar.e + w.a.a || !this.g.a().equals(aVar.d))) {
                return false;
            }
        }
        return true;
    }
}
