package b.i.a.b.j.t.i;

import android.database.Cursor;
import b.i.a.b.j.a$b;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k implements t$b {
    public final t a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f800b;
    public final b.i.a.b.j.i c;

    public k(t tVar, List list, b.i.a.b.j.i iVar) {
        this.a = tVar;
        this.f800b = list;
        this.c = iVar;
    }

    @Override // b.i.a.b.j.t.i.t$b
    public Object apply(Object obj) {
        t tVar = this.a;
        List list = this.f800b;
        b.i.a.b.j.i iVar = this.c;
        Cursor cursor = (Cursor) obj;
        b.i.a.b.b bVar = t.j;
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            boolean z2 = cursor.getInt(7) != 0;
            a$b a_b = new a$b();
            a_b.f = new HashMap();
            a_b.f(cursor.getString(1));
            a_b.e(cursor.getLong(2));
            a_b.g(cursor.getLong(3));
            if (z2) {
                String string = cursor.getString(4);
                a_b.d(new b.i.a.b.j.e(string == null ? t.j : new b.i.a.b.b(string), cursor.getBlob(5)));
            } else {
                String string2 = cursor.getString(4);
                a_b.d(new b.i.a.b.j.e(string2 == null ? t.j : new b.i.a.b.b(string2), (byte[]) t.n(tVar.b().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num"), l.a)));
            }
            if (!cursor.isNull(6)) {
                a_b.f762b = Integer.valueOf(cursor.getInt(6));
            }
            list.add(new b(j, iVar, a_b.b()));
        }
        return null;
    }
}
