package androidx.work.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.utils.IdGenerator;
import androidx.work.impl.utils.PreferenceUtils;

/* JADX INFO: loaded from: classes.dex */
public class WorkDatabaseMigrations$WorkMigration9To10 extends Migration {
    public final Context mContext;

    public WorkDatabaseMigrations$WorkMigration9To10(@NonNull Context context) {
        super(9, 10);
        this.mContext = context;
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
        PreferenceUtils.migrateLegacyPreferences(this.mContext, supportSQLiteDatabase);
        IdGenerator.migrateLegacyIdGenerator(this.mContext, supportSQLiteDatabase);
    }
}
