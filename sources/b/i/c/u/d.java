package b.i.c.u;

/* JADX INFO: compiled from: FirebaseInstallations.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {
    public final f j;
    public final boolean k;

    public d(f fVar, boolean z2) {
        this.j = fVar;
        this.k = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar = this.j;
        boolean z2 = this.k;
        Object obj = f.a;
        fVar.b(z2);
    }
}
