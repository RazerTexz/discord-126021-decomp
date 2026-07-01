package b.i.a.f.e.h.j;

import android.util.Log;
import b.i.a.f.e.h.a;
import b.i.a.f.e.h.j.g;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class z implements Runnable {
    public final /* synthetic */ ConnectionResult j;
    public final /* synthetic */ g.b k;

    public z(g.b bVar, ConnectionResult connectionResult) {
        this.k = bVar;
        this.j = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.i.a.f.e.k.g gVar;
        g.b bVar = this.k;
        g.a<?> aVar = g.this.t.get(bVar.f1362b);
        if (aVar == null) {
            return;
        }
        if (!this.j.x0()) {
            aVar.e(this.j, null);
            return;
        }
        g.b bVar2 = this.k;
        bVar2.e = true;
        if (bVar2.a.o()) {
            g.b bVar3 = this.k;
            if (!bVar3.e || (gVar = bVar3.c) == null) {
                return;
            }
            bVar3.a.b(gVar, bVar3.d);
            return;
        }
        try {
            a.f fVar = this.k.a;
            fVar.b(null, fVar.a());
        } catch (SecurityException e) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
            this.k.a.c("Failed to get service from broker.");
            aVar.e(new ConnectionResult(10), null);
        }
    }
}
