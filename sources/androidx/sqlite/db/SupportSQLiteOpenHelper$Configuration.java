package androidx.sqlite.db;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class SupportSQLiteOpenHelper$Configuration {

    @NonNull
    public final SupportSQLiteOpenHelper$Callback callback;

    @NonNull
    public final Context context;

    @Nullable
    public final String name;
    public final boolean useNoBackupDirectory;

    public SupportSQLiteOpenHelper$Configuration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback) {
        this(context, str, supportSQLiteOpenHelper$Callback, false);
    }

    @NonNull
    public static SupportSQLiteOpenHelper$Configuration$Builder builder(@NonNull Context context) {
        return new SupportSQLiteOpenHelper$Configuration$Builder(context);
    }

    public SupportSQLiteOpenHelper$Configuration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback, boolean z2) {
        this.context = context;
        this.name = str;
        this.callback = supportSQLiteOpenHelper$Callback;
        this.useNoBackupDirectory = z2;
    }
}
