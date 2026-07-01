package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Factory;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class RoomDatabase$Builder<T extends RoomDatabase> {
    private boolean mAllowDestructiveMigrationOnDowngrade;
    private boolean mAllowMainThreadQueries;
    private ArrayList<RoomDatabase$Callback> mCallbacks;
    private final Context mContext;
    private String mCopyFromAssetPath;
    private File mCopyFromFile;
    private final Class<T> mDatabaseClass;
    private SupportSQLiteOpenHelper$Factory mFactory;
    private Set<Integer> mMigrationStartAndEndVersions;
    private Set<Integer> mMigrationsNotRequiredFrom;
    private boolean mMultiInstanceInvalidation;
    private final String mName;
    private Executor mQueryExecutor;
    private Executor mTransactionExecutor;
    private RoomDatabase$JournalMode mJournalMode = RoomDatabase$JournalMode.AUTOMATIC;
    private boolean mRequireMigration = true;
    private final RoomDatabase$MigrationContainer mMigrationContainer = new RoomDatabase$MigrationContainer();

    public RoomDatabase$Builder(@NonNull Context context, @NonNull Class<T> cls, @Nullable String str) {
        this.mContext = context;
        this.mDatabaseClass = cls;
        this.mName = str;
    }

    @NonNull
    public RoomDatabase$Builder<T> addCallback(@NonNull RoomDatabase$Callback roomDatabase$Callback) {
        if (this.mCallbacks == null) {
            this.mCallbacks = new ArrayList<>();
        }
        this.mCallbacks.add(roomDatabase$Callback);
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> addMigrations(@NonNull Migration... migrationArr) {
        if (this.mMigrationStartAndEndVersions == null) {
            this.mMigrationStartAndEndVersions = new HashSet();
        }
        for (Migration migration : migrationArr) {
            this.mMigrationStartAndEndVersions.add(Integer.valueOf(migration.startVersion));
            this.mMigrationStartAndEndVersions.add(Integer.valueOf(migration.endVersion));
        }
        this.mMigrationContainer.addMigrations(migrationArr);
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> allowMainThreadQueries() {
        this.mAllowMainThreadQueries = true;
        return this;
    }

    @NonNull
    @SuppressLint({"RestrictedApi"})
    public T build() {
        Executor executor;
        if (this.mContext == null) {
            throw new IllegalArgumentException("Cannot provide null context for the database.");
        }
        if (this.mDatabaseClass == null) {
            throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
        }
        Executor executor2 = this.mQueryExecutor;
        if (executor2 == null && this.mTransactionExecutor == null) {
            Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
            this.mTransactionExecutor = iOThreadExecutor;
            this.mQueryExecutor = iOThreadExecutor;
        } else if (executor2 != null && this.mTransactionExecutor == null) {
            this.mTransactionExecutor = executor2;
        } else if (executor2 == null && (executor = this.mTransactionExecutor) != null) {
            this.mQueryExecutor = executor;
        }
        Set<Integer> set = this.mMigrationStartAndEndVersions;
        if (set != null && this.mMigrationsNotRequiredFrom != null) {
            for (Integer num : set) {
                if (this.mMigrationsNotRequiredFrom.contains(num)) {
                    throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                }
            }
        }
        if (this.mFactory == null) {
            this.mFactory = new FrameworkSQLiteOpenHelperFactory();
        }
        String str = this.mCopyFromAssetPath;
        if (str != null || this.mCopyFromFile != null) {
            if (this.mName == null) {
                throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
            }
            if (str != null && this.mCopyFromFile != null) {
                throw new IllegalArgumentException("Both createFromAsset() and createFromFile() was called on this Builder but the database can only be created using one of the two configurations.");
            }
            this.mFactory = new SQLiteCopyOpenHelperFactory(str, this.mCopyFromFile, this.mFactory);
        }
        Context context = this.mContext;
        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context, this.mName, this.mFactory, this.mMigrationContainer, this.mCallbacks, this.mAllowMainThreadQueries, this.mJournalMode.resolve(context), this.mQueryExecutor, this.mTransactionExecutor, this.mMultiInstanceInvalidation, this.mRequireMigration, this.mAllowDestructiveMigrationOnDowngrade, this.mMigrationsNotRequiredFrom, this.mCopyFromAssetPath, this.mCopyFromFile);
        T t = (T) Room.getGeneratedImplementation(this.mDatabaseClass, "_Impl");
        t.init(databaseConfiguration);
        return t;
    }

    @NonNull
    public RoomDatabase$Builder<T> createFromAsset(@NonNull String str) {
        this.mCopyFromAssetPath = str;
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> createFromFile(@NonNull File file) {
        this.mCopyFromFile = file;
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> enableMultiInstanceInvalidation() {
        this.mMultiInstanceInvalidation = this.mName != null;
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> fallbackToDestructiveMigration() {
        this.mRequireMigration = false;
        this.mAllowDestructiveMigrationOnDowngrade = true;
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> fallbackToDestructiveMigrationFrom(int... iArr) {
        if (this.mMigrationsNotRequiredFrom == null) {
            this.mMigrationsNotRequiredFrom = new HashSet(iArr.length);
        }
        for (int i : iArr) {
            this.mMigrationsNotRequiredFrom.add(Integer.valueOf(i));
        }
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
        this.mRequireMigration = true;
        this.mAllowDestructiveMigrationOnDowngrade = true;
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> openHelperFactory(@Nullable SupportSQLiteOpenHelper$Factory supportSQLiteOpenHelper$Factory) {
        this.mFactory = supportSQLiteOpenHelper$Factory;
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> setJournalMode(@NonNull RoomDatabase$JournalMode roomDatabase$JournalMode) {
        this.mJournalMode = roomDatabase$JournalMode;
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> setQueryExecutor(@NonNull Executor executor) {
        this.mQueryExecutor = executor;
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> setTransactionExecutor(@NonNull Executor executor) {
        this.mTransactionExecutor = executor;
        return this;
    }
}
