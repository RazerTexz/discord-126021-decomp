package b.i.a.c.w2;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.f3.Util2;
import b.i.a.c.w2.DrmSessionEventListener;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: b.i.a.c.w2.s, reason: use source file name */
/* JADX INFO: compiled from: DrmSessionEventListener.java */
/* JADX INFO: loaded from: classes3.dex */
public interface DrmSessionEventListener {
    void J(int i, @Nullable MediaSource2.a aVar);

    void S(int i, @Nullable MediaSource2.a aVar);

    void c0(int i, @Nullable MediaSource2.a aVar, int i2);

    void d0(int i, @Nullable MediaSource2.a aVar);

    void i0(int i, @Nullable MediaSource2.a aVar);

    void u(int i, @Nullable MediaSource2.a aVar, Exception exc);

    /* JADX INFO: renamed from: b.i.a.c.w2.s$a */
    /* JADX INFO: compiled from: DrmSessionEventListener.java */
    public static class a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final MediaSource2.a f1156b;
        public final CopyOnWriteArrayList<C0031a> c;

        /* JADX INFO: renamed from: b.i.a.c.w2.s$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DrmSessionEventListener.java */
        public static final class C0031a {
            public Handler a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public DrmSessionEventListener f1157b;

            public C0031a(Handler handler, DrmSessionEventListener drmSessionEventListener) {
                this.a = handler;
                this.f1157b = drmSessionEventListener;
            }
        }

        public a() {
            this.c = new CopyOnWriteArrayList<>();
            this.a = 0;
            this.f1156b = null;
        }

        public void a() {
            for (C0031a c0031a : this.c) {
                final DrmSessionEventListener drmSessionEventListener = c0031a.f1157b;
                Util2.E(c0031a.a, new Runnable() { // from class: b.i.a.c.w2.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrmSessionEventListener.a aVar = this.j;
                        drmSessionEventListener.S(aVar.a, aVar.f1156b);
                    }
                });
            }
        }

        public void b() {
            for (C0031a c0031a : this.c) {
                final DrmSessionEventListener drmSessionEventListener = c0031a.f1157b;
                Util2.E(c0031a.a, new Runnable() { // from class: b.i.a.c.w2.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrmSessionEventListener.a aVar = this.j;
                        drmSessionEventListener.J(aVar.a, aVar.f1156b);
                    }
                });
            }
        }

        public void c() {
            for (C0031a c0031a : this.c) {
                final DrmSessionEventListener drmSessionEventListener = c0031a.f1157b;
                Util2.E(c0031a.a, new Runnable() { // from class: b.i.a.c.w2.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrmSessionEventListener.a aVar = this.j;
                        drmSessionEventListener.i0(aVar.a, aVar.f1156b);
                    }
                });
            }
        }

        public void d(final int i) {
            for (C0031a c0031a : this.c) {
                final DrmSessionEventListener drmSessionEventListener = c0031a.f1157b;
                Util2.E(c0031a.a, new Runnable() { // from class: b.i.a.c.w2.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrmSessionEventListener.a aVar = this.j;
                        DrmSessionEventListener drmSessionEventListener2 = drmSessionEventListener;
                        int i2 = i;
                        Objects.requireNonNull(aVar);
                        Objects.requireNonNull(drmSessionEventListener2);
                        drmSessionEventListener2.c0(aVar.a, aVar.f1156b, i2);
                    }
                });
            }
        }

        public void e(final Exception exc) {
            for (C0031a c0031a : this.c) {
                final DrmSessionEventListener drmSessionEventListener = c0031a.f1157b;
                Util2.E(c0031a.a, new Runnable() { // from class: b.i.a.c.w2.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrmSessionEventListener.a aVar = this.j;
                        drmSessionEventListener.u(aVar.a, aVar.f1156b, exc);
                    }
                });
            }
        }

        public void f() {
            for (C0031a c0031a : this.c) {
                final DrmSessionEventListener drmSessionEventListener = c0031a.f1157b;
                Util2.E(c0031a.a, new Runnable() { // from class: b.i.a.c.w2.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrmSessionEventListener.a aVar = this.j;
                        drmSessionEventListener.d0(aVar.a, aVar.f1156b);
                    }
                });
            }
        }

        @CheckResult
        public a g(int i, @Nullable MediaSource2.a aVar) {
            return new a(this.c, i, aVar);
        }

        public a(CopyOnWriteArrayList<C0031a> copyOnWriteArrayList, int i, @Nullable MediaSource2.a aVar) {
            this.c = copyOnWriteArrayList;
            this.a = i;
            this.f1156b = aVar;
        }
    }
}
