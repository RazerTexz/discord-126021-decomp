package b.i.a.b.j.t.i;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i implements t$b {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.b.j.i f798b;

    public i(long j, b.i.a.b.j.i iVar) {
        this.a = j;
        this.f798b = iVar;
    }

    @Override // b.i.a.b.j.t.i.t$b
    public Object apply(Object obj) {
        long j = this.a;
        b.i.a.b.j.i iVar = this.f798b;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        b.i.a.b.b bVar = t.j;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{iVar.b(), String.valueOf(b.i.a.b.j.w.a.a(iVar.d()))}) < 1) {
            contentValues.put("backend_name", iVar.b());
            contentValues.put("priority", Integer.valueOf(b.i.a.b.j.w.a.a(iVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }
}
