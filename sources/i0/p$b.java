package i0;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: OkHttpCall.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p$b extends ResponseBody {
    public final ResponseBody l;
    public final g0.g m;
    public IOException n;

    public p$b(ResponseBody responseBody) {
        this.l = responseBody;
        p$b$a p_b_a = new p$b$a(this, responseBody.c());
        d0.z.d.m.checkParameterIsNotNull(p_b_a, "$this$buffer");
        this.m = new g0.r(p_b_a);
    }

    @Override // okhttp3.ResponseBody
    public long a() {
        return this.l.a();
    }

    @Override // okhttp3.ResponseBody
    public MediaType b() {
        return this.l.b();
    }

    @Override // okhttp3.ResponseBody
    public g0.g c() {
        return this.m;
    }

    @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.l.close();
    }
}
