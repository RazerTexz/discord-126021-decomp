package b.i.a.c.e3.b0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import b.i.a.c.f3.e0;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.exoplayer2.database.DatabaseIOException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: CachedContentIndex.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j$a implements j$c {
    public static final String[] a = {ModelAuditLogEntry.CHANGE_KEY_ID, "key", "metadata"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.c.u2.a f933b;
    public final SparseArray<i> c = new SparseArray<>();
    public String d;
    public String e;

    public j$a(b.i.a.c.u2.a aVar) {
        this.f933b = aVar;
    }

    public static void j(SQLiteDatabase sQLiteDatabase, String str) {
        String strValueOf = String.valueOf(str);
        sQLiteDatabase.execSQL(strValueOf.length() != 0 ? "DROP TABLE IF EXISTS ".concat(strValueOf) : new String("DROP TABLE IF EXISTS "));
    }

    public static String k(String str) {
        String strValueOf = String.valueOf(str);
        return strValueOf.length() != 0 ? "ExoPlayerCacheIndex".concat(strValueOf) : new String("ExoPlayerCacheIndex");
    }

    @Override // b.i.a.c.e3.b0.j$c
    public void a(i iVar, boolean z2) {
        if (z2) {
            this.c.delete(iVar.a);
        } else {
            this.c.put(iVar.a, null);
        }
    }

    @Override // b.i.a.c.e3.b0.j$c
    public void b(HashMap<String, i> map) throws IOException {
        try {
            SQLiteDatabase writableDatabase = this.f933b.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                l(writableDatabase);
                Iterator<i> it = map.values().iterator();
                while (it.hasNext()) {
                    i(writableDatabase, it.next());
                }
                writableDatabase.setTransactionSuccessful();
                this.c.clear();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    @Override // b.i.a.c.e3.b0.j$c
    public void c(i iVar) {
        this.c.put(iVar.a, iVar);
    }

    @Override // b.i.a.c.e3.b0.j$c
    public boolean d() throws DatabaseIOException {
        SQLiteDatabase readableDatabase = this.f933b.getReadableDatabase();
        String str = this.d;
        Objects.requireNonNull(str);
        return b.i.a.c.u2.d.a(readableDatabase, 1, str) != -1;
    }

    @Override // b.i.a.c.e3.b0.j$c
    public void e(HashMap<String, i> map) throws IOException {
        if (this.c.size() == 0) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = this.f933b.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            for (int i = 0; i < this.c.size(); i++) {
                try {
                    i iVarValueAt = this.c.valueAt(i);
                    if (iVarValueAt == null) {
                        int iKeyAt = this.c.keyAt(i);
                        String str = this.e;
                        Objects.requireNonNull(str);
                        writableDatabase.delete(str, "id = ?", new String[]{Integer.toString(iKeyAt)});
                    } else {
                        i(writableDatabase, iVarValueAt);
                    }
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
            writableDatabase.setTransactionSuccessful();
            this.c.clear();
            writableDatabase.endTransaction();
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    @Override // b.i.a.c.e3.b0.j$c
    public void f(long j) {
        String hexString = Long.toHexString(j);
        this.d = hexString;
        this.e = k(hexString);
    }

    @Override // b.i.a.c.e3.b0.j$c
    public void g(HashMap<String, i> map, SparseArray<String> sparseArray) throws IOException {
        b.c.a.a0.d.D(this.c.size() == 0);
        try {
            SQLiteDatabase readableDatabase = this.f933b.getReadableDatabase();
            String str = this.d;
            Objects.requireNonNull(str);
            if (b.i.a.c.u2.d.a(readableDatabase, 1, str) != 1) {
                SQLiteDatabase writableDatabase = this.f933b.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    l(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
            SQLiteDatabase readableDatabase2 = this.f933b.getReadableDatabase();
            String str2 = this.e;
            Objects.requireNonNull(str2);
            Cursor cursorQuery = readableDatabase2.query(str2, a, null, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    int i = cursorQuery.getInt(0);
                    String string = cursorQuery.getString(1);
                    Objects.requireNonNull(string);
                    map.put(string, new i(i, string, j.a(new DataInputStream(new ByteArrayInputStream(cursorQuery.getBlob(2))))));
                    sparseArray.put(i, string);
                } catch (Throwable th2) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
            cursorQuery.close();
        } catch (SQLiteException e) {
            map.clear();
            sparseArray.clear();
            throw new DatabaseIOException(e);
        }
    }

    @Override // b.i.a.c.e3.b0.j$c
    public void h() throws DatabaseIOException {
        b.i.a.c.u2.a aVar = this.f933b;
        String str = this.d;
        Objects.requireNonNull(str);
        try {
            String strK = k(str);
            SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                int i = b.i.a.c.u2.d.a;
                try {
                    if (e0.J(writableDatabase, "ExoPlayerVersions")) {
                        writableDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", new String[]{Integer.toString(1), str});
                    }
                    j(writableDatabase, strK);
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (SQLException e) {
                    throw new DatabaseIOException(e);
                }
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public final void i(SQLiteDatabase sQLiteDatabase, i iVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        j.b(iVar.e, new DataOutputStream(byteArrayOutputStream));
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ModelAuditLogEntry.CHANGE_KEY_ID, Integer.valueOf(iVar.a));
        contentValues.put("key", iVar.f930b);
        contentValues.put("metadata", byteArray);
        String str = this.e;
        Objects.requireNonNull(str);
        sQLiteDatabase.replaceOrThrow(str, null, contentValues);
    }

    public final void l(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException {
        String str = this.d;
        Objects.requireNonNull(str);
        b.i.a.c.u2.d.b(sQLiteDatabase, 1, str, 1);
        String str2 = this.e;
        Objects.requireNonNull(str2);
        j(sQLiteDatabase, str2);
        String str3 = this.e;
        sQLiteDatabase.execSQL(b.d.b.a.a.l(b.d.b.a.a.b(str3, 88), "CREATE TABLE ", str3, " ", "(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)"));
    }
}
