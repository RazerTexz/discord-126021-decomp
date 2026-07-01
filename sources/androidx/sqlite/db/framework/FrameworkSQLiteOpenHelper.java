package androidx.sqlite.db.framework;

import android.content.Context;
import android.os.Build$VERSION;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Callback;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    private final SupportSQLiteOpenHelper$Callback mCallback;
    private final Context mContext;
    private FrameworkSQLiteOpenHelper$OpenHelper mDelegate;
    private final Object mLock;
    private final String mName;
    private final boolean mUseNoBackupDirectory;
    private boolean mWriteAheadLoggingEnabled;

    public FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback) {
        this(context, str, supportSQLiteOpenHelper$Callback, false);
    }

    private FrameworkSQLiteOpenHelper$OpenHelper getDelegate() {
        FrameworkSQLiteOpenHelper$OpenHelper frameworkSQLiteOpenHelper$OpenHelper;
        synchronized (this.mLock) {
            if (this.mDelegate == null) {
                FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr = new FrameworkSQLiteDatabase[1];
                if (Build$VERSION.SDK_INT < 23 || this.mName == null || !this.mUseNoBackupDirectory) {
                    this.mDelegate = new FrameworkSQLiteOpenHelper$OpenHelper(this.mContext, this.mName, frameworkSQLiteDatabaseArr, this.mCallback);
                } else {
                    this.mDelegate = new FrameworkSQLiteOpenHelper$OpenHelper(this.mContext, new File(this.mContext.getNoBackupFilesDir(), this.mName).getAbsolutePath(), frameworkSQLiteDatabaseArr, this.mCallback);
                }
                this.mDelegate.setWriteAheadLoggingEnabled(this.mWriteAheadLoggingEnabled);
            }
            frameworkSQLiteOpenHelper$OpenHelper = this.mDelegate;
        }
        return frameworkSQLiteOpenHelper$OpenHelper;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        getDelegate().close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.mName;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return getDelegate().getReadableSupportDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return getDelegate().getWritableSupportDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z2) {
        synchronized (this.mLock) {
            FrameworkSQLiteOpenHelper$OpenHelper frameworkSQLiteOpenHelper$OpenHelper = this.mDelegate;
            if (frameworkSQLiteOpenHelper$OpenHelper != null) {
                frameworkSQLiteOpenHelper$OpenHelper.setWriteAheadLoggingEnabled(z2);
            }
            this.mWriteAheadLoggingEnabled = z2;
        }
    }

    public FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback, boolean z2) {
        this.mContext = context;
        this.mName = str;
        this.mCallback = supportSQLiteOpenHelper$Callback;
        this.mUseNoBackupDirectory = z2;
        this.mLock = new Object();
    }
}
