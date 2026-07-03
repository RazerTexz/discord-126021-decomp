package p007b.p225i.p226a.p341g.p349h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: b.i.a.g.h.a */
/* JADX INFO: compiled from: SnackbarManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4427a {

    /* JADX INFO: renamed from: a */
    public static C4427a f11762a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final Object f11763b = new Object();

    /* JADX INFO: renamed from: c */
    @NonNull
    public final Handler f11764c = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: renamed from: d */
    @Nullable
    public c f11765d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public c f11766e;

    /* JADX INFO: renamed from: b.i.a.g.h.a$a */
    /* JADX INFO: compiled from: SnackbarManager.java */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            C4427a c4427a = C4427a.this;
            c cVar = (c) message.obj;
            synchronized (c4427a.f11763b) {
                if (c4427a.f11765d == cVar || c4427a.f11766e == cVar) {
                    c4427a.m6135a(cVar, 2);
                }
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.h.a$b */
    /* JADX INFO: compiled from: SnackbarManager.java */
    public interface b {
        /* JADX INFO: renamed from: a */
        void mo6142a(int i);

        void show();
    }

    /* JADX INFO: renamed from: b.i.a.g.h.a$c */
    /* JADX INFO: compiled from: SnackbarManager.java */
    public static class c {

        /* JADX INFO: renamed from: a */
        @NonNull
        public final WeakReference<b> f11768a;

        /* JADX INFO: renamed from: b */
        public int f11769b;

        /* JADX INFO: renamed from: c */
        public boolean f11770c;

        public c(int i, b bVar) {
            this.f11768a = new WeakReference<>(bVar);
            this.f11769b = i;
        }
    }

    /* JADX INFO: renamed from: b */
    public static C4427a m6134b() {
        if (f11762a == null) {
            f11762a = new C4427a();
        }
        return f11762a;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m6135a(@NonNull c cVar, int i) {
        b bVar = cVar.f11768a.get();
        if (bVar == null) {
            return false;
        }
        this.f11764c.removeCallbacksAndMessages(cVar);
        bVar.mo6142a(i);
        return true;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m6136c(b bVar) {
        c cVar = this.f11765d;
        if (cVar != null) {
            return bVar != null && cVar.f11768a.get() == bVar;
        }
        return false;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m6137d(b bVar) {
        c cVar = this.f11766e;
        if (cVar != null) {
            return bVar != null && cVar.f11768a.get() == bVar;
        }
        return false;
    }

    /* JADX INFO: renamed from: e */
    public void m6138e(b bVar) {
        synchronized (this.f11763b) {
            if (m6136c(bVar)) {
                c cVar = this.f11765d;
                if (!cVar.f11770c) {
                    cVar.f11770c = true;
                    this.f11764c.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public void m6139f(b bVar) {
        synchronized (this.f11763b) {
            if (m6136c(bVar)) {
                c cVar = this.f11765d;
                if (cVar.f11770c) {
                    cVar.f11770c = false;
                    m6140g(cVar);
                }
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m6140g(@NonNull c cVar) {
        int i = cVar.f11769b;
        if (i == -2) {
            return;
        }
        if (i <= 0) {
            i = i == -1 ? 1500 : 2750;
        }
        this.f11764c.removeCallbacksAndMessages(cVar);
        Handler handler = this.f11764c;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i);
    }

    /* JADX INFO: renamed from: h */
    public final void m6141h() {
        c cVar = this.f11766e;
        if (cVar != null) {
            this.f11765d = cVar;
            this.f11766e = null;
            b bVar = cVar.f11768a.get();
            if (bVar != null) {
                bVar.show();
            } else {
                this.f11765d = null;
            }
        }
    }
}
