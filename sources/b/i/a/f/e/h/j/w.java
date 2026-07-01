package b.i.a.f.e.h.j;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class w implements Runnable {
    public final /* synthetic */ x j;

    public w(x xVar) {
        this.j = xVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g$a g_a = this.j.a;
        g_a.f1361b.c(g_a.c.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
