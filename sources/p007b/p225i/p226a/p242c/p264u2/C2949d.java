package p007b.p225i.p226a.p242c.p264u2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.exoplayer2.database.DatabaseIOException;
import p007b.p225i.p226a.p242c.C2807i1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.u2.d */
/* JADX INFO: compiled from: VersionTable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2949d {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f7887a = 0;

    static {
        C2807i1.m3272a("goog.exo.database");
    }

    /* JADX INFO: renamed from: a */
    public static int m3545a(SQLiteDatabase sQLiteDatabase, int i, String str) throws DatabaseIOException {
        try {
            if (!C2738e0.m2989J(sQLiteDatabase, "ExoPlayerVersions")) {
                return -1;
            }
            Cursor cursorQuery = sQLiteDatabase.query("ExoPlayerVersions", new String[]{"version"}, "feature = ? AND instance_uid = ?", new String[]{Integer.toString(i), str}, null, null, null);
            try {
                if (cursorQuery.getCount() == 0) {
                    cursorQuery.close();
                    return -1;
                }
                cursorQuery.moveToNext();
                int i2 = cursorQuery.getInt(0);
                cursorQuery.close();
                return i2;
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
            throw new DatabaseIOException(e);
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m3546b(SQLiteDatabase sQLiteDatabase, int i, String str, int i2) throws DatabaseIOException {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))");
            ContentValues contentValues = new ContentValues();
            contentValues.put("feature", Integer.valueOf(i));
            contentValues.put("instance_uid", str);
            contentValues.put("version", Integer.valueOf(i2));
            sQLiteDatabase.replaceOrThrow("ExoPlayerVersions", null, contentValues);
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }
}
