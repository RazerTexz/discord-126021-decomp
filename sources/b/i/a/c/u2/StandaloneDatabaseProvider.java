package b.i.a.c.u2;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import b.i.a.c.f3.Log2;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: renamed from: b.i.a.c.u2.c, reason: use source file name */
/* JADX INFO: compiled from: StandaloneDatabaseProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public class StandaloneDatabaseProvider extends SQLiteOpenHelper implements DatabaseProvider {
    public StandaloneDatabaseProvider(Context context) {
        super(context.getApplicationContext(), "exoplayer_internal.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Cursor cursorQuery = sQLiteDatabase.query("sqlite_master", new String[]{"type", ModelAuditLogEntry.CHANGE_KEY_NAME}, null, null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                String string = cursorQuery.getString(0);
                String string2 = cursorQuery.getString(1);
                if (!"sqlite_sequence".equals(string2)) {
                    StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 16 + String.valueOf(string2).length());
                    sb.append("DROP ");
                    sb.append(string);
                    sb.append(" IF EXISTS ");
                    sb.append(string2);
                    String string3 = sb.toString();
                    try {
                        sQLiteDatabase.execSQL(string3);
                    } catch (SQLException e) {
                        String strValueOf = String.valueOf(string3);
                        Log2.b("SADatabaseProvider", strValueOf.length() != 0 ? "Error executing ".concat(strValueOf) : new String("Error executing "), e);
                    }
                }
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
        }
        cursorQuery.close();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
