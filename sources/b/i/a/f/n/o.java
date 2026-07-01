package b.i.a.f.n;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements Runnable {
    public final /* synthetic */ p j;

    public o(p pVar) {
        this.j = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.j.f1597b) {
            b bVar = this.j.c;
            if (bVar != null) {
                bVar.b();
            }
        }
    }
}
