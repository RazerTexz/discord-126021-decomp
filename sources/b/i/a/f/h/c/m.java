package b.i.a.f.h.c;

import android.content.Context;
import android.os.RemoteException;
import b.i.a.f.e.h.a;
import b.i.a.f.e.h.h;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m<R extends b.i.a.f.e.h.h> extends b.i.a.f.e.h.j.d<R, o> {
    public m(b.i.a.f.e.h.c cVar) {
        super(b.i.a.f.c.a.a.e, cVar);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult, b.i.a.f.e.h.j.e
    public /* bridge */ /* synthetic */ void b(Object obj) {
        b((b.i.a.f.e.h.h) obj);
    }

    @Override // b.i.a.f.e.h.j.d
    public void k(a.b bVar) throws RemoteException {
        o oVar = (o) bVar;
        m(oVar.d, (t) oVar.w());
    }

    public abstract void m(Context context, t tVar) throws RemoteException;
}
