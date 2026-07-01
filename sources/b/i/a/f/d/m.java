package b.i.a.f.d;

import android.util.Log;
import com.google.android.gms.cloudmessaging.zzp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class m implements Runnable {
    public final g j;
    public final q k;

    public m(g gVar, q qVar) {
        this.j = gVar;
        this.k = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g gVar = this.j;
        int i = this.k.a;
        synchronized (gVar) {
            q<?> qVar = gVar.n.get(i);
            if (qVar != null) {
                StringBuilder sb = new StringBuilder(31);
                sb.append("Timing out request: ");
                sb.append(i);
                Log.w("MessengerIpcClient", sb.toString());
                gVar.n.remove(i);
                qVar.b(new zzp(3, "Timed out waiting for response"));
                gVar.c();
            }
        }
    }
}
