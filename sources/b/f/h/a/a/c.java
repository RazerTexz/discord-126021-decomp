package b.f.h.a.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import b.f.h.a.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: AnimationBackendDelegateWithInactivityCheck.java */
/* JADX INFO: loaded from: classes.dex */
public class c<T extends a> extends b<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.d.k.b f525b;
    public final ScheduledExecutorService c;
    public boolean d;
    public long e;
    public c$b f;
    public final Runnable g;

    public c(T t, c$b c_b, b.f.d.k.b bVar, ScheduledExecutorService scheduledExecutorService) {
        super(t);
        this.d = false;
        this.g = new c$a(this);
        this.f = c_b;
        this.f525b = bVar;
        this.c = scheduledExecutorService;
    }

    public final synchronized void c() {
        if (!this.d) {
            this.d = true;
            this.c.schedule(this.g, 1000L, TimeUnit.MILLISECONDS);
        }
    }

    @Override // b.f.h.a.a.b, b.f.h.a.a.a
    public boolean j(Drawable drawable, Canvas canvas, int i) {
        this.e = this.f525b.now();
        boolean zJ = super.j(drawable, canvas, i);
        c();
        return zJ;
    }
}
