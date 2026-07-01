package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes.dex */
public class WorkTagDao_Impl$1 extends EntityInsertionAdapter<WorkTag> {
    public final /* synthetic */ WorkTagDao_Impl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkTagDao_Impl$1(WorkTagDao_Impl workTagDao_Impl, RoomDatabase roomDatabase) {
        super(roomDatabase);
        this.this$0 = workTagDao_Impl;
    }

    @Override // androidx.room.EntityInsertionAdapter
    public /* bridge */ /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, WorkTag workTag) {
        bind2(supportSQLiteStatement, workTag);
    }

    @Override // androidx.room.SharedSQLiteStatement
    public String createQuery() {
        return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
    }

    /* JADX INFO: renamed from: bind, reason: avoid collision after fix types in other method */
    public void bind2(SupportSQLiteStatement supportSQLiteStatement, WorkTag workTag) {
        String str = workTag.tag;
        if (str == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, str);
        }
        String str2 = workTag.workSpecId;
        if (str2 == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindString(2, str2);
        }
    }
}
