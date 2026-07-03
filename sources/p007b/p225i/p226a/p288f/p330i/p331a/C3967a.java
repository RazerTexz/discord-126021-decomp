package p007b.p225i.p226a.p288f.p330i.p331a;

import android.os.BadParcelableException;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p313h.p325l.C3578a0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;
import p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4258z5;

/* JADX INFO: renamed from: b.i.a.f.i.a.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3967a {

    /* JADX INFO: renamed from: a */
    public final C3661g f10500a;

    /* JADX INFO: renamed from: b.i.a.f.i.a.a$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
    public interface a extends InterfaceC4258z5 {
    }

    public C3967a(C3661g c3661g) {
        this.f10500a = c3661g;
    }

    /* JADX INFO: renamed from: a */
    public void m5439a(a aVar) {
        C3661g c3661g = this.f10500a;
        Objects.requireNonNull(c3661g);
        synchronized (c3661g.f9952g) {
            for (int i = 0; i < c3661g.f9952g.size(); i++) {
                if (aVar.equals(c3661g.f9952g.get(i).first)) {
                    Log.w(c3661g.f9948c, "OnEventListener already registered.");
                    return;
                }
            }
            C3661g.c cVar = new C3661g.c(aVar);
            c3661g.f9952g.add(new Pair<>(aVar, cVar));
            if (c3661g.f9955j != null) {
                try {
                    c3661g.f9955j.registerOnMeasurementEventListener(cVar);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(c3661g.f9948c, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            c3661g.f9950e.execute(new C3578a0(c3661g, cVar));
        }
    }
}
