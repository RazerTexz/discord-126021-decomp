package b.i.a.b.j.t.i;

import android.database.sqlite.SQLiteDatabase;
import java.util.List;

/* JADX INFO: compiled from: SchemaManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class w implements z$a {
    public static final w a = new w();

    @Override // b.i.a.b.j.t.i.z$a
    public void a(SQLiteDatabase sQLiteDatabase) {
        List<z$a> list = z.j;
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }
}
