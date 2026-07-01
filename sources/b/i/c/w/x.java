package b.i.c.w;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.iid.FirebaseInstanceId;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class x implements Callable {
    public final Context j;
    public final ScheduledExecutorService k;
    public final FirebaseInstanceId l;
    public final b.i.c.s.q m;
    public final b.i.c.s.n n;

    public x(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseInstanceId firebaseInstanceId, b.i.c.s.q qVar, b.i.c.s.n nVar) {
        this.j = context;
        this.k = scheduledExecutorService;
        this.l = firebaseInstanceId;
        this.m = qVar;
        this.n = nVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        w wVar;
        Context context = this.j;
        ScheduledExecutorService scheduledExecutorService = this.k;
        FirebaseInstanceId firebaseInstanceId = this.l;
        b.i.c.s.q qVar = this.m;
        b.i.c.s.n nVar = this.n;
        synchronized (w.class) {
            WeakReference<w> weakReference = w.a;
            wVar = weakReference != null ? weakReference.get() : null;
            if (wVar == null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
                w wVar2 = new w(sharedPreferences, scheduledExecutorService);
                synchronized (wVar2) {
                    wVar2.c = u.a(sharedPreferences, "topic_operation_queue", ",", scheduledExecutorService);
                }
                w.a = new WeakReference<>(wVar2);
                wVar = wVar2;
            }
        }
        return new y(firebaseInstanceId, qVar, wVar, nVar, context, scheduledExecutorService);
    }
}
