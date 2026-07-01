package b.i.a.f.j.b.e;

import android.os.IBinder;
import android.os.RemoteException;
import b.i.a.f.e.h.j.k$a;
import com.google.android.gms.nearby.messages.internal.zzcb;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n implements a0 {
    public final b.i.a.f.e.h.j.k a;

    public n(b.i.a.f.e.h.j.k kVar) {
        this.a = kVar;
    }

    @Override // b.i.a.f.j.b.e.a0
    public final void a(f fVar, b.i.a.f.e.h.j.k kVar) throws RemoteException {
        b.i.a.f.e.h.j.k kVar2 = this.a;
        if (!fVar.A.a(kVar2.c)) {
            b.i.a.f.h.m.o<k$a, IBinder> oVar = fVar.A;
            oVar.a.put(kVar2.c, new WeakReference<>(new b.i.a.f.h.m.m(kVar2)));
        }
        zzcb zzcbVar = new zzcb(1, new b.i.a.f.h.m.j(kVar), fVar.A.b(kVar2.c), false, null, null);
        zzcbVar.m = true;
        ((u0) fVar.w()).s(zzcbVar);
    }
}
