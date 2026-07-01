package b.i.a.b.j.t.i;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class m implements t$d {
    public final SQLiteDatabase a;

    public m(SQLiteDatabase sQLiteDatabase) {
        this.a = sQLiteDatabase;
    }

    @Override // b.i.a.b.j.t.i.t$d
    public Object a() {
        SQLiteDatabase sQLiteDatabase = this.a;
        b.i.a.b.b bVar = t.j;
        sQLiteDatabase.beginTransaction();
        return null;
    }
}
