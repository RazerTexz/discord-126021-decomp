package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

/* JADX INFO: loaded from: classes.dex */
public class FrameworkSQLiteDatabase$1 implements SQLiteDatabase$CursorFactory {
    public final /* synthetic */ FrameworkSQLiteDatabase this$0;
    public final /* synthetic */ SupportSQLiteQuery val$supportQuery;

    public FrameworkSQLiteDatabase$1(FrameworkSQLiteDatabase frameworkSQLiteDatabase, SupportSQLiteQuery supportSQLiteQuery) {
        this.this$0 = frameworkSQLiteDatabase;
        this.val$supportQuery = supportSQLiteQuery;
    }

    @Override // android.database.sqlite.SQLiteDatabase$CursorFactory
    public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        this.val$supportQuery.bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }
}
