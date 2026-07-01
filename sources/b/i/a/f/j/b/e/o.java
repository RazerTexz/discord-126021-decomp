package b.i.a.f.j.b.e;

import android.os.IBinder;
import android.os.RemoteException;
import b.i.a.f.e.h.j.k$a;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.messages.internal.zzcb;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class o implements a0 {
    public final b.i.a.f.e.h.j.k a;

    public o(b.i.a.f.e.h.j.k kVar) {
        this.a = kVar;
    }

    @Override // b.i.a.f.j.b.e.a0
    public final void a(f fVar, b.i.a.f.e.h.j.k kVar) throws RemoteException {
        b.i.a.f.e.h.j.k kVar2 = this.a;
        Objects.requireNonNull(fVar);
        b.i.a.f.h.m.j jVar = new b.i.a.f.h.m.j(kVar);
        if (!fVar.A.a(kVar2.c)) {
            jVar.g(new Status(0, null));
            return;
        }
        zzcb zzcbVar = new zzcb(1, jVar, fVar.A.b(kVar2.c), false, null, null);
        zzcbVar.m = false;
        ((u0) fVar.w()).s(zzcbVar);
        b.i.a.f.h.m.o<k$a, IBinder> oVar = fVar.A;
        oVar.a.remove(kVar2.c);
    }
}
