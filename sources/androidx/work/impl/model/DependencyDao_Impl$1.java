package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes.dex */
public class DependencyDao_Impl$1 extends EntityInsertionAdapter<Dependency> {
    public final /* synthetic */ DependencyDao_Impl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DependencyDao_Impl$1(DependencyDao_Impl dependencyDao_Impl, RoomDatabase roomDatabase) {
        super(roomDatabase);
        this.this$0 = dependencyDao_Impl;
    }

    @Override // androidx.room.EntityInsertionAdapter
    public /* bridge */ /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, Dependency dependency) {
        bind2(supportSQLiteStatement, dependency);
    }

    @Override // androidx.room.SharedSQLiteStatement
    public String createQuery() {
        return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
    }

    /* JADX INFO: renamed from: bind, reason: avoid collision after fix types in other method */
    public void bind2(SupportSQLiteStatement supportSQLiteStatement, Dependency dependency) {
        String str = dependency.workSpecId;
        if (str == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, str);
        }
        String str2 = dependency.prerequisiteId;
        if (str2 == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindString(2, str2);
        }
    }
}
