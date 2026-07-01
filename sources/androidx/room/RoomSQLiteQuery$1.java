package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;

/* JADX INFO: loaded from: classes.dex */
public class RoomSQLiteQuery$1 implements SupportSQLiteProgram {
    public final /* synthetic */ RoomSQLiteQuery val$query;

    public RoomSQLiteQuery$1(RoomSQLiteQuery roomSQLiteQuery) {
        this.val$query = roomSQLiteQuery;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i, byte[] bArr) {
        this.val$query.bindBlob(i, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i, double d) {
        this.val$query.bindDouble(i, d);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i, long j) {
        this.val$query.bindLong(i, j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i) {
        this.val$query.bindNull(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i, String str) {
        this.val$query.bindString(i, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.val$query.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
