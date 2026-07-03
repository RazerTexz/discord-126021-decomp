package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.i.a.f.h.l.cc */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class BinderC3618cc extends AbstractBinderC3702ic {

    /* JADX INFO: renamed from: a */
    public final AtomicReference<Bundle> f9888a = new AtomicReference<>();

    /* JADX INFO: renamed from: b */
    public boolean f9889b;

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0002, code lost:
    
        r4 = r4.get("r");
     */
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T m4618g(Bundle bundle, Class<T> cls) {
        Object obj;
        if (bundle == null || obj == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            Log.w("AM", String.format("Unexpected object type. Expected, Received".concat(": %s, %s"), cls.getCanonicalName(), obj.getClass().getCanonicalName()), e);
            throw e;
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3660fc
    /* JADX INFO: renamed from: f */
    public final void mo4619f(Bundle bundle) {
        synchronized (this.f9888a) {
            try {
                this.f9888a.set(bundle);
                this.f9889b = true;
                this.f9888a.notify();
            } catch (Throwable th) {
                this.f9888a.notify();
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: i */
    public final String m4620i(long j) {
        return (String) m4618g(m4621t0(j), String.class);
    }

    /* JADX INFO: renamed from: t0 */
    public final Bundle m4621t0(long j) {
        Bundle bundle;
        synchronized (this.f9888a) {
            if (!this.f9889b) {
                try {
                    this.f9888a.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = this.f9888a.get();
        }
        return bundle;
    }
}
