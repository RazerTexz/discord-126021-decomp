package androidx.work.impl.model;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: classes.dex */
public class WorkSpecDao_Impl$3 extends SharedSQLiteStatement {
    public final /* synthetic */ WorkSpecDao_Impl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkSpecDao_Impl$3(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
        super(roomDatabase);
        this.this$0 = workSpecDao_Impl;
    }

    @Override // androidx.room.SharedSQLiteStatement
    public String createQuery() {
        return "UPDATE workspec SET output=? WHERE id=?";
    }
}
