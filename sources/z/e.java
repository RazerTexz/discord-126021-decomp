package z;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {
    public final /* synthetic */ h j;
    public final /* synthetic */ c k;
    public final /* synthetic */ g l;

    public e(h hVar, c cVar, g gVar) {
        this.j = hVar;
        this.k = cVar;
        this.l = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.j.c(this.k.a(this.l));
        } catch (CancellationException unused) {
            this.j.a();
        } catch (Exception e) {
            this.j.b(e);
        }
    }
}
