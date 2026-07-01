package b.i.a.f.b;

import android.annotation.SuppressLint;
import android.content.Context;
import b.i.a.f.h.j.f1;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"StaticFieldLeak"})
public final class f {
    public static volatile f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1331b;
    public final f$a c;
    public volatile f1 d;
    public Thread$UncaughtExceptionHandler e;

    public f(Context context) {
        Context applicationContext = context.getApplicationContext();
        Objects.requireNonNull(applicationContext, "null reference");
        this.f1331b = applicationContext;
        this.c = new f$a(this);
        new CopyOnWriteArrayList();
        new d();
    }

    public static void b() {
        if (!(Thread.currentThread() instanceof f$c)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final void a(Runnable runnable) {
        this.c.submit(runnable);
    }
}
