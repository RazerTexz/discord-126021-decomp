package b.i.a.f.e.h.j;

import b.i.a.f.e.h.j.g;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class v implements Runnable {
    public final /* synthetic */ int j;
    public final /* synthetic */ g.a k;

    public v(g.a aVar, int i) {
        this.k = aVar;
        this.j = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.k.d(this.j);
    }
}
