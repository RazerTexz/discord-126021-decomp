package b.i.a.f.e.h.j;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.a.f.e.h.a;
import b.i.a.f.e.h.j.g;
import b.i.a.f.e.h.j.k;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class p0 extends e0<Boolean> {
    public final k.a<?> c;

    public p0(k.a<?> aVar, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.c = aVar;
    }

    @Override // b.i.a.f.e.h.j.s
    public final /* bridge */ /* synthetic */ void d(@NonNull x0 x0Var, boolean z2) {
    }

    @Override // b.i.a.f.e.h.j.m0
    @Nullable
    public final Feature[] f(g.a<?> aVar) {
        d0 d0Var = aVar.g.get(this.c);
        if (d0Var == null) {
            return null;
        }
        Objects.requireNonNull(d0Var.a);
        return null;
    }

    @Override // b.i.a.f.e.h.j.m0
    public final boolean g(g.a<?> aVar) {
        d0 d0Var = aVar.g.get(this.c);
        if (d0Var == null) {
            return false;
        }
        Objects.requireNonNull(d0Var.a);
        return false;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // b.i.a.f.e.h.j.e0
    public final void h(g.a<?> aVar) throws RemoteException {
        d0 d0VarRemove = aVar.g.remove(this.c);
        if (d0VarRemove == null) {
            this.f1357b.b((T) Boolean.FALSE);
            return;
        }
        q<a.b, ?> qVar = d0VarRemove.f1356b;
        a.f fVar = aVar.f1361b;
        TaskCompletionSource<T> taskCompletionSource = this.f1357b;
        b.i.a.f.j.b.e.x xVar = (b.i.a.f.j.b.e.x) qVar;
        Objects.requireNonNull(xVar);
        xVar.f1587b.a((b.i.a.f.j.b.e.f) fVar, b.i.a.f.j.b.e.i.j(xVar.c, taskCompletionSource));
        k<?> kVar = d0VarRemove.a.a;
        kVar.f1366b = null;
        kVar.c = null;
    }
}
