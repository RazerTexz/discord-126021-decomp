package androidx.work.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.utils.PreferenceUtils;

/* JADX INFO: loaded from: classes.dex */
public class WorkDatabaseMigrations$RescheduleMigration extends Migration {
    public final Context mContext;

    public WorkDatabaseMigrations$RescheduleMigration(@NonNull Context context, int i, int i2) {
        super(i, i2);
        this.mContext = context;
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        if (this.endVersion >= 10) {
            supportSQLiteDatabase.execSQL(WorkDatabaseMigrations.INSERT_PREFERENCE, new Object[]{PreferenceUtils.KEY_RESCHEDULE_NEEDED, 1});
        } else {
            this.mContext.getSharedPreferences(PreferenceUtils.PREFERENCES_FILE_NAME, 0).edit().putBoolean(PreferenceUtils.KEY_RESCHEDULE_NEEDED, true).apply();
        }
    }
}
