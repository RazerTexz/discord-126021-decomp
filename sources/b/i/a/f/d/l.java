package b.i.a.f.d;

import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class l implements Runnable {
    public final g j;
    public final IBinder k;

    public l(g gVar, IBinder iBinder) {
        this.j = gVar;
        this.k = iBinder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g gVar = this.j;
        IBinder iBinder = this.k;
        synchronized (gVar) {
            try {
                if (iBinder == null) {
                    gVar.a(0, "Null service connection");
                    return;
                }
                try {
                    gVar.l = new p(iBinder);
                    gVar.j = 2;
                    gVar.o.c.execute(new k(gVar));
                } catch (RemoteException e) {
                    gVar.a(0, e.getMessage());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
