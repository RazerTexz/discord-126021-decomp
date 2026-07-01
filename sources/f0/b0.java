package f0;

import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: ResponseBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends ResponseBody {
    public final /* synthetic */ g0.g l;
    public final /* synthetic */ MediaType m;
    public final /* synthetic */ long n;

    public b0(g0.g gVar, MediaType mediaType, long j) {
        this.l = gVar;
        this.m = mediaType;
        this.n = j;
    }

    @Override // okhttp3.ResponseBody
    public long a() {
        return this.n;
    }

    @Override // okhttp3.ResponseBody
    public MediaType b() {
        return this.m;
    }

    @Override // okhttp3.ResponseBody
    public g0.g c() {
        return this.l;
    }
}
