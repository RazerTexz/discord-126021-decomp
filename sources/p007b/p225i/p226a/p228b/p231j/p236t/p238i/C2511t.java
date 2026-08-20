package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p228b.C2407b;
import p007b.p225i.p226a.p228b.p231j.AbstractC2439f;
import p007b.p225i.p226a.p228b.p231j.AbstractC2442i;
import p007b.p225i.p226a.p228b.p231j.C2434a;
import p007b.p225i.p226a.p228b.p231j.C2435b;
import p007b.p225i.p226a.p228b.p231j.C2438e;
import p007b.p225i.p226a.p228b.p231j.p239u.InterfaceC2518a;
import p007b.p225i.p226a.p228b.p231j.p240v.InterfaceC2519a;
import p007b.p225i.p226a.p228b.p231j.p241w.C2524a;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.t */
/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes3.dex */
@WorkerThread
public class C2511t implements InterfaceC2494c, InterfaceC2518a {

    /* JADX INFO: renamed from: j */
    public static final C2407b f5441j = new C2407b("proto");

    /* JADX INFO: renamed from: k */
    public final C2517z f5442k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC2519a f5443l;

    /* JADX INFO: renamed from: m */
    public final InterfaceC2519a f5444m;

    /* JADX INFO: renamed from: n */
    public final AbstractC2495d f5445n;

    /* JADX INFO: renamed from: b.i.a.b.j.t.i.t$b */
    /* JADX INFO: compiled from: SQLiteEventStore.java */
    public interface b<T, U> {
        U apply(T t);
    }

    /* JADX INFO: renamed from: b.i.a.b.j.t.i.t$c */
    /* JADX INFO: compiled from: SQLiteEventStore.java */
    public static class c {

        /* JADX INFO: renamed from: a */
        public final String f5446a;

        /* JADX INFO: renamed from: b */
        public final String f5447b;

        public c(String str, String str2, a aVar) {
            this.f5446a = str;
            this.f5447b = str2;
        }
    }

    /* JADX INFO: renamed from: b.i.a.b.j.t.i.t$d */
    /* JADX INFO: compiled from: SQLiteEventStore.java */
    public interface d<T> {
        /* JADX INFO: renamed from: a */
        T mo2403a();
    }

    public C2511t(InterfaceC2519a interfaceC2519a, InterfaceC2519a interfaceC2519a2, AbstractC2495d abstractC2495d, C2517z c2517z) {
        this.f5442k = c2517z;
        this.f5443l = interfaceC2519a;
        this.f5444m = interfaceC2519a2;
        this.f5445n = abstractC2495d;
    }

