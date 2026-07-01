package b.i.a.f.e.h.j;

import b.i.a.f.e.h.j.g;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class w implements Runnable {
    public final /* synthetic */ x j;

    public w(x xVar) {
        this.j = xVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.a aVar = this.j.a;
        aVar.f1361b.c(aVar.c.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
