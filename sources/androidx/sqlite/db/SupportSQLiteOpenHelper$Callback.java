package androidx.sqlite.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.d.b.a.a;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class SupportSQLiteOpenHelper$Callback {
    private static final String TAG = "SupportSQLite";
    public final int version;

    public SupportSQLiteOpenHelper$Callback(int i) {
        this.version = i;
    }

    private void deleteDatabaseFile(String str) {
        if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
            return;
        }
        Log.w(TAG, "deleting the database file: " + str);
        try {
            SQLiteDatabase.deleteDatabase(new File(str));
        } catch (Exception e) {
            Log.w(TAG, "delete failed: ", e);
        }
    }

    public void onConfigure(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    public void onCorruption(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        StringBuilder sbU = a.U("Corruption reported by sqlite on database: ");
        sbU.append(supportSQLiteDatabase.getPath());
        Log.e(TAG, sbU.toString());
        if (!supportSQLiteDatabase.isOpen()) {
            deleteDatabaseFile(supportSQLiteDatabase.getPath());
            return;
        }
        List<Pair<String, String>> attachedDbs = null;
        try {
            try {
                attachedDbs = supportSQLiteDatabase.getAttachedDbs();
            } finally {
                if (attachedDbs != null) {
                    Iterator<Pair<String, String>> it = attachedDbs.iterator();
                    while (it.hasNext()) {
                        deleteDatabaseFile((String) it.next().second);
                    }
                } else {
                    deleteDatabaseFile(supportSQLiteDatabase.getPath());
                }
            }
        } catch (SQLiteException unused) {
        }
        try {
            supportSQLiteDatabase.close();
        } catch (IOException unused2) {
        }
    }

    public abstract void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase);

    public void onDowngrade(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        throw new SQLiteException(a.s("Can't downgrade database from version ", i, " to ", i2));
    }

    public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    public abstract void onUpgrade(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2);
}
