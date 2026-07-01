package i0;

import okhttp3.ResponseBody;

/* JADX INFO: compiled from: HttpServiceMethod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j$a<ResponseT, ReturnT> extends j<ResponseT, ReturnT> {
    public final e<ResponseT, ReturnT> d;

    public j$a(w wVar, f0.e$a e_a, h<ResponseBody, ResponseT> hVar, e<ResponseT, ReturnT> eVar) {
        super(wVar, e_a, hVar);
        this.d = eVar;
    }

    @Override // i0.j
    public ReturnT c(d<ResponseT> dVar, Object[] objArr) {
        return this.d.b(dVar);
    }
}
