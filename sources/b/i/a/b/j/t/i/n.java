package b.i.a.b.j.t.i;

import com.google.android.datatransport.runtime.synchronization.SynchronizationException;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n implements t$b {
    public static final n a = new n();

    @Override // b.i.a.b.j.t.i.t$b
    public Object apply(Object obj) {
        b.i.a.b.b bVar = t.j;
        throw new SynchronizationException("Timed out while trying to acquire the lock.", (Throwable) obj);
    }
}
