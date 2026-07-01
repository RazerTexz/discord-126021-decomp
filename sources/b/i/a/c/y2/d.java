package b.i.a.c.y2;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ o j;
    public final /* synthetic */ Runnable k;

    public /* synthetic */ d(o oVar, Runnable runnable) {
        this.j = oVar;
        this.k = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o oVar = this.j;
        Runnable runnable = this.k;
        synchronized (oVar.a) {
            if (!oVar.l) {
                long j = oVar.k - 1;
                oVar.k = j;
                if (j <= 0) {
                    if (j < 0) {
                        oVar.c(new IllegalStateException());
                    } else {
                        oVar.a();
                        try {
                            runnable.run();
                        } catch (IllegalStateException e) {
                            oVar.c(e);
                        } catch (Exception e2) {
                            oVar.c(new IllegalStateException(e2));
                        }
                    }
                }
            }
        }
    }
}
