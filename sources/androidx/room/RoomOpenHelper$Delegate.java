package androidx.room;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
public abstract class RoomOpenHelper$Delegate {
    public final int version;

    public RoomOpenHelper$Delegate(int i) {
        this.version = i;
    }

    public abstract void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

    public abstract void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

    public abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

    public abstract void onOpen(SupportSQLiteDatabase supportSQLiteDatabase);

    public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    @NonNull
    public RoomOpenHelper$ValidationResult onValidateSchema(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        validateMigration(supportSQLiteDatabase);
        return new RoomOpenHelper$ValidationResult(true, null);
    }

    @Deprecated
    public void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
        throw new UnsupportedOperationException("validateMigration is deprecated");
    }
}
