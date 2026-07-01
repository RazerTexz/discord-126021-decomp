package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceDao_Impl$2 implements Callable<Long> {
    public final /* synthetic */ PreferenceDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public PreferenceDao_Impl$2(PreferenceDao_Impl preferenceDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = preferenceDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Long call() throws Exception {
        return call();
    }

    public void finalize() {
        this.val$_statement.release();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Long call() throws Exception {
        Long lValueOf = null;
        Cursor cursorQuery = DBUtil.query(PreferenceDao_Impl.access$000(this.this$0), this.val$_statement, false, null);
        try {
            if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                lValueOf = Long.valueOf(cursorQuery.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorQuery.close();
        }
    }
}
