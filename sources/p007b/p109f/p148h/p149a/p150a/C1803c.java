package p007b.p109f.p148h.p149a.p150a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import p007b.p109f.p115d.p126k.InterfaceC1714b;
import p007b.p109f.p148h.p149a.p150a.InterfaceC1801a;

/* JADX INFO: renamed from: b.f.h.a.a.c */
/* JADX INFO: compiled from: AnimationBackendDelegateWithInactivityCheck.java */
/* JADX INFO: loaded from: classes.dex */
public class C1803c<T extends InterfaceC1801a> extends C1802b<T> {

    /* JADX INFO: renamed from: b */
    public final InterfaceC1714b f3489b;

    /* JADX INFO: renamed from: c */
    public final ScheduledExecutorService f3490c;

    /* JADX INFO: renamed from: d */
    public boolean f3491d;

    /* JADX INFO: renamed from: e */
    public long f3492e;

    /* JADX INFO: renamed from: f */
    public b f3493f;

    /* JADX INFO: renamed from: g */
    public final Runnable f3494g;

    /* JADX INFO: renamed from: b.f.h.a.a.c$a */
    /* JADX INFO: compiled from: AnimationBackendDelegateWithInactivityCheck.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (C1803c.this) {
                C1803c c1803c = C1803c.this;
                c1803c.f3491d = false;
                if (c1803c.f3489b.now() - c1803c.f3492e > 2000) {
                    b bVar = C1803c.this.f3493f;
                    if (bVar != null) {
                        bVar.mo1146c();
                    }
                } else {
                    C1803c.this.m1145c();
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.f.h.a.a.c$b */
    /* JADX INFO: compiled from: AnimationBackendDelegateWithInactivityCheck.java */
    public interface b {
        /* JADX INFO: renamed from: c */
        void mo1146c();
    }

    public C1803c(T t, b bVar, InterfaceC1714b interfaceC1714b, ScheduledExecutorService scheduledExecutorService) {
        super(t);
        this.f3491d = false;
        this.f3494g = new a();
        this.f3493f = bVar;
        this.f3489b = interfaceC1714b;
        this.f3490c = scheduledExecutorService;
    }

    /* JADX INFO: renamed from: c */
    public final synchronized void m1145c() {
        if (!this.f3491d) {
            this.f3491d = true;
            this.f3490c.schedule(this.f3494g, 1000L, TimeUnit.MILLISECONDS);
        }
    }

    @Override // p007b.p109f.p148h.p149a.p150a.C1802b, p007b.p109f.p148h.p149a.p150a.InterfaceC1801a
    /* JADX INFO: renamed from: j */
    public boolean mo1141j(Drawable drawable, Canvas canvas, int i) {
        this.f3492e = this.f3489b.now();
        boolean zMo1141j = super.mo1141j(drawable, canvas, i);
        m1145c();
        return zMo1141j;
    }
}
