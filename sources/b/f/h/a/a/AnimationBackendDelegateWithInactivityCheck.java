package b.f.h.a.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import b.f.d.k.MonotonicClock;
import b.f.h.a.a.AnimationBackend;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: b.f.h.a.a.c, reason: use source file name */
/* JADX INFO: compiled from: AnimationBackendDelegateWithInactivityCheck.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimationBackendDelegateWithInactivityCheck<T extends AnimationBackend> extends AnimationBackendDelegate<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MonotonicClock f525b;
    public final ScheduledExecutorService c;
    public boolean d;
    public long e;
    public b f;
    public final Runnable g;

    /* JADX INFO: renamed from: b.f.h.a.a.c$a */
    /* JADX INFO: compiled from: AnimationBackendDelegateWithInactivityCheck.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (AnimationBackendDelegateWithInactivityCheck.this) {
                AnimationBackendDelegateWithInactivityCheck animationBackendDelegateWithInactivityCheck = AnimationBackendDelegateWithInactivityCheck.this;
                animationBackendDelegateWithInactivityCheck.d = false;
                if (animationBackendDelegateWithInactivityCheck.f525b.now() - animationBackendDelegateWithInactivityCheck.e > 2000) {
                    b bVar = AnimationBackendDelegateWithInactivityCheck.this.f;
                    if (bVar != null) {
                        bVar.c();
                    }
                } else {
                    AnimationBackendDelegateWithInactivityCheck.this.c();
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.f.h.a.a.c$b */
    /* JADX INFO: compiled from: AnimationBackendDelegateWithInactivityCheck.java */
    public interface b {
        void c();
    }

    public AnimationBackendDelegateWithInactivityCheck(T t, b bVar, MonotonicClock monotonicClock, ScheduledExecutorService scheduledExecutorService) {
        super(t);
        this.d = false;
        this.g = new a();
        this.f = bVar;
        this.f525b = monotonicClock;
        this.c = scheduledExecutorService;
    }

    public final synchronized void c() {
        if (!this.d) {
            this.d = true;
            this.c.schedule(this.g, 1000L, TimeUnit.MILLISECONDS);
        }
    }

    @Override // b.f.h.a.a.AnimationBackendDelegate, b.f.h.a.a.AnimationBackend
    public boolean j(Drawable drawable, Canvas canvas, int i) {
        this.e = this.f525b.now();
        boolean zJ = super.j(drawable, canvas, i);
        c();
        return zJ;
    }
}
