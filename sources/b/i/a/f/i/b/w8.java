package b.i.a.f.i.b;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;
import b.i.a.f.h.l.bc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class w8 extends a5 {
    public Handler c;
    public final f9 d;
    public final d9 e;
    public final x8 f;

    public w8(u4 u4Var) {
        super(u4Var);
        this.d = new f9(this);
        this.e = new d9(this);
        this.f = new x8(this);
    }

    @Override // b.i.a.f.i.b.a5
    public final boolean v() {
        return false;
    }

    public final boolean w(boolean z2, boolean z3, long j) {
        return this.e.a(z2, z3, j);
    }

    @WorkerThread
    public final void x() {
        b();
        if (this.c == null) {
            this.c = new bc(Looper.getMainLooper());
        }
    }
}
