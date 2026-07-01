package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes.dex */
public class SystemIdInfoDao_Impl$1 extends EntityInsertionAdapter<SystemIdInfo> {
    public final /* synthetic */ SystemIdInfoDao_Impl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SystemIdInfoDao_Impl$1(SystemIdInfoDao_Impl systemIdInfoDao_Impl, RoomDatabase roomDatabase) {
        super(roomDatabase);
        this.this$0 = systemIdInfoDao_Impl;
    }

    @Override // androidx.room.EntityInsertionAdapter
    public /* bridge */ /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, SystemIdInfo systemIdInfo) {
        bind2(supportSQLiteStatement, systemIdInfo);
    }

    @Override // androidx.room.SharedSQLiteStatement
    public String createQuery() {
        return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
    }

    /* JADX INFO: renamed from: bind, reason: avoid collision after fix types in other method */
    public void bind2(SupportSQLiteStatement supportSQLiteStatement, SystemIdInfo systemIdInfo) {
        String str = systemIdInfo.workSpecId;
        if (str == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, str);
        }
        supportSQLiteStatement.bindLong(2, systemIdInfo.systemId);
    }
}
