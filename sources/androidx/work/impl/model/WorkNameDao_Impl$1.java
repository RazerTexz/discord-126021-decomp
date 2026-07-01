package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes.dex */
public class WorkNameDao_Impl$1 extends EntityInsertionAdapter<WorkName> {
    public final /* synthetic */ WorkNameDao_Impl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkNameDao_Impl$1(WorkNameDao_Impl workNameDao_Impl, RoomDatabase roomDatabase) {
        super(roomDatabase);
        this.this$0 = workNameDao_Impl;
    }

    @Override // androidx.room.EntityInsertionAdapter
    public /* bridge */ /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, WorkName workName) {
        bind2(supportSQLiteStatement, workName);
    }

    @Override // androidx.room.SharedSQLiteStatement
    public String createQuery() {
        return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
    }

    /* JADX INFO: renamed from: bind, reason: avoid collision after fix types in other method */
    public void bind2(SupportSQLiteStatement supportSQLiteStatement, WorkName workName) {
        String str = workName.name;
        if (str == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, str);
        }
        String str2 = workName.workSpecId;
        if (str2 == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindString(2, str2);
        }
    }
}
