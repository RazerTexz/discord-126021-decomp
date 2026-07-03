package androidx.sqlite.p006db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.p006db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes.dex */
public class FrameworkSQLiteStatement extends FrameworkSQLiteProgram implements SupportSQLiteStatement {
    private final SQLiteStatement mDelegate;

    public FrameworkSQLiteStatement(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.mDelegate = sQLiteStatement;
    }

    @Override // androidx.sqlite.p006db.SupportSQLiteStatement
    public void execute() {
        this.mDelegate.execute();
    }

    @Override // androidx.sqlite.p006db.SupportSQLiteStatement
    public long executeInsert() {
        return this.mDelegate.executeInsert();
    }

    @Override // androidx.sqlite.p006db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        return this.mDelegate.executeUpdateDelete();
    }

    @Override // androidx.sqlite.p006db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        return this.mDelegate.simpleQueryForLong();
    }

    @Override // androidx.sqlite.p006db.SupportSQLiteStatement
    public String simpleQueryForString() {
        return this.mDelegate.simpleQueryForString();
    }
}
