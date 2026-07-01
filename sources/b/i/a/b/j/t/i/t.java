package b.i.a.b.j.t.i;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.b.Encoding2;
import b.i.a.b.j.AutoValue_EventInternal;
import b.i.a.b.j.AutoValue_TransportContext;
import b.i.a.b.j.EncodedPayload;
import b.i.a.b.j.EventInternal;
import b.i.a.b.j.TransportContext;
import b.i.a.b.j.t.i.t;
import b.i.a.b.j.u.SynchronizationGuard;
import b.i.a.b.j.v.Clock3;
import b.i.a.b.j.w.PriorityMapping;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes3.dex */
@WorkerThread
public class t implements EventStore, SynchronizationGuard {
    public static final Encoding2 j = new Encoding2("proto");
    public final SchemaManager5 k;
    public final Clock3 l;
    public final Clock3 m;
    public final EventStoreConfig n;

    /* JADX INFO: compiled from: SQLiteEventStore.java */
    public interface b<T, U> {
        U apply(T t);
    }

    /* JADX INFO: compiled from: SQLiteEventStore.java */
    public static class c {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f802b;

        public c(String str, String str2, a aVar) {
            this.a = str;
            this.f802b = str2;
        }
    }

    /* JADX INFO: compiled from: SQLiteEventStore.java */
    public interface d<T> {
        T a();
    }

    public t(Clock3 clock3, Clock3 clock4, EventStoreConfig eventStoreConfig, SchemaManager5 schemaManager5) {
        this.k = schemaManager5;
        this.l = clock3;
        this.m = clock4;
        this.n = eventStoreConfig;
    }

