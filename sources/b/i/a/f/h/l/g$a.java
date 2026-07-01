package b.i.a.f.h.l;

import android.os.RemoteException;
import android.os.SystemClock;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g$a implements Runnable {
    public final long j;
    public final long k;
    public final boolean l;
    public final /* synthetic */ g m;

    public g$a(g gVar, boolean z2) {
        this.m = gVar;
        Objects.requireNonNull((b.i.a.f.e.o.c) gVar.d);
        this.j = System.currentTimeMillis();
        Objects.requireNonNull((b.i.a.f.e.o.c) gVar.d);
        this.k = SystemClock.elapsedRealtime();
        this.l = z2;
    }

    public abstract void a() throws RemoteException;

    public void b() {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.m.i) {
            b();
            return;
        }
        try {
            a();
        } catch (Exception e) {
            this.m.b(e, false, this.l);
            b();
        }
    }
}
