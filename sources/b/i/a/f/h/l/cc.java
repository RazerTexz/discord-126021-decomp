package b.i.a.f.h.l;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class cc extends ic {
    public final AtomicReference<Bundle> a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1439b;

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0002, code lost:
    
        r4 = r4.get("r");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T g(Bundle bundle, Class<T> cls) {
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

    @Override // b.i.a.f.h.l.fc
    public final void f(Bundle bundle) {
        synchronized (this.a) {
            try {
                this.a.set(bundle);
                this.f1439b = true;
                this.a.notify();
            } catch (Throwable th) {
                this.a.notify();
                throw th;
            }
        }
    }

    public final String i(long j) {
        return (String) g(t0(j), String.class);
    }

    public final Bundle t0(long j) {
        Bundle bundle;
        synchronized (this.a) {
            if (!this.f1439b) {
                try {
                    this.a.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = this.a.get();
        }
        return bundle;
    }
}
