package p007b.p225i.p226a.p288f.p313h.p323j;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.h.j.p */
/* JADX INFO: loaded from: classes3.dex */
public final class C3534p extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C3532o f9776j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3534p(C3532o c3532o, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f9776j = c3532o;
    }

    /* JADX INFO: renamed from: b */
    public static Set<String> m4483b(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery(C1643a.m859k(str.length() + 22, "SELECT * FROM ", str, " LIMIT 0"), null);
        try {
            for (String str2 : cursorRawQuery.getColumnNames()) {
                hashSet.add(str2);
            }
            cursorRawQuery.close();
            return hashSet;
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m4484a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{ModelAuditLogEntry.CHANGE_KEY_NAME}, "name=?", new String[]{str}, null, null, null);
                boolean zMoveToFirst = cursorQuery.moveToFirst();
                cursorQuery.close();
                return zMoveToFirst;
            } catch (SQLiteException e) {
                this.f9776j.m4433f("Error querying for table", str, e);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        if (!this.f9776j.f9772p.m4507b(3600000L)) {
            throw new SQLiteException("Database open failed");
        }
        try {
            return super.getWritableDatabase();
        } catch (SQLiteException unused) {
            this.f9776j.f9772p.m4506a();
            this.f9776j.m4429H("Opening the database failed, dropping the table and recreating it");
            String str = C3532o.f9768l;
            this.f9776j.f9684j.f9722b.getDatabasePath("google_analytics_v4.db").delete();
            try {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                this.f9776j.f9772p.f9825b = 0L;
                return writableDatabase;
            } catch (SQLiteException e) {
                this.f9776j.m4426A("Failed to open freshly created database", e);
                throw e;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        int i;
        String path = sQLiteDatabase.getPath();
        try {
            i = Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException unused) {
            String str = Build.VERSION.SDK;
            C3529m0 c3529m0 = C3529m0.f9761l;
            if (c3529m0 != null) {
                c3529m0.m4426A("Invalid version number", str);
            } else {
                Log.e(C3510e0.f9690b.f9716a, str != null ? C1643a.m859k(str.length() + 23, "Invalid version number", ":", str) : "Invalid version number");
            }
            i = 0;
        }
        if (i < 9) {
            return;
        }
        File file = new File(path);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (m4484a(sQLiteDatabase, "hits2")) {
            Set<String> setM4483b = m4483b(sQLiteDatabase, "hits2");
            String[] strArr = {"hit_id", "hit_string", "hit_time", "hit_url"};
            for (int i = 0; i < 4; i++) {
                String str = strArr[i];
                if (!((HashSet) setM4483b).remove(str)) {
                    String strValueOf = String.valueOf(str);
                    throw new SQLiteException(strValueOf.length() != 0 ? "Database hits2 is missing required column: ".concat(strValueOf) : new String("Database hits2 is missing required column: "));
                }
            }
            HashSet hashSet = (HashSet) setM4483b;
            boolean z2 = !hashSet.remove("hit_app_id");
            if (!hashSet.isEmpty()) {
                throw new SQLiteException("Database hits2 has extra columns");
            }
            if (z2) {
                sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
            }
        } else {
            sQLiteDatabase.execSQL(C3532o.f9768l);
        }
        if (!m4484a(sQLiteDatabase, "properties")) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
            return;
        }
        Set<String> setM4483b2 = m4483b(sQLiteDatabase, "properties");
        String[] strArr2 = {"app_uid", "cid", "tid", "params", "adid", "hits_count"};
        for (int i2 = 0; i2 < 6; i2++) {
            String str2 = strArr2[i2];
            if (!((HashSet) setM4483b2).remove(str2)) {
                String strValueOf2 = String.valueOf(str2);
                throw new SQLiteException(strValueOf2.length() != 0 ? "Database properties is missing required column: ".concat(strValueOf2) : new String("Database properties is missing required column: "));
            }
        }
        if (!((HashSet) setM4483b2).isEmpty()) {
            throw new SQLiteException("Database properties table has extra columns");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
