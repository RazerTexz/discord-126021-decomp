package b.i.a.f.i.b;

import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class c9 extends i {
    public final /* synthetic */ d9 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c9(d9 d9Var, t5 t5Var) {
        super(t5Var);
        this.e = d9Var;
    }

    @Override // b.i.a.f.i.b.i
    @WorkerThread
    public final void a() {
        d9 d9Var = this.e;
        d9Var.d.b();
        Objects.requireNonNull((b.i.a.f.e.o.c) d9Var.d.a.o);
        d9Var.a(false, false, SystemClock.elapsedRealtime());
        a aVarM = d9Var.d.m();
        Objects.requireNonNull((b.i.a.f.e.o.c) d9Var.d.a.o);
        aVarM.t(SystemClock.elapsedRealtime());
    }
}
