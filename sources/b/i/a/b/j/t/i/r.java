package b.i.a.b.j.t.i;

import com.google.android.datatransport.runtime.synchronization.SynchronizationException;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class r implements t$b {
    public static final r a = new r();

    @Override // b.i.a.b.j.t.i.t$b
    public Object apply(Object obj) {
        b.i.a.b.b bVar = t.j;
        throw new SynchronizationException("Timed out while trying to open db.", (Throwable) obj);
    }
}
