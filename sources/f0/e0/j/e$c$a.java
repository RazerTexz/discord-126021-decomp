package f0.e0.j;

import java.io.IOException;

/* JADX INFO: compiled from: Http2Connection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$c$a extends e$c {
    @Override // f0.e0.j.e$c
    public void b(n nVar) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(nVar, "stream");
        nVar.c(a.REFUSED_STREAM, null);
    }
}
