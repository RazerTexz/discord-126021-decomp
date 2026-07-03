package androidx.room;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.sqlite.p006db.SupportSQLiteOpenHelper;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;

    @Nullable
    public final List<RoomDatabase.Callback> callbacks;

    @NonNull
    public final Context context;

    @Nullable
    public final String copyFromAssetPath;

    @Nullable
    public final File copyFromFile;
    public final RoomDatabase.JournalMode journalMode;
    private final Set<Integer> mMigrationNotRequiredFrom;

    @NonNull
    public final RoomDatabase.MigrationContainer migrationContainer;
    public final boolean multiInstanceInvalidation;

    @Nullable
    public final String name;

    @NonNull
    public final Executor queryExecutor;
    public final boolean requireMigration;

    @NonNull
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;

    @NonNull
    public final Executor transactionExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, @NonNull Executor executor, boolean z3, @Nullable Set<Integer> set) {
        this(context, str, factory, migrationContainer, list, z2, journalMode, executor, executor, false, z3, false, set, null, null);
    }

    public boolean isMigrationRequired(int i, int i2) {
        Set<Integer> set;
        return !((i > i2) && this.allowDestructiveMigrationOnDowngrade) && this.requireMigration && ((set = this.mMigrationNotRequiredFrom) == null || !set.contains(Integer.valueOf(i)));
    }

    @Deprecated
    public boolean isMigrationRequiredFrom(int i) {
        return isMigrationRequired(i, i + 1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, @NonNull Executor executor, @NonNull Executor executor2, boolean z3, boolean z4, boolean z5, @Nullable Set<Integer> set) {
        this(context, str, factory, migrationContainer, list, z2, journalMode, executor, executor2, z3, z4, z5, set, null, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, @NonNull Executor executor, @NonNull Executor executor2, boolean z3, boolean z4, boolean z5, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file) {
        this.sqliteOpenHelperFactory = factory;
        this.context = context;
        this.name = str;
        this.migrationContainer = migrationContainer;
        this.callbacks = list;
        this.allowMainThreadQueries = z2;
        this.journalMode = journalMode;
        this.queryExecutor = executor;
        this.transactionExecutor = executor2;
        this.multiInstanceInvalidation = z3;
        this.requireMigration = z4;
        this.allowDestructiveMigrationOnDowngrade = z5;
        this.mMigrationNotRequiredFrom = set;
        this.copyFromAssetPath = str2;
        this.copyFromFile = file;
    }
}
