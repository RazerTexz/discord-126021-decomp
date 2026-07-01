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
public final class n0 extends e0<Void> {
    public final d0 c;

    public n0(d0 d0Var, TaskCompletionSource<Void> taskCompletionSource) {
        super(3, taskCompletionSource);
        this.c = d0Var;
    }

    @Override // b.i.a.f.e.h.j.s
    public final /* bridge */ /* synthetic */ void d(@NonNull x0 x0Var, boolean z2) {
    }

    @Override // b.i.a.f.e.h.j.m0
    @Nullable
    public final Feature[] f(g.a<?> aVar) {
        Objects.requireNonNull(this.c.a);
        return null;
    }

    @Override // b.i.a.f.e.h.j.m0
    public final boolean g(g.a<?> aVar) {
        Objects.requireNonNull(this.c.a);
        return false;
    }

    @Override // b.i.a.f.e.h.j.e0
    public final void h(g.a<?> aVar) throws RemoteException {
        m<a.b, ?> mVar = this.c.a;
        a.f fVar = aVar.f1361b;
        TaskCompletionSource<T> taskCompletionSource = this.f1357b;
        b.i.a.f.j.b.e.v vVar = (b.i.a.f.j.b.e.v) mVar;
        Objects.requireNonNull(vVar);
        vVar.f1586b.a((b.i.a.f.j.b.e.f) fVar, b.i.a.f.j.b.e.i.j(vVar.c, taskCompletionSource));
        k.a<?> aVar2 = this.c.a.a.c;
        if (aVar2 != null) {
            aVar.g.put(aVar2, this.c);
        }
    }
}
