package b.i.a.g.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: b.i.a.g.h.a, reason: use source file name */
/* JADX INFO: compiled from: SnackbarManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class SnackbarManager {
    public static SnackbarManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Object f1624b = new Object();

    @NonNull
    public final Handler c = new Handler(Looper.getMainLooper(), new a());

    @Nullable
    public c d;

    @Nullable
    public c e;

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
            SnackbarManager snackbarManager = SnackbarManager.this;
            c cVar = (c) message.obj;
            synchronized (snackbarManager.f1624b) {
                if (snackbarManager.d == cVar || snackbarManager.e == cVar) {
                    snackbarManager.a(cVar, 2);
                }
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.h.a$b */
    /* JADX INFO: compiled from: SnackbarManager.java */
    public interface b {
        void a(int i);

        void show();
    }

    /* JADX INFO: renamed from: b.i.a.g.h.a$c */
    /* JADX INFO: compiled from: SnackbarManager.java */
    public static class c {

        @NonNull
        public final WeakReference<b> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1625b;
        public boolean c;

        public c(int i, b bVar) {
            this.a = new WeakReference<>(bVar);
            this.f1625b = i;
        }
    }

    public static SnackbarManager b() {
        if (a == null) {
            a = new SnackbarManager();
        }
        return a;
    }

    public final boolean a(@NonNull c cVar, int i) {
        b bVar = cVar.a.get();
        if (bVar == null) {
            return false;
        }
        this.c.removeCallbacksAndMessages(cVar);
        bVar.a(i);
        return true;
    }

    public final boolean c(b bVar) {
        c cVar = this.d;
        if (cVar != null) {
            return bVar != null && cVar.a.get() == bVar;
        }
        return false;
    }

    public final boolean d(b bVar) {
        c cVar = this.e;
        if (cVar != null) {
            return bVar != null && cVar.a.get() == bVar;
        }
        return false;
    }

    public void e(b bVar) {
        synchronized (this.f1624b) {
            if (c(bVar)) {
                c cVar = this.d;
                if (!cVar.c) {
                    cVar.c = true;
                    this.c.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void f(b bVar) {
        synchronized (this.f1624b) {
            if (c(bVar)) {
                c cVar = this.d;
                if (cVar.c) {
                    cVar.c = false;
                    g(cVar);
                }
            }
        }
    }

    public final void g(@NonNull c cVar) {
        int i = cVar.f1625b;
        if (i == -2) {
            return;
        }
        if (i <= 0) {
            i = i == -1 ? 1500 : 2750;
        }
        this.c.removeCallbacksAndMessages(cVar);
        Handler handler = this.c;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i);
    }

    public final void h() {
        c cVar = this.e;
        if (cVar != null) {
            this.d = cVar;
            this.e = null;
            b bVar = cVar.a.get();
            if (bVar != null) {
                bVar.show();
            } else {
                this.d = null;
            }
        }
    }
}