    public static String f(Iterable<PersistedEvent> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<PersistedEvent> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().b());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static <T> T n(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    @Override // b.i.a.b.j.u.SynchronizationGuard
    public <T> T a(SynchronizationGuard.a<T> aVar) {
        final SQLiteDatabase sQLiteDatabaseB = b();
        e(new d(sQLiteDatabaseB) { // from class: b.i.a.b.j.t.i.m
            public final SQLiteDatabase a;

            {
                this.a = sQLiteDatabaseB;
            }

            @Override // b.i.a.b.j.t.i.t.d
            public Object a() {
                SQLiteDatabase sQLiteDatabase = this.a;
                Encoding2 encoding2 = t.j;
                sQLiteDatabase.beginTransaction();
                return null;
            }
        }, new b() { // from class: b.i.a.b.j.t.i.n
            @Override // b.i.a.b.j.t.i.t.b
            public Object apply(Object obj) {
                Encoding2 encoding2 = t.j;
                throw new SynchronizationException("Timed out while trying to acquire the lock.", (Throwable) obj);
            }
        });
        try {
            T tExecute = aVar.execute();
            sQLiteDatabaseB.setTransactionSuccessful();
            return tExecute;
        } finally {
            sQLiteDatabaseB.endTransaction();
        }
    }

    @Override // b.i.a.b.j.t.i.EventStore
    @Nullable
    public PersistedEvent a0(final TransportContext transportContext, final EventInternal eventInternal) {
        AnimatableValueParser.Y("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", transportContext.d(), eventInternal.g(), transportContext.b());
        long jLongValue = ((Long) d(new b(this, transportContext, eventInternal) { // from class: b.i.a.b.j.t.i.s
            public final t a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final TransportContext f801b;
            public final EventInternal c;

            {
                this.a = this;
                this.f801b = transportContext;
                this.c = eventInternal;
            }

            @Override // b.i.a.b.j.t.i.t.b
            public Object apply(Object obj) {
                long jInsert;
                t tVar = this.a;
                TransportContext transportContext2 = this.f801b;
                EventInternal eventInternal2 = this.c;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                Encoding2 encoding2 = t.j;
                if (tVar.b().compileStatement("PRAGMA page_size").simpleQueryForLong() * tVar.b().compileStatement("PRAGMA page_count").simpleQueryForLong() >= tVar.n.e()) {
                    return -1L;
                }
                Long lC = tVar.c(sQLiteDatabase, transportContext2);
                if (lC != null) {
                    jInsert = lC.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", transportContext2.b());
                    contentValues.put("priority", Integer.valueOf(PriorityMapping.a(transportContext2.d())));
                    contentValues.put("next_request_ms", (Integer) 0);
                    if (transportContext2.c() != null) {
                        contentValues.put(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE, Base64.encodeToString(transportContext2.c(), 0));
                    }
                    jInsert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                int iD = tVar.n.d();
                byte[] bArr = eventInternal2.d().f766b;
                boolean z2 = bArr.length <= iD;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(jInsert));
                contentValues2.put("transport_name", eventInternal2.g());
                contentValues2.put("timestamp_ms", Long.valueOf(eventInternal2.e()));
                contentValues2.put("uptime_ms", Long.valueOf(eventInternal2.h()));
                contentValues2.put("payload_encoding", eventInternal2.d().a.a);
                contentValues2.put(ModelAuditLogEntry.CHANGE_KEY_CODE, eventInternal2.c());
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
                for (Map.Entry entry : Collections.unmodifiableMap(eventInternal2.b()).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(jInsert2));
                    contentValues4.put(ModelAuditLogEntry.CHANGE_KEY_NAME, (String) entry.getKey());
                    contentValues4.put("value", (String) entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(jInsert2);
            }
        })).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return new AutoValue_PersistedEvent(jLongValue, transportContext, eventInternal);
    }

    @VisibleForTesting
    public SQLiteDatabase b() {
        final SchemaManager5 schemaManager5 = this.k;
        schemaManager5.getClass();
        return (SQLiteDatabase) e(new d(schemaManager5) { // from class: b.i.a.b.j.t.i.o
            public final SchemaManager5 a;

            {
                this.a = schemaManager5;
            }

            @Override // b.i.a.b.j.t.i.t.d
            public Object a() {
                return this.a.getWritableDatabase();
            }
        }, new b() { // from class: b.i.a.b.j.t.i.r
            @Override // b.i.a.b.j.t.i.t.b
            public Object apply(Object obj) {
                Encoding2 encoding2 = t.j;
                throw new SynchronizationException("Timed out while trying to open db.", (Throwable) obj);
            }
        });
    }

    @Nullable
    public final Long c(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))));
        if (transportContext.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(transportContext.c(), 0));
        }
        Cursor cursorQuery = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            return !cursorQuery.moveToNext() ? null : Long.valueOf(cursorQuery.getLong(0));
        } finally {
            cursorQuery.close();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.k.close();
    }

    public final <T> T d(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase sQLiteDatabaseB = b();
        sQLiteDatabaseB.beginTransaction();
        try {
            T tApply = bVar.apply(sQLiteDatabaseB);
            sQLiteDatabaseB.setTransactionSuccessful();
            return tApply;
        } finally {
            sQLiteDatabaseB.endTransaction();
        }
    }

    public final <T> T e(d<T> dVar, b<Throwable, T> bVar) {
        long jA = this.m.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e) {
                if (this.m.a() >= ((long) this.n.a()) + jA) {
                    return bVar.apply(e);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // b.i.a.b.j.t.i.EventStore
    public long h0(TransportContext transportContext) {
        Cursor cursorRawQuery = b().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))});
        try {
            return (cursorRawQuery.moveToNext() ? Long.valueOf(cursorRawQuery.getLong(0)) : 0L).longValue();
        } finally {
            cursorRawQuery.close();
        }
    }

    @Override // b.i.a.b.j.t.i.EventStore
    public int l() {
        long jA = this.l.a() - this.n.b();
        SQLiteDatabase sQLiteDatabaseB = b();
        sQLiteDatabaseB.beginTransaction();
        try {
            Integer numValueOf = Integer.valueOf(sQLiteDatabaseB.delete("events", "timestamp_ms < ?", new String[]{String.valueOf(jA)}));
            sQLiteDatabaseB.setTransactionSuccessful();
            return numValueOf.intValue();
        } finally {
            sQLiteDatabaseB.endTransaction();
        }
    }

    @Override // b.i.a.b.j.t.i.EventStore
    public boolean l0(TransportContext transportContext) {
        SQLiteDatabase sQLiteDatabaseB = b();
        sQLiteDatabaseB.beginTransaction();
        try {
            Long lC = c(sQLiteDatabaseB, transportContext);
            Boolean bool = lC == null ? Boolean.FALSE : (Boolean) n(b().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lC.toString()}), new b() { // from class: b.i.a.b.j.t.i.q
                @Override // b.i.a.b.j.t.i.t.b
                public Object apply(Object obj) {
                    return Boolean.valueOf(((Cursor) obj).moveToNext());
                }
            });
            sQLiteDatabaseB.setTransactionSuccessful();
            return bool.booleanValue();
        } finally {
            sQLiteDatabaseB.endTransaction();
        }
    }

    @Override // b.i.a.b.j.t.i.EventStore
    public void m(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder sbU = outline.U("DELETE FROM events WHERE _id in ");
            sbU.append(f(iterable));
            b().compileStatement(sbU.toString()).execute();
        }
    }

    @Override // b.i.a.b.j.t.i.EventStore
    public void n0(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder sbU = outline.U("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
            sbU.append(f(iterable));
            String string = sbU.toString();
            SQLiteDatabase sQLiteDatabaseB = b();
            sQLiteDatabaseB.beginTransaction();
            try {
                sQLiteDatabaseB.compileStatement(string).execute();
                sQLiteDatabaseB.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                sQLiteDatabaseB.setTransactionSuccessful();
            } finally {
                sQLiteDatabaseB.endTransaction();
            }
        }
    }

    @Override // b.i.a.b.j.t.i.EventStore
    public Iterable<PersistedEvent> r(final TransportContext transportContext) {
        return (Iterable) d(new b(this, transportContext) { // from class: b.i.a.b.j.t.i.j
            public final t a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final TransportContext f799b;

            {
                this.a = this;
                this.f799b = transportContext;
            }

            @Override // b.i.a.b.j.t.i.t.b
            public Object apply(Object obj) {
                final t tVar = this.a;
                final TransportContext transportContext2 = this.f799b;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                Encoding2 encoding2 = t.j;
                Objects.requireNonNull(tVar);
                final ArrayList arrayList = new ArrayList();
                Long lC = tVar.c(sQLiteDatabase, transportContext2);
                if (lC != null) {
                    t.n(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", ModelAuditLogEntry.CHANGE_KEY_CODE, "inline"}, "context_id = ?", new String[]{lC.toString()}, null, null, null, String.valueOf(tVar.n.c())), new t.b(tVar, arrayList, transportContext2) { // from class: b.i.a.b.j.t.i.k
                        public final t a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        public final List f800b;
                        public final TransportContext c;

                        {
                            this.a = tVar;
                            this.f800b = arrayList;
                            this.c = transportContext2;
                        }

                        @Override // b.i.a.b.j.t.i.t.b
                        public Object apply(Object obj2) {
                            t tVar2 = this.a;
                            List list = this.f800b;
                            TransportContext transportContext3 = this.c;
                            Cursor cursor = (Cursor) obj2;
                            Encoding2 encoding3 = t.j;
                            while (cursor.moveToNext()) {
                                long j2 = cursor.getLong(0);
                                boolean z2 = cursor.getInt(7) != 0;
                                AutoValue_EventInternal.b bVar = new AutoValue_EventInternal.b();
                                bVar.f = new HashMap();
                                bVar.f(cursor.getString(1));
                                bVar.e(cursor.getLong(2));
                                bVar.g(cursor.getLong(3));
                                if (z2) {
                                    String string = cursor.getString(4);
                                    bVar.d(new EncodedPayload(string == null ? t.j : new Encoding2(string), cursor.getBlob(5)));
                                } else {
                                    String string2 = cursor.getString(4);
                                    bVar.d(new EncodedPayload(string2 == null ? t.j : new Encoding2(string2), (byte[]) t.n(tVar2.b().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j2)}, null, null, "sequence_num"), new t.b() { // from class: b.i.a.b.j.t.i.l
                                        @Override // b.i.a.b.j.t.i.t.b
                                        public Object apply(Object obj3) {
                                            Cursor cursor2 = (Cursor) obj3;
                                            Encoding2 encoding4 = t.j;
                                            ArrayList arrayList2 = new ArrayList();
                                            int length = 0;
                                            while (cursor2.moveToNext()) {
                                                byte[] blob = cursor2.getBlob(0);
                                                arrayList2.add(blob);
                                                length += blob.length;
                                            }
                                            byte[] bArr = new byte[length];
                                            int length2 = 0;
                                            for (int i = 0; i < arrayList2.size(); i++) {
                                                byte[] bArr2 = (byte[]) arrayList2.get(i);
                                                System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
                                                length2 += bArr2.length;
                                            }
                                            return bArr;
                                        }
                                    })));
                                }
                                if (!cursor.isNull(6)) {
                                    bVar.f762b = Integer.valueOf(cursor.getInt(6));
                                }
                                list.add(new AutoValue_PersistedEvent(j2, transportContext3, bVar.b()));
                            }
                            return null;
                        }
                    });
                }
                HashMap map = new HashMap();
                StringBuilder sb = new StringBuilder("event_id IN (");
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(((PersistedEvent) arrayList.get(i)).b());
                    if (i < arrayList.size() - 1) {
                        sb.append(',');
                    }
                }
                sb.append(')');
                Cursor cursorQuery = sQLiteDatabase.query("event_metadata", new String[]{"event_id", ModelAuditLogEntry.CHANGE_KEY_NAME, "value"}, sb.toString(), null, null, null, null);
                while (cursorQuery.moveToNext()) {
                    try {
                        long j2 = cursorQuery.getLong(0);
                        Set hashSet = (Set) map.get(Long.valueOf(j2));
                        if (hashSet == null) {
                            hashSet = new HashSet();
                            map.put(Long.valueOf(j2), hashSet);
                        }
                        hashSet.add(new t.c(cursorQuery.getString(1), cursorQuery.getString(2), null));
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                }
                cursorQuery.close();
                ListIterator listIterator = arrayList.listIterator();
                while (listIterator.hasNext()) {
                    PersistedEvent persistedEvent = (PersistedEvent) listIterator.next();
                    if (map.containsKey(Long.valueOf(persistedEvent.b()))) {
                        EventInternal.a aVarI = persistedEvent.a().i();
                        for (t.c cVar : (Set) map.get(Long.valueOf(persistedEvent.b()))) {
                            aVarI.a(cVar.a, cVar.f802b);
                        }
                        listIterator.set(new AutoValue_PersistedEvent(persistedEvent.b(), persistedEvent.c(), aVarI.b()));
                    }
                }
                return arrayList;
            }
        });
    }

    @Override // b.i.a.b.j.t.i.EventStore
    public void v(final TransportContext transportContext, final long j2) {
        d(new b(j2, transportContext) { // from class: b.i.a.b.j.t.i.i
            public final long a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final TransportContext f798b;

            {
                this.a = j2;
                this.f798b = transportContext;
            }

            @Override // b.i.a.b.j.t.i.t.b
            public Object apply(Object obj) {
                long j3 = this.a;
                TransportContext transportContext2 = this.f798b;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                Encoding2 encoding2 = t.j;
                ContentValues contentValues = new ContentValues();
                contentValues.put("next_request_ms", Long.valueOf(j3));
                if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{transportContext2.b(), String.valueOf(PriorityMapping.a(transportContext2.d()))}) < 1) {
                    contentValues.put("backend_name", transportContext2.b());
                    contentValues.put("priority", Integer.valueOf(PriorityMapping.a(transportContext2.d())));
                    sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                return null;
            }
        });
    }

    @Override // b.i.a.b.j.t.i.EventStore
    public Iterable<TransportContext> z() {
        SQLiteDatabase sQLiteDatabaseB = b();
        sQLiteDatabaseB.beginTransaction();
        try {
            List list = (List) n(sQLiteDatabaseB.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new b() { // from class: b.i.a.b.j.t.i.p
                @Override // b.i.a.b.j.t.i.t.b
                public Object apply(Object obj) {
                    Cursor cursor = (Cursor) obj;
                    Encoding2 encoding2 = t.j;
                    ArrayList arrayList = new ArrayList();
                    while (cursor.moveToNext()) {
                        TransportContext.a aVarA = TransportContext.a();
                        aVarA.b(cursor.getString(1));
                        aVarA.c(PriorityMapping.b(cursor.getInt(2)));
                        String string = cursor.getString(3);
                        AutoValue_TransportContext.b bVar = (AutoValue_TransportContext.b) aVarA;
                        bVar.f764b = string == null ? null : Base64.decode(string, 0);
                        arrayList.add(bVar.a());
                    }
                    return arrayList;
                }
            });
            sQLiteDatabaseB.setTransactionSuccessful();
            return list;
        } finally {
            sQLiteDatabaseB.endTransaction();
        }
    }
}
