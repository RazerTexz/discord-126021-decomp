package b.i.a.f.i.b;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzn;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class h8 implements Runnable {
    public final /* synthetic */ AtomicReference j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;
    public final /* synthetic */ String m;
    public final /* synthetic */ boolean n;
    public final /* synthetic */ zzn o;
    public final /* synthetic */ q7 p;

    public h8(q7 q7Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z2, zzn zznVar) {
        this.p = q7Var;
        this.j = atomicReference;
        this.k = str;
        this.l = str2;
        this.m = str3;
        this.n = z2;
        this.o = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.j) {
            try {
                try {
                    q7 q7Var = this.p;
                    i3 i3Var = q7Var.d;
                    if (i3Var == null) {
                        q7Var.g().f.d("(legacy) Failed to get user properties; not connected to service", q3.s(this.k), this.l, this.m);
                        this.j.set(Collections.emptyList());
                        this.j.notify();
                    } else {
                        if (TextUtils.isEmpty(this.k)) {
                            this.j.set(i3Var.R(this.l, this.m, this.n, this.o));
                        } else {
                            this.j.set(i3Var.u(this.k, this.l, this.m, this.n));
                        }
                        this.p.F();
                        this.j.notify();
                    }
                } catch (RemoteException e) {
                    this.p.g().f.d("(legacy) Failed to get user properties; remote exception", q3.s(this.k), this.l, e);
                    this.j.set(Collections.emptyList());
                    this.j.notify();
                }
            } catch (Throwable th) {
                this.j.notify();
                throw th;
            }
        }
    }
}