    /* JADX INFO: renamed from: f */
    public static String m2404f(Iterable<AbstractC2499h> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<AbstractC2499h> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().mo2392b());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    /* JADX INFO: renamed from: n */
    public static <T> T m2405n(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p239u.InterfaceC2518a
    /* JADX INFO: renamed from: a */
    public <T> T mo2406a(InterfaceC2518a.a<T> aVar) {
        final SQLiteDatabase sQLiteDatabaseM2407b = m2407b();
        m2410e(new d(sQLiteDatabaseM2407b) { // from class: b.i.a.b.j.t.i.m

            /* JADX INFO: renamed from: a */
            public final SQLiteDatabase f5432a;

            {
                this.f5432a = sQLiteDatabaseM2407b;
            }

            @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t.d
            /* JADX INFO: renamed from: a */
            public Object mo2403a() {
                SQLiteDatabase sQLiteDatabase = this.f5432a;
                C2407b c2407b = C2511t.f5441j;
                sQLiteDatabase.beginTransaction();
                return null;
            }
        }, new b() { // from class: b.i.a.b.j.t.i.n
            @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t.b
            public Object apply(Object obj) {
                C2407b c2407b = C2511t.f5441j;
                throw new SynchronizationException("Timed out while trying to acquire the lock.", (Throwable) obj);
            }
        });
        try {
            T tExecute = aVar.execute();
            sQLiteDatabaseM2407b.setTransactionSuccessful();
            return tExecute;
        } finally {
            sQLiteDatabaseM2407b.endTransaction();
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.InterfaceC2494c
    @Nullable
    /* JADX INFO: renamed from: a0 */
    public AbstractC2499h mo2394a0(final AbstractC2442i abstractC2442i, final AbstractC2439f abstractC2439f) {
        C1460d.m489Y("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", abstractC2442i.mo2350d(), abstractC2439f.mo2340g(), abstractC2442i.mo2348b());
        long jLongValue = ((Long) m2409d(new b(this, abstractC2442i, abstractC2439f) { // from class: b.i.a.b.j.t.i.s

            /* JADX INFO: renamed from: a */
            public final C2511t f5438a;

            /* JADX INFO: renamed from: b */
            public final AbstractC2442i f5439b;

            /* JADX INFO: renamed from: c */
            public final AbstractC2439f f5440c;

            {
                this.f5438a = this;
                this.f5439b = abstractC2442i;
                this.f5440c = abstractC2439f;
            }

            @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t.b
            public Object apply(Object obj) {
                long jInsert;
                C2511t c2511t = this.f5438a;
                AbstractC2442i abstractC2442i2 = this.f5439b;
                AbstractC2439f abstractC2439f2 = this.f5440c;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                C2407b c2407b = C2511t.f5441j;
                if (c2511t.m2407b().compileStatement("PRAGMA page_size").simpleQueryForLong() * c2511t.m2407b().compileStatement("PRAGMA page_count").simpleQueryForLong() >= c2511t.f5445n.mo2390e()) {
                    return -1L;
                }
                Long lM2408c = c2511t.m2408c(sQLiteDatabase, abstractC2442i2);
                if (lM2408c != null) {
                    jInsert = lM2408c.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", abstractC2442i2.mo2348b());
                    contentValues.put("priority", Integer.valueOf(C2524a.m2414a(abstractC2442i2.mo2350d())));
                    contentValues.put("next_request_ms", (Integer) 0);
                    if (abstractC2442i2.mo2349c() != null) {
                        contentValues.put(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE, Base64.encodeToString(abstractC2442i2.mo2349c(), 0));
                    }
                    jInsert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                int iMo2389d = c2511t.f5445n.mo2389d();
                byte[] bArr = abstractC2439f2.mo2338d().f5277b;
                boolean z2 = bArr.length <= iMo2389d;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(jInsert));
                contentValues2.put("transport_name", abstractC2439f2.mo2340g());
                contentValues2.put("timestamp_ms", Long.valueOf(abstractC2439f2.mo2339e()));
                contentValues2.put("uptime_ms", Long.valueOf(abstractC2439f2.mo2341h()));
                contentValues2.put("payload_encoding", abstractC2439f2.mo2338d().f5276a.f5118a);
                contentValues2.put(ModelAuditLogEntry.CHANGE_KEY_CODE, abstractC2439f2.mo2337c());
                contentValues2.put("num_attempts", (Integer) 0);
                contentValues2.put("inline", Boolean.valueOf(z2));
                contentValues2.put("payload", z2 ? bArr : new byte[0]);
                long jInsert2 = sQLiteDatabase.insert("events", null, contentValues2);
                if (!z2) {
                    int iCeil = (int) Math.ceil(((double) bArr.length) / ((double) iMo2389d));
                    for (int i = 1; i <= iCeil; i++) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, (i - 1) * iMo2389d, Math.min(i * iMo2389d, bArr.length));
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("event_id", Long.valueOf(jInsert2));
                        contentValues3.put("sequence_num", Integer.valueOf(i));
                        contentValues3.put("bytes", bArrCopyOfRange);
                        sQLiteDatabase.insert("event_payloads", null, contentValues3);
                    }
                }
                for (Map.Entry entry : Collections.unmodifiableMap(abstractC2439f2.mo2336b()).entrySet()) {
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
        return new C2493b(jLongValue, abstractC2442i, abstractC2439f);
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: b */
    public SQLiteDatabase m2407b() {
        final C2517z c2517z = this.f5442k;
        c2517z.getClass();
        return (SQLiteDatabase) m2410e(new d(c2517z) { // from class: b.i.a.b.j.t.i.o

            /* JADX INFO: renamed from: a */
            public final C2517z f5434a;

            {
                this.f5434a = c2517z;
            }

            @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t.d
            /* JADX INFO: renamed from: a */
            public Object mo2403a() {
                return this.f5434a.getWritableDatabase();
            }
        }, new b() { // from class: b.i.a.b.j.t.i.r
            @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t.b
            public Object apply(Object obj) {
                C2407b c2407b = C2511t.f5441j;
                throw new SynchronizationException("Timed out while trying to open db.", (Throwable) obj);
            }
        });
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public final Long m2408c(SQLiteDatabase sQLiteDatabase, AbstractC2442i abstractC2442i) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(abstractC2442i.mo2348b(), String.valueOf(C2524a.m2414a(abstractC2442i.mo2350d()))));
        if (abstractC2442i.mo2349c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(abstractC2442i.mo2349c(), 0));
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
        this.f5442k.close();
    }

    /* JADX INFO: renamed from: d */
    public final <T> T m2409d(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase sQLiteDatabaseM2407b = m2407b();
        sQLiteDatabaseM2407b.beginTransaction();
        try {
            T tApply = bVar.apply(sQLiteDatabaseM2407b);
            sQLiteDatabaseM2407b.setTransactionSuccessful();
            return tApply;
        } finally {
            sQLiteDatabaseM2407b.endTransaction();
        }
    }

    /* JADX INFO: renamed from: e */
    public final <T> T m2410e(d<T> dVar, b<Throwable, T> bVar) {
        long jMo2413a = this.f5444m.mo2413a();
        while (true) {
            try {
                return dVar.mo2403a();
            } catch (SQLiteDatabaseLockedException e) {
                if (this.f5444m.mo2413a() >= ((long) this.f5445n.mo2386a()) + jMo2413a) {
                    return bVar.apply(e);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.InterfaceC2494c
    /* JADX INFO: renamed from: h0 */
    public long mo2395h0(AbstractC2442i abstractC2442i) {
        Cursor cursorRawQuery = m2407b().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{abstractC2442i.mo2348b(), String.valueOf(C2524a.m2414a(abstractC2442i.mo2350d()))});
        try {
            return (cursorRawQuery.moveToNext() ? Long.valueOf(cursorRawQuery.getLong(0)) : 0L).longValue();
        } finally {
            cursorRawQuery.close();
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.InterfaceC2494c
    /* JADX INFO: renamed from: l */
    public int mo2396l() {
        long jMo2413a = this.f5443l.mo2413a() - this.f5445n.mo2387b();
        SQLiteDatabase sQLiteDatabaseM2407b = m2407b();
        sQLiteDatabaseM2407b.beginTransaction();
        try {
            Integer numValueOf = Integer.valueOf(sQLiteDatabaseM2407b.delete("events", "timestamp_ms < ?", new String[]{String.valueOf(jMo2413a)}));
            sQLiteDatabaseM2407b.setTransactionSuccessful();
            return numValueOf.intValue();
        } finally {
            sQLiteDatabaseM2407b.endTransaction();
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.InterfaceC2494c
    /* JADX INFO: renamed from: l0 */
    public boolean mo2397l0(AbstractC2442i abstractC2442i) {
        SQLiteDatabase sQLiteDatabaseM2407b = m2407b();
        sQLiteDatabaseM2407b.beginTransaction();
        try {
            Long lM2408c = m2408c(sQLiteDatabaseM2407b, abstractC2442i);
            Boolean bool = lM2408c == null ? Boolean.FALSE : (Boolean) m2405n(m2407b().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lM2408c.toString()}), new b() { // from class: b.i.a.b.j.t.i.q
                @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t.b
                public Object apply(Object obj) {
                    return Boolean.valueOf(((Cursor) obj).moveToNext());
                }
            });
            sQLiteDatabaseM2407b.setTransactionSuccessful();
            return bool.booleanValue();
        } finally {
            sQLiteDatabaseM2407b.endTransaction();
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.InterfaceC2494c
    /* JADX INFO: renamed from: m */
    public void mo2398m(Iterable<AbstractC2499h> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder sbM833U = C1643a.m833U("DELETE FROM events WHERE _id in ");
            sbM833U.append(m2404f(iterable));
            m2407b().compileStatement(sbM833U.toString()).execute();
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.InterfaceC2494c
    /* JADX INFO: renamed from: n0 */
    public void mo2399n0(Iterable<AbstractC2499h> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder sbM833U = C1643a.m833U("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
            sbM833U.append(m2404f(iterable));
            String string = sbM833U.toString();
            SQLiteDatabase sQLiteDatabaseM2407b = m2407b();
            sQLiteDatabaseM2407b.beginTransaction();
            try {
                sQLiteDatabaseM2407b.compileStatement(string).execute();
                sQLiteDatabaseM2407b.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                sQLiteDatabaseM2407b.setTransactionSuccessful();
            } finally {
                sQLiteDatabaseM2407b.endTransaction();
            }
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.InterfaceC2494c
    /* JADX INFO: renamed from: r */
    public Iterable<AbstractC2499h> mo2400r(final AbstractC2442i abstractC2442i) {
        return (Iterable) m2409d(new b(this, abstractC2442i) { // from class: b.i.a.b.j.t.i.j

            /* JADX INFO: renamed from: a */
            public final C2511t f5426a;

            /* JADX INFO: renamed from: b */
            public final AbstractC2442i f5427b;

            {
                this.f5426a = this;
                this.f5427b = abstractC2442i;
            }

            @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t.b
            public Object apply(Object obj) {
                final C2511t c2511t = this.f5426a;
                final AbstractC2442i abstractC2442i2 = this.f5427b;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                C2407b c2407b = C2511t.f5441j;
                Objects.requireNonNull(c2511t);
                final ArrayList arrayList = new ArrayList();
                Long lM2408c = c2511t.m2408c(sQLiteDatabase, abstractC2442i2);
                if (lM2408c != null) {
                    C2511t.m2405n(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", ModelAuditLogEntry.CHANGE_KEY_CODE, "inline"}, "context_id = ?", new String[]{lM2408c.toString()}, null, null, null, String.valueOf(c2511t.f5445n.mo2388c())), new C2511t.b(c2511t, arrayList, abstractC2442i2) { // from class: b.i.a.b.j.t.i.k

                        /* JADX INFO: renamed from: a */
                        public final C2511t f5428a;

                        /* JADX INFO: renamed from: b */
                        public final List f5429b;

                        /* JADX INFO: renamed from: c */
                        public final AbstractC2442i f5430c;

                        {
                            this.f5428a = c2511t;
                            this.f5429b = arrayList;
                            this.f5430c = abstractC2442i2;
                        }

                        @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t.b
                        public Object apply(Object obj2) {
                            C2511t c2511t2 = this.f5428a;
                            List list = this.f5429b;
                            AbstractC2442i abstractC2442i3 = this.f5430c;
                            Cursor cursor = (Cursor) obj2;
                            C2407b c2407b2 = C2511t.f5441j;
                            while (cursor.moveToNext()) {
                                long j = cursor.getLong(0);
                                boolean z2 = cursor.getInt(7) != 0;
                                C2434a.b bVar = new C2434a.b();
                                bVar.f5257f = new HashMap();
                                bVar.m2346f(cursor.getString(1));
                                bVar.m2345e(cursor.getLong(2));
                                bVar.m2347g(cursor.getLong(3));
                                if (z2) {
                                    String string = cursor.getString(4);
                                    bVar.m2344d(new C2438e(string == null ? C2511t.f5441j : new C2407b(string), cursor.getBlob(5)));
                                } else {
                                    String string2 = cursor.getString(4);
                                    bVar.m2344d(new C2438e(string2 == null ? C2511t.f5441j : new C2407b(string2), (byte[]) C2511t.m2405n(c2511t2.m2407b().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num"), new C2511t.b() { // from class: b.i.a.b.j.t.i.l
                                        @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t.b
                                        public Object apply(Object obj3) {
                                            Cursor cursor2 = (Cursor) obj3;
                                            C2407b c2407b3 = C2511t.f5441j;
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
                                    bVar.f5253b = Integer.valueOf(cursor.getInt(6));
                                }
                                list.add(new C2493b(j, abstractC2442i3, bVar.mo2342b()));
                            }
                            return null;
                        }
                    });
                }
                HashMap map = new HashMap();
                StringBuilder sb = new StringBuilder("event_id IN (");
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(((AbstractC2499h) arrayList.get(i)).mo2392b());
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
                        hashSet.add(new C2511t.c(cursorQuery.getString(1), cursorQuery.getString(2), null));
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                }
                cursorQuery.close();
                ListIterator listIterator = arrayList.listIterator();
                while (listIterator.hasNext()) {
                    AbstractC2499h abstractC2499h = (AbstractC2499h) listIterator.next();
                    if (map.containsKey(Long.valueOf(abstractC2499h.mo2392b()))) {
                        AbstractC2439f.a aVarM2356i = abstractC2499h.mo2391a().m2356i();
                        for (C2511t.c cVar : (Set) map.get(Long.valueOf(abstractC2499h.mo2392b()))) {
                            aVarM2356i.m2357a(cVar.f5446a, cVar.f5447b);
                        }
                        listIterator.set(new C2493b(abstractC2499h.mo2392b(), abstractC2499h.mo2393c(), aVarM2356i.mo2342b()));
                    }
                }
                return arrayList;
            }
        });
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.InterfaceC2494c
    /* JADX INFO: renamed from: v */
    public void mo2401v(final AbstractC2442i abstractC2442i, final long j) {
        m2409d(new b(j, abstractC2442i) { // from class: b.i.a.b.j.t.i.i

            /* JADX INFO: renamed from: a */
            public final long f5424a;

            /* JADX INFO: renamed from: b */
            public final AbstractC2442i f5425b;

            {
                this.f5424a = j;
                this.f5425b = abstractC2442i;
            }

            @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t.b
            public Object apply(Object obj) {
                long j2 = this.f5424a;
                AbstractC2442i abstractC2442i2 = this.f5425b;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                C2407b c2407b = C2511t.f5441j;
                ContentValues contentValues = new ContentValues();
                contentValues.put("next_request_ms", Long.valueOf(j2));
                if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{abstractC2442i2.mo2348b(), String.valueOf(C2524a.m2414a(abstractC2442i2.mo2350d()))}) < 1) {
                    contentValues.put("backend_name", abstractC2442i2.mo2348b());
                    contentValues.put("priority", Integer.valueOf(C2524a.m2414a(abstractC2442i2.mo2350d())));
                    sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                return null;
            }
        });
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.InterfaceC2494c
    /* JADX INFO: renamed from: z */
    public Iterable<AbstractC2442i> mo2402z() {
        SQLiteDatabase sQLiteDatabaseM2407b = m2407b();
        sQLiteDatabaseM2407b.beginTransaction();
        try {
            List list = (List) m2405n(sQLiteDatabaseM2407b.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new b() { // from class: b.i.a.b.j.t.i.p
                @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t.b
                public Object apply(Object obj) {
                    Cursor cursor = (Cursor) obj;
                    C2407b c2407b = C2511t.f5441j;
                    ArrayList arrayList = new ArrayList();
                    while (cursor.moveToNext()) {
                        AbstractC2442i.a aVarM2358a = AbstractC2442i.m2358a();
                        aVarM2358a.mo2352b(cursor.getString(1));
                        aVarM2358a.mo2353c(C2524a.m2415b(cursor.getInt(2)));
                        String string = cursor.getString(3);
                        C2435b.b bVar = (C2435b.b) aVarM2358a;
                        bVar.f5262b = string == null ? null : Base64.decode(string, 0);
                        arrayList.add(bVar.mo2351a());
                    }
                    return arrayList;
                }
            });
            sQLiteDatabaseM2407b.setTransactionSuccessful();
            return list;
        } finally {
            sQLiteDatabaseM2407b.endTransaction();
        }
    }
}
