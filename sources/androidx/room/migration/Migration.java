package androidx.room.migration;

import androidx.annotation.NonNull;
import androidx.sqlite.p006db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public abstract class Migration {
    public final int endVersion;
    public final int startVersion;

    public Migration(int i, int i2) {
        this.startVersion = i;
        this.endVersion = i2;
    }

    public abstract void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase);
}
