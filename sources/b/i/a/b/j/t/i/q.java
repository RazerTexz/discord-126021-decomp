package b.i.a.b.j.t.i;

import android.database.Cursor;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class q implements t$b {
    public static final q a = new q();

    @Override // b.i.a.b.j.t.i.t$b
    public Object apply(Object obj) {
        return Boolean.valueOf(((Cursor) obj).moveToNext());
    }
}
