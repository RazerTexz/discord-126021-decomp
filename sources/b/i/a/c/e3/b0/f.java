package b.i.a.c.e3.b0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.WorkerThread;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.exoplayer2.database.DatabaseIOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: CacheFileMetadataIndex.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final String[] a = {ModelAuditLogEntry.CHANGE_KEY_NAME, "length", "last_touch_timestamp"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.c.u2.a f929b;
    public String c;

    public f(b.i.a.c.u2.a aVar) {
        this.f929b = aVar;
    }

    @WorkerThread
    public Map<String, e> a() throws DatabaseIOException {
        try {
            Objects.requireNonNull(this.c);
            Cursor cursorQuery = this.f929b.getReadableDatabase().query(this.c, a, null, null, null, null, null);
            try {
                HashMap map = new HashMap(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(0);
                    Objects.requireNonNull(string);
                    map.put(string, new e(cursorQuery.getLong(1), cursorQuery.getLong(2)));
                }
                cursorQuery.close();
                return map;
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
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    @WorkerThread
    public void b(long j) throws DatabaseIOException {
        try {
            String hexString = Long.toHexString(j);
            String strValueOf = String.valueOf(hexString);
            this.c = strValueOf.length() != 0 ? "ExoPlayerCacheFileMetadata".concat(strValueOf) : new String("ExoPlayerCacheFileMetadata");
            if (b.i.a.c.u2.d.a(this.f929b.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = this.f929b.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    b.i.a.c.u2.d.b(writableDatabase, 2, hexString, 1);
                    String strValueOf2 = String.valueOf(this.c);
                    writableDatabase.execSQL(strValueOf2.length() != 0 ? "DROP TABLE IF EXISTS ".concat(strValueOf2) : new String("DROP TABLE IF EXISTS "));
                    String str = this.c;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 108);
                    sb.append("CREATE TABLE ");
                    sb.append(str);
                    sb.append(" ");
                    sb.append("(name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                    writableDatabase.execSQL(sb.toString());
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    @WorkerThread
    public void c(Set<String> set) throws DatabaseIOException {
        Objects.requireNonNull(this.c);
        try {
            SQLiteDatabase writableDatabase = this.f929b.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete(this.c, "name = ?", new String[]{it.next()});
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    @WorkerThread
    public void d(String str, long j, long j2) throws DatabaseIOException {
        Objects.requireNonNull(this.c);
        try {
            SQLiteDatabase writableDatabase = this.f929b.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ModelAuditLogEntry.CHANGE_KEY_NAME, str);
            contentValues.put("length", Long.valueOf(j));
            contentValues.put("last_touch_timestamp", Long.valueOf(j2));
            writableDatabase.replaceOrThrow(this.c, null, contentValues);
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }
}
