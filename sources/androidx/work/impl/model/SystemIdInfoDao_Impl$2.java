package androidx.work.impl.model;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: classes.dex */
public class SystemIdInfoDao_Impl$2 extends SharedSQLiteStatement {
    public final /* synthetic */ SystemIdInfoDao_Impl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SystemIdInfoDao_Impl$2(SystemIdInfoDao_Impl systemIdInfoDao_Impl, RoomDatabase roomDatabase) {
        super(roomDatabase);
        this.this$0 = systemIdInfoDao_Impl;
    }

    @Override // androidx.room.SharedSQLiteStatement
    public String createQuery() {
        return "DELETE FROM SystemIdInfo where work_spec_id=?";
    }
}
