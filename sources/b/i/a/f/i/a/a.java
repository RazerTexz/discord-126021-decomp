package b.i.a.f.i.a;

import android.os.BadParcelableException;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import b.i.a.f.h.l.a0;
import b.i.a.f.h.l.g;
import b.i.a.f.h.l.g$c;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public final g a;

    public a(g gVar) {
        this.a = gVar;
    }

    public void a(a$a a_a) {
        g gVar = this.a;
        Objects.requireNonNull(gVar);
        synchronized (gVar.g) {
            for (int i = 0; i < gVar.g.size(); i++) {
                if (a_a.equals(gVar.g.get(i).first)) {
                    Log.w(gVar.c, "OnEventListener already registered.");
                    return;
                }
            }
            g$c g_c = new g$c(a_a);
            gVar.g.add(new Pair<>(a_a, g_c));
            if (gVar.j != null) {
                try {
                    gVar.j.registerOnMeasurementEventListener(g_c);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(gVar.c, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            gVar.e.execute(new a0(gVar, g_c));
        }
    }
}
