package b.i.a.f.i.b;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import b.i.a.f.i.b.t8;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class p8<T extends Context & t8> {
    public final T a;

    public p8(T t) {
        this.a = t;
    }

    @MainThread
    public final boolean a(Intent intent) {
        if (intent == null) {
            b().f.a("onUnbind called with null intent");
            return true;
        }
        b().n.b("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final q3 b() {
        return u4.b(this.a, null, null).g();
    }

    @MainThread
    public final void c(Intent intent) {
        if (intent == null) {
            b().f.a("onRebind called with null intent");
        } else {
            b().n.b("onRebind called. action", intent.getAction());
        }
    }
}
