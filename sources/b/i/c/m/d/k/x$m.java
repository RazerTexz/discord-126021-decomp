package b.i.c.m.d.k;

import android.content.Context;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public final class x$m implements Runnable {
    public final Context j;
    public final b.i.c.m.d.q.c.c k;
    public final b.i.c.m.d.q.b l;
    public final boolean m;

    public x$m(Context context, b.i.c.m.d.q.c.c cVar, b.i.c.m.d.q.b bVar, boolean z2) {
        this.j = context;
        this.k = cVar;
        this.l = bVar;
        this.m = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (h.b(this.j)) {
            b.i.c.m.d.b.a.b("Attempting to send crash report at time of crash...");
            this.l.a(this.k, this.m);
        }
    }
}
