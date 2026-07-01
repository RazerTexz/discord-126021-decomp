package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.i.a.b.g;
import b.i.a.f.e.o.f;
import b.i.a.f.n.c0;
import b.i.a.f.n.v;
import b.i.c.c;
import b.i.c.r.d;
import b.i.c.s.n;
import b.i.c.s.q;
import b.i.c.t.a;
import b.i.c.w.x;
import b.i.c.w.y;
import b.i.c.x.h;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class FirebaseMessaging {

    @Nullable
    @SuppressLint({"FirebaseUnknownNullness"})
    @VisibleForTesting
    public static g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f3112b;
    public final c c;
    public final FirebaseInstanceId d;
    public final FirebaseMessaging$a e;
    public final Executor f;
    public final Task<y> g;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public FirebaseMessaging(c cVar, FirebaseInstanceId firebaseInstanceId, a<h> aVar, a<d> aVar2, b.i.c.u.g gVar, @Nullable g gVar2, b.i.c.q.d dVar) {
        try {
            Class.forName("com.google.firebase.iid.FirebaseInstanceIdReceiver");
            a = gVar2;
            this.c = cVar;
            this.d = firebaseInstanceId;
            this.e = new FirebaseMessaging$a(this, dVar);
            cVar.a();
            Context context = cVar.d;
            this.f3112b = context;
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new b.i.a.f.e.o.j.a("Firebase-Messaging-Init"));
            this.f = scheduledThreadPoolExecutor;
            scheduledThreadPoolExecutor.execute(new b.i.c.w.g(this, firebaseInstanceId));
            q qVar = new q(context);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(1, new b.i.a.f.e.o.j.a("Firebase-Messaging-Topics-Io"));
            int i = y.f1800b;
            Task<y> taskO = f.o(scheduledThreadPoolExecutor2, new x(context, scheduledThreadPoolExecutor2, firebaseInstanceId, qVar, new n(cVar, qVar, aVar, aVar2, gVar)));
            this.g = taskO;
            c0 c0Var = (c0) taskO;
            c0Var.f1592b.a(new v(new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b.i.a.f.e.o.j.a("Firebase-Messaging-Trigger-Topics-Io")), new b.i.c.w.h(this)));
            c0Var.w();
        } catch (ClassNotFoundException unused) {
            throw new IllegalStateException("FirebaseMessaging and FirebaseInstanceId versions not compatible. Update to latest version of firebase-messaging.");
        }
    }

    @NonNull
    @Keep
    public static synchronized FirebaseMessaging getInstance(@NonNull c cVar) {
        FirebaseMessaging firebaseMessaging;
        cVar.a();
        firebaseMessaging = (FirebaseMessaging) cVar.g.a(FirebaseMessaging.class);
        b.c.a.a0.d.z(firebaseMessaging, "Firebase Messaging component is not present");
        return firebaseMessaging;
    }
}
