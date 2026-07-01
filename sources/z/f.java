package z;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Runnable {
    public final /* synthetic */ h j;
    public final /* synthetic */ Callable k;

    public f(h hVar, Callable callable) {
        this.j = hVar;
        this.k = callable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.j.c(this.k.call());
        } catch (CancellationException unused) {
            this.j.a();
        } catch (Exception e) {
            this.j.b(e);
        }
    }
}
