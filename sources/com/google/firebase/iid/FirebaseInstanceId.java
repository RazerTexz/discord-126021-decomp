package com.google.firebase.iid;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.a.f.e.o.f;
import b.i.c.c;
import b.i.c.r.d;
import b.i.c.s.i;
import b.i.c.s.j;
import b.i.c.s.k;
import b.i.c.s.l;
import b.i.c.s.n;
import b.i.c.s.o;
import b.i.c.s.p;
import b.i.c.s.q;
import b.i.c.s.t;
import b.i.c.s.u;
import b.i.c.s.w;
import b.i.c.s.w$a;
import b.i.c.s.x;
import b.i.c.t.a;
import b.i.c.u.g;
import b.i.c.x.h;
import com.google.android.gms.tasks.Task;
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
    public final c f;
    public final q g;
    public final n h;
    public final u i;
    public final g j;
    public boolean k;
    public static final long a = TimeUnit.HOURS.toSeconds(8);
    public static final Pattern c = Pattern.compile("\\AA[\\w-]{38}\\z");

    public FirebaseInstanceId(c cVar, a<h> aVar, a<d> aVar2, g gVar) {
        cVar.a();
        q qVar = new q(cVar.d);
        ExecutorService executorServiceA = b.i.c.s.h.a();
        ExecutorService executorServiceA2 = b.i.c.s.h.a();
        this.k = false;
        if (q.b(cVar) == null) {
            throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
        }
        synchronized (FirebaseInstanceId.class) {
            if (f3111b == null) {
                cVar.a();
                f3111b = new w(cVar.d);
            }
        }
        this.f = cVar;
        this.g = qVar;
        this.h = new n(cVar, qVar, aVar, aVar2, gVar);
        this.e = executorServiceA2;
        this.i = new u(executorServiceA);
        this.j = gVar;
    }

    public static <T> T a(@NonNull Task<T> task) throws InterruptedException {
        b.c.a.a0.d.z(task, "Task must not be null");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        task.c(j.j, new k(countDownLatch));
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

    public static void c(@NonNull c cVar) {
        cVar.a();
        b.c.a.a0.d.v(cVar.f.g, "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
        cVar.a();
        b.c.a.a0.d.v(cVar.f.f1655b, "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
        cVar.a();
        b.c.a.a0.d.v(cVar.f.a, "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
        cVar.a();
        b.c.a.a0.d.o(cVar.f.f1655b.contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        cVar.a();
        b.c.a.a0.d.o(c.matcher(cVar.f.a).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    @NonNull
    @Keep
    public static FirebaseInstanceId getInstance(@NonNull c cVar) {
        c(cVar);
        cVar.a();
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) cVar.g.a(FirebaseInstanceId.class);
        b.c.a.a0.d.z(firebaseInstanceId, "Firebase Instance ID component is not present");
        return firebaseInstanceId;
    }

    public static boolean l() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            return true;
        }
        return Build$VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
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
                d = new ScheduledThreadPoolExecutor(1, new b.i.a.f.e.o.j.a("FirebaseInstanceId"));
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

    public final Task<o> g(String str, String str2) {
        if (str2.isEmpty() || str2.equalsIgnoreCase("fcm") || str2.equalsIgnoreCase("gcm")) {
            str2 = "*";
        }
        return f.Z(null).j(this.e, new i(this, str, str2));
    }

    public final String h() {
        c cVar = this.f;
        cVar.a();
        return "[DEFAULT]".equals(cVar.e) ? "" : this.f.c();
    }

    @Nullable
    @Deprecated
    public String i() {
        c(this.f);
        w$a w_aJ = j();
        if (p(w_aJ)) {
            synchronized (this) {
                if (!this.k) {
                    o(0L);
                }
            }
        }
        int i = w$a.f1776b;
        if (w_aJ == null) {
            return null;
        }
        return w_aJ.c;
    }

    @Nullable
    public w$a j() {
        return k(q.b(this.f), "*");
    }

    @Nullable
    public w$a k(String str, String str2) {
        w$a w_aB;
        w wVar = f3111b;
        String strH = h();
        synchronized (wVar) {
            w_aB = w$a.b(wVar.a.getString(wVar.b(strH, str, str2), null));
        }
        return w_aB;
    }

    public final Task m(String str, String str2) throws Exception {
        Task<o> taskJ;
        String strE = e();
        w$a w_aK = k(str, str2);
        if (!p(w_aK)) {
            return f.Z(new p(strE, w_aK.c));
        }
        u uVar = this.i;
        synchronized (uVar) {
            Pair<String, String> pair = new Pair<>(str, str2);
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
                taskJ = nVar.a(nVar.b(strE, str, str2, new Bundle())).r(this.e, new l(this, str, str2, strE)).j(uVar.a, new t(uVar, pair));
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

    public boolean p(@Nullable w$a w_a) {
        if (w_a != null) {
            if (!(System.currentTimeMillis() > w_a.e + w$a.a || !this.g.a().equals(w_a.d))) {
                return false;
            }
        }
        return true;
    }
}
