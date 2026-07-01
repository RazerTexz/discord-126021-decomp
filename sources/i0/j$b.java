package i0;

import kotlin.coroutines.Continuation;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: HttpServiceMethod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j$b<ResponseT> extends j<ResponseT, Object> {
    public final e<ResponseT, d<ResponseT>> d;

    public j$b(w wVar, f0.e$a e_a, h<ResponseBody, ResponseT> hVar, e<ResponseT, d<ResponseT>> eVar, boolean z2) {
        super(wVar, e_a, hVar);
        this.d = eVar;
    }

    @Override // i0.j
    public Object c(d<ResponseT> dVar, Object[] objArr) {
        d<ResponseT> dVarB = this.d.b(dVar);
        Continuation continuation = (Continuation) objArr[objArr.length - 1];
        try {
            s.a.l lVar = new s.a.l(d0.w.h.b.intercepted(continuation), 1);
            lVar.f(new l(dVarB));
            dVarB.C(new m(lVar));
            Object objU = lVar.u();
            if (objU == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                d0.w.i.a.g.probeCoroutineSuspended(continuation);
            }
            return objU;
        } catch (Exception e) {
            return b.i.a.f.e.o.f.i1(e, continuation);
        }
    }
}
