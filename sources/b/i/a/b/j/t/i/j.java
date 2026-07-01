package b.i.a.b.j.t.i;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class j implements t$b {
    public final t a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.b.j.i f799b;

    public j(t tVar, b.i.a.b.j.i iVar) {
        this.a = tVar;
        this.f799b = iVar;
    }

    @Override // b.i.a.b.j.t.i.t$b
    public Object apply(Object obj) {
        t tVar = this.a;
        b.i.a.b.j.i iVar = this.f799b;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        b.i.a.b.b bVar = t.j;
        Objects.requireNonNull(tVar);
        ArrayList arrayList = new ArrayList();
        Long lC = tVar.c(sQLiteDatabase, iVar);
        if (lC != null) {
            t.n(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", ModelAuditLogEntry.CHANGE_KEY_CODE, "inline"}, "context_id = ?", new String[]{lC.toString()}, null, null, null, String.valueOf(tVar.n.c())), new k(tVar, arrayList, iVar));
        }
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(((h) arrayList.get(i)).b());
            if (i < arrayList.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        Cursor cursorQuery = sQLiteDatabase.query("event_metadata", new String[]{"event_id", ModelAuditLogEntry.CHANGE_KEY_NAME, "value"}, sb.toString(), null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                long j = cursorQuery.getLong(0);
                Set hashSet = (Set) map.get(Long.valueOf(j));
                if (hashSet == null) {
                    hashSet = new HashSet();
                    map.put(Long.valueOf(j), hashSet);
                }
                hashSet.add(new t$c(cursorQuery.getString(1), cursorQuery.getString(2), null));
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            h hVar = (h) listIterator.next();
            if (map.containsKey(Long.valueOf(hVar.b()))) {
                b.i.a.b.j.f$a f_aI = hVar.a().i();
                for (t$c t_c : (Set) map.get(Long.valueOf(hVar.b()))) {
                    f_aI.a(t_c.a, t_c.f802b);
                }
                listIterator.set(new b(hVar.b(), hVar.c(), f_aI.b()));
            }
        }
        return arrayList;
    }
}
