package androidx.sqlite.db.framework;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Callback;

/* JADX INFO: loaded from: classes.dex */
public class FrameworkSQLiteOpenHelper$OpenHelper$1 implements DatabaseErrorHandler {
    public final /* synthetic */ SupportSQLiteOpenHelper$Callback val$callback;
    public final /* synthetic */ FrameworkSQLiteDatabase[] val$dbRef;

    public FrameworkSQLiteOpenHelper$OpenHelper$1(SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback, FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr) {
        this.val$callback = supportSQLiteOpenHelper$Callback;
        this.val$dbRef = frameworkSQLiteDatabaseArr;
    }

    @Override // android.database.DatabaseErrorHandler
    public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        this.val$callback.onCorruption(FrameworkSQLiteOpenHelper$OpenHelper.getWrappedDb(this.val$dbRef, sQLiteDatabase));
    }
}
