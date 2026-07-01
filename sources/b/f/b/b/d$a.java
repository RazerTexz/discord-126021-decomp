package b.f.b.b;

import java.util.Objects;

/* JADX INFO: compiled from: DiskStorageCache.java */
/* JADX INFO: loaded from: classes.dex */
public class d$a implements Runnable {
    public final /* synthetic */ d j;

    public d$a(d dVar) {
        this.j = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.j.q) {
            this.j.e();
        }
        Objects.requireNonNull(this.j);
        this.j.e.countDown();
    }
}
