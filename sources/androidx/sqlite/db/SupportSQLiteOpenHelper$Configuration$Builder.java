package androidx.sqlite.db;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class SupportSQLiteOpenHelper$Configuration$Builder {
    public SupportSQLiteOpenHelper$Callback mCallback;
    public Context mContext;
    public String mName;
    public boolean mUseNoBackUpDirectory;

    public SupportSQLiteOpenHelper$Configuration$Builder(@NonNull Context context) {
        this.mContext = context;
    }

    @NonNull
    public SupportSQLiteOpenHelper$Configuration build() {
        if (this.mCallback == null) {
            throw new IllegalArgumentException("Must set a callback to create the configuration.");
        }
        if (this.mContext == null) {
            throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
        }
        if (this.mUseNoBackUpDirectory && TextUtils.isEmpty(this.mName)) {
            throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
        }
        return new SupportSQLiteOpenHelper$Configuration(this.mContext, this.mName, this.mCallback, this.mUseNoBackUpDirectory);
    }

    @NonNull
    public SupportSQLiteOpenHelper$Configuration$Builder callback(@NonNull SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback) {
        this.mCallback = supportSQLiteOpenHelper$Callback;
        return this;
    }

    @NonNull
    public SupportSQLiteOpenHelper$Configuration$Builder name(@Nullable String str) {
        this.mName = str;
        return this;
    }

    @NonNull
    public SupportSQLiteOpenHelper$Configuration$Builder noBackupDirectory(boolean z2) {
        this.mUseNoBackUpDirectory = z2;
        return this;
    }
}
