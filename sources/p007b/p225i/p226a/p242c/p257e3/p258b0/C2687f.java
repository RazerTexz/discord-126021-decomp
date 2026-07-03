package p007b.p225i.p226a.p242c.p257e3.p258b0;

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
import p007b.p225i.p226a.p242c.p264u2.C2949d;
import p007b.p225i.p226a.p242c.p264u2.InterfaceC2946a;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.f */
/* JADX INFO: compiled from: CacheFileMetadataIndex.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2687f {

    /* JADX INFO: renamed from: a */
    public static final String[] f6461a = {ModelAuditLogEntry.CHANGE_KEY_NAME, "length", "last_touch_timestamp"};

    /* JADX INFO: renamed from: b */
    public final InterfaceC2946a f6462b;

    /* JADX INFO: renamed from: c */
    public String f6463c;

    public C2687f(InterfaceC2946a interfaceC2946a) {
        this.f6462b = interfaceC2946a;
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public Map<String, C2686e> m2787a() throws DatabaseIOException {
        try {
            Objects.requireNonNull(this.f6463c);
            Cursor cursorQuery = this.f6462b.getReadableDatabase().query(this.f6463c, f6461a, null, null, null, null, null);
            try {
                HashMap map = new HashMap(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(0);
                    Objects.requireNonNull(string);
                    map.put(string, new C2686e(cursorQuery.getLong(1), cursorQuery.getLong(2)));
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
    /* JADX INFO: renamed from: b */
    public void m2788b(long j) throws DatabaseIOException {
        try {
            String hexString = Long.toHexString(j);
            String strValueOf = String.valueOf(hexString);
            this.f6463c = strValueOf.length() != 0 ? "ExoPlayerCacheFileMetadata".concat(strValueOf) : new String("ExoPlayerCacheFileMetadata");
            if (C2949d.m3545a(this.f6462b.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = this.f6462b.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    C2949d.m3546b(writableDatabase, 2, hexString, 1);
                    String strValueOf2 = String.valueOf(this.f6463c);
                    writableDatabase.execSQL(strValueOf2.length() != 0 ? "DROP TABLE IF EXISTS ".concat(strValueOf2) : new String("DROP TABLE IF EXISTS "));
                    String str = this.f6463c;
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
    /* JADX INFO: renamed from: c */
    public void m2789c(Set<String> set) throws DatabaseIOException {
        Objects.requireNonNull(this.f6463c);
        try {
            SQLiteDatabase writableDatabase = this.f6462b.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete(this.f6463c, "name = ?", new String[]{it.next()});
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
    /* JADX INFO: renamed from: d */
    public void m2790d(String str, long j, long j2) throws DatabaseIOException {
        Objects.requireNonNull(this.f6463c);
        try {
            SQLiteDatabase writableDatabase = this.f6462b.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ModelAuditLogEntry.CHANGE_KEY_NAME, str);
            contentValues.put("length", Long.valueOf(j));
            contentValues.put("last_touch_timestamp", Long.valueOf(j2));
            writableDatabase.replaceOrThrow(this.f6463c, null, contentValues);
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }
}
