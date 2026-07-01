package androidx.sqlite.db.framework;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Factory;

/* JADX INFO: loaded from: classes.dex */
public final class FrameworkSQLiteOpenHelperFactory implements SupportSQLiteOpenHelper$Factory {
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper$Factory
    @NonNull
    public SupportSQLiteOpenHelper create(@NonNull SupportSQLiteOpenHelper$Configuration supportSQLiteOpenHelper$Configuration) {
        return new FrameworkSQLiteOpenHelper(supportSQLiteOpenHelper$Configuration.context, supportSQLiteOpenHelper$Configuration.name, supportSQLiteOpenHelper$Configuration.callback, supportSQLiteOpenHelper$Configuration.useNoBackupDirectory);
    }
}
