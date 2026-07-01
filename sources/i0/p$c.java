package i0;

import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: OkHttpCall.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p$c extends ResponseBody {
    public final MediaType l;
    public final long m;

    public p$c(MediaType mediaType, long j) {
        this.l = mediaType;
        this.m = j;
    }

    @Override // okhttp3.ResponseBody
    public long a() {
        return this.m;
    }

    @Override // okhttp3.ResponseBody
    public MediaType b() {
        return this.l;
    }

    @Override // okhttp3.ResponseBody
    public g0.g c() {
        throw new IllegalStateException("Cannot read raw response body of a converted body.");
    }
}
