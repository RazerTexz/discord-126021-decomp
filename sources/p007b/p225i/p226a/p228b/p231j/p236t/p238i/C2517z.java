package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2517z;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.z */
/* JADX INFO: compiled from: SchemaManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2517z extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: j */
    public static final List<a> f5456j = Arrays.asList(new a() { // from class: b.i.a.b.j.t.i.v
        @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2517z.a
        /* JADX INFO: renamed from: a */
        public void mo2411a(SQLiteDatabase sQLiteDatabase) {
            List<C2517z.a> list = C2517z.f5456j;
            sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
            sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
            sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
            sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
            sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
        }
    }, new a() { // from class: b.i.a.b.j.t.i.w
        @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2517z.a
        /* JADX INFO: renamed from: a */
        public void mo2411a(SQLiteDatabase sQLiteDatabase) {
            List<C2517z.a> list = C2517z.f5456j;
            sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
            sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
            sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
        }
    }, new a() { // from class: b.i.a.b.j.t.i.x
        @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2517z.a
        /* JADX INFO: renamed from: a */
        public void mo2411a(SQLiteDatabase sQLiteDatabase) {
            List<C2517z.a> list = C2517z.f5456j;
            sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
        }
    }, new a() { // from class: b.i.a.b.j.t.i.y
        @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2517z.a
        /* JADX INFO: renamed from: a */
        public void mo2411a(SQLiteDatabase sQLiteDatabase) {
            List<C2517z.a> list = C2517z.f5456j;
            sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
            sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
        }
    });

    /* JADX INFO: renamed from: k */
    public final int f5457k;

    /* JADX INFO: renamed from: l */
    public boolean f5458l;

    /* JADX INFO: renamed from: b.i.a.b.j.t.i.z$a */
    /* JADX INFO: compiled from: SchemaManager.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo2411a(SQLiteDatabase sQLiteDatabase);
    }

    public C2517z(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.f5458l = false;
        this.f5457k = i;
    }

    /* JADX INFO: renamed from: a */
    public final void m2412a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        List<a> list = f5456j;
        if (i2 <= list.size()) {
            while (i < i2) {
                f5456j.get(i).mo2411a(sQLiteDatabase);
                i++;
            }
        } else {
            StringBuilder sbM835W = C1643a.m835W("Migration from ", i, " to ", i2, " was requested, but cannot be performed. Only ");
            sbM835W.append(list.size());
            sbM835W.append(" migrations are provided");
            throw new IllegalArgumentException(sbM835W.toString());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f5458l = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        int i = this.f5457k;
        if (!this.f5458l) {
            onConfigure(sQLiteDatabase);
        }
        m2412a(sQLiteDatabase, 0, i);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        if (!this.f5458l) {
            onConfigure(sQLiteDatabase);
        }
        m2412a(sQLiteDatabase, 0, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (this.f5458l) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (!this.f5458l) {
            onConfigure(sQLiteDatabase);
        }
        m2412a(sQLiteDatabase, i, i2);
    }
}
