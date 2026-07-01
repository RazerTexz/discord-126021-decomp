package b.i.c.l;

import java.util.Map$Entry;

/* JADX INFO: compiled from: EventBus.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class p implements Runnable {
    public final Map$Entry j;
    public final b.i.c.q.a k;

    public p(Map$Entry map$Entry, b.i.c.q.a aVar) {
        this.j = map$Entry;
        this.k = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map$Entry map$Entry = this.j;
        ((b.i.c.q.b) map$Entry.getKey()).a(this.k);
    }
}
