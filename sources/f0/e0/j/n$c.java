package f0.e0.j;

import java.io.IOException;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: Http2Stream.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n$c extends g0.b {
    public final /* synthetic */ n l;

    public n$c(n nVar) {
        this.l = nVar;
    }

    @Override // g0.b
    public IOException k(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // g0.b
    public void l() {
        this.l.e(a.CANCEL);
        e eVar = this.l.n;
        synchronized (eVar) {
            long j = eVar.A;
            long j2 = eVar.f3641z;
            if (j < j2) {
                return;
            }
            eVar.f3641z = j2 + 1;
            eVar.C = System.nanoTime() + ((long) 1000000000);
            f0.e0.f.c cVar = eVar.t;
            String strJ = b.d.b.a.a.J(new StringBuilder(), eVar.o, " ping");
            cVar.c(new k(strJ, true, strJ, true, eVar), 0L);
        }
    }

    public final void m() throws IOException {
        if (j()) {
            throw new SocketTimeoutException("timeout");
        }
    }
}
