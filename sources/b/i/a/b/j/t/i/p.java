package b.i.a.b.j.t.i;

import android.database.Cursor;
import android.util.Base64;
import b.i.a.b.j.b$b;
import b.i.a.b.j.i$a;
import java.util.ArrayList;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class p implements t$b {
    public static final p a = new p();

    @Override // b.i.a.b.j.t.i.t$b
    public Object apply(Object obj) {
        Cursor cursor = (Cursor) obj;
        b.i.a.b.b bVar = t.j;
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            i$a i_aA = b.i.a.b.j.i.a();
            i_aA.b(cursor.getString(1));
            i_aA.c(b.i.a.b.j.w.a.b(cursor.getInt(2)));
            String string = cursor.getString(3);
            b$b b_b = (b$b) i_aA;
            b_b.f764b = string == null ? null : Base64.decode(string, 0);
            arrayList.add(b_b.a());
        }
        return arrayList;
    }
}
