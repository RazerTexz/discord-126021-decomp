package i0;

import java.io.IOException;

/* JADX INFO: compiled from: OkHttpCall.java */
/* JADX INFO: loaded from: classes3.dex */
public class p$b$a extends g0.j {
    public final /* synthetic */ p$b k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p$b$a(p$b p_b, g0.x xVar) {
        super(xVar);
        this.k = p_b;
    }

    @Override // g0.x
    public long i0(g0.e eVar, long j) throws IOException {
        try {
            d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
            return this.j.i0(eVar, j);
        } catch (IOException e) {
            this.k.n = e;
            throw e;
        }
    }
}
