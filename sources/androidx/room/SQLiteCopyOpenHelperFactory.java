package androidx.room;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Factory;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class SQLiteCopyOpenHelperFactory implements SupportSQLiteOpenHelper$Factory {

    @Nullable
    private final String mCopyFromAssetPath;

    @Nullable
    private final File mCopyFromFile;

    @NonNull
    private final SupportSQLiteOpenHelper$Factory mDelegate;

    public SQLiteCopyOpenHelperFactory(@Nullable String str, @Nullable File file, @NonNull SupportSQLiteOpenHelper$Factory supportSQLiteOpenHelper$Factory) {
        this.mCopyFromAssetPath = str;
        this.mCopyFromFile = file;
        this.mDelegate = supportSQLiteOpenHelper$Factory;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper$Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper$Configuration supportSQLiteOpenHelper$Configuration) {
        return new SQLiteCopyOpenHelper(supportSQLiteOpenHelper$Configuration.context, this.mCopyFromAssetPath, this.mCopyFromFile, supportSQLiteOpenHelper$Configuration.callback.version, this.mDelegate.create(supportSQLiteOpenHelper$Configuration));
    }
}
