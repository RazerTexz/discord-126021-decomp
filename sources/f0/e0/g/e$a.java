package f0.e0.g;

import f0.e0.k.h$a;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: RealCall.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$a implements Runnable {
    public volatile AtomicInteger j;
    public final f0.f k;
    public final /* synthetic */ e l;

    public e$a(e eVar, f0.f fVar) {
        d0.z.d.m.checkParameterIsNotNull(fVar, "responseCallback");
        this.l = eVar;
        this.k = fVar;
        this.j = new AtomicInteger(0);
    }

    public final String a() {
        return this.l.f3619z.url.g;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar;
        StringBuilder sbU = b.d.b.a.a.U("OkHttp ");
        sbU.append(this.l.f3619z.url.h());
        String string = sbU.toString();
        Thread threadCurrentThread = Thread.currentThread();
        d0.z.d.m.checkExpressionValueIsNotNull(threadCurrentThread, "currentThread");
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(string);
        try {
            this.l.l.i();
            boolean z2 = false;
            try {
                try {
                    try {
                        this.k.a(this.l, this.l.j());
                        eVar = this.l;
                    } catch (IOException e) {
                        e = e;
                        z2 = true;
                        if (z2) {
                            h$a h_a = f0.e0.k.h.c;
                            f0.e0.k.h.a.i("Callback failure for " + e.b(this.l), 4, e);
                        } else {
                            this.k.b(this.l, e);
                        }
                        eVar = this.l;
                    } catch (Throwable th) {
                        th = th;
                        z2 = true;
                        this.l.cancel();
                        if (!z2) {
                            IOException iOException = new IOException("canceled due to " + th);
                            iOException.addSuppressed(th);
                            this.k.b(this.l, iOException);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    this.l.f3618y.m.c(this);
                    throw th2;
                }
            } catch (IOException e2) {
                e = e2;
            } catch (Throwable th3) {
                th = th3;
            }
            eVar.f3618y.m.c(this);
            threadCurrentThread.setName(name);
        } catch (Throwable th4) {
            threadCurrentThread.setName(name);
            throw th4;
        }
    }
}
