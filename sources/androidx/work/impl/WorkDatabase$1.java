package androidx.work.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration$Builder;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Factory;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;

/* JADX INFO: loaded from: classes.dex */
public class WorkDatabase$1 implements SupportSQLiteOpenHelper$Factory {
    public final /* synthetic */ Context val$context;

    public WorkDatabase$1(Context context) {
        this.val$context = context;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper$Factory
    @NonNull
    public SupportSQLiteOpenHelper create(@NonNull SupportSQLiteOpenHelper$Configuration supportSQLiteOpenHelper$Configuration) {
        SupportSQLiteOpenHelper$Configuration$Builder supportSQLiteOpenHelper$Configuration$BuilderBuilder = SupportSQLiteOpenHelper$Configuration.builder(this.val$context);
        supportSQLiteOpenHelper$Configuration$BuilderBuilder.name(supportSQLiteOpenHelper$Configuration.name).callback(supportSQLiteOpenHelper$Configuration.callback).noBackupDirectory(true);
        return new FrameworkSQLiteOpenHelperFactory().create(supportSQLiteOpenHelper$Configuration$BuilderBuilder.build());
    }
}
