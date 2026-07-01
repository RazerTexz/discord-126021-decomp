package b.i.a.b.j.t.i;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map$Entry;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class s implements t$b {
    public final t a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.b.j.i f801b;
    public final b.i.a.b.j.f c;

    public s(t tVar, b.i.a.b.j.i iVar, b.i.a.b.j.f fVar) {
        this.a = tVar;
        this.f801b = iVar;
        this.c = fVar;
    }

    @Override // b.i.a.b.j.t.i.t$b
    public Object apply(Object obj) {
        long jInsert;
        t tVar = this.a;
        b.i.a.b.j.i iVar = this.f801b;
        b.i.a.b.j.f fVar = this.c;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        b.i.a.b.b bVar = t.j;
        if (tVar.b().compileStatement("PRAGMA page_size").simpleQueryForLong() * tVar.b().compileStatement("PRAGMA page_count").simpleQueryForLong() >= tVar.n.e()) {
            return -1L;
        }
        Long lC = tVar.c(sQLiteDatabase, iVar);
        if (lC != null) {
            jInsert = lC.longValue();
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("backend_name", iVar.b());
            contentValues.put("priority", Integer.valueOf(b.i.a.b.j.w.a.a(iVar.d())));
            contentValues.put("next_request_ms", (Integer) 0);
            if (iVar.c() != null) {
                contentValues.put(NotificationCompat$MessagingStyle$Message.KEY_EXTRAS_BUNDLE, Base64.encodeToString(iVar.c(), 0));
            }
            jInsert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        int iD = tVar.n.d();
        byte[] bArr = fVar.d().f766b;
        boolean z2 = bArr.length <= iD;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("context_id", Long.valueOf(jInsert));
        contentValues2.put("transport_name", fVar.g());
        contentValues2.put("timestamp_ms", Long.valueOf(fVar.e()));
        contentValues2.put("uptime_ms", Long.valueOf(fVar.h()));
        contentValues2.put("payload_encoding", fVar.d().a.a);
        contentValues2.put(ModelAuditLogEntry.CHANGE_KEY_CODE, fVar.c());
        contentValues2.put("num_attempts", (Integer) 0);
        contentValues2.put("inline", Boolean.valueOf(z2));
        contentValues2.put("payload", z2 ? bArr : new byte[0]);
        long jInsert2 = sQLiteDatabase.insert("events", null, contentValues2);
        if (!z2) {
            int iCeil = (int) Math.ceil(((double) bArr.length) / ((double) iD));
            for (int i = 1; i <= iCeil; i++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, (i - 1) * iD, Math.min(i * iD, bArr.length));
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put("event_id", Long.valueOf(jInsert2));
                contentValues3.put("sequence_num", Integer.valueOf(i));
                contentValues3.put("bytes", bArrCopyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues3);
            }
        }
        for (Map$Entry map$Entry : Collections.unmodifiableMap(fVar.b()).entrySet()) {
            ContentValues contentValues4 = new ContentValues();
            contentValues4.put("event_id", Long.valueOf(jInsert2));
            contentValues4.put(ModelAuditLogEntry.CHANGE_KEY_NAME, (String) map$Entry.getKey());
            contentValues4.put("value", (String) map$Entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues4);
        }
        return Long.valueOf(jInsert2);
    }
}
