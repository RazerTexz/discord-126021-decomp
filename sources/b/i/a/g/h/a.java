package b.i.a.g.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SnackbarManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Object f1624b = new Object();

    @NonNull
    public final Handler c = new Handler(Looper.getMainLooper(), new a$a(this));

    @Nullable
    public a$c d;

    @Nullable
    public a$c e;

    public static a b() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public final boolean a(@NonNull a$c a_c, int i) {
        a$b a_b = a_c.a.get();
        if (a_b == null) {
            return false;
        }
        this.c.removeCallbacksAndMessages(a_c);
        a_b.a(i);
        return true;
    }

    public final boolean c(a$b a_b) {
        a$c a_c = this.d;
        if (a_c != null) {
            return a_b != null && a_c.a.get() == a_b;
        }
        return false;
    }

    public final boolean d(a$b a_b) {
        a$c a_c = this.e;
        if (a_c != null) {
            return a_b != null && a_c.a.get() == a_b;
        }
        return false;
    }

    public void e(a$b a_b) {
        synchronized (this.f1624b) {
            if (c(a_b)) {
                a$c a_c = this.d;
                if (!a_c.c) {
                    a_c.c = true;
                    this.c.removeCallbacksAndMessages(a_c);
                }
            }
        }
    }

    public void f(a$b a_b) {
        synchronized (this.f1624b) {
            if (c(a_b)) {
                a$c a_c = this.d;
                if (a_c.c) {
                    a_c.c = false;
                    g(a_c);
                }
            }
        }
    }

    public final void g(@NonNull a$c a_c) {
        int i = a_c.f1625b;
        if (i == -2) {
            return;
        }
        if (i <= 0) {
            i = i == -1 ? 1500 : 2750;
        }
        this.c.removeCallbacksAndMessages(a_c);
        Handler handler = this.c;
        handler.sendMessageDelayed(Message.obtain(handler, 0, a_c), i);
    }

    public final void h() {
        a$c a_c = this.e;
        if (a_c != null) {
            this.d = a_c;
            this.e = null;
            a$b a_b = a_c.a.get();
            if (a_b != null) {
                a_b.show();
            } else {
                this.d = null;
            }
        }
    }
}
