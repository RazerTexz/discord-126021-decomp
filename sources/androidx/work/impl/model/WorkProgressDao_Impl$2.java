package androidx.work.impl.model;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: classes.dex */
public class WorkProgressDao_Impl$2 extends SharedSQLiteStatement {
    public final /* synthetic */ WorkProgressDao_Impl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkProgressDao_Impl$2(WorkProgressDao_Impl workProgressDao_Impl, RoomDatabase roomDatabase) {
        super(roomDatabase);
        this.this$0 = workProgressDao_Impl;
    }

    @Override // androidx.room.SharedSQLiteStatement
    public String createQuery() {
        return "DELETE from WorkProgress where work_spec_id=?";
    }
}
