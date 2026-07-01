package i0;

import okhttp3.ResponseBody;

/* JADX INFO: compiled from: HttpServiceMethod.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j<ResponseT, ReturnT> extends z<ReturnT> {
    public final w a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0.e$a f3742b;
    public final h<ResponseBody, ResponseT> c;

    public j(w wVar, f0.e$a e_a, h<ResponseBody, ResponseT> hVar) {
        this.a = wVar;
        this.f3742b = e_a;
        this.c = hVar;
    }

    @Override // i0.z
    public final ReturnT a(Object[] objArr) {
        return c(new p(this.a, objArr, this.f3742b, this.c), objArr);
    }

    public abstract ReturnT c(d<ResponseT> dVar, Object[] objArr);
}
