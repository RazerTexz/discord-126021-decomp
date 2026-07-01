package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Data;

/* JADX INFO: loaded from: classes.dex */
public class WorkProgressDao_Impl$1 extends EntityInsertionAdapter<WorkProgress> {
    public final /* synthetic */ WorkProgressDao_Impl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkProgressDao_Impl$1(WorkProgressDao_Impl workProgressDao_Impl, RoomDatabase roomDatabase) {
        super(roomDatabase);
        this.this$0 = workProgressDao_Impl;
    }

    @Override // androidx.room.EntityInsertionAdapter
    public /* bridge */ /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, WorkProgress workProgress) throws Throwable {
        bind2(supportSQLiteStatement, workProgress);
    }

    @Override // androidx.room.SharedSQLiteStatement
    public String createQuery() {
        return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
    }

    /* JADX INFO: renamed from: bind, reason: avoid collision after fix types in other method */
    public void bind2(SupportSQLiteStatement supportSQLiteStatement, WorkProgress workProgress) throws Throwable {
        String str = workProgress.mWorkSpecId;
        if (str == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, str);
        }
        byte[] byteArrayInternal = Data.toByteArrayInternal(workProgress.mProgress);
        if (byteArrayInternal == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindBlob(2, byteArrayInternal);
        }
    }
}
